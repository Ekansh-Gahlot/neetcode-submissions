class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<int[]> st = new Stack<>();
        int arr[] = new int[temperatures.length];

        for(int i = 0 ; i < temperatures.length; i++)
        {
            int t = temperatures[i];

            while(!st.isEmpty() && t > st.peek()[0])
            {
                int pair[] = st.pop();
                arr[pair[1]] = i - pair[1];
            }


            st.push(new int[]{t,i});
        }
        return arr;
    }
}
