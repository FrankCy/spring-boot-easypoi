package com.spring.test.poi.pojo;

import cn.afterturn.easypoi.excel.annotation.Excel;

/**
 * @version 1.0
 * @description：
 * @author: Yang.Chang
 * @project: spring-boot-easypoi
 * @package: com.spring.test.poi.pojo
 * @email: cy880708@163.com
 * @date: 2018/11/8 下午12:06
 * @mofified By:
 */

public class PoiVo {

    @Excel(name = "主键", orderNum = "0")
    private int id;

    @Excel(name = "名称", orderNum = "1")
    private String poiName;

    @Excel(name = "描述", orderNum = "2")
    private String poiDes;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPoiName() {
        return poiName;
    }

    public void setPoiName(String poiName) {
        this.poiName = poiName;
    }

    public String getPoiDes() {
        return poiDes;
    }

    public void setPoiDes(String poiDes) {
        this.poiDes = poiDes;
    }

    public PoiVo() {
    }

    public PoiVo(int id, String poiName, String poiDes) {
        this.id = id;
        this.poiName = poiName;
        this.poiDes = poiDes;
    }
}
