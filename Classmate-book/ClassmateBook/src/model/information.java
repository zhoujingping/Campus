package model;

public class information {
    String name = null;
    String address = null;
    String phone = null;
    String wchat = null;
    String email = null;
    String QQ = null;
    int classId = 0;
    String Message = null;
    int id = 0;

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public int getClassId() {
        return classId;
    }

    public String getAddress() {
        return address;
    }

    public String getMessage() {
        return Message;
    }

    public String getQQ() {
        return QQ;
    }

    public String getWchat() {
        return wchat;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public void setQQ(String QQ) {
        this.QQ = QQ;
    }

    public void setWchat(String wchat) {
        this.wchat = wchat;
    }
}
