package com.spring.test.poi.service.impl;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.spring.test.poi.pojo.PoiVo;
import com.spring.test.poi.service.PoiService;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0
 * @description：
 * @author: Yang.Chang
 * @project: spring-boot-easypoi
 * @package: com.spring.test.poi.service.impl
 * @email: cy880708@163.com
 * @date: 2018/11/8 下午12:05
 * @mofified By:
 */
@Service
public class PoiServiceImpl implements PoiService {

    @Override
    public void downExcel(HttpServletResponse response){
//        List<PoiVo> list = getAllStu();
        List<PoiVo> list = new ArrayList<PoiVo>();
        for(int i=0 ; i<99999; i++) {
            PoiVo poiVo = new PoiVo();
            poiVo.setId(i);
            poiVo.setPoiName(i+"name");
            poiVo.setPoiDes(i+"des");
            list.add(poiVo);
        }

        System.out.println("一共有 ： " + list.size());
        //指定列表标题和工作表名称
        ExportParams params = new ExportParams("测试POI","测试POI内容");
        params.setCreateHeadRows(true);
        Workbook workbook = ExcelExportUtil.exportExcel(params, PoiVo.class,list);
        response.setHeader("content-Type","application/vnd.ms-excel");
        response.setHeader("Content-Disposition","attachment;filename="+System.currentTimeMillis()+".xls");
        response.setCharacterEncoding("UTF-8");
        try {
            workbook.write(response.getOutputStream());
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
