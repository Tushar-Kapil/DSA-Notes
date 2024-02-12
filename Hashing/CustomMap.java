package Hashing;

import java.util.ArrayList;
import java.util.List;

public class CustomMap<K, V> {

    private List<MapNode<K, V>> bucket;
    private int capacity;
    private int size;
    private final int INITIAL_CAPACITY = 5;

    CustomMap() {
        bucket = new ArrayList<>();
        capacity = INITIAL_CAPACITY;
        for (int i = 0; i < capacity; i++) {
            bucket.add(null);
        }
    }

    private int getBucketIndex(K key) {
        int hashCode = key.hashCode();

        return hashCode % capacity;
    }

    public V get(K key) {
        int bucketIndex = getBucketIndex(key);

        MapNode<K, V> head = bucket.get(bucketIndex);

        while (head != null) {
            if (head.key.equals(key)) {
                return head.value;
            }
            head = head.next;
        }
        return null;
    }

    public void put(K key, V value) {
        int bucketIndex = getBucketIndex(key);
        MapNode<K, V> head = bucket.get(bucketIndex);

        while (head != null) {
            if (head.key.equals(key)) {
                head.value = value;
                break;
            }
            head = head.next;
        }
        size++;
        MapNode<K, V> node = new MapNode<>(key, value);
        head = bucket.get(bucketIndex);
        node.next = head;
        bucket.set(bucketIndex, node);

        double loadFactor = (1.0 * size) / capacity;

        if (loadFactor > 0.7) {
            rehash();
        }

    }

    private void rehash() {
        List<MapNode<K, V>> temp = bucket;
        bucket = new ArrayList<>();
        capacity *= 2;

        for (int i = 0; i < capacity; i++) {
            bucket.add(null);
        }

        size = 0;

        for (int i = 0; i < temp.size(); i++) {
            MapNode<K, V> head = temp.get(i);

            while (head != null) {
                put(head.key, head.value);
                head = head.next;
            }
        }
    }

    public void remove(K key) {
        int bucketIndex = getBucketIndex(key);
        MapNode<K, V> head = bucket.get(bucketIndex);
        MapNode<K, V> prev = null;

        while (head != null) {
            if (head.key.equals(key)) {
                if (prev == null) {
                    bucket.set(bucketIndex, head.next);
                } else {
                    prev.next = head.next;
                    head.next = null;
                    size--;
                    break;
                }
            }
            prev = head;
            head = head.next;
        }
    }

    @SuppressWarnings("hiding")
    private class MapNode<K, V> {
        K key;
        V value;
        MapNode<K, V> next;

        MapNode(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        CustomMap<Integer, String> map = new CustomMap<>();
        map.put(1, "Tushar");
        map.put(2, "Tanya");
        map.put(3, "Stuart");
        System.out.println(map.get(3));
    }

}
