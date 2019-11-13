package com.toato.ssm.domain;

import com.toato.ssm.utls.DateUtils;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class Product {
    private Integer id;                  // 主键
    private String productNum;          // 编号唯一
    private String productName;         // 名称
    private String cityName;            // 出发城市
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date departureTime;         // 出发时间
    private double productPrice;        // 产品价格
    private String productDesc;         // 产品描述
    private Integer productStatus;      // 状态 0 关闭 1 开启

    private String productStatusStr;    // productStatus的String形式
    private String departureTimestr;    // departureTime的String形式


    public String getProductStatusStr() {

        if(productStatus != null) {
            // 状态 0 关闭 1 开启
            if(productStatus == 0) {
                productStatusStr = "关闭";
            }
            if(productStatus == 1) {
                productStatusStr = "开启";
            }
        }

        return productStatusStr;
    }


    public String getDepartureTimestr() {

        // 将departureTime转换为String形式,方便网页读取
        if(departureTime != null) {
            departureTimestr = DateUtils.date2String(departureTime, "yyyy-MM-dd HH:mm:ss");
        }

        return departureTimestr;
    }
}