package com.g4b.g4bexam.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.FastjsonTypeHandler;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Map;

/**
 * @author Liangzhaohao
 * @version 1.0.0
 * @className Paper
 * @description 试卷实体类
 * @createTime 2021/10/26 12:25
 */
@Data
@TableName(value = "paper", autoResultMap = true)
@Document("Paper")
public class Paper {
    @TableId(value = "ID", type = IdType.AUTO)
    @Id
    private Integer id;
    @TableField(value = "name")
    private String name;
    @TableField(value = "phone")
    private String phone;
    @TableField(value = "position")
    private String position;
    @TableField(value = "score")
    private String score;
    @TableField(value = "choicequestionlist", typeHandler = FastjsonTypeHandler.class)
    private List<ChoiceQuestion> choiceQuestionList;
    @TableField(value = "essayquestionlist", typeHandler = FastjsonTypeHandler.class)
    private List<EssayQuestion> essayQuestionList;
    @TableField(value = "responselist", typeHandler = FastjsonTypeHandler.class)
    private Map<String, String> responseList;
}
