class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        
        for(int i = 0; i < hand.length; i++)
        {
            map.put(hand[i], map.getOrDefault(hand[i],0)+1);
        }

        while(!map.isEmpty())
        {
            int first = map.firstKey();
            for(int i = 0 ; i < groupSize; i++)
            {
                int currKey = first + i;
                if(!map.containsKey(currKey)) return false;
                map.put(currKey, map.get(currKey)-1);

                if(map.get(currKey) == 0)
                map.remove(currKey);
            }
        }
        return true;
    }
}
