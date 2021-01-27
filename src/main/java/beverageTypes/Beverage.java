package beverageTypes;

import java.util.Map;

public interface Beverage {

    String beverageType();
    Map<String, Integer> ingredientsRequired();
}
