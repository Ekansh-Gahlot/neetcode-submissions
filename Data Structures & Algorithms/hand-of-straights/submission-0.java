class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for(int i = 0 ; i < hand.length; i++)
        {
            map.put(hand[i], map.getOrDefault(hand[i],0)+1);
        }

        while(!map.isEmpty())
        {
            int first = map.firstKey();

            for(int i = 0; i < groupSize; i++)
            {
                int current = first+i;
                if(!map.containsKey(current)) return false;

                map.put(current, map.get(current)-1);

                if(map.get(current) == 0)
                map.remove(current);
            }
        }
            return true;
    }
}
