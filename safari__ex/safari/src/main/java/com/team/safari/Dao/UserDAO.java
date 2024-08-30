package com.team.safari.Dao;

import com.team.safari.Vo.UserVO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAO {

    private final JdbcTemplate jdbcTemplate;

    public UserDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(UserVO userVO) {
        String sql = "INSERT INTO Users (UserID, Password, UserName, Email, Phone) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, userVO.getUserId(), userVO.getPassword(), userVO.getUserName(), userVO.getEmail(), userVO.getPhone());
    }
}