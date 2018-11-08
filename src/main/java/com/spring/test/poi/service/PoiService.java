package com.spring.test.poi.service;

import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;

/**
 * @version 1.0
 * @description：
 * @author: Yang.Chang
 * @project: spring-boot-easypoi
 * @package: com.spring.test.poi.service.impl
 * @email: cy880708@163.com
 * @date: 2018/11/8 下午12:04
 * @mofified By:
 */
public interface PoiService {

    /**
     * @description：导出Excel
     * @version 1.0
     * @author: Yang.Chang
     * @email: cy880708@163.com
     * @date: 2018/11/8 下午12:05
     * @mofified By:
     */
    void downExcel(HttpServletResponse httpServletResponse);

}
