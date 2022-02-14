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
 * 投诉表
 * </p>
 *
 * @author 小牛
 * @since 2022-02-05
 */
@Getter
@Setter
@TableName("tb_complaint")
@ApiModel(value = "Complaint对象", description = "投诉表")
public class Complaint implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("投诉ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("所属小区名称")
    @TableField("community_name")
    private String communityName;

    @ApiModelProperty("所属小区ID")
    @TableField("community_id")
    private Integer communityId;

    @ApiModelProperty("投诉人员（业主）ID")
    @TableField("owner_id")
    private Integer ownerId;

    @ApiModelProperty("投诉人员（业主）名称")
    @TableField("owner_name")
    private String ownerName;

    @ApiModelProperty("投诉具体描述")
    @TableField("description")
    private String description;

    @ApiModelProperty("投诉事由")
    @TableField("reason")
    private String reason;

    @ApiModelProperty("创建时间")
    @TableField("create_time")
    private LocalDateTime createTime;

    @ApiModelProperty("更新时间")
    @TableField("update_time")
    private LocalDateTime updateTime;

    @ApiModelProperty("状态：0-未受理，1-已受理（默认），2-已处理完毕")
    @TableField("status")
    private String status;


}
