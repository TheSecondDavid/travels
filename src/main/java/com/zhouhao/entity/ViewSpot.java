package com.zhouhao.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.Date;

@Data
@AllArgsConstructor
@TableName("t_place")
public class ViewSpot {
    Integer id;
    String name;
    String picpath;
    Date hottime;
    Integer hotticket;
    Integer dimticket;
    String introduction;
    Integer proviceid;
}
