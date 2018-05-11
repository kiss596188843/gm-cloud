package com.cetiti.gm.common.service;


import com.cetiti.gm.common.model.PageInfo;

/**
 * Created by liangliang on 2017/02/25.
 *
 * @author liangliang
 * @since 2017/02/25
 */
public interface BasePageService<T> extends BaseService<T> {

    PageInfo<T> listPage(PageInfo<T> pageInfo, T entity);
}
