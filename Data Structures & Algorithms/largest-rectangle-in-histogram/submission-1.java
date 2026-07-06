class Solution {
    
    public int largestRectangleArea(int[] heights) {
        int ns[] = new int[heights.length];
        int ps[] = new int[heights.length];
        nextSmaller(heights,ns);
        prevSmaller(heights,ps);
        for(int i = 0; i < heights.length ; i++)
        {
            System.out.print(ns[i]+"  ");
        }
        System.out.println();

        for(int i = 0; i < heights.length ; i++)
        {
            System.out.print(ps[i]+"  ");
        }
        System.out.println();

        for(int i = 0; i < heights.length ; i++)
        {
            System.out.print(heights[i]+"  ");
        }

        int maxArea = 0;
        for(int i = 0 ; i < heights.length; i++)
        {
            int ans = ((ns[i] - ps[i]-1) * heights[i]);
            System.out.println(ans);
            maxArea = Math.max(maxArea, Math.max(ans,heights[i]));
        }
        return maxArea;
    }


    public void nextSmaller(int[] heights, int[] ns)
    {
        Stack<Integer> st = new Stack<>();

        for(int i = heights.length-1; i >= 0; i--)
        {
            while(!st.isEmpty() && heights[st.peek()] >= heights[i])
            {
                st.pop();
            }
            if(st.isEmpty())
            {
                ns[i] = heights.length;
            }
            else{
                ns[i] = st.peek();
                // st.push(i);
            }
            st.push(i);
        }
    }

    public void prevSmaller(int[] heights, int[] ps)
    {
        Stack<Integer> st = new Stack<>();

        for(int i = 0; i < heights.length; i++)
        {
            while(!st.isEmpty() && heights[st.peek()] >= heights[i])
            {
                st.pop();
            }
            if(st.isEmpty())
            {
                ps[i] = -1;
            }
            else{
                ps[i] = st.peek();
            }
            st.push(i);
        }

    }
}
