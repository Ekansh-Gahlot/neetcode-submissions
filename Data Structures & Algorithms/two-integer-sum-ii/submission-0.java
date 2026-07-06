class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int result[] = new int[2];
        for(int i = 0; i < numbers.length; i++)
        {
            int ele = numbers[i];
            System.out.println(target-ele);
            int index = binarySearch(numbers,i+1,numbers.length-1,(target-ele));

            if(index!=-1 && index!=i)
            {
                result[0] = i+1;
                result[1] = index+1;
                // Arrays.sort(result);
                return (result);
            }
        }
        return result;
    }

    public int binarySearch(int[] arr, int low, int high, int key)
    {
        
       

        while(low<=high)
        {
            int mid = (low+high)/2;

            if(arr[mid] == key) return mid;

            else if(arr[mid] > key) {high = mid - 1;}
            else { low = mid+1;}
        }
        return -1;
    }
}