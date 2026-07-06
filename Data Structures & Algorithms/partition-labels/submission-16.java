class Solution {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            map.put(ch, i);
        }
        List<Integer> list = new ArrayList<>();
        int count = 0;
        int lastIndex = 0;
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            lastIndex = Math.max(lastIndex,map.get(ch));
            count++;
            if(i >= lastIndex)
            {
                list.add(count);
                count = 0;
            }
        }
        return list;
    }
}
