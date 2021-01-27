package beverageTypes;

import ingredients.IngredientsTypes;

import java.util.HashMap;
import java.util.Map;

public class GreenTea implements Beverage {

    @Override
    public String beverageType() {
        return "green_tea";
    }

    @Override
    public Map<String, Integer> ingredientsRequired() {

        Map<String, Integer> requiredIngredients = new HashMap<>();
        requiredIngredients.put(IngredientsTypes.hot_water.name(), 100);
        requiredIngredients.put(IngredientsTypes.ginger_syrup.name(), 30);
        requiredIngredients.put(IngredientsTypes.sugar_syrup.name(), 50);
        requiredIngredients.put("green_mixture", 30);

        return requiredIngredients;

    }
}