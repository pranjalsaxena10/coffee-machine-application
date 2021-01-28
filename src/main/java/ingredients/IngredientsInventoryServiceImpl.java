package ingredients;

import exception.IllegalIngredientException;
import exception.InsufficientIngredientException;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * This class is used to implement IngredientsInventoryService
 */
public class IngredientsInventoryServiceImpl implements IngredientsInventoryService {

    private Map<IngredientsTypes, Integer> availableIngredients;

    public IngredientsInventoryServiceImpl() {
        this.availableIngredients = new ConcurrentHashMap<>();
        this.availableIngredients.put(IngredientsTypes.hot_water, 500);
        this.availableIngredients.put(IngredientsTypes.hot_milk, 500);
        this.availableIngredients.put(IngredientsTypes.ginger_syrup, 100);
        this.availableIngredients.put(IngredientsTypes.sugar_syrup, 100);
        this.availableIngredients.put(IngredientsTypes.tea_leaves_syrup, 100);
    }


    /**
     * This method is designed to return available ingredients status in the form of map
     *
     * @return Map which stores name of ingredients as key and their available quantities as values
     */

    @Override
    public Map<IngredientsTypes, Integer> getIngredientsInfo() {
        return this.availableIngredients;
    }

    /**
     * This method is used to reduce the quantity of ingredient after it is utilized
     *
     * @param ingredientName
     * @param value
     */

    @Override
    public synchronized void reduce(String ingredientName, Integer value) throws IllegalIngredientException, InsufficientIngredientException {

        try {

            IngredientsTypes ingredientType = IngredientsTypes.valueOf(ingredientName);
            if(ingredientType != null && availableIngredients.containsKey(ingredientType)) {
                Integer availableValue = availableIngredients.get(ingredientType);
                if(availableValue < value) {
                    throw new InsufficientIngredientException(String.format("%s is not sufficient", ingredientName));
                }
                availableValue = availableValue - value;
                availableIngredients.put(ingredientType, availableValue);
            }

        } catch (IllegalArgumentException exception) {

            String errorMessage = String.format("%s is not available", ingredientName);
            IllegalIngredientException illegalIngredientException = new IllegalIngredientException(errorMessage);
            throw illegalIngredientException;

        }


    }
}

