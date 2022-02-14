package com.ag.domain;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.models.auth.In;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("tb_estate_manager_power")
public class EstateManagerPower {



    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @TableField("power_rule")
    private  String  powRule;
    @TableField("power_name")
    private  String  powName;

    private  String  rank1;
    private LocalDateTime time;
    private  String status;

}
