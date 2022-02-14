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
 * 维修表
 * </p>
 *
 * @author 小牛
 * @since 2022-02-05
 */
@Getter
@Setter
@TableName("tb_repair")
@ApiModel(value = "Repair对象", description = "维修表")
public class Repair implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("维修ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("所属小区名称")
    @TableField("community_name")
    private String communityName;

    @ApiModelProperty("所属小区ID")
    @TableField("community_id")
    private Integer communityId;

    @ApiModelProperty("所属楼栋名称")
    @TableField("building_name")
    private String buildingName;

    @ApiModelProperty("所属楼栋ID")
    @TableField("building_id")
    private Integer buildingId;

    @ApiModelProperty("报修人员（业主）名称")
    @TableField("owner_name")
    private String ownerName;

    @ApiModelProperty("报修人员（业主）ID")
    @TableField("owner_id")
    private Integer ownerId;

    @ApiModelProperty("设备名称")
    @TableField("device_name")
    private String deviceName;

    @ApiModelProperty("设备编号ID")
    @TableField("device_id")
    private Integer deviceId;

    @ApiModelProperty("报修描述")
    @TableField("description")
    private String description;

    @ApiModelProperty("创建时间")
    @TableField("create_time")
    private LocalDateTime createTime;

    @ApiModelProperty("更新时间")
    @TableField("update_time")
    private LocalDateTime updateTime;

    @ApiModelProperty("状态：0-待受理，1-已受理，2-修理完毕")
    @TableField("status")
    private String status;


}
