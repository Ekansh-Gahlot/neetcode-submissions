public class Node{
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

class LRUCache {

    HashMap<Integer,Node> map;
    int cap;
    Node left;
    Node right;
    /*We have left and right pointers as
        left pointer -> Least Recently Used;
        right pointer -> Most Recently Used;
    */
    public LRUCache(int capacity) {
       this.map = new HashMap<>();
       this.cap = capacity;
       this.left = new Node(0,0);
       this.right = new Node(0,0);
       this.left.next = this.right;
       this.right.prev = this.left;
    }
    
    //Remove node from left pointer
    public void remove(Node node){
        Node prev = node.prev;
        Node nxt = node.next;
        prev.next = nxt;
        nxt.prev = prev;
    }

    //Insert node between before right;
    public void insert(Node node){
        Node prev = this.right.prev;
        prev.next = node;
        node.prev = prev;
        node.next = this.right;
        this.right.prev = node;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            // Update least recently used and most recently used.
            remove(node);
            insert(node);
            return node.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            remove(node);
        }
        Node newNode = new Node(key, value);
        map.put(key,newNode);
        insert(newNode);

        if(map.size() > cap){
            //Least Recently Used will always be left.next, that is why we have left and right pointers.
            Node lru = this.left.next;
            remove(lru);
            map.remove(lru.key);
        }
    }

}
