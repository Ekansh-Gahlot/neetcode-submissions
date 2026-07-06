class Solution {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for(int i = 0 ; i < s.length(); i++)
        {
            char c = s.charAt(i);
            map.put(c, i);
        }
        int lastSeen = 0;
        int size = 0;
        for(int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            lastSeen = Math.max(map.get(c), lastSeen);
            size++;
            if(i == lastSeen){
                list.add(size);
                size = 0;
            }
        }
        return list;
    }
}
