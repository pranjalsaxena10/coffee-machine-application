package beverageTypes;

public class BeverageFactory {

    public Beverage create (final String beverageType) {
        switch (beverageType) {
            case "hot_tea":
                return new HotTea();
            case "hot_coffee":
                return new HotCoffee();
            case "black_tea":
                return new BlackTea();

            case "green_tea":
                return new GreenTea();
            default:
                throw new IllegalArgumentException(
                        "Wrong Beverage type: " + beverageType
                );
        }
    }
}
