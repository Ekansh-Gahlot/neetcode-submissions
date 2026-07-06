class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<int[]> st = new Stack<>();

        int res[] = new int[temperatures.length];
        for(int i = 0; i < temperatures.length; i++)
        {
            int t = temperatures[i];
            while(!st.isEmpty() && t > st.peek()[0])
            {
                int arr[] = st.pop();
                res[arr[1]] = i - arr[1];
            }

            st.push(new int[]{t,i});
        }
        return res;
    }
}
