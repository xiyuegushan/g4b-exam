package com.g4b.g4bexam.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author Liangzhaohao
 * @version 1.0.0
 * @className EssayQuestion
 * @description 问答题实体类
 * @createTime 2021/10/26 12:35
 */
@Data
@TableName(value = "essay_question")
public class EssayQuestion {
    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;
    @TableField(value = "question")
    private String question;
    @TableField(value = "answer")
    private String answer;
    @TableField(value = "type")
    private String type;
}
