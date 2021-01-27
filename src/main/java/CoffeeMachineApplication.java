import beverageTypes.Beverage;
import beverageTypes.BeverageFactory;
import ingredients.IngredientsInventoryService;
import ingredients.IngredientsInventoryServiceImpl;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CoffeeMachineApplication {

    public static void main(String[] args) {
        IngredientsInventoryService ingredientsInventoryService = new IngredientsInventoryServiceImpl();
        CoffeeMachine coffeeMachine = new CoffeeMachine(ingredientsInventoryService);

        final int threadCount = 4;
        final ExecutorService service = Executors.newFixedThreadPool(threadCount);

        BeverageFactory beverageFactory = new BeverageFactory();
        String[] beveragesType = {"hot_tea", "hot_coffee", "black_tea", "green_tea"};
        Beverage[] beverages = new Beverage[4];
        for(int i=0; i<4; i++) {
            beverages[i] = beverageFactory.create(beveragesType[i]);
        }

        for(int i=0; i<threadCount; i++) {
            User user = new User(coffeeMachine, beverages[i]);
            service.execute(user);
        }

        service.shutdown();
    }
}

