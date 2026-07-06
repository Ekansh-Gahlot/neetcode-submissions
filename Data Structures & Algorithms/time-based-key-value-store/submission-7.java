class TimeMap {
    HashMap<String, List<Node>> map;
    int time;
    public TimeMap() {
        this.map = new HashMap<>();
        this.time = 0;
    }
    
    public void set(String key, String value, int timestamp) {
       if(!map.containsKey(key))
       map.put(key, new ArrayList<>());
       map.get(key).add(new Node(value, timestamp));

    }
    
    public String get(String key, int timestamp) {
        List<Node> list = map.getOrDefault(key, new ArrayList<>());

        int left = 0;
        int right = list.size()-1;
        String result = "";

        while(left<=right){
            int mid = left + (right-left)/2;

            if(list.get(mid).timestamp <= timestamp){
                result = list.get(mid).value;
                left = mid+1;
            }
            else
            right = mid-1;
        }
        return result;
    }
}

class Node{
    String value;
    int timestamp;

    Node(String value, int timestamp){
        this.timestamp = timestamp;
        this.value = value;
    }
}
