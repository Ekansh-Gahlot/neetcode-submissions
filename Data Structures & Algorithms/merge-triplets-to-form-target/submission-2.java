class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        boolean foundX = false;
        boolean foundY = false;
        boolean foundZ = false;

        for(int[] t: triplets){
            int a = t[0];
            int b = t[1];
            int c = t[2];

            if(a <= target[0] && b <= target[1] && c <= target[2]){
                if(a == target[0]) foundX = true;
                if(b == target[1]) foundY = true;
                if(c == target[2]) foundZ = true;
            }
        }
        return foundX && foundY && foundZ;
    }
}
