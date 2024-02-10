package Hashing;

import java.util.HashMap;
import java.util.Map;

public class HMap {

    public static void main(String[] args) {
        // UnOrdered
        HashMap<Integer, String> map = new HashMap<>();

        map.put(62, "Tushar");
        map.put(42, "Tanya");

        System.out.println(map);

        System.out.println(map.containsKey(63));

        System.out.println(map.get(62));

        for (Map.Entry<Integer, String> e : map.entrySet()) {
            System.out.print(e.getKey() + ": ");
            System.out.print(e.getValue() + ",");
        }

    }
}
