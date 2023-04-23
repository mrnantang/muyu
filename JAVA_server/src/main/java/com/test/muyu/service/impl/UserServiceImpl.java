package com.test.muyu.service.impl;

import com.test.muyu.exception.MallException;
import com.test.muyu.exception.MallExceptionEnum;
import com.test.muyu.model.dao.UserMapper;
import com.test.muyu.model.pojo.User;
import com.test.muyu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public void submitData(String userName,Integer count){
        User user = new User();
        user.setUserName(userName);
        user.setCount(count);
        submitTodayData(user);
        User result = userMapper.selectByName(userName);
        int i = 0;//偷懒更新和添加写到一起
        if (result != null){
            user.setCount(result.getCount() + count);
            i = userMapper.updateUser(user);
        }else {
            i = userMapper.insertUserData(user);
        }
        if (i == 0)
            throw new MallException(MallExceptionEnum.SUBMIT_FAILED);
    }

    public void submitTodayData(User user){
        int i = userMapper.inertTodayRankingList(user);
        if (i==0)
            throw new MallException(MallExceptionEnum.SUBMIT_FAILED);
    }

    @Override
    public List<User> getRankingList(){
        List<User> users = userMapper.selectRankingList();
        return users;
    }

    @Override
    public List<User> getRankingListForDate(){
        List<User> users = userMapper.selectRankingForDate();
        return users;
    }

    @Override
    public void deleteTodayRankingList(){
        int i = userMapper.deleteRankingList();
        if (i==0)
            throw new MallException(MallExceptionEnum.SYSTEM_ERROR);
    }



}
