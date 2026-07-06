class TimeMap {

    HashMap<String, List<Pair>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key))
        map.put(key, new ArrayList<>());
        map.get(key).add(new Pair(value, timestamp));
        
    }
    
    public String get(String key, int timestamp) {
        List<Pair> list = map.getOrDefault(key, new ArrayList<>());
        int left = 0; 
        int right = list.size()-1;
        String result = "";
        while(left <= right){
            int mid = (left+right)/2;

            if(list.get(mid).timestamp <= timestamp){
                result = list.get(mid).val;
                left = mid+1;
            }
            else{
                right = mid-1;
            }
        }
        return result;
    }
}

class Pair{
    String val;
    int timestamp;

    Pair(String val, int timestamp){
        this.val = val;
        this.timestamp = timestamp;
    }
}