class LRUCache {

    int cap;
    Node left;
    Node right;
    HashMap<Integer, Node> map;

    public LRUCache(int capacity) {
        this.cap = capacity;
        left = new Node(0,0);
        right = new Node(0,0);
        this.left.next = this.right;
        this.right.prev = this.left;
        map = new HashMap<>();
    }

    public void insert(Node node){
        Node temp = this.right.prev;
        temp.next = node;
        node.next = this.right;
        node.prev = this.right.prev;
        this.right.prev = node;
    }

    public void remove(Node node){
        Node nxt = node.next;
        Node prv = node.prev;
        nxt.prev = prv;
        prv.next = nxt;
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
        map.put(key, temp);
        insert(temp);

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
        this.next = null;
        this.prev = null;
    }
}
