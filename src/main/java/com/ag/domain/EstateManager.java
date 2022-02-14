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
 * 物业管理人员表
 * </p>
 *
 * @author 小牛
 * @since 2022-02-05
 */
@Getter
@Setter
@TableName("tb_estate_manager")
@ApiModel(value = "EstateManager对象", description = "物业管理人员表")
public class EstateManager implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("物业管理人员ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("所属小区名称")
    @TableField("community_name")
    private String communityName;

    @ApiModelProperty("所属小区ID")
    @TableField("community_id")
    private Integer communityId;

    @ApiModelProperty("登录名:登录时使用的名称")
    @TableField("login_name")
    private String loginName;

    @ApiModelProperty("真实名称")
    @TableField("name")
    private String name;

    @ApiModelProperty("密码")
    @TableField("password")
    private String password;

    @ApiModelProperty("手机")
    @TableField("telephone")
    private Integer telephone;

    @ApiModelProperty("邮箱")
    @TableField("email")
    private String email;

    @ApiModelProperty("角色ID：0-普通用户（默认0），1-管理员用户")
    @TableField("role_id")
    private Integer roleId;

    @ApiModelProperty("创建时间")
    @TableField("create_time")
    private LocalDateTime createTime;

    @ApiModelProperty("更新时间")
    @TableField("update_time")
    private LocalDateTime updateTime;


}
