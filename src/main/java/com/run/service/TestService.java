package com.run.service;

import com.run.entity.Test;

import java.util.List;

public interface TestService {
    public List<Test> selectAll() throws Exception;

    public void insertItem(Test test) throws Exception;
}
