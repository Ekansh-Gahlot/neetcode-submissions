class Solution {
    List<List<String>> res;
    List<String> temp;
    public List<List<String>> partition(String s) {
        res = new ArrayList<>();
        temp = new ArrayList<>();
        dfs(s, 0);
        return res;
    }

    public void dfs(String s, int i){
        if(i == s.length())
        {
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int j = i; j < s.length(); j++){
            if(isPali(s,i,j)){
                temp.add(s.substring(i,j+1));
                dfs(s, j+1);
                temp.remove(temp.size()-1);
            }
        }
    }

    public boolean isPali(String s, int i, int j){
        while(i<=j){
            if(s.charAt(i)!=s.charAt(j))
            return false;
            i++;
            j--;
        }
        return true;
    }
}
