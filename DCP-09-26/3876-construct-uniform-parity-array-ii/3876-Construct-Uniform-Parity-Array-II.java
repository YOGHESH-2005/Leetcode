class Solution {
    public boolean uniformArray(int[] nums1) {
        int minOdd = Integer.MAX_VALUE;
        int minEven = Integer.MAX_VALUE;
        boolean hasOdd = false;
        boolean hasEven = false;
        for (int num : nums1) {
            if (num % 2 == 0) {
                minEven = Math.min(minEven, num);
                hasEven = true;
            } else {
                minOdd = Math.min(minOdd, num);
                hasOdd = true;
            }
        }
        if (!hasOdd || !hasEven) {
            return true;
        }  
        return minOdd < minEven;
    }
}