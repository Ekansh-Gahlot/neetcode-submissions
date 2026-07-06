class LRUCache {

    int cap;
    Node left;
    Node right;
    HashMap<Integer, Node> map;

    public LRUCache(int capacity) {
        left = new Node(0,0);
        right = new Node(0,0);
        cap = capacity;
        map = new HashMap<>();
        this.left.next = this.right;
        this.right.prev = this.left;
    }

    public void insert(Node node){
       Node prev = this.right.prev;
       prev.next = node;
       node.prev = prev;
       node.next = this.right;
       this.right.prev = node;
    }

    public void remove(Node node){
        Node prev = node.prev;
        Node nxt = node.next;
        prev.next = nxt;
        nxt.prev = prev;
    }
    
    public int get(int key) {
        if(map.containsKey(key))
        {
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
        Node node = new Node(key, value);
        map.put(key, node);
        insert(node);

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
    Node prev;
    Node next;

    Node(int key, int value){
        this.key = key;
        this.value = value;
        prev = null;
        next = null;
    }
}
