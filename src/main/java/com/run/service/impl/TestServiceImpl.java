package com.run.service.impl;

import com.run.dao.TestDao;
import com.run.entity.Test;
import com.run.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestDao testDao;

    @Override
    public List<Test> selectAll() throws Exception{
        return testDao.selectAll();
    }

    public void insertItem(Test test) throws Exception {
        testDao.insertItem(test);
    }
}
