import java.util.*;

public class CoolDrinksMenu {

    public static void main(String[] args) {

        Map<String, Integer> drinks = new LinkedHashMap<>();

        drinks.put("Coca Cola", 40);
        drinks.put("Pepsi", 40);
        drinks.put("Sprite", 35);
        drinks.put("Fanta", 35);
        drinks.put("Mountain Dew", 45);
        drinks.put("7Up", 35);
        drinks.put("Thums Up", 40);
        drinks.put("Maaza", 50);
        drinks.put("Slice", 50);

        System.out.println("----- Cool Drinks Menu -----");

        for (Map.Entry<String, Integer> entry : drinks.entrySet()) {
            System.out.println(entry.getKey() + " : ₹" + entry.getValue());
        }
    }
}
