class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> list = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        backTrack(list, temp, s, 0);
        return list;
    }


    public void backTrack(List<List<String>> list, List<String> temp, String s, int i){
        //Base Condition
        if(i >= s.length()){
            list.add(new ArrayList<>(temp));
            return;
        }

        for(int j = i; j < s.length(); j++){
            if(isPali(s, i, j)){
                temp.add(s.substring(i, j+1));
                backTrack(list, temp, s, j+1);
                temp.remove(temp.size()-1);
            }
        }
    }

    public boolean isPali(String word, int i, int j){
        while(i <= j){
            if(word.charAt(i) != word.charAt(j))
            return false;
            i++;
            j--;
        }
        return true;
    }
}
