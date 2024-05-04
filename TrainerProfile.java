class TrainerProfile {
    private String name;
    private String specialties;
    private String profilePic;

    public TrainerProfile(String name, String specialties, String profilePic) {
        this.name = name;
        this.specialties = specialties;
        this.profilePic = profilePic;
    }

    public String getName() {
        return name;
    }

    public String getSpecialties() {
        return specialties;
    }

    public String getImagePath() {
        return profilePic;
    }
}

