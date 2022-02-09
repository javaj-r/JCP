package question4;

import java.util.Map;

/**
 * @author javid
 * Created on 2/8/2022
 */
public class Main {

    public static void main(String[] args) {


        Map<String, String> map = new CustomHashMap<>();

        System.out.println("isEmpty: " + map.isEmpty());

        map.put("Elvis", "Presley");
        map.put("Priscilla", "Wagner");
        map.put("Tom", "Parker");

        System.out.println("isEmpty: " + map.isEmpty());

        System.out.println(map.toString());

        System.out.println(map.containsKey("Tom"));
        System.out.println(map.containsValue("Parker"));

        map.remove("Tom");

        System.out.println(map.toString());

        System.out.println(map.containsKey("Tom"));
        System.out.println(map.containsValue("Parker"));

        System.out.println("");

        for (Map.Entry<String, String> entry: map.entrySet()) {
            System.out.println(entry);
        }

        map.put("Priscilla", "Updated");

        System.out.println(map);

    }
}
