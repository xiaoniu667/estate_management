package com.ag.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 房屋表
 * </p>
 *
 * @author 小牛
 * @since 2022-02-05
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("tb_house")
@ApiModel(value = "House对象", description = "房屋表")
public class House implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("房屋ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("所属小区名称")
    @TableField("community_name")
    private String communityName;

    @ApiModelProperty("所属小区ID")
    @TableField("community_id")
    private Integer communityId;

    @ApiModelProperty("所属栋数名称")
    @TableField("building_name")
    private String buildingName;

    @ApiModelProperty("所属栋数ID")
    @TableField("building_id")
    private Integer buildingId;

    @ApiModelProperty("房产编码")
    @TableField("code")
    private String code;

    @ApiModelProperty("房产名称")
    @TableField("name")
    private String name;

    @ApiModelProperty("户主（业主）ID")
    @TableField("owner_id")
    private Integer ownerId;

    @ApiModelProperty("户主（业主）名称")
    @TableField("owner_name")
    private String ownerName;

    @ApiModelProperty("联系方式")
    @TableField("telephone")
    private Integer telephone;

    @ApiModelProperty("房间数")
    @TableField("room_num")
    private Integer roomNum;

    @ApiModelProperty("单元")
    @TableField("unit")
    private Integer unit;

    @ApiModelProperty("楼层")
    @TableField("floor")
    private Integer floor;

    @ApiModelProperty("描述")
    @TableField("description")
    private String description;

    @ApiModelProperty("入住时间")
    @TableField("live_time")
    private LocalDateTime liveTime;


}
