package org.common.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author lyq on 2019-12-24 4:41 下午
 */
public abstract class BaseController<S extends IService<T>, T extends Model<T>> {

    @Autowired
    protected S baseService;

    @PostMapping("/add")
    public boolean insert(@RequestBody T t){
        return baseService.save(t);
    }

    @PostMapping("/addBatch")
    public boolean insertBatch(@RequestBody List<T> list){
        return baseService.saveBatch(list);
    }

    @DeleteMapping("/{id}")
    public boolean remove(@PathVariable Long id){
        return baseService.removeById(id);
    }

    /**
     * 根据主键批量删除
     */
    @DeleteMapping("/batch")
    public boolean removeList(@RequestBody List<Long> idList){
        return baseService.removeByIds(idList);
    }

    /**
     * 根据主键更新
     * @return
     * @param t
     */
    @PutMapping("/update")
    public boolean update(@RequestBody T t){
        return baseService.updateById(t);
    }

    @GetMapping("/{id}")
    public T selectByKey(@PathVariable Long id){
        return baseService.getById(id);
    }

    /**
     * 查询所有不带分页
     */
    @GetMapping("/list")
    public List<T> selectList(){
        return baseService.list();
    }

    @GetMapping("/list/wrapper")
    public List<T> selectListByWrapper(T t){
        QueryWrapper<T> queryWrapper = createQueryWrapper(t);
        return baseService.list(queryWrapper);
    }

    /**
     * 分页查询
     * @return
     */
    @GetMapping("/page")
    public Page<T> selectPage(Page page,T t){
        QueryWrapper<T> queryWrapper = createQueryWrapper(t);
        return baseService.page(page, queryWrapper);
    }

    /**
     * 构造构造queryWrapper
     * @return
     */
    protected abstract QueryWrapper<T> createQueryWrapper(T t);

}
