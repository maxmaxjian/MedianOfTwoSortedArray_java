
public class Solution1 implements Solution {

    @Override
    public double medianOfTwoSortedArray(int[] nums1, int[] nums2) {
        int sm1, sm2;
        sm1 = nums1.length-1;
        Pair id1 = new Pair(sm1, true);
        sm2 = binSearchNumOfSmaller(nums2, nums1[sm1]);
        Pair id2 = new Pair(sm2, false);
        int half = (nums1.length+nums2.length)/2;
        if ((nums1.length+nums2.length)%2 == 0) {
            half -= 1;
        }

        while (id1.idx+id2.idx != half) {
            if (id1.idx+id2.idx < half) {
                sm1 = (id1.idx+nums1.length-1)/2;
                sm2 = (id2.idx+nums2.length-1)/2;
                if (id1.found) {
                    if (sm2 != id2.idx) {
                        id2 = new Pair(sm2, true);
                        sm1 = binSearchNumOfSmaller(nums1, nums2[sm2]);
                        id1 = new Pair(sm1, false);
                    } else {
                        id1 = new Pair(sm1, true);
                        sm2 = binSearchNumOfSmaller(nums2, nums1[sm1]);
                        id2 = new Pair(sm2, false);
                    }
                } else {
                    if (sm1 != id1.idx) {
                        id1 = new Pair(sm1, true);
                        sm2 = binSearchNumOfSmaller(nums2, nums1[sm1]);
                        id2 = new Pair(sm2, false);
                    } else {
                        id2 = new Pair(sm2, true);
                        sm1 = binSearchNumOfSmaller(nums1, nums2[sm2]);
                        id1 = new Pair(sm1, false);
                    }
                }
            } else {
                sm1 = id1.idx/2;
                sm2 = id2.idx/2;
                if (id1.found) {
                    if (sm2 != id2.idx) {
                        id2 = new Pair(sm2, true);
                        sm1 = binSearchNumOfSmaller(nums1, nums2[sm2]);
                        id1 = new Pair(sm1, false);
                    } else {
                        id1 = new Pair(sm1, true);
                        sm2 = binSearchNumOfSmaller(nums2, nums1[sm1]);
                        id2 = new Pair(sm2, false);
                    }
                } else {
                    if (sm1 != id1.idx) {
                        id1 = new Pair(sm1, true);
                        sm2 = binSearchNumOfSmaller(nums2, nums1[sm1]);
                        id2 = new Pair(sm2, false);
                    } else {
                        id2 = new Pair(sm2, true);
                        sm1 = binSearchNumOfSmaller(nums1, nums2[sm2]);
                        id1 = new Pair(sm1, false);
                    }
                }
            }
        }
        if ((nums1.length+nums2.length)%2 == 1) {
            return id1.found ? nums1[id1.idx] : nums2[id2.idx];
        } else {
            if (id1.found) {
                int prev = id1.idx < nums1.length-1 ? Math.min(nums1[id1.idx+1], nums2[id2.idx]) : nums2[id2.idx];
                return (prev+nums1[id1.idx])/2.0;
            } else {
                int prev = id2.idx < nums2.length-1 ? Math.min(nums2[id2.idx+1], nums1[id1.idx]) : nums1[id1.idx];
                return (prev+nums2[id2.idx])/2.0;
            }
        }
    }

    private int binSearchNumOfSmaller(int[] nums, int target) {
        int b = 0, e = nums.length-1;
        int mid;
        while (b < e-1) {
            mid = (b+e)/2;
            if (nums[mid] <= target) {
                b = mid;
            } else {
                e = mid;
            }
        }
        if (b == e) {
            if (nums[b] < target) {
                return 1;
            } else {
                return 0;
            }
        } else {
            if (nums[b] > target) {
                return 0;
            } else if (nums[e] < target) {
                return nums.length;
            } else {
                return e;
            }
        }
    }

    class Pair {
        public final int idx;
        public final boolean found;

        public Pair(int idx, boolean found) {
            this.idx = idx;
            this.found = found;
        }
    }

    public static void main(String[] args) {
//        int[] nums1 = {1,3}, nums2 = {2};
//        int[] nums1 = {1,2}, nums2 = {3,4};
//        int[] nums1 = {3}, nums2 = {-2,-1};
//        int[] nums1 = {1,1,3,3}, nums2 = {1,1,3,3};
        int[] nums1 = {1,2,2}, nums2 = {1,2,3};

        Solution soln = new Solution1();
        double median = soln.medianOfTwoSortedArray(nums1, nums2);
        System.out.println(String.format("The median is: %f", median));
    }
}
