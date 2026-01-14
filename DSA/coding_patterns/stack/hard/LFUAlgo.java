
// https://leetcode.com/problems/lfu-cache/

package coding_patterns.stack.hard;
import java.util.*;

class Node {
    int value;
    int key;
    int freq;

    Node(int k, int v) {
        key = k;
        value = v;
        freq = 1;
    }
}

class LFUCache {
    Map<Integer, LinkedList<Node>> freqMap;
    Map<Integer, Node> map;
    int capacity;
    int minFreq;

    public LFUCache(int c) {
        capacity = c;
        freqMap = new LinkedHashMap<>();
        map = new LinkedHashMap<>();
    }

    public int get(int key) {
        Node touched = map.get(key);
        if (touched == null)
            return -1;

        int oldFreq = touched.freq;
        LinkedList<Node> oldList = freqMap.get(oldFreq);

        if (oldList != null && !oldList.isEmpty())
            oldList.remove(touched);

        if (oldList != null && oldList.isEmpty()) {
            freqMap.remove(oldFreq);
            if (minFreq == oldFreq) {
                minFreq++;
            }
        }

        touched.freq++;

        freqMap.computeIfAbsent(touched.freq, k -> new LinkedList<>()).addFirst(touched);

        map.put(key, touched);
        return touched.value;
    }

    public void put(int key, int value) {

        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            get(key);
            return;
        }

        if (map.size() == capacity) {
            LinkedList<Node> list = freqMap.get(minFreq);
            Node removeNode = list.removeLast();
            map.remove(removeNode.key);

            if (list.isEmpty()) {
                freqMap.remove(minFreq);
            }
        }

        Node node = new Node(key, value);
        map.put(key, node);
        freqMap.computeIfAbsent(1, k -> new LinkedList<>()).addFirst(node);
        minFreq = 1;
    }
}

public class LFUAlgo {
    public static void main(String[] args) {

    }
}