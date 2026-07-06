class Solution {



public int climbStairs(int n) {
return dfs(n);
}

public int dfs(int n){
if(n == 0)
return 1;

if(n<0)
return 0;

int res = dfs(n-1) + dfs(n-2);
return res;
}
}
