package com.g4b.g4bexam.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.g4b.g4bexam.model.entity.ChoiceQuestion;
import com.g4b.g4bexam.model.entity.EssayQuestion;

import java.util.List;

public interface QuestionService {
    List<ChoiceQuestion> getChoiceQuestion(Wrapper<ChoiceQuestion> wrapper);
    List<EssayQuestion> getEssayQuestion(Wrapper<EssayQuestion> wrapper);
}
