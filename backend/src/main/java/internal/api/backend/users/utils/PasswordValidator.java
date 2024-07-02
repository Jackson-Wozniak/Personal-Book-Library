package internal.api.backend.users.utils;

public class PasswordValidator {

    private static final String uppercase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String lowercase = "abcdefghijklmnopqrstuvwxyz";
    private static final String specials = "!@#$%&*()'+,-./:;<=>?[]^_`{|}";

    /*
    Requirements for valid password:
        - contains 8+ characters
        - has 1+ of each: uppercase, lowercase, number, and special char
        - does not contain spaces
     */
    public static boolean containsRequiredComponents(String password){
        if(password.length() < 8) return false;
        boolean upper = false;
        boolean lower = false;
        boolean number = false;
        boolean special = false;
        for(int i = 0; i < password.length(); i++){
            char temp = password.charAt(i);
            if(temp == ' ') return false;
            if(uppercase.contains(String.valueOf(temp))){
                upper = true;
                continue;
            }
            if(lowercase.contains(String.valueOf(temp))){
                lower = true;
                continue;
            }
            if(Character.isDigit(temp)){
                number = true;
                continue;
            }
            if(specials.contains(String.valueOf(temp))){
                special = true;
            }
        }
        return (upper && lower) && (number && special);
    }
}
