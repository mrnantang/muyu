package com.test.muyu.model.dao;

import com.test.muyu.model.pojo.User;
import com.test.muyu.model.vo.UserVo;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    User selectByName(String userName);
    int updateUser(User user);
    int insertUserData(User user);
    int inertTodayRankingList(User user);
    List<User> selectRankingList();
    List<User> selectRankingForDate();
    int deleteRankingList();
}
