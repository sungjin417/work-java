package com.example.test.dao;

import com.example.test.vo.UserVO;

import java.sql.SQLException;

public interface UserDAO {
    void insertUser(UserVO user) throws SQLException;
    // 필요한 경우 추가 메서드 정의
}

