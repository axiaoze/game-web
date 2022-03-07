package com.xiaoze.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("game_introduce")
public class Introduce {
    //@TableId(type = IdType.AUTO)
    private Integer id;
    private String name;
    private String type;
    @TableField(value = "creation_time")
    private Date creationTime;
    @TableField(value = "insert_time")
    private Date insertTime;
    private String description;
    private String address;
}
