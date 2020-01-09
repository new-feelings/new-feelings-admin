package org.feeling.gateway.config;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author lyq on 2020-01-02 5:25 下午
 * @desc
 */
@Slf4j
@Component
public class TokenFilter implements GlobalFilter, Ordered {

    /**
     * 白名单
     */
    public static final HashSet<String> whitePath;

    static {
        whitePath = new HashSet<>();
        whitePath.add("/api/admin/users/login");
        whitePath.add("/api/admin/users/logout");
    }

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        String path = request.getURI().getPath();
        if (whitePath.contains(path)) {
            return chain.filter(exchange);
        }
        String token = request.getHeaders().getFirst(HttpHeaders.AUTHORIZATION);
        if (StringUtils.isEmpty(token)) {
            ServerHttpResponse response = exchange.getResponse();
            return authFailure(response);
        }
        ServerHttpRequest httpRequest = request.mutate().header("Authorization", token).build();
        ServerWebExchange build = exchange.mutate().request(httpRequest).build();
        return chain.filter(build);

    }

    private Mono<Void> authFailure(ServerHttpResponse resp) {
        resp.setStatusCode(HttpStatus.UNAUTHORIZED);
        resp.getHeaders().add("Content-Type","application/json;charset=UTF-8");
        Map<String,Object> result = new HashMap<>(2);
        result.put("code",HttpStatus.UNAUTHORIZED.value());
        result.put("message","未登录,请先登录！");
        String returnStr = null;
        try {
            returnStr = JSONObject.toJSONString(result);
        } catch (Exception e) {
            log.error(e.getMessage(),e);
        }
        DataBuffer buffer = resp.bufferFactory().wrap(returnStr.getBytes(StandardCharsets.UTF_8));
        return resp.writeWith(Flux.just(buffer));
    }

    @Override
    public int getOrder() {
        return -1;
    }

}
