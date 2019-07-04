import java.util.Hashtable;

class LRUCache {
    
    private DoubleLinkedNode head;
    private DoubleLinkedNode tail;
    int capacity;
    int count;
    
    Hashtable<Integer, DoubleLinkedNode> hash;
    
    class DoubleLinkedNode {
        int key;
        int value;
        DoubleLinkedNode prev;
        DoubleLinkedNode post;
    }
    
    private void insert(DoubleLinkedNode node) {
        //insert a node right after the head
        node.prev = head;
        node.post = head.post;
        
        head.post.prev = node;
        head.post = node;
    }
    
    private void removeNode(DoubleLinkedNode node) {
        DoubleLinkedNode pre = node.prev;
        DoubleLinkedNode pos = node.post;
        
        pos.prev = pre;
        pre.post = pos;
    }
    
    private void moveToHead(DoubleLinkedNode node) {
        removeNode(node);
        insert(node);
    }
    
    private DoubleLinkedNode removeTail() {
        DoubleLinkedNode pre = tail.prev;
        removeNode(pre);
        
        return pre;
    }
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.count = 0;
        this.hash = new Hashtable<Integer, DoubleLinkedNode>();
        this.head = new DoubleLinkedNode();
        this.tail = new DoubleLinkedNode();
        head.prev = null;
        tail.post = null;
        head.post = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        DoubleLinkedNode node = hash.get(key);
        if(node == null) {
            return -1;
        } else {
            moveToHead(node);
        }
        
        return node.value;
    }
    
    public void put(int key, int value) {
        DoubleLinkedNode node = hash.get(key);
        if(node == null) {
            DoubleLinkedNode newNode = new DoubleLinkedNode();
            newNode.key = key;
            newNode.value = value;
            count++;
            while(count > capacity) {
                DoubleLinkedNode tailNode = removeTail();
                hash.remove(tailNode.key);
                count--;
            }
            insert(newNode);
            hash.put(key, newNode);
        } else {
            node.value = value;
            moveToHead(node);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */