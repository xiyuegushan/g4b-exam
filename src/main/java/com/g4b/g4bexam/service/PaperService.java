package com.g4b.g4bexam.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.g4b.g4bexam.model.entity.Paper;

public interface PaperService {
    int savePaper(Paper paper);
    Paper selectPaper(int id);
    int updatePaper(Paper paper);
    IPage<Paper> selectPage(Page<Paper> page, QueryWrapper queryWrapper);
}
