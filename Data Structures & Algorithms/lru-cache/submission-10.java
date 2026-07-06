class LRUCache {
    int cap;
    Node left;
    Node right;
    HashMap<Integer, Node> map;
    public LRUCache(int capacity) {
        this.cap = capacity;
        map = new HashMap<>();
        left = new Node(0,0);
        right = new Node(0,0);
        left.next = right;
        right.prev = left;
    }

    public void remove(Node node){
        Node nxt = node.next;
        node.prev.next = nxt;
        node.next.prev = node.prev;
    }

    public void insert(Node node){
        Node prv = right.prev;
        prv.next = node;
        node.next = right;
        right.prev = node;
        node.prev = prv;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node n = map.get(key);
            remove(n);
            insert(n);
            return n.value;
        }
        return -1;
        
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
          Node node = map.get(key);
          remove(node);
        }
        Node newNode = new Node(key, value);
        insert(newNode);
        map.put(key, newNode);
        if(map.size() > cap){
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
    }
}
