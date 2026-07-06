class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> temp = new ArrayList<>();

        dfs(0, res, temp, s);
        return res;
    }

    public void dfs(int i, List<List<String>> res, List<String> temp, String s){
        if(i >= s.length()){
            res.add(new ArrayList<>(temp));
            return;
        }

        for(int j = i; j < s.length(); j++){
            if(isPali(s, i, j)){
                temp.add(s.substring(i, j+1));
                dfs(j+1, res, temp, s);
                temp.remove(temp.size()-1);
            }
        }
    }

    public boolean isPali(String s, int l, int r){
        while(l<=r){
            if(s.charAt(l)!=s.charAt(r))
            return false;
            l++;
            r--;
        }
        return true;
    }
}
