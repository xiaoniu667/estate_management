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
 * 收费项目表
 * </p>
 *
 * @author 小牛
 * @since 2022-02-05
 */
@Getter
@Setter
@TableName("tb_charge_item")
@ApiModel(value = "ChargeItem对象", description = "收费项目表")
public class ChargeItem implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("收费项目ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("所属小区ID")
    @TableField("community_id")
    private Integer communityId;

    @ApiModelProperty("所属小区名称")
    @TableField("community_name")
    private String communityName;

    @ApiModelProperty("收费编号")
    @TableField("code")
    private String code;

    @ApiModelProperty("项目名称")
    @TableField("name")
    private String name;

    @ApiModelProperty("创建时间")
    @TableField("create_time")
    private LocalDateTime createTime;

    @ApiModelProperty("更新时间")
    @TableField("update_time")
    private LocalDateTime updateTime;

    @ApiModelProperty("项目收费金额（年），单位分")
    @TableField("money")
    private Integer money;


}
