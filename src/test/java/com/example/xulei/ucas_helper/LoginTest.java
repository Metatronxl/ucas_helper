package com.example.xulei.ucas_helper;


import com.example.xulei.ucas_helper.service.LoginService;
import com.example.xulei.ucas_helper.utils.TestAccount;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author lei.X
 * @date 2018/9/26
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class LoginTest {


    @Autowired
    private LoginService loginService;

    @Before
    public void init(){
        System.out.println("====begin test=====");
    }

    @After
    public void after(){
        System.out.println("====test end======");
    }

    @Test
    public void testMainPage(){
        loginService.vertifyHomePage();
    }

    @Test
    public void  testLogin(){
        String userName = TestAccount.USERNAME;
        String pwd  = TestAccount.PWD;

        loginService.login(userName,pwd);

    }
}
