package coding_patterns.stack.hard;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

class Node {
    int value;
    int key;

    Node(int v, int k) {
        value = v;
        key = k;
    }
}

class LRUCache {
    int capacity;
    LinkedList<Node> list;
    Map<Integer, Node> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        list = new LinkedList<>();
        map = new HashMap<>();
    }

    public int get(int key) {
        Node touched = null;
        touched = map.get(key);

        if (touched == null)
            return -1;

        int val = touched.value;
        list.remove(touched);
        list.addFirst(touched);
        return val;
    }

    public void put(int key, int value) {

        if (map.containsKey(key)) {
            Node existing = map.get(key);
            existing.value = value;
            list.remove(existing);
            list.addFirst(existing);
            return;
        }

        if (list.size() >= capacity) {
            Node lastNode = list.removeLast();
            map.remove(lastNode.key);
        }

        Node newNode = new Node(value, key);
        map.put(key, newNode);
        list.addFirst(newNode);
    }
}

public class LRUAlgo {
    public static void main(String[] args) {

    }
}