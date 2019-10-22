package com.leetcode.solutions.discussions;

import java.util.HashMap;
import java.util.Map;

/**
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.

 get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

 Follow up:
 Could you do both operations in O(1) time complexity?

 Example:

 LRUCache cache = new LRUCache( 2 capacity);

        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // returns 1
        cache.put(3, 3);    // evicts key 2
        cache.get(2);       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        cache.get(1);       // returns -1 (not found)
        cache.get(3);       // returns 3
        cache.get(4);       // returns 4
 */

public class C146 {

    static class LRUCache {

        class Node {
            public Node prev;
            public Node next;
            public int key;
            public int value;

            public Node(int key, int value) {
                this.key = key;
                this.value = value;
                this.prev = null;
                this.next = null;
            }
        }

        public Map<Integer, Node> map = new HashMap<>();
        // head and tail doesn't hold any value, it just serve as a pointer
        public Node head = new Node(-1, -1);
        public Node tail = new Node(-1, -1);
        public int capacity;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            head.next = tail;// in beginning, just head pointer to tail with empty map
            tail.prev = head;
        }

        // most recently visited node is at tail
        // less frequent visited node is at head
        // moving node form middle to tail has two steps: (1) remove (2) add to tail, hence (2) can be reused by get
        // and put
        public int get(int key) {
            if (!map.containsKey(key))
                return -1;

            // remove current
            Node current = map.get(key);
            current.prev.next = current.next;
            current.next.prev = current.prev;

            // move current to tail
            // this is very important, abstract the common logic
            move_to_tail(current);

            return map.get(key).value;
        }

        // put will call get !!
        public void put(int key, int value) {
            // this is also a trick !!
            // this internal `get` method will update the key's position in the linked list.
            if (get(key) != -1) {
                map.get(key).value = value;
                return;
            }

            if (map.size() == capacity) {
                map.remove(head.next.key);
                head.next = head.next.next;
                head.next.prev = head;
            }

            Node insert = new Node(key, value);
            map.put(key, insert);
            move_to_tail(insert);
        }

        private void move_to_tail(Node current) {
            current.prev = tail.prev;
            tail.prev = current;
            current.prev.next = current;
            current.next = tail;
        }
    }

    public static void main(String[] strs) {
        LRUCache cache = new C146.LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);
        System.out.println(cache.get(2));
        cache.put(4, 4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

}
