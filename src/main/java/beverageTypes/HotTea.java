package beverageTypes;

import ingredients.IngredientsTypes;

import java.util.HashMap;
import java.util.Map;

/**
 * Description about Hot Tea
 */
public class HotTea implements Beverage {
    @Override
    public String beverageType() {
        return "hot_tea";
    }

    @Override
    public Map<String, Integer> ingredientsRequired() {

        Map<String, Integer> requiredIngredients = new HashMap<>();
        requiredIngredients.put(IngredientsTypes.hot_water.name(), 200);
        requiredIngredients.put(IngredientsTypes.hot_milk.name(), 100);
        requiredIngredients.put(IngredientsTypes.ginger_syrup.name(), 10);
        requiredIngredients.put(IngredientsTypes.sugar_syrup.name(), 10);
        requiredIngredients.put(IngredientsTypes.tea_leaves_syrup.name(), 30);

        return requiredIngredients;

    }
}

