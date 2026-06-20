public class nineteenthjune2026 {
    /// optimized way of doing the problem
    public int largestAltitude(int[] nums) {

        int maxheight = 0;
        int sum = 0;
        for (int num : nums) {

            sum = num + sum;
            maxheight = Math.max(sum, maxheight);
        }

        return maxheight;


    }

    /// //BRUTE FORCE CODE
    /// TRY TO DO THE CODE IN THE SIMULATION MANNER


    public static int largestAltitude_bruteforce(int[] nums) {
        //// no need to optimize the code -->(first solve with the brute force )


        ///// the brute force solution from the hints (sections) --> but what will
        /// ahpppen when the array size is more --> it will give the MLE

        int prefixsum[] = new int[nums.length + 1]; /// the altitudes
        prefixsum[0] = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            prefixsum[i + 1] = sum;
        }
        /// finding the max in the prefix sum array
        int max = Integer.MIN_VALUE;
        for (int i : prefixsum) {
            max = Math.max(i, max);
        }

        return max;
    }


}
