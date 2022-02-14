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
import java.util.Date;

/**
 * <p>
 * 活动表
 * </p>
 *
 * @author 小牛
 * @since 2022-02-05
 */
@Getter
@Setter
@TableName("tb_activity")
@ApiModel(value = "Activity对象", description = "活动表")
public class Activity implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("活动ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("所属小区名称")
    @TableField("community_name")
    private String communityName;

    @ApiModelProperty("所属小区ID")
    @TableField("community_id")
    private Integer communityId;

    @ApiModelProperty("活动标题")
    @TableField("title")
    private String title;

    @ApiModelProperty("活动地点")
    @TableField("address")
    private String address;

    @ApiModelProperty("举办单位")
    @TableField("organizer")
    private String organizer;

    @ApiModelProperty("创建时间")
    @TableField("create_time")
    private LocalDateTime createTime;

    @ApiModelProperty("更新时间")
    @TableField("update_time")
    private LocalDateTime updateTime;



    @ApiModelProperty("活动开始日期")
    @TableField("start_date")
    private Date startDate;

    @ApiModelProperty("活动开始时间")
    @TableField("start_time")
    private LocalDateTime startTime;

    @ApiModelProperty("活动截止时间")
    @TableField("end_time")
    private LocalDateTime endTime;

    @ApiModelProperty("状态:0-活动未开始（默认），1-活动进行中，2-活动已结束")
    @TableField("status")
    private String status;


}
