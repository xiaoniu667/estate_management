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
 * 宠物表
 * </p>
 *
 * @author 小牛
 * @since 2022-02-05
 */
@Getter
@Setter
@TableName("tb_pet")
@ApiModel(value = "Pet对象", description = "宠物表")
public class Pet implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("宠物ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("宠物照片")
    @TableField("picture")
    private String picture;

    @ApiModelProperty("所属成员（业主）名称")
    @TableField("owner_name")
    private String ownerName;

    @ApiModelProperty("所属成员（业主）ID")
    @TableField("owner_id")
    private Integer ownerId;

    @ApiModelProperty("宠物名称")
    @TableField("name")
    private String name;

    @ApiModelProperty("宠物颜色")
    @TableField("color")
    private String color;

    @ApiModelProperty("备注")
    @TableField("remark")
    private String remark;

    @ApiModelProperty("创建时间")
    @TableField("create_time")
    private LocalDateTime createTime;

    @ApiModelProperty("更新时间")
    @TableField("update_time")
    private LocalDateTime updateTime;

    @ApiModelProperty("收养时间")
    @TableField("adopt_time")
    private LocalDateTime adoptTime;


}
