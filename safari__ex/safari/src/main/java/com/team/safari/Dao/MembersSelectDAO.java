package com.team.safari.Dao;


import com.team.safari.Common.Common;
import com.team.safari.Vo.UserVO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;



public class MembersSelectDAO {

    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    public List<UserVO> selectMembersInfo(){
        List<UserVO> mvl = new ArrayList<>();
        try{
            conn = Common.getConnection();
            String sql = "SELECT USER_ID, USER_PASSWORD, USER_NAME, USER_EMAIL, USER_PHONE \n" +
                    "                    FROM Users JOIN UserSelections \n" +
                    "                    ON M.USER_POINT BETWEEN G.LO_POINT AND G.HI_POINT";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while(rs.next()){
                String userId = rs.getString("USER_ID");
                String password = rs.getString("USER_PASSWORD");
                String userName = rs.getString("USER_NAME");
                String email = rs.getString("USER_EMAIL");
                String phone = rs.getString("USER_PHONE");

                UserVO userVO = new UserVO(userId, password, userName, email, phone);
                mvl.add(userVO);

            }
            Common.close(rs);
            Common.close(pstmt);
            Common.close(conn);
        }catch(Exception e) {
            e.printStackTrace();
        }
        return mvl;
    }




}