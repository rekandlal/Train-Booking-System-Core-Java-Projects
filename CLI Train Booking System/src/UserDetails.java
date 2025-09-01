public class UserDetails {

    private String fullName;
    private String userName;
    private String password;
    private String email;
    private String phone;

    //constructor
    public UserDetails(String fullName, String userName, String password, String email, String phone) {
        this.fullName = fullName;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.phone = phone;
    }

    //getter and setter

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    //pretty print

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("┌────────────┬──────────────────────────────┐\n");
        sb.append(String.format("│ %-10s │ %-28s │\n", "Field", "Value"));
        sb.append("├────────────┼──────────────────────────────┤\n");
        sb.append(String.format("│ %-10s │ %-28s │\n", "Full Name", fullName));
        sb.append(String.format("│ %-10s │ %-28s │\n", "User Name", userName));
        sb.append(String.format("│ %-10s │ %-28s │\n", "Email", email));
        sb.append(String.format("│ %-10s │ %-28s │\n", "Phone", phone));
        sb.append("└────────────┴──────────────────────────────┘");

        return sb.toString();
    }


}

