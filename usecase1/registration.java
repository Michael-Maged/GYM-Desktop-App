package usecase1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class registration {

    private static final String csvFile = "SocialMediaPlatform\\registered_users.csv";

    public static void registerUser(String username, String password, String email){
        
        if (username.contains(" ")) {
            System.out.println("Username cannot contain spaces");
            return;
        }

        if (usernameTaken(username)){
            System.out.println("Username already taken");
            return;
        }

        if (!verifyEmail(email)){
            return;
        }

        if (!passLen(password)){
            System.out.println("Password must be more than 6 characters");
            return;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(csvFile, true))) {
            if (new File(csvFile).length() == 0) {
                writer.write("Username,Email,Password\n");
            }
            writer.write(username.toLowerCase() + "," + email + "," + password + "\n");
            System.out.println("User registered successfully");
        } 
        catch (IOException e){
            System.out.println("Error occurred while registering user");
            e.printStackTrace();
        }
    }

    private static boolean usernameTaken(String username) {
        try (BufferedReader reader = new BufferedReader(new FileReader(csvFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] userData = line.split(",");
                if (userData[0].equals(username)) {
                    return true;
                }
            }
        } 
        catch (IOException e) {
            System.out.println("Error occurred while checking username");
            e.printStackTrace();
        }
        return false;
    }

    private static boolean verifyEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        Pattern p = Pattern.compile(emailRegex);
        Matcher m = p.matcher(email);
        
        try (BufferedReader reader = new BufferedReader(new FileReader(csvFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] userData = line.split(",");
                if (userData[1].equals(email)) {
                    System.out.println("Email already in use");
                    return false;
                }
            }
        } 
        catch (IOException e) {
            System.out.println("Error occurred while checking email");
            e.printStackTrace();
        }
        
        if (m.matches()){
            return true;
        }
        else{
            System.out.println("Invalid email address");
            return false;
        }
    }

    private static boolean passLen(String password){
        return password.length() >= 6;
    }
}

