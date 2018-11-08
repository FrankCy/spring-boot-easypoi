package com.spring.test.poi.controller;

import com.spring.test.poi.service.PoiService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * @version 1.0
 * @description：
 * @author: Yang.Chang
 * @project: spring-boot-easypoi
 * @package: com.spring.test.poi.controller
 * @email: cy880708@163.com
 * @date: 2018/11/8 上午11:04
 * @mofified By:
 */
@RestController
@RequestMapping("/poi")
public class PoiController {

    /**
     * @description：日志
     * @version 1.0
     * @author: Yang.Chang
     * @email: cy880708@163.com
     * @date: 2018/11/8 下午1:38
     * @mofified By:
     */
    private final Logger logger = LoggerFactory.getLogger(PoiController.class);

    @Autowired
    private PoiService poiService;

    /**
     * @description：访问首页信息
     * @version 1.0
     * @author: Yang.Chang
     * @email: cy880708@163.com
     * @date: 2018/11/8 上午11:07
     * @mofified By:
     */
    @RequestMapping(value = "/index")
    public String index(Model model){
        System.out.println("测试");
        return "index";
    }

    /**
     * @description：导出Excel
     * @version 1.0
     * @author: Yang.Chang
     * @email: cy880708@163.com
     * @date: 2018/11/8 下午12:11
     * @mofified By:
     */
    @RequestMapping(value = "/exportExcel")
    @ResponseBody
    public void exportStuInfoExcel(HttpServletResponse response){
        poiService.downExcel(response);
    }

}
