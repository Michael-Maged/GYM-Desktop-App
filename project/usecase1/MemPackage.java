import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MemPackage {
    private String packName;
    private String duration;
    private Branch branch;
    private ArrayList<String> classes;
    private ArrayList<String> facilities;
    private Map<String, String> servicesDiscounts;

    public MemPackage(String packName, String duration, Branch branch){
        this.packName = packName;
        this.duration = duration;
        this.branch = branch;
        this.classes = new ArrayList<>();
        this.facilities = new ArrayList<>();
        this.servicesDiscounts = new HashMap<>();
    }

    public String getPackName(){
        return this.packName;
    }

    public String getDuration(){
        return this.duration;
    }

    public Branch getBranch(){
        return this.branch;
    }

    public void addClass(String classs){
        classes.add(classs);
    }

    public void addFacility(String facility){
        facilities.add(facility);
    }

    public void addServicesDiscounts(String service, Integer discount){
        servicesDiscounts.put(service, discount.toString() + "%");
    }

    
}
