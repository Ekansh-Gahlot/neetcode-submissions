class Solution {
    List<List<Integer>> list = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        combo(candidates, target, 0);
        return list;
    }

    public void combo(int[] c, int target, int i){
        if(target == 0){
            list.add(new ArrayList<>(temp));
            return;
        }

        if(target < 0 || i >= c.length)
        return;
        temp.add(c[i]);
        combo(c, target-c[i], i+1);
        temp.remove(temp.size()-1);
        int k = i+1;
        while(k < c.length && c[i] == c[k]){
            k++;
        }
        combo(c, target, k);
    }
}
