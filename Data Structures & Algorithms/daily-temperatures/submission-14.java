class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> st = new Stack<>();
        int arr[] = new int[temperatures.length];
        for(int i = temperatures.length-1; i>=0; i--){
            if(st.isEmpty()){
                arr[i] = 0;
                st.add(i);
            }else{
            while(!st.isEmpty() && temperatures[st.peek()] <= temperatures[i]){
                st.pop();
            }

            if(!st.isEmpty()){
                arr[i] =  st.peek() - i;
            }else{
                arr[i] = 0;
            }
            st.add(i);

            }

        }
        return arr;
    }
}
