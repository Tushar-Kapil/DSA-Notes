package Hashing;

import java.util.HashMap;
import java.util.HashSet;

import java.util.Iterator;
import java.util.Map;

public class Hset {

    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();
        Map<String, Integer> cnt = new HashMap<>();

        // TreeSet --> natural order (slower than hashset)
        // LinkedHashSet --> maintains order (faster than TreeSet)
        // HashSet > LinkedHashSet > TreeSet

        set.add("Tushar");
        set.add("Tanya");
        set.add("Stuart");
        set.add("Bhalu");

        System.out.println("Size: " + set.size());

        System.out.println(set);

        // set.remove(1);

        System.out.println(set.contains("Tushar"));

        Iterator<String> it = set.iterator();

        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();

        set.forEach(System.out::print);
        System.out.println();

        for (String string : set) {
            System.out.print(string + " ");
        }

    }
}
