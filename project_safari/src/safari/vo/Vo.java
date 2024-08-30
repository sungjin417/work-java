package safari.vo;

public class Vo {
    private String userID;     // 사원 이름
    private String username;      // 직책
    private String password;      // 부서번호
    private String email;         // 상관 사원 번호
    private int phonenumber;       // 입사 년도


    public Vo(String userID, String username, String email, int phonenumber,
              String password) {
        this.userID = userID;
        this.username = username;
        this.email = email;
        this.password = password;
        this.phonenumber = phonenumber;

    }


    public String getUserID() {
        return userID;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {return password;}

    public int getPhonenumber() {
        return phonenumber;
    }




    public void setUserID(String userID) {
        this.userID = userID;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {this.password = password;}

    public void setPhonenumber(int phonenumber) {
        this.phonenumber = phonenumber;
    }


}
