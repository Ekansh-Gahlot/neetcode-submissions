class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if(s1.length()>s2.length())return false;
        
        int str1Arr[] = new int[26];
        int str2Arr[] = new int[26];

        for(int i = 0; i < s1.length(); i++){
            str1Arr[s1.charAt(i)-'a']++;
            str2Arr[s2.charAt(i)-'a']++;
        }

        if(isMatched(str1Arr, str2Arr))
        return true;
        
        for(int i = s1.length(); i < s2.length(); i++){
            str2Arr[s2.charAt(i-s1.length())-'a']--;
            str2Arr[s2.charAt(i)-'a']++;
            if(isMatched(str1Arr, str2Arr))
            return true;
        }
        return false;
    }

    public boolean isMatched(int arr1[], int arr2[]){
        for(int i = 0 ; i < arr1.length; i++)
        {
            if(arr1[i]!=arr2[i])return false;
        }
        return true;
    }
}
