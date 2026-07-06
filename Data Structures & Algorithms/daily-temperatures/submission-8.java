class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> st = new Stack<>();
        int arr[] = new int[temperatures.length];

        for(int i = temperatures.length-1; i >= 0; i--){
            if(!st.isEmpty()){
                while(!st.isEmpty() && temperatures[i] >= temperatures[st.peek()]){
                    st.pop();
                }
                if(!st.isEmpty() && temperatures[st.peek()] > temperatures[i]){
                    arr[i] = st.peek() - i;
                }
            }
            st.push(i);
        }
        return arr;
    }
}
