class Solution {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            map.put(c, i);
        }

        List<Integer> list = new ArrayList<>();
        int size = 0;
        int lastIndex = 0;

        for(int i = 0; i < s.length(); i++)
        {
            lastIndex = Math.max(lastIndex, map.get(s.charAt(i)));
            size++;

            if(i == lastIndex)
            {
                list.add(size);
                size = 0;
            }
        }
        return list;
    }
}
