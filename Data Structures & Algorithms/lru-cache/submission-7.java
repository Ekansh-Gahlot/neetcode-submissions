class LRUCache {
    HashMap<Integer, Node> map;
    int cap;
    Node left;
    Node right;
    public LRUCache(int capacity) {
        this.map = new HashMap<>();
        this.cap = capacity;
        left = new Node(0,0);
        right = new Node(0,0);
        this.left.next = this.right;
        this.right.prev = this.left;
    }
    
    public void remove(Node node){
        Node prv = node.prev;
        Node nxt = node.next;
        prv.next = nxt;
        nxt.prev = prv;
    }

    public void insert(Node node){
        Node prv = this.right.prev;
        prv.next = node;
        node.prev = prv;
        node.next = this.right;
        this.right.prev = node;
    }

    public int get(int key) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            remove(node);
            insert(node);
            return node.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            remove(node);
        }
        Node temp = new Node(key, value);
        insert(temp);
        map.put(key, temp);

        if(map.size()>cap){
            Node lru = this.left.next;
            remove(lru);
            map.remove(lru.key);
        }
    }
}

class Node{
    int key;
    int value;
    Node next;
    Node prev;

    Node(int key, int value){
        this.key = key;
        this.value = value;
        this.next = null;
        this.prev = null;
    }
}
