package com.run.dao;

import com.run.entity.Test;

import java.util.List;

public interface TestDao {

    public List<Test> selectAll() throws Exception;

    public void insertItem(Test test) throws Exception;
}
