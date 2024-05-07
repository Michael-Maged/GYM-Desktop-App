import java.util.List;

public class Recipe {
    private String name;
    private List<String> ingredients;
    private int preparationTime;
    private NutritionalFacts nutritionalFacts;
    private String instructions;

    public Recipe(String name, List<String> ingredients, int preparationTime, NutritionalFacts nutritionalFacts, String instructions) {
        this.name = name;
        this.ingredients = ingredients;
        this.preparationTime = preparationTime;
        this.nutritionalFacts = nutritionalFacts;
        this.instructions = instructions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public int getPreparationTime() {
        return preparationTime;
    }

    public void setPreparationTime(int preparationTime) {
        this.preparationTime = preparationTime;
    }

    public NutritionalFacts getNutritionalFacts() {
        return nutritionalFacts;
    }

    public void setNutritionalFacts(NutritionalFacts nutritionalFacts) {
        this.nutritionalFacts = nutritionalFacts;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }
}