package Strings;

public class StringB {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer("Tushar");
        // System.out.println(sb.capacity());

        sb.append(" Kapil");

        System.out.println(sb);

        sb.deleteCharAt(2);
        System.out.println(sb);

        sb.insert(0, "Hello ");
        System.out.println(sb);
    }
}