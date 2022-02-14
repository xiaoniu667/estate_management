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
 * 设备表
 * </p>
 *
 * @author 小牛
 * @since 2022-02-05
 */
@Getter
@Setter
@TableName("tb_device")
@ApiModel(value = "Device对象", description = "设备表")
public class Device implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("设备ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("所属小区名称")
    @TableField("community_name")
    private String communityName;

    @ApiModelProperty("所属小区ID")
    @TableField("community_id")
    private Integer communityId;

    @ApiModelProperty("设备编号")
    @TableField("code")
    private String code;

    @ApiModelProperty("设备名称")
    @TableField("name")
    private String name;

    @ApiModelProperty("设备品牌")
    @TableField("brand")
    private String brand;

    @ApiModelProperty("购买单价(￥)，单位分")
    @TableField("unit_price")
    private Integer unitPrice;

    @ApiModelProperty("购买数量")
    @TableField("num")
    private Integer num;

    @ApiModelProperty("预计使用年限(年)")
    @TableField("expected_useful_life")
    private Integer expectedUsefulLife;

    @ApiModelProperty("创建时间")
    @TableField("create_time")
    private LocalDateTime createTime;

    @ApiModelProperty("更新时间")
    @TableField("update_time")
    private LocalDateTime updateTime;

    @ApiModelProperty("购买日期")
    @TableField("purchase_date")
    private LocalDateTime purchaseDate;


}
