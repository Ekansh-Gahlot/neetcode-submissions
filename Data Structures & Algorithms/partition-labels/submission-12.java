class Solution {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        for(int i = 0 ; i < s.length(); i++){
            map.put(s.charAt(i),i);
        }

        int lastIndex = 0;
        int size = 0;
        for(int i = 0 ; i < s.length(); i++){
            char ch = s.charAt(i);
            lastIndex = Math.max(lastIndex, map.get(ch));
            size++;
            if(i >= lastIndex){
                res.add(size);
                size = 0;
            }
        }
        return res;
    }
}
