package com.ag.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 车位表
 * </p>
 *
 * @author 小牛
 * @since 2022-02-05
 */
@Data
@TableName("tb_parking")
@ApiModel(value = "Parking对象", description = "车位表")
public class Parking implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("车位ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("所属小区名称")
    @TableField("community_name")
    private String communityName;

    @ApiModelProperty("所属小区ID")
    @TableField("community_id")
    private Integer communityId;

    @ApiModelProperty("车位编号")
    @TableField("code")
    private String code;

    @ApiModelProperty("车位名称")
    @TableField("name")
    private String name;

    @ApiModelProperty("创建时间")
    @TableField("create_time")
    private LocalDateTime createTime;



    @ApiModelProperty("状态")
    @TableField("status")
    private String status;


    @ApiModelProperty("更新时间")
    @TableField("update_time")
    private LocalDateTime updateTime;


}
