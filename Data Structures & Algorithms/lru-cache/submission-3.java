class LRUCache {

    HashMap<Integer, Node> map;
    int cap;
    Node right;
    Node left;
    public LRUCache(int capacity) {
        map = new HashMap<>();
        cap = capacity;
        this.right = new Node(0,0);
        this.left = new Node(0,0);
        this.right.prev = this.left;
        this.left.next = this.right;
    }
    public void remove(Node node){
        Node nxt = node.next;
        Node prev = node.prev;
        nxt.prev = prev;
        prev.next = nxt;
    }

    public void insert(Node node){
        Node rightPrev = this.right.prev;
        rightPrev.next = node;
        node.prev = rightPrev;
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
            Node node = map.get(key);
            remove(node);
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
