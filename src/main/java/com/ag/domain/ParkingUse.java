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
 * 车位使用表
 * </p>
 *
 * @author 小牛
 * @since 2022-02-05
 */
@Getter
@Setter
@TableName("tb_parking_use")
@ApiModel(value = "ParkingUse对象", description = "车位使用表")
public class ParkingUse implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("车位使用ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("所属小区名称")
    @TableField("community_name")
    private String communityName;

    @ApiModelProperty("所属小区ID")
    @TableField("community_id")
    private Integer communityId;

    @ApiModelProperty("车位编号")
    @TableField("code")
    private String code;

    @ApiModelProperty("车牌号码")
    @TableField("car_number")
    private String carNumber;

    @ApiModelProperty("车辆牌照（照片）")
    @TableField("picture")
    private String picture;

    @ApiModelProperty("车辆所有人（业主）名称")
    @TableField("owner_name")
    private String ownerName;

    @ApiModelProperty("车辆所有人（业主）ID")
    @TableField("owner_id")
    private Integer ownerId;

    @ApiModelProperty("联系方式")
    @TableField("telephone")
    private Integer telephone;

    @ApiModelProperty("使用性质：0-购买(默认)，1-月租，2-年租")
    @TableField("use_type")
    private String useType;

    @ApiModelProperty("总费用(￥)，以分为单位")
    @TableField("total_fee")
    private Integer totalFee;

    @ApiModelProperty("创建时间")
    @TableField("create_time")
    private LocalDateTime createTime;

    @ApiModelProperty("更新时间")
    @TableField("update_time")
    private LocalDateTime updateTime;

    @ApiModelProperty("（使用）开始时间")
    @TableField("start_time")
    private LocalDateTime startTime;

    @ApiModelProperty("（使用）结束时间")
    @TableField("end_time")
    private LocalDateTime endTime;


}
