class Solution {
    
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> st = new Stack<>();
        int l = temperatures.length;
        int[] res = new int[l];

        for(int i = (l-1) ; i >= 0; i--){
            int ele = temperatures[i];
            if(!st.isEmpty()){
                while(!st.isEmpty() && temperatures[st.peek()] <= ele ){
                    st.pop();
                }
                if(st.isEmpty()){
                    res[i] = 0;
                }
                else{
                    res[i] = st.peek() - i;
                }
            }
            else{
                res[i] = 0;
            }
            st.push(i);
        }
        return res;
    }
}
