package com.team.safari.Service;

import com.team.safari.Dao.UserDAO;
import com.team.safari.Vo.UserVO;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;

    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public void registerUser(UserVO userVO) {
        userDAO.save(userVO);
    }
}