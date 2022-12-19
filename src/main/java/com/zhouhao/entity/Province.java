package com.zhouhao.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;

@TableName("t_province")
@Data
@AllArgsConstructor
public class Province {
    String id;
    String name;
    String tags;
    @TableField("placeCounts")
    Integer count;
}
