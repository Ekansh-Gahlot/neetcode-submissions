class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        String[] dup = new String[strs.length];
        List<List<String>>  list = new ArrayList<>();
        HashMap<String,List<String>> map = new HashMap<>();

        for(int i = 0 ; i < strs.length; i++){
            String s = strs[i];
            char[] chr = s.toCharArray();
            Arrays.sort(chr);
            dup[i] = String.valueOf(chr);
        }

        for(int i = 0; i < strs.length; i++){
            String s = strs[i];

            if(!map.containsKey(dup[i])){
                map.put(dup[i], new ArrayList<>());
            }
            // else{
            map.get(dup[i]).add(strs[i]);
            // }
        }

        list.addAll(map.values());
        return list;
    }
    
}
