package com.safari.safari.dao;

import com.safari.safari.common.Common;
import com.safari.safari.vo.MembersVO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;



public class MembersSelectDAO {

    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    public List<MembersVO> selectMembersInfo(){
        List<MembersVO> mvl = new ArrayList<>();
        try{
            conn = Common.getConnection();
            String sql = "SELECT USER_ID, USER_ALIAS, USER_NAME, USER_EMAIL, USER_PHONE, TO_CHAR(JOIN_DATE, 'YYYY-MM-DD') JOIN_DATE, HERO_GRADE, USER_POINT, TRUNC(SYSDATE - JOIN_DATE) DAYS\n" +
                    "                    FROM MEMBERS M JOIN GRADE G\n" +
                    "                    ON M.USER_POINT BETWEEN G.LO_POINT AND G.HI_POINT";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while(rs.next()){
                String userId = rs.getString("USER_ID");
                String userAlias = rs.getString("USER_ALIAS");
                String userName = rs.getString("USER_NAME");
                String userEmail = rs.getString("USER_EMAIL");
                String userPhone = rs.getString("USER_PHONE");
                String joinDate = rs.getString("JOIN_DATE");
                String heroGrade = rs.getString("HERO_GRADE");
                int userPoint = rs.getInt("USER_POINT");
                int days = rs.getInt("DAYS");

                mvl.add(new MembersVO(userId,userAlias,userName,userEmail,userPhone,joinDate,heroGrade,userPoint,days));

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