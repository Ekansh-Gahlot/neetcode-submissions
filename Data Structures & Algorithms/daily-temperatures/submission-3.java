class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<int[]> st = new Stack<>();
        int ans[] = new int[temperatures.length];

        for(int i = 0 ; i < temperatures.length; i++)
        {
            int t = temperatures[i];
            while(!st.isEmpty() && t > st.peek()[0])
            {
                int[] element = st.pop();
                ans[element[1]] = i - element[1]; 
            }

            st.push(new int[]{t,i});
        }
        return ans;
    }
}
