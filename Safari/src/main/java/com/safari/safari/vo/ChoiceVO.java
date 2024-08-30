package com.safari.safari.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class ChoiceVO {

    private String userId;
    private String Password;
    private String userName;
    private String email;
    private String Phone;

    public ChoiceVO(String userId, String Password, String userName, String email, String Phone) {
        this.userId = userId;
        this.Password = Password;
        this.userName = userName;
        this.email = email;
        this.Phone = Phone;
    }
}
