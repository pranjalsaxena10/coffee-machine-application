import beverageTypes.Beverage;
import exception.IllegalIngredientException;
import exception.InsufficientIngredientException;

public class User implements Runnable {

    private CoffeeMachine coffeeMachine;
    private Beverage beverage;

    public User(CoffeeMachine coffeeMachine, Beverage beverage) {
        this.coffeeMachine = coffeeMachine;
        this.beverage = beverage;
    }

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        try {

            CoffeeOutlet coffeeOutlet = (CoffeeOutlet) coffeeMachine.allotOutlet();
            coffeeOutlet.prepareBeverage(beverage);
            coffeeMachine.releaseOutlet(coffeeOutlet);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (InsufficientIngredientException e) {
            System.out.println(String.format("%s cannot be prepared because item %s", beverage.beverageType(), e.getMessage()));
        } catch (IllegalIngredientException e) {
            System.out.println(String.format("%s cannot be prepared because %s", beverage.beverageType(), e.getMessage()));
        }
    }
}
