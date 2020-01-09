package org.feeling.admin.auth;

import lombok.Data;

/**
 * @author lyq on 2020-01-09 11:21 下午
 * @desc
 */
@Data
public class AuthEntity {

    private String access_token;

    private String token_type;

    private String refresh_token;

    private Long expires_in;

    private String scope;

}
