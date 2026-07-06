class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        HashMap<String,List<String>> map = new HashMap<>(); 
        String sortedStrs[] = new String[strs.length]; 
        for(int i = 0; i < strs.length; i++)
        {
            char charArray[] = strs[i].toCharArray();
            Arrays.sort(charArray);
            sortedStrs[i] = String.valueOf(charArray);
        }

        for(int i = 0; i < sortedStrs.length; i++)
        {
            String copy = sortedStrs[i];
            if(!map.containsKey(copy)){
                map.put(copy, new ArrayList<>());
            }
            map.get(copy).add(strs[i]);
        }

        result.addAll(map.values());
    return result;
    }
}
