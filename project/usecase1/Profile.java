public class Profile {
    private String Name;
    private String password;
    private String email;
    private String profilePicture;
    private long phonenumber;


    public profile(String Name, String email, String password , long phonenumber) {
        this.Name = Name;
        this.email = email;
        this.password = password;
        this.phonenumber = phonenumber;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public void setphonenumber(long phonenumber) {
        this.phonenumber = phonenumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }
    
    public String getName() {
        return this.Name;
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

    public long getPhonenumber() {
        return this.phonenumber;
    }

}

class UserProfile extends profile{
    private static int ID_Counter = 1;
    private int ID;
    private float weight;
    private int height;
    private int age;
    private boolean isMale; 
    private double currentBMR;
    private float OldWeights;
    private float NewWeights;
    private MemPackage UserPackage;
    private int Musclemass; // in kilograms
    private int Waterpercentage;
    private double Bodyfatpercentage;
    private int idealWeight;
    private String metabolicRateComparison = "";
    private String waterPercentageComparison = "";
    private String muscleMassComparison = "";
    private String bodyFatComparison = "";
    // Construct the comparison message
    public  String comparisonMessage = "Comparison with another analysis:\n" +
            "Body Fat Percentage: " + bodyFatComparison + "\n" +
            "Muscle Mass: " + muscleMassComparison + "\n" +
            "Water Percentage: " + waterPercentageComparison + "\n" +
            "Metabolic Rate: " + metabolicRateComparison;


    public UserProfile(String username, String email, String password,float weight, int height, int age, boolean isMale , long phonenumber ){
        super(username,email,password ,phonenumber);
        this.height = height;
        this.weight = weight;
        this.age = age;
        this.isMale = isMale;
        this.ID = ID_Counter;
        ID_Counter ++ ;

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

    public void setOldWeights(float OldWeights){
        this.OldWeights = OldWeights;
    }

    public void setNewWeight(float Newweight){
        this.OldWeights = this.NewWeights;
        this.NewWeights = Newweight;
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

    public int getID()
    {
        return ID;
    }

    public double getBodyfatpercentage(){return Bodyfatpercentage;}
    public int getmuscleMass(){return Musclemass;}; // in kilograms
    public int getwaterPercentage(){return Waterpercentage;};
    public int getIdealWeight(){return idealWeight;}

    public void calcBMR(){
        if(this.isMale){
            currentBMR = ((10*this.weight) + (6.25*this.height) - (5*this.age) + 5);
        }
        else{
            currentBMR = ((10*this.weight) + (6.25*this.height) - (5*this.age) - 161);
        }
        System.out.println("MultiPly the calories by your activity level");
    }

    public double getUserCalories(){
        return currentBMR;
    }

    public float trackProgress (){
        return (this.NewWeights - this.OldWeights);
    }

    public void calculateIdealWeight() {
        double heightSquared = Math.pow((this.height * Math.pow(10,-2)), 2);
        double temp = 22 * heightSquared;
        idealWeight = (int) Math.round(temp);
    }
    public void comparebodyfat(double targetbodyfat) {
        // Compare body fat percentage

        if (this.Bodyfatpercentage < targetbodyfat) {
            bodyFatComparison = "Lower body fat percentage";
        } else if (this.Bodyfatpercentage > targetbodyfat) {
            bodyFatComparison = "Higher body fat percentage";
        } else {
            bodyFatComparison = "Similar body fat percentage";
        }
    }
        public void comparemusclemass(int targetmusclemass){
            if (this.Musclemass < targetmusclemass) {
                muscleMassComparison = "Lower muscle mass";
            } else if (this.Musclemass > targetmusclemass) {
                muscleMassComparison = "Higher muscle mass";
            } else {
                muscleMassComparison = "Similar muscle mass";
            }
        }
        // Compare water percentage
            public void comparewaterpercentage(int targetwaterpercentage){

            if (this.Waterpercentage < targetwaterpercentage) {
                waterPercentageComparison = "Lower water percentage";
            } else if (this.Waterpercentage > targetwaterpercentage) {
                waterPercentageComparison = "Higher water percentage";
            } else {
                waterPercentageComparison = "Similar water percentage";
            }
        }
        // Compare metabolic rate
        public void comparemetabolicrate(int targetBMR){

        if (this.currentBMR < targetBMR) {
            metabolicRateComparison = "Lower metabolic rate";
        } else if (this.currentBMR > targetBMR) {
            metabolicRateComparison = "Higher metabolic rate";
        } else {
            metabolicRateComparison = "Similar metabolic rate";
        }
}

}

class TrainerProfile extends profile{
    private int YearsOfExperience;
    private String specialties;


    public TrainerProfile(String username, String email, String password, int YearsOfExperience, String specialties, long phonenumber){
        super(username,email,password,phonenumber);
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
