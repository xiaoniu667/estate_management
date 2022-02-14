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
import java.util.List;

/**
 * <p>
 * 业主表
 * </p>
 *
 * @author 小牛
 * @since 2022-02-05
 */
@Data
@TableName("tb_owner")
@ApiModel(value = "Owner对象", description = "业主表")
public class Owner extends Building implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("业主ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("所属小区")
    @TableField("community_id")
    private Integer communityId;

    @ApiModelProperty("所属房产")
    @TableField("house_id")
    private Integer houseId;

    @ApiModelProperty("成员名称")
    @TableField("name")
    private String name;

    @ApiModelProperty("成员照片")
    @TableField("picture")
    private String picture;

    @ApiModelProperty("身份证号")
    @TableField("idcard")
    private String idCard;

    @ApiModelProperty("联系方式")
    @TableField("telephone")
    private Integer telephone;

    @ApiModelProperty("职业")
    @TableField("profession")
    private String profession;

    @ApiModelProperty("性别:0-男（默认），1-女")
    @TableField("sex")
    private String sex;

    @ApiModelProperty("类型:0-房主（默认），1-租客")
    @TableField("type")
    private String type;

    @ApiModelProperty("备注（默认无）")
    @TableField("remark")
    private String remark;

    @ApiModelProperty("创建时间")
    @TableField("create_time")
    private LocalDateTime createTime;

    @ApiModelProperty("更新时间")
    @TableField("update_time")
    private LocalDateTime updateTime;

    @ApiModelProperty("出生日期")
    @TableField("birthday")
    private LocalDateTime birthday;


    @TableField("community_name")
    private String communityName;

    @TableField("total_households")
    private Integer totalHouseholds;

    @TableField("description")
    private String description;

    @TableField("house_name")
    private String houseName;

}
