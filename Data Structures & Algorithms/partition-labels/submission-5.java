class Solution {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character,Integer> map = new HashMap<>();


        for(int i = 0; i < s.length(); i++)
        {
            map.put(s.charAt(i), i);
        }
        List<Integer> list = new ArrayList<>();
        int size = 0;
        int end = 0;

        for(int i = 0; i < s.length(); i++)
        {
            end = Math.max(end, map.get(s.charAt(i)));
            size++;
            if(i == end)
            {
                list.add(size);
                size = 0;
            }
        }
        return list;

    }
}
