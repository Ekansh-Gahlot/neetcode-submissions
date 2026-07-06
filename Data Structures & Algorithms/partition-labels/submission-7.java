class Solution {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for(int i = 0 ; i < s.length(); i++){
            map.put(s.charAt(i), i);
        }
        int maxLastSeen = 0;
        int size = 0;;
        for(int i = 0; i < s.length(); i++)
        {
            int lastSeenIndex = map.get(s.charAt(i));

            maxLastSeen = Math.max(maxLastSeen, lastSeenIndex);
            size++;
            if(i == maxLastSeen)
            {
                list.add(size);
                size = 0;
            }
        }
        return list;
    }
}
