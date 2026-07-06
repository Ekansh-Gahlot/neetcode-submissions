class Solution {
    List<List<String>> ans = new ArrayList<>();
    List<String> temp = new ArrayList<>(); 
    public List<List<String>> partition(String s) {
        backTrack(s, 0);
        return ans;
    }

    public void backTrack(String s, int i){
        if(i >= s.length()){
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int j = i; j < s.length(); j++){
            if(isPali(s, i, j)){
                temp.add(s.substring(i,j+1));
                backTrack(s,j+1);
                temp.remove(temp.size()-1);
            }
        }
    }

    public boolean isPali(String s, int i, int j){
        while(i <= j){
            if(s.charAt(i)!=s.charAt(j))
            return false;
            i++;
            j--;
        }
        return true;
    }
}
