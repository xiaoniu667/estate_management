package com.ag.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 收费名细表
 * </p>
 *
 * @author 小牛
 * @since 2022-02-05
 */
@Getter
@Setter
@TableName("tb_charge_detail")
@ApiModel(value = "ChargeDetail对象", description = "收费名细表")
public class ChargeDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("收费明细ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("所属小区ID")
    @TableField("community_id")
    private Integer communityId;

    @ApiModelProperty("所属小区名称")
    @TableField("community_name")
    private String communityName;

    @ApiModelProperty("收费项目ID")
    @TableField("charge_item_id")
    private Integer chargeItemId;

    @ApiModelProperty("收费项目名称")
    @TableField("charge_item_name")
    private String chargeItemName;

    @ApiModelProperty("承办人名称")
    @TableField("contractor")
    private String contractor;

    @ApiModelProperty("承办人联系电话")
    @TableField("telephone")
    private Integer telephone;

    @ApiModelProperty("应收金额(￥)，单位分")
    @TableField("pay_money")
    private Integer payMoney;

    @ApiModelProperty("实收金额(￥)，单位分")
    @TableField("actual_money")
    private Integer actualMoney;

    @ApiModelProperty("创建时间")
    @TableField("create_time")
    private LocalDateTime createTime;

    @ApiModelProperty("更新时间")
    @TableField("update_time")
    private LocalDateTime updateTime;

    @ApiModelProperty("缴费时间")
    @TableField("pay_time")
    private LocalDateTime payTime;

    @ApiModelProperty("状态：0-生效中（默认），1-已过期")
    @TableField("status")
    private String status;


}
