package com.test.muyu.service;

import com.test.muyu.model.pojo.User;

import java.util.List;

public interface UserService {
    void submitData(String userName,Integer count);
    List<User> getRankingList();

    List<User> getRankingListForDate();

    void deleteTodayRankingList();
}
