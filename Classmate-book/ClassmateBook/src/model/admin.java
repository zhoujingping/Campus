package model;

public class admin {
    String userName = null;
    String passWord = null;
    String phone = null;
    String email = null;
    String school = null;

    public String getEmail() {
        return email;
    }

    public String getPassWord() {
        return passWord;
    }

    public String getPhone() {
        return phone;
    }

    public String getSchool() {
        return school;
    }

    public String getUserName() {
        return userName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
