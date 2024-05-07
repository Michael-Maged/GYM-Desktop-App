public class Profile {
    private String Name;
    private String password;
    private String email;
    private String profilePicture;


    public Profile(String Name, String email, String password) {
        this.Name = Name;
        this.email = email;
        this.password = password;
    }

    public void setName(String Name) {
        this.Name = Name;
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
}

class UserProfile extends Profile{
    private float weight;
    private int height;
    private int age;
    private boolean isMale; 
    private double currentBMR;
    private float OldWeights;
    private float NewWeights;
    private MemPack UserPackage;
    private int Musclemass;
    private int Waterpercentage;
    private double Bodyfatpercentage;
    private int calories;


    public UserProfile(String name, String email, String password, int height, int age, float weight, boolean isMale){
        super(name,email,password);
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

    public void setMMP(int Musclemass){
        this.Musclemass = Musclemass;
    }

    public void setPBF(double Bodyfatpercentage){
        this.Bodyfatpercentage = Bodyfatpercentage;
    }

    public void setOldWeights(float OldWeights){
        this.OldWeights = OldWeights;
    }

    public void setNewWeight(float Newweight){
        this.OldWeights = this.NewWeights;
        this.NewWeights = Newweight;
    }

    public int getheight() {
        return this.height;
    }

    public float getweight() {
        return this.weight;
    }

    public int getage() {
        return this.age;
    }

    public boolean getisMale() {
        return this.isMale;
    }

    public double getBodyfatpercentage(){
        return this.Bodyfatpercentage;
    }

    public int getMMP(){
        return this.Musclemass;
    }

    public int getwaterPercentage(){
        return this.Waterpercentage;
    }

    public void calcBMR(){
        if(this.isMale){
            this.currentBMR = ((10*this.weight) + (6.25*this.height) - (5*this.age) + 5);
            this.calories = (int)Math.round(this.currentBMR * 1.5);
        }
        else{
            this.currentBMR = ((10*this.weight) + (6.25*this.height) - (5*this.age) - 161);
            this.calories = (int)Math.round(this.currentBMR * 1.5);
        }
    }

    public double getBMR(){
        return this.currentBMR;
    }

    public double getcalories(){
        return this.calories;
    }

    public float trackProgress (){
        return (this.NewWeights - this.OldWeights);
    }
}