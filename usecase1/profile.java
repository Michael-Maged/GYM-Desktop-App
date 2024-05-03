package usecase1;

public class profile {
    private String username;
    private String password;
    private String email;
    private String profilePicture;


    public profile(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }
    
    public String getUsername() {
        return this.username;
    }

    public String getPassword(){
        return this.password;
    }

    public String getEmail() {
        return this.email;
    }

    public String getProfilePicture() {
        return this.profilePicture;
    }
    
}

class UserProfile extends profile{
    private float weight;
    private int height;
    private int age;
    private boolean isMale; 
    private double UserCalories;
    
    public UserProfile(String username, String email, String password,float weight, int height, int age, boolean isMale){
        super(username,email,password);
        this.height = height;
        this.weight = weight;
        this.age = age;
        this.isMale = isMale;
    }
    public void setheight(int height) {
        this.height = height;
    }

    public void setweight(float weight) {
        this.weight = weight;
    }

    public void setage(int age) {
        this.age = age;
    }

    public void setisMale(boolean isMale) {
        this.isMale = isMale;
    }
    public int getheight() {
        return height;
    }

    public float getweight() {
        return weight;
    }

    public int getage() {
        return age;
    }

    public boolean getisMale() {
        return isMale;
    }

    public void calcCalories(float weight,int height ,int age, boolean isMale){
        if(isMale){
            UserCalories = ((10*weight) + (6.25*height) - (5*age) + 5);
        }
        else{
            UserCalories = ((10*weight) + (6.25*height) - (5*age) - 161);
        }
        System.out.println("MultiPly the calories by your activity level");
    }

    public double getUserCalories(){
        return UserCalories;
    }
}

class TrainerProfile extends profile{
    private int YearsOfExperience;
    private String specialties;
    
    public TrainerProfile(String username, String email, String password, int YearsOfExperience, String specialties){
        super(username,email,password);
        this.YearsOfExperience = YearsOfExperience;
        this.specialties = specialties;
    }
    
    public void setYearsOfExperience( int YearsOfExperience){
        this.YearsOfExperience = YearsOfExperience;
    }

    public int getYearsOfExperience(){
        return YearsOfExperience;
    }

    public void Setspecialties(String specialties){
        this.specialties = specialties ;
    }

    public String getSpecialties(){
        return specialties;
    }

}
