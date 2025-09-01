import java.util.HashMap;
import java.util.Map;

public class UserServices {

    private Map<String , UserDetails> useMap = new HashMap<>();
    private UserDetails currentUser = null;

    // User registration logic
    public boolean registerUser(String username, String fullName , String password , String email ,  String phone) {

        if(useMap.containsKey(username)){
            System.out.println("Username already exists!");
            return false;
        }

        UserDetails user =  new UserDetails(fullName , username , password , email , phone);
        useMap.put(username, user);
        System.out.println("User registered successfully!");
        return true;
    }


    // user login  logic
    public boolean loginUser(String username, String password ) {
        if(!useMap.containsKey(username)){
            System.out.println("Invalid Username : " + username);
            return false;
        }

        UserDetails user = useMap.get(username);
        if(!user.getPassword().equals(password)){

            System.out.println("Incorrect password!");
            return false;
        }

        currentUser = user;
        System.out.println("Logged in successfully " + currentUser.getFullName() + " !");
        return true;
    }

    public void logoutUser(){
        if(currentUser != null){
            System.out.println( currentUser.getFullName() + "Logged out successfully ");
        }
        currentUser = null;
    }

    public UserDetails getCurrentUser() {
        return currentUser;
    }

    public boolean isLoggedIn(){
        return currentUser != null;
    }

}


