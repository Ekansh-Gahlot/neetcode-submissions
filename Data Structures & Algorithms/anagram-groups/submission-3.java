class Solution {
    HashMap<String, List<String>> map = new HashMap<>();
    public List<List<String>> groupAnagrams(String[] strs) {
        for(String s: strs){
            char[] ch = s.toCharArray();
            Arrays.sort(ch);
            String st = new String(ch);
            if(!map.containsKey(st)){
                map.put(st, new ArrayList<>());
            }
            map.get(st).add(s);
        }

        List<List<String>> list = new ArrayList<>(map.values());
        return list;
    }
}
