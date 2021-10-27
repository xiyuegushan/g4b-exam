package com.g4b.g4bexam.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.g4b.g4bexam.mapper.ChoiceQuestionMapper;
import com.g4b.g4bexam.mapper.EssayQuestionMapper;
import com.g4b.g4bexam.model.entity.ChoiceQuestion;
import com.g4b.g4bexam.model.entity.EssayQuestion;
import com.g4b.g4bexam.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Liangzhaohao
 * @version 1.0.0
 * @className QuestionServiceImpl
 * @description 问题服务实现类
 * @createTime 2021/10/26 10:30
 */
@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    ChoiceQuestionMapper choiceQuestionMapper;

    @Autowired
    EssayQuestionMapper essayQuestionMapper;

    @Override
    public List<ChoiceQuestion> getChoiceQuestion(Wrapper<ChoiceQuestion> wrapper) {
        return choiceQuestionMapper.selectList(wrapper);
    }

    @Override
    public List<EssayQuestion> getEssayQuestion(Wrapper<EssayQuestion> wrapper) {
        return essayQuestionMapper.selectList(wrapper);
    }


}
