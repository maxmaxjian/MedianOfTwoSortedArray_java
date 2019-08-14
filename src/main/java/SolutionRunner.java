public class SolutionRunner {

    public static void main(String[] args) {
//        int[] nums1 = {1,3}, nums2 = {2};
//        int[] nums1 = {1,2}, nums2 = {3,4};
//        int[] nums1 = {3}, nums2 = {-2,-1};
//        int[] nums1 = {1,1,3,3}, nums2 = {1,1,3,3};
        int[] nums1 = {1,2,3}, nums2 = {1,2,3};
//        int[] nums1 = {1,3}, nums2 = {2};

        Solution soln = new Solution3();
        double median = soln.medianOfTwoSortedArray(nums1, nums2);
        System.out.println(String.format("The median is: %f", median));
    }
}
