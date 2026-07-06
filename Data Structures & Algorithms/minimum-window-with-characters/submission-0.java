class Solution {

    public boolean compare(String a, String b)
    {
        int count[] = new int[256];
        Arrays.fill(count,0);

        for(char ch: b.toCharArray()){
            count[ch]++;
        }
        for(char ch: a.toCharArray()){
            if(count[ch] > 0)
            count[ch]--;
        }

        for(int c: count){
            if(c!=0)
            return false;
        }
        return true;
    }

    public String minWindow(String s, String t) {
        if(s.length() < t.length()) return "";

        int ls = s.length();
        int ts = t.length();
        String smallestSubstring = "";
        int minLen = Integer.MAX_VALUE;

        for(int i = 0; i < s.length(); i++){
            for(int j = i; j < s.length(); j++){
                String str = s.substring(i,j+1);

                if(compare(str,t)) {
                    int currLen = str.length();

                    if(currLen<minLen){
                        minLen = currLen;
                        smallestSubstring = str;
                    }
                }
            }
        }
        return smallestSubstring;


    }
}
