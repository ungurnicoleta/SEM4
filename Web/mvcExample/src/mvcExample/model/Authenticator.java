package mvcExample.model;

public class Authenticator {
	 
    public String authenticate(String username, String password) {
	// this is where we normally connect to a database and verify whether the username and password are correct.
	// instead of that we just return success if username is "user1" and password is "pass1"
        if (("user1".equalsIgnoreCase(username))
                && ("pass1".equals(password))) {
            return "success";
        } else {
            return "failure";
        }
    }
}
