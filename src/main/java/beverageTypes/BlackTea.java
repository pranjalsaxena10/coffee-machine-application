package beverageTypes;

import ingredients.IngredientsTypes;

import java.util.HashMap;
import java.util.Map;

/**
 * Description about Black Tea
 */

public class BlackTea implements Beverage {

    @Override
    public String beverageType() {
        return "black_tea";
    }

    @Override
    public Map<String, Integer> ingredientsRequired() {

        Map<String, Integer> requiredIngredients = new HashMap<>();
        requiredIngredients.put(IngredientsTypes.hot_water.name(), 300);
        requiredIngredients.put(IngredientsTypes.ginger_syrup.name(), 30);
        requiredIngredients.put(IngredientsTypes.sugar_syrup.name(), 50);
        requiredIngredients.put(IngredientsTypes.tea_leaves_syrup.name(), 30);

        return requiredIngredients;

    }
}
