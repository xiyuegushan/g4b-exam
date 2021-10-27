package com.g4b.g4bexam.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author Liangzhaohao
 * @version 1.0.0
 * @className ChoiceQuestion
 * @description 选择题实体类
 * @createTime 2021/10/26 10:18
 */
@Data
@TableName(value = "choice_question")
public class ChoiceQuestion {
    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;
    @TableField(value = "question")
    private String question;
    @TableField(value = "optiona")
    private String optionA;
    @TableField(value = "optionb")
    private String optionB;
    @TableField(value = "optionc")
    private String optionC;
    @TableField(value = "optiond")
    private String optionD;
    @TableField(value = "answer")
    private String answer;
    @TableField(value = "type")
    private String type;
}
