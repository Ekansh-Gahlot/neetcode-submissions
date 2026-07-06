class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        String alphanumeric = "abcdefghijklmnopqrstuvwxyz1234567890";
        String arrSplit[] = s.split(" ");
        String newStr = "";
        for(String spl: arrSplit)
        {
            newStr += spl;
        }
        System.out.println(newStr);
        String finalStr = "";
        for(char c: newStr.toCharArray())
        {
            System.out.println("the char is "+c);
            if(alphanumeric.indexOf(c) != -1) finalStr += c;
            System.out.println("the final string is "+finalStr);
        }

        // System.out.println("the final string is "+finalStr);
        int k = finalStr.length()-1;
        for(int i = 0; i < finalStr.length(); i++)
        {
            if((finalStr.charAt(i) != finalStr.charAt(k)) && k >= i) {
                System.out.println("the ith char is"+finalStr.charAt(i));
                System.out.println("the kth char is"+finalStr.charAt(k));
                return false;
            }
            if(k < i) return true;
            k--;
        }
        return true;
    }
}
