package medium;

import java.util.HashMap;
import java.util.Map;

class LRUCache {

    class Node {
        int key, value;
        Node prev, next;

        Node(int k, int v) {
            key = k;
            value = v;
        }
    }

    private Map<Integer, Node> cache;
    private int capacity;
    private Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();

        // dummy nodes
        head = new Node(0, 0);
        tail = new Node(0, 0);

        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) return -1;

        Node node = cache.get(key);
        remove(node);
        insert(node); // move to front

        return node.value;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            remove(node);
        }

        Node newNode = new Node(key, value);
        cache.put(key, newNode);
        insert(newNode);

        if (cache.size() > capacity) {
            Node lru = tail.prev;
            remove(lru);
            cache.remove(lru.key);
        }
    }

    // remove node from DLL
    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insert(Node node) {
        node.next = head.next;
        node.prev = head;

        head.next.prev = node;
        head.next = node;
    }

    public static void main(String[] args) {
        System.out.println("=== LRU Cache Simulation (capacity = 3) ===\n");
        LRUCache lru = new LRUCache(3);

        lru.put(1, 10);
        System.out.println("put(1, 10)");

        lru.put(2, 20);
        System.out.println("put(2, 20)");

        lru.put(3, 30);
        System.out.println("put(3, 30)");

        System.out.println("get(1) = " + lru.get(1));   // 10, also makes 1 most recent

        lru.put(4, 40); // evicts key 2 (least recently used)
        System.out.println("put(4, 40)  --> evicts key 2");

        System.out.println("get(2) = " + lru.get(2));   // -1, already evicted
        System.out.println("get(3) = " + lru.get(3));   // 30
        System.out.println("get(4) = " + lru.get(4));   // 40

        lru.put(5, 50); // evicts key 1 (least recently used now)
        System.out.println("put(5, 50)  --> evicts key 1");

        System.out.println("get(1) = " + lru.get(1));   // -1, evicted
        System.out.println("get(3) = " + lru.get(3));   // 30
        System.out.println("get(4) = " + lru.get(4));   // 40
        System.out.println("get(5) = " + lru.get(5));   // 50

        System.out.println("\n=== Update existing key ===\n");
        lru.put(3, 300); // update key 3, moves it to most recent
        System.out.println("put(3, 300) --> updates key 3");
        System.out.println("get(3) = " + lru.get(3));   // 300
    }
}