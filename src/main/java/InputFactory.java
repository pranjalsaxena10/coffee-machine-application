import ingredients.IngredientsTypes;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * This class is used to read data from file system
 */
public class InputFactory {

    private static String filePath;
    private static JSONObject machine;
    private static int NO_OF_OUTLETS;
    private static int NO_OF_BEVERAGES;

    public InputFactory(String path) {
        filePath = path;
    }

    public JSONObject getAvailableIngredients() {
        return machine;
    }

    public static String getFilePath() {
        return filePath;
    }

    public static JSONObject getMachine() {
        return machine;
    }

    public static int getNoOfOutlets() {
        return NO_OF_OUTLETS;
    }

    public static int getNoOfBeverages() {
        return NO_OF_BEVERAGES;
    }

    public static void invokeFileInput() {
        JSONParser jsonParser = new JSONParser();

        try {
            Reader reader = new FileReader(filePath);
            JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
            machine = (JSONObject) jsonObject.get("machine");
            JSONObject outlets = (JSONObject) machine.get("outlets");
            Long count_n = (Long) outlets.get("count_n");
            NO_OF_OUTLETS = count_n.intValue();
            JSONObject beverages = (JSONObject) machine.get("beverages");
            NO_OF_BEVERAGES = beverages.size();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}
