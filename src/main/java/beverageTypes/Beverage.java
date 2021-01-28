package beverageTypes;

import java.util.Map;

/**
 * This interface is used to implement Simple Factory Design Pattern
 */
public interface Beverage {

    String beverageType();
    Map<String, Integer> ingredientsRequired();
}
