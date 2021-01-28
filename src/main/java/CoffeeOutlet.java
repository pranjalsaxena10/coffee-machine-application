import beverageTypes.Beverage;
import exception.IllegalIngredientException;
import exception.InsufficientIngredientException;
import ingredients.IngredientsInventoryService;

import java.util.Map;

/**
 * This class is used to implement functionality of each outlet available in Coffee Machine
 */
public class CoffeeOutlet {
    private int id;
    private IngredientsInventoryService ingredientsInventoryService;

    public CoffeeOutlet(int id, IngredientsInventoryService ingredientsInventoryService) {
        this.id = id;
        this.ingredientsInventoryService = ingredientsInventoryService;
    }

    /**
     * Id of the outlet
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id of that outlet
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * This method is used to implement functionality of Beverage preparation
     * @param beverage
     * @throws InsufficientIngredientException
     * @throws InterruptedException
     * @throws IllegalIngredientException
     */
    public void prepareBeverage(Beverage beverage) throws InsufficientIngredientException, InterruptedException, IllegalIngredientException {
        try {
            Thread.sleep(4000);
            for (Map.Entry<String, Integer> entry : beverage.ingredientsRequired().entrySet()) {
                String key = entry.getKey();
                Integer value = entry.getValue();
                try {
                    ingredientsInventoryService.reduce(key, value);
                } catch (IllegalIngredientException | InsufficientIngredientException ex) {
                    throw ex;
                }

            }

            System.out.println(String.format("%s is prepared",beverage.beverageType()));

        } catch(InterruptedException | IllegalIngredientException | InsufficientIngredientException e) {
            throw e;
        }
    }
}
