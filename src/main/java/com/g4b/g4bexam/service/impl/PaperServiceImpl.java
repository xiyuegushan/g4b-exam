package com.g4b.g4bexam.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.g4b.g4bexam.mapper.PaperMapper;
import com.g4b.g4bexam.model.entity.Paper;
import com.g4b.g4bexam.service.PaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Liangzhaohao
 * @className PaperServiceImpl
 * @description
 * @createTime 2021/10/26 16:25
 */
@Service
public class PaperServiceImpl implements PaperService {

    @Autowired
    PaperMapper paperMapper;

    @Override
    public int savePaper(Paper paper) {
        return paperMapper.insert(paper);
    }

    @Override
    public Paper selectPaper(int id) {
        return paperMapper.selectById(id);
    }

    @Override
    public int updatePaper(Paper paper) {
        return paperMapper.updateById(paper);
    }

    @Override
    public IPage<Paper> selectPage(Page<Paper> page, QueryWrapper queryWrapper) {
        return paperMapper.selectPage(page,null);
    }
}
