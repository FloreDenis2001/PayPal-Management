package model;

public class Users {
    private int userId;
    private String userPhoneNo;
    private String userEmail;
    private String userFirstName;
    private String userLastName;
    private int dateOfBirth;
    private String address;
    private String password;

    public Users(int userId, String userPhoneNo, String userEmail, String userFirstName, String userLastName, int dateOfBirth, String address, String password) {
        this.userId = userId;
        this.userPhoneNo = userPhoneNo;
        this.userEmail = userEmail;
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.password = password;
    }


    public Users(String users) {
        String[] path = users.split(",");
        this.userId = Integer.parseInt(path[0]);
        this.userPhoneNo = path[1];
        this.userEmail = path[2];
        this.userFirstName = path[3];
        this.userLastName = path[4];
        this.dateOfBirth = Integer.parseInt(path[5]);
        this.address = path[6];
        this.password = path[7];
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserPhoneNo() {
        return userPhoneNo;
    }

    public void setUserPhoneNo(String userPhoneNo) {
        this.userPhoneNo = userPhoneNo;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public int getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(int dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public String descriere() {
        String text = "Id : " + this.userId + "\n";
        text += "Phone : " + this.userPhoneNo + "\n";
        text += "Email : " + this.userEmail + "\n";
        text += "First Name : " + this.userFirstName + "\n";
        text += "Last Name : " + this.userLastName + "\n";
        text += "Date Of Birth : " + this.dateOfBirth + "\n";
        text += "Address : " + this.address + "\n";
        text += "Password: " + this.password + "\n";
        return text;
    }

    public String toSave() {
        String text = this.userId + "," + this.userPhoneNo + "," + this.userEmail + "," + this.userFirstName + "," + this.userLastName + "," + this.dateOfBirth + "," + this.address+","+this.password;
        return text;
    }
}
