class Solution {
    HashMap<Character, Integer> map;
    List<Integer> list;
    public List<Integer> partitionLabels(String s) {
        map = new HashMap<>();
        list = new ArrayList<>();
        int k = 0;
        for(char c: s.toCharArray()){
            map.put(c, k);
            k++;
        }

        int size = 0;
        int lastIndex = 0;

        for(int i = 0 ; i < s.length(); i++){
            lastIndex = Math.max(lastIndex,map.get(s.charAt(i)));
            size++;

            if(i >= lastIndex){
                list.add(size);
                size = 0;
            }
        }
        return list;
        
    }
}
