import java.util.HashMap;
import java.util.Map;

public class Branch {
    private String location;
    private Map<String, String> classTimings;
    private Map<String, String> specialFeatureTimings;

    public Branch(String location) {
        this.location = location;
        this.classTimings = new HashMap<>();
        this.specialFeatureTimings = new HashMap<>();
    }

    public String getLocation(){
        return this.location;
    }

    public void addClassTiming(String className, String day, String timing) {
        classTimings.put(day, className + " - " + timing);
    }

    public void addSpecialFeatureTiming(String featureName, String day, String timing) {
        specialFeatureTimings.put(day, featureName + " - " + timing);
    }
}