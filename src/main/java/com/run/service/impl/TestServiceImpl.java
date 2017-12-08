package com.run.service.impl;

import com.run.dao.TestDao;
import com.run.dao.TestMapper;
import com.run.entity.Test;
import com.run.entity.TestExample;
import com.run.service.TestService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestDao testDao;

    @Autowired
    private TestMapper testMapper;

    @Override
    public List<Test> selectAll() throws Exception{
        testInnerService();
        return testDao.selectAll();
    }

    public void insertItem(Test test) throws Exception {
        testDao.insertItem(test);
    }

//    public List<Test> testRowbounds() throws Exception {
//        int offset = 3;
//        int limit = 1;
//        RowBounds rowBounds = new RowBounds(offset,limit);
//        TestExample example = new TestExample();
//        TestExample.Criteria criteria =example.createCriteria();
//        criteria.andIdEqualTo("24");
//        List<com.run.entity.Test> testList = testMapper.selectByExampleWithRowbounds(example,rowBounds);
//        for (com.run.entity.Test test : testList) {
//            System.out.println(test);
//        }
//    }


    @Override
    public void testInnerService() {
        System.out.println("testsetsettset");
    }
}
