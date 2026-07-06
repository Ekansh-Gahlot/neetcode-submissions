class Solution {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        int left = 0;
        int right = 0;
        int lastSeenIndex = 0;
        List<Integer> list = new ArrayList<>();

        for(int i = 0 ;  i < s.length(); i++){
            char ch = s.charAt(i);
            map.put(ch,i);
        }

        while(right < s.length()){
            lastSeenIndex = Math.max(lastSeenIndex, map.get(s.charAt(right)));

            if(right == lastSeenIndex){
                list.add(right-left+1);
                left = right+1;
            }
            right++;
        }
        return list;
    }
}
