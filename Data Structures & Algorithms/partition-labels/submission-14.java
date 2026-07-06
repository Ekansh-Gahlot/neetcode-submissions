class Solution {
    HashMap<Character, Integer> map = new HashMap<>();
    List<Integer> list = new ArrayList<>();
    public List<Integer> partitionLabels(String s) {

        for(int i = 0 ; i < s.length(); i++){
            map.put(s.charAt(i),i);
        }
        int left = 0;
        int right = 0;
        int lastIndex = 0;
        while(right < s.length()){
            char ch = s.charAt(right);
            lastIndex = Math.max(map.get(ch),lastIndex);

            if(right == lastIndex){
                list.add(right-left+1);
                left=right+1;
            }
            right++;
        }
        return list;
        
    }
}
