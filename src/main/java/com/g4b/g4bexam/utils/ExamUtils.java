package com.g4b.g4bexam.utils;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Liangzhaohao
 * @version 1.0.0
 * @className getRandomList
 * @description 获取随机指定个数List
 * @createTime 2021/10/26 13:35
 */
@Component
public class ExamUtils<T> {

    private static ExamUtils examUtils;

    @PostConstruct
    public void init() {
        examUtils = this;
    }

    public List<T> getRandomList(List<T> paramList, int count) {
        if (paramList.size() < count) {
            return paramList;
        }
        Random random = new Random();
        List<Integer> tempList = new ArrayList<>();
        List<T> newList = new ArrayList<>();
        int temp = 0;
        for (int i = 0; i < count; i++) {
            temp = random.nextInt(paramList.size());
            if (!tempList.contains(temp)) {
                tempList.add(temp);
                newList.add(paramList.get(temp));
            } else {
                i--;
            }
        }
        return newList;
    }
}
