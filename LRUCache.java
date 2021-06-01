/* LRU CACHE
https://leetcode.com/problems/lru-cache/
https://www.interviewbit.com/problems/lru-cache/
https://www.geeksforgeeks.org/lru-cache-implementation/
TC: O(1); SC: O(1) */

//First Method
public class LRUCache {
    class Node {
        public int key;
        public int val;
        public Node prev;
        public Node next;
        
        public Node(int key,int val) {
             this.key = key;
            this.val = val;
            prev = null;
            next = null;
        }
    }
    
    Map<Integer, Node>  hm;
    Node start;
    Node end;
    int capacity;
    public Solution(int capacity) {
        hm = new HashMap<>();
        start = new Node(0,0);
        end = new Node(0,0);
        this.capacity = capacity;
        start.next = end;
        end.prev = start; 
    }
    
    private void addNode(Node node) {
        node.next = start.next;
        start.next = node;
        node.prev = start;
        node.next.prev = node;
    }

     private void removeNode(Node node) {
        Node temp = node.next;
        node.prev.next = temp;
        temp.prev = node.prev;
    }
    public int get(int key) {
        if(hm.containsKey(key)) {
            Node node=hm.get(key);
            removeNode(node);
            addNode(node);
            return node.val;
        }
        return -1;
    }
    
    public void set(int key, int value) {
       Node node = new Node(key, value);
       if(hm.containsKey(key)) {
            Node n=hm.get(key);
            removeNode(n);
            addNode(node);
        }
        else {
            if(hm.size()==capacity) {
                Node temp=end.prev;
                removeNode(temp);
                hm.remove(temp.key);
            }
        addNode(node);
        }
        hm.put(key,node);
    }
}

//Second Method (built-in functions)
class LRUCache {
LinkedHashMap<Integer, Integer> cache;
    public LRUCache(int capacity) {
         cache = new LinkedHashMap<Integer, Integer>(capacity, 100.0f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > capacity;
            }
        };
    }
    
    public int get(int key) {
        if (cache.containsKey(key))
            return cache.get(key);
        return -1;
    }
    
    public void put(int key, int value) {
        cache.put(key, value);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */