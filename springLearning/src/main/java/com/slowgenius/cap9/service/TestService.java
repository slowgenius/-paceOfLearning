package com.slowgenius.cap9.service;

import com.slowgenius.cap9.dao.TestDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @author slowgenius
 * @date 2/22/2020 8:09 PM
 * @description
 */
@Service
public class TestService {

    /**
     * 不加注解默认匹配的事变量名对应的dao
     */
    @Qualifier("testDao2")
    @Autowired
    private TestDao testDao;

    public TestDao getTestDao() {
        return testDao;
    }

    public void setTestDao(TestDao testDao) {
        this.testDao = testDao;
    }
}
