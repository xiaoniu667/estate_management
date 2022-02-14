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
 * 信件表
 * </p>
 *
 * @author 小牛
 * @since 2022-02-05
 */
@Getter
@Setter
@TableName("tb_letter")
@ApiModel(value = "Letter对象", description = "信件表")
public class Letter implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("信件ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("所属小区ID")
    @TableField("community_id")
    private Integer communityId;

    @ApiModelProperty("所属小区名称")
    @TableField("community_name")
    private String communityName;

    @ApiModelProperty("信件发送者（业主）ID")
    @TableField("owner_id")
    private Integer ownerId;

    @ApiModelProperty("信件发送者（业主）名称")
    @TableField("owner_name")
    private String ownerName;

    @ApiModelProperty("信件来源：0-信箱（默认），1-邮件，2-微信，3-公众号，4-app,5-pc")
    @TableField("origin")
    private String origin;

    @ApiModelProperty("信件标题")
    @TableField("title")
    private String title;

    @ApiModelProperty("信箱内容")
    @TableField("content")
    private String content;

    @ApiModelProperty("创建时间")
    @TableField("create_time")
    private LocalDateTime createTime;

    @ApiModelProperty("更新时间")
    @TableField("update_time")
    private LocalDateTime updateTime;

    @ApiModelProperty("状态:0-未读（默认），1-已读")
    @TableField("status")
    private String status;


}
