package com.toato.ssm.domain;

import com.toato.ssm.utls.DateUtils;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Orders {

    private Integer id;
    private Integer orderNum;
    private Date orderTime;
    private int orderStatus;
    private int peopleCount;
    private Integer payType;
    private String orderDesc;

    private Member member;                  // 订单对应的会员
    private Product product;                // 订单对应的产品
    private List<Traveller> travellers;     // 订单的旅客

    private String orderStatusStr;
    private String orderTimeStr;
    private String payTypeStr;

    public String getOrderStatusStr() {
        // 订单状态( 0未支付  1已支付 )
        if(orderStatus == 0) {
            orderStatusStr = "未支付";
        }else if(orderStatus == 1) {
            orderStatusStr = "已支付";
        }

        return orderStatusStr;
    }

    public String getOrderTimeStr() {
        if(orderTime != null) {
            orderTimeStr = DateUtils.date2String(orderTime, "yyyy-MM-dd HH:mm:ss");
        }
        return orderTimeStr;
    }

    public String getPayTypeStr() {
        // 支付方式( 0支付宝 1微信 2其它 )
        if(payType == 0) {
            payTypeStr = "支付宝";
        }else if(payType == 1) {
            payTypeStr = "微信";
        }else if(payType == 2){
            payTypeStr = "其他";
        }

        return payTypeStr;
    }
}