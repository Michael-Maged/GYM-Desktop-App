package usecase1;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class login {


    private static final String csvFile = "GYM-Desktop-App\\registered_users.csv";

    public static profile loginUser(Integer ID, String password) {
        try (BufferedReader reader = new BufferedReader(new FileReader(csvFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] userData = line.split(",");
                if ((userData[0].equals(ID.toString())) && userData[2].equals(password)) {
                    System.out.println("Successful Login");
                    return new profile(userData[0], userData[1], userData[2]);
                }
            }
        }
        catch (IOException e) {
            System.out.println("Error occurred while logging in");
            e.printStackTrace();
        }

        System.out.println("Invalid username or password");
        return null;
    }
}

