import ingredients.IngredientsInventoryService;

import java.util.concurrent.Semaphore;

public class CoffeeMachine {
    private static int NO_OF_OUTLETS;
    private final Semaphore availableOutlet = new Semaphore(NO_OF_OUTLETS, true);
    private boolean[] inUse = new boolean[NO_OF_OUTLETS];
    private CoffeeOutlet[] coffeeOutlets = new CoffeeOutlet[NO_OF_OUTLETS];
    static {
        NO_OF_OUTLETS = InputFactory.getNoOfOutlets();
    }

    private final IngredientsInventoryService ingredientsInventoryService;

    public CoffeeMachine(IngredientsInventoryService ingredientsInventoryService) {
        this.ingredientsInventoryService = ingredientsInventoryService;
        for(int i=0; i<NO_OF_OUTLETS; i++) {
            coffeeOutlets[i] = new CoffeeOutlet(i, ingredientsInventoryService);
        }
    }

    public Object allotOutlet() throws InterruptedException {
        availableOutlet.acquire();
        return getNextAvailableCoffeeOutlet();
    }

    private synchronized CoffeeOutlet getNextAvailableCoffeeOutlet() {
        CoffeeOutlet coffeeOutlet = null;
        for(int i=0; i < NO_OF_OUTLETS; i++) {
            if(!inUse[i]) {
                inUse[i] = true;
                coffeeOutlet = coffeeOutlets[i];
                break;
            }
        }
        return coffeeOutlet;
    }

    public void releaseOutlet(CoffeeOutlet coffeeOutlet) {
        if(markAsReady(coffeeOutlet))
            availableOutlet.release();
    }

    private synchronized boolean markAsReady(CoffeeOutlet coffeeOutlet) {

        int id = coffeeOutlet.getId();
        if(inUse[id]) {
            inUse[id] = false;
            return true;
        }
        return false;
    }
}


