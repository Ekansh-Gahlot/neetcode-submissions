class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // Stack<int[][]> st = new int[temperatures.length][2];
        Stack<int[]> st = new Stack<>();
        int[] res = new int[temperatures.length];

        for(int i = temperatures.length-1; i >= 0; i--)
        {
            while(!st.isEmpty() && st.peek()[1] <= temperatures[i]){
                st.pop();
            }

            if(st.isEmpty()){
                res[i] = 0;
            }
            else{
                res[i] = (st.peek()[0] - i);
            }

            st.push(new int[]{i, temperatures[i]});
        }
        return res;
    }
}
