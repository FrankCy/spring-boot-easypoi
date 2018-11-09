package com.spring.test.poi.service.impl;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.spring.test.poi.controller.PoiController;
import com.spring.test.poi.pojo.PoiVo;
import com.spring.test.poi.service.PoiService;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private final Logger logger = LoggerFactory.getLogger(PoiController.class);

    /**
     * @description：导出Excel接口实现类
     * @version 1.0
     * @author: Yang.Chang
     * @email: cy880708@163.com
     * @date: 2018/11/8 下午2:54
     * @mofified By:
     */
    @Override
    public void downExcel(HttpServletResponse response){
//        List<PoiVo> list = getAllPoiVo();
        List<PoiVo> list = new ArrayList<PoiVo>();
        //单sheet默认最多保存6万行数据，如果超过导出上限会自动创建sheet（讲道理应该可以自定义）
        for(int i=0 ; i<10000; i++) {
            PoiVo poiVo = new PoiVo();
            poiVo.setId(i);
            poiVo.setPoiName(i+"name");
            poiVo.setPoiDes(i+"des");
            list.add(poiVo);
        }

        logger.info("共有：" + list.size() + "条数据");
        //指定列表标题和工作表名称
        ExportParams params = new ExportParams("测试通过EasyPoi导出Excel","POI-Sheet");
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
