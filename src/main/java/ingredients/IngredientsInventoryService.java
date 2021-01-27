package ingredients;

import exception.IllegalIngredientException;
import exception.InsufficientIngredientException;

import java.util.Map;

public interface IngredientsInventoryService {

    /**
     * This method is designed to return available ingredients status in the form of map
     * @return Map which stores name of ingredients as key and their available quantities as values
     */

    Map<IngredientsTypes, Integer> getIngredientsInfo();

    /**
     * This method is used to reduce the quantity of ingredient after it is utilized
     * @param ingredientName
     * @param value
     */
    void reduce(String ingredientName, Integer value) throws IllegalIngredientException, InsufficientIngredientException;
}