package com.ag.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 小区表
 * </p>
 *
 * @author 小牛
 * @since 2022-02-05
 */
@Getter
@Setter
@TableName("tb_community")
@ApiModel(value = "Community对象", description = "小区表")
public class Community implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("小区id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("小区编号")
    @TableField("code")
    private String code;

    @ApiModelProperty("小区名称")
    @TableField("name")
    private String name;

    @ApiModelProperty("坐落地址")
    @TableField("address")
    private String address;

    @ApiModelProperty("占地面积（m2）")
    @TableField("area")
    private Double area;

    @ApiModelProperty("总栋数")
    @TableField("total_buildings")
    private Integer totalBuildings;

    @ApiModelProperty("总户数")
    @TableField("total_households")
    private Integer totalHouseholds;

    @ApiModelProperty("绿化率（%）")
    @TableField("greening_rate")
    private Integer greeningRate;

    @ApiModelProperty("缩略图")
    @TableField("thumbnail")
    private String thumbnail;

    @ApiModelProperty("开发商名称")
    @TableField("developer")
    private String developer;

    @ApiModelProperty("物业公司名称")
    @TableField("estate_company")
    private String estateCompany;

    @ApiModelProperty("创建时间")
    @TableField("create_time")
    private LocalDateTime createTime;

    @ApiModelProperty("更新时间")
    @TableField("update_time")
    private LocalDateTime updateTime;

    @ApiModelProperty("状态:0-启用（默认），1-不启用")
    @TableField("status")
    private String status;


}
