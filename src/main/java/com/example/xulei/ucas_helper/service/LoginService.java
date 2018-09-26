package com.example.xulei.ucas_helper.service;

import com.example.xulei.ucas_helper.model.CommonRes;
import com.example.xulei.ucas_helper.utils.ReturnUtil;
import com.example.xulei.ucas_helper.utils.UcasPage;
import lombok.extern.slf4j.Slf4j;
import net.dongliu.requests.RawResponse;
import net.dongliu.requests.Requests;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lei.X
 * @date 2018/9/26
 */
@Service
@Slf4j
public class LoginService {

    public final String TAG = "loginService";


    /**
     * login
     */
    public CommonRes<String> login(String username, String password){

        vertifyHomePage();

        String login_url = UcasPage.LOGIN_URL;
        Map<String,String> loginMap = new HashMap<>();
        loginMap.put("userName",username);
        loginMap.put("pwd",password);
        loginMap.put("sb","sb");

        try {
            RawResponse result = Requests.post(UcasPage.LOGIN_URL).body(loginMap).send();
            int statusCode = result.getStatusCode();
            log.info(TAG,"login result code:"+statusCode);

            return ReturnUtil.success("success :"+ String.valueOf(statusCode));
        } catch (Exception e) {
            log.error(TAG,e);
            return ReturnUtil.failed(e);
        }

    }

    /**
     * add login cookie
     */
    public void vertifyHomePage(){
        try {

            RawResponse response = Requests.get(UcasPage.LOGIN_PAGE).send();
            int statusCode = response.getStatusCode();
            log.info("status code:",statusCode);
        } catch (Exception e) {
            log.error(TAG,"首页验证错误:{}",e);
        }
    }

}
