class TimeMap {
    HashMap<String, List<Pair>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)){
            map.put(key, new ArrayList<>());
        }
        map.get(key).add(new Pair(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        List<Pair> list = map.getOrDefault(key, new ArrayList<>());
        int left = 0;
        int right = list.size()-1;
        String res = "";
        while(left<=right){
            int mid = (left+right)/2;
            Pair p = list.get(mid);
            if(p.val <= timestamp){
                res = p.key;
                left = mid+1;
            }
            else{
                right = mid-1;
            }
        }
        return res;
    }
}

public class Pair{
    String key;
    int val;

    Pair(String key, int val){
        this.key = key;
        this.val = val;
    }
}
