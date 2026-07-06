class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int s1Arr[] = new int[26];
        int s2Arr[] = new int[26];

        if(s2.length() < s1.length())return false;

        for(int i = 0; i < s1.length(); i++)
        {
            s1Arr[s1.charAt(i)-'a']++;
            s2Arr[s2.charAt(i)-'a']++;
        }

        if(isMatched(s1Arr,s2Arr)) return true;

        for(int i = s1.length(); i < s2.length(); i++){
            s2Arr[s2.charAt(i-s1.length()) - 'a']--;
            s2Arr[s2.charAt(i)-'a']++;
            if(isMatched(s1Arr,s2Arr))return true;
        }
        return false;
    }


    public boolean isMatched(int arr1[], int arr2[]){
        for(int i = 0; i < arr1.length; i++){
            if(arr1[i] != arr2[i]){
                return false;
            }
        }
        return true;
    }
}
