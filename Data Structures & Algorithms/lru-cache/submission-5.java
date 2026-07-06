class LRUCache {
    HashMap<Integer, Node> map;
    int cap;
    Node left;
    Node right;
    public LRUCache(int capacity) {
        cap = capacity;
        map = new HashMap<>();
        this.left = new Node(0,0);
        this.right = new Node(0,0);
        this.left.next = this.right;
        this.right.prev = this.left;
    }

    public void remove(Node node){
        Node nxt = node.next;
        Node priv = node.prev;
        priv.next = nxt;
        nxt.prev = priv;
    }

    public void insert(Node node){
        Node prev = this.right.prev;
        prev.next = node;
        node.prev = prev;
        node.next = this.right;
        this.right.prev = node;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node temp = map.get(key);
            remove(temp);
            insert(temp);
            return temp.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node oldNode = map.get(key);
            remove(oldNode);
        }
        Node newNode = new Node(key, value);
        map.put(key, newNode);
        insert(newNode);

        if(map.size() > cap){
            Node lru = this.left.next;
            remove(lru);
            map.remove(lru.key);
        }
    }
}

public class Node{
    int key;
    int val;
    Node next;
    Node prev;

    Node(int key, int val){
        this.key = key;
        this.val = val;
        this.next = null;
        this.prev = null;
    }
}
