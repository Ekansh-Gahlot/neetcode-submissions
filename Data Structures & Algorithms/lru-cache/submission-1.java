class LRUCache {

    Node left;
    Node right;
    HashMap<Integer, Node> map;
    int capacity;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        this.capacity = capacity;
        this.left = new Node(0,0);
        this.right = new Node(0,0);
        this.left.next = this.right;
        this.right.prev = this.left;
    }

    public void remove(Node node){
        Node prev = node.prev;
        Node nxt = node.next;
        prev.next = nxt;
        nxt.prev = prev;
    }

    public void insert(Node node){
        Node prev = this.right.prev;
        prev.next = node;
        node.prev = prev;
        node.next = this.right;
        this.right.prev = node;
    }
    
    public int get(int key) {
        if(map.containsKey(key))
        {
            Node node = map.get(key);
            remove(node);
            insert(node);
            return node.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key))
        {
            Node node = map.get(key);
            remove(node);
        }
        Node newNode = new Node(key, value);
        map.put(key, newNode);
        insert(newNode);

        if(map.size() > capacity){
            Node lru = this.left.next;
            remove(lru);
            map.remove(lru.key);
        }
        
    }
}

class Node{
    int key;
    int val;
    Node prev;
    Node next;

    Node(int key, int val){
        this.key = key;
        this.val = val;
        this.prev = null;
        this.next = null;
    }

}
