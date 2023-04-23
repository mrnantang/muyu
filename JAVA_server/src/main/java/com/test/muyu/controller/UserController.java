package com.test.muyu.controller;

import com.test.muyu.common.ApiRestResponse;
import com.test.muyu.exception.MallException;
import com.test.muyu.exception.MallExceptionEnum;
import com.test.muyu.model.pojo.User;
import com.test.muyu.service.UserService;
import com.test.muyu.util.RC4Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.UnsupportedEncodingException;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/submit")
    @ResponseBody
    public ApiRestResponse submitData(@RequestParam("userName") String userName,@RequestParam("count") String count){

        try {
            count = RC4Util.decryRC4(count,"muyu12345678","utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String qm = count.substring(count.length()-4,count.length());
        if (!qm.equals("muyu")){
            return ApiRestResponse.error(MallExceptionEnum.SUBMIT_FAILED);
        }
        String i = count.substring(0,count.length()-4);
        userService.submitData(userName,Integer.parseInt(i));
        return ApiRestResponse.success();
    }

    @GetMapping("/rankingList")
    @ResponseBody
    public ApiRestResponse getRankingList(){
        List<User> rankingList = userService.getRankingList();
        return ApiRestResponse.success(rankingList);
    }

    @GetMapping("/rankingListDate")
    @ResponseBody
    public ApiRestResponse getRankingListForDate(){
        List<User> rankingList = userService.getRankingListForDate();
        return ApiRestResponse.success(rankingList);
    }
}
