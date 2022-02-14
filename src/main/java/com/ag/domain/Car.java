package com.ag.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 车辆表
 * </p>
 *
 * @author 小牛
 * @since 2022-02-05
 */
@Data
@TableName("tb_car")
@ApiModel(value = "Car对象", description = "车辆表")
public class Car implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("车辆ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("车辆照片")
    @TableField("picture")
    private String picture;

    @ApiModelProperty("所属成员（业主）")
    @TableField("owner_id")
    private Integer ownerId;

    @ApiModelProperty("车辆颜色")
    @TableField("color")
    private String color;

    @ApiModelProperty("车牌号")
    @TableField("car_number")
    private String carNumber;

    @ApiModelProperty("备注")
    @TableField("remark")
    private String remark;

    @ApiModelProperty("创建时间")
    @TableField("create_time")
    private LocalDateTime createTime;

    @ApiModelProperty("更新时间")
    @TableField("update_time")
    private LocalDateTime updateTime;

//    @TableField(select = false)
    @TableField("owner_name")
    private String ownerName;


}
