package study.piepie.algorithm.cache;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;

/**
 * @author Robin
 * @date 2021-05-08 10:15
 **/
@Getter
@Setter
public class LRUCache implements Cache {
    private int capacity;
    // 也可以使用java自带的LinkedHashMap实现
    private HashMap<Integer, Node> cache;
    // 实现一个双向链表
    private DoubleList doubleList;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        doubleList = new DoubleList();
        cache = new HashMap<>();
    }

    @Override
    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        Node node = cache.get(key);
        makeRecently(key);
        return node.getValue();
    }

    @Override
    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            deleteKey(key);
            addRecently(key, value);
            return;
        }
        if (doubleList.getSize() > capacity) {
            removeLeastRecently();
        }
        addRecently(key, value);
    }

    private void makeRecently(int key) {
        Node node = cache.get(key);
        doubleList.remove(node);
        doubleList.addLast(node);
    }

    private void  addRecently(int key, int value) {
        Node node = new Node(key, value);
        doubleList.addLast(node);
        cache.put(key, node);
    }

    private void removeLeastRecently() {
        Node removeNode = doubleList.removeFirst();
        cache.remove(removeNode.getKey());
    }

    private void deleteKey(int key) {
        Node node = cache.get(key);
        cache.remove(key);
        doubleList.remove(node);
    }
}