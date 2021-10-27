package com.g4b.g4bexam.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.g4b.g4bexam.commons.JsonResponse;
import com.g4b.g4bexam.model.dto.PaperInfo;
import com.g4b.g4bexam.model.entity.ChoiceQuestion;
import com.g4b.g4bexam.model.entity.EssayQuestion;
import com.g4b.g4bexam.model.entity.Paper;
import com.g4b.g4bexam.service.PaperService;
import com.g4b.g4bexam.service.QuestionService;
import com.g4b.g4bexam.utils.ExamUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Liangzhaohao
 * @version 1.0.0
 * @className QuestionController
 * @description 问题Controller
 * @createTime 2021/10/26 10:40
 */
@RestController
@Slf4j
public class ExamController {

    @Autowired
    QuestionService questionService;

    @Autowired
    PaperService paperService;

    @Autowired
    ExamUtils examUtils;

    @PostMapping("/paper")
    public JsonResponse getPaper(@RequestBody PaperInfo paperInfo) {
        QueryWrapper<ChoiceQuestion> choiceQuestionQueryWrapper = new QueryWrapper<>();
        QueryWrapper<EssayQuestion> essayQuestionQueryWrapper = new QueryWrapper<>();
        Map<String, Object> map = new HashMap<>();
        map.put("type", paperInfo.getPosition());
        choiceQuestionQueryWrapper.allEq(map, false);
        essayQuestionQueryWrapper.allEq(map, false);
        try {
            //根据岗位获取对应的选择题和问答题List
            List<ChoiceQuestion> choiceQuestionList = questionService.getChoiceQuestion(choiceQuestionQueryWrapper);
            List<EssayQuestion> essayQuestionList = questionService.getEssayQuestion(essayQuestionQueryWrapper);

            //调用封装的方法,从选择题\问答题List中取出指定个数的题目并分别存入两个新的List
            List<ChoiceQuestion> randomChoiceQuestionList = examUtils.getRandomList(choiceQuestionList, 10);
            List<EssayQuestion> randomEssayQuestionList = examUtils.getRandomList(essayQuestionList, 5);

            //初始化Paper,并set入对应的姓名,手机,岗位以及对应的选择题问答题List
            Paper paper = new Paper();
            paper.setName(paperInfo.getName());
            paper.setPhone(paperInfo.getPhone());
            paper.setPosition(paperInfo.getPosition());
            paper.setChoiceQuestionList(randomChoiceQuestionList);
            paper.setEssayQuestionList(randomEssayQuestionList);

            //将封装完成后的Paper返回给前端
            return JsonResponse.success("获取试卷成功", paper);
        } catch (Exception e) {
            return JsonResponse.fail("获取试卷失败,失败原因:" + e.getMessage());
        }
    }

    @PostMapping("/paper/submit")
    public JsonResponse submitPaper(@RequestBody Paper paper) {
        try {
            paperService.savePaper(paper);
            return JsonResponse.success("提交成功", null);
        } catch (Exception e) {
            return JsonResponse.fail("提交失败,失败原因:" + e.getMessage());
        }
    }

    @GetMapping("/paper/{id}")
    public JsonResponse selectPaper(@PathVariable int id) {
        try {
            Paper paper = paperService.selectPaper(id);
            return JsonResponse.success("获取对应试卷成功", paper);
        } catch (Exception e) {
            return JsonResponse.fail("获取对应试卷失败,失败原因:" + e.getMessage());
        }
    }

    @PutMapping("/paper")
    public JsonResponse markPaper(@RequestBody Paper paper) {
        try {
            paperService.updatePaper(paper);
            return JsonResponse.success("评分成功", null);
        } catch (Exception e) {
            return JsonResponse.fail("评分失败,失败原因:" + e.getMessage());
        }
    }

    @GetMapping("/paper/{pageNum}/{pageSize}")
    public JsonResponse selectPage(@PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize) {
        Page<Paper> page = new Page<>(pageNum, pageSize);
        try {
            IPage<Paper> paperIPage = paperService.selectPage(page, null);
            return JsonResponse.success("获取已提交试卷分页信息成功", paperIPage);
        } catch (Exception e) {
            return JsonResponse.fail("获取已提交试卷分页信息失败,失败原因:" + e.getMessage());
        }
    }
}
