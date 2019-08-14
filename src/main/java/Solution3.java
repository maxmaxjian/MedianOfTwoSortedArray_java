import java.util.HashSet;
import java.util.Set;

public class Solution3 implements Solution {

    // Solution based on elimination

    @Override
    public double medianOfTwoSortedArray(int[] nums1, int[] nums2) {
        if (nums1.length == 0) {
            return median(nums2);
        } else if (nums2.length == 0) {
            return median(nums1);
        } else {
            int half = (nums1.length+nums2.length)/2;
            int id1, id2, sm1, sm2, eq1, eq2;
            Set<Integer> set = new HashSet<>();
            if ((nums1.length+nums2.length)%2 == 1) {
                id1 = nums1.length - 1;
                while (!set.contains(id1)) {
                    set.add(id1);
                    eq1 = numEquals(nums1, id1);
                    sm2 = numSmaller(nums2, nums1[id1]);
                    if (id1+sm2 < half) {
                        id1 = (id1+nums1.length-1)/2;
                    } else if (id1+sm2 >= half && id1+sm2-eq1 <= half) {
                        return nums1[id1];
                    } else {
                        id1 = id1/2;
                    }
                }

                set.clear();
                id2 = nums2.length-1;
                while (!set.contains(id2)) {
                    set.add(id2);
                    eq2 = numEquals(nums2, id2);
                    sm1 = numSmaller(nums1, nums2[id2]);
                    if (id2+sm1 < half) {
                        id2 = (id2+nums2.length-1)/2;
                    } else if (id2+sm1 >= half && id2+sm1-eq2 <= half) {
                        return nums2[id2];
                    } else {
                        id2 = id2/2;
                    }
                }
            } else {
                half -= 1;
                id1 = nums1.length - 1;
                while (!set.contains(id1)) {
                    set.add(id1);
                    eq1 = numEquals(nums1, id1);
                    sm2 = numSmaller(nums2, nums1[id1]);
                    if (id1+sm2 < half) {
                        id1 = (id1+nums1.length-1)/2;
                    } else if (id1+sm2 >= half && id1+sm2-eq1 <= half) {
                        double result;
                        if (id1 < nums1.length-1 && sm2 < nums2.length) {
                            result = (nums1[id1]+Math.min(nums1[id1+1], nums2[sm2]))/2.0;
                        } else if (id1 < nums1.length-1) {
                            result = (nums1[id1]+nums1[id1+1])/2.0;
                        } else {
                            result = (nums1[id1]+nums2[sm2])/2.0;
                        }
                        return result;
                    } else {
                        id1 = id1/2;
                    }
                }

                set.clear();
                id2 = nums2.length-1;
                while (!set.contains(id2)) {
                    set.add(id2);
                    eq2 = numEquals(nums2, id2);
                    sm1 = numSmaller(nums1, nums2[id2]);
                    if (id2+sm1 < half) {
                        id2 = (id2+nums2.length-1)/2;
                    } else if (id2+sm1 >= half && id2+sm1-eq2 <= half) {
                        double result;
                        if (id2 < nums2.length-1 && sm1 < nums1.length) {
                            result = (nums2[id2]+Math.min(nums2[id2+1], nums1[sm1]))/2.0;
                        } else if (id2 < nums2.length-1) {
                            result = (nums2[id2]+nums2[id2+1])/2.0;
                        } else {
                            result = (nums2[id2]+nums1[sm1])/2.0;
                        }
                        return result;
                    } else {
                        id2 = id2/2;
                    }
                }
            }
            return Double.MIN_VALUE;
        }
    }

    private int numSmaller(int[] nums, int target) {
//        int b = 0, e = nums.length-1, mid;
//        while (b < e-1) {
//            mid = (b+e)/2;
//            if (nums[mid] >= target) {
//                e = mid;
//            } else {
//                b = mid;
//            }
//        }
//
//        if (b == e) {
//            return nums[b] < target ? 1 : 0;
//        } else {
//            return nums[b] < target ? e : b;
//        }
        int result = 0;
        for (int i = 0; i < nums.length && nums[i] <= target; i++) {
            result++;
        }
        return result;
    }

    private int numEquals(int[] nums, int idx) {
        int result = 0;
        for (int i = 0; i < idx; i++) {
            if (nums[i] == nums[idx]) {
                result++;
            }
        }
        return result;
    }

    private int numLarger(int[] nums, int target) {
        int id = 0;
        while (id < nums.length && nums[id] <= target) {
            id++;
        }
        return nums.length-id;
    }

    private double median(int[] nums) {
        int half = nums.length/2;
        if (nums.length%2 == 0) {
            return (nums[half-1]+nums[half])/2.0;
        } else {
            return nums[half];
        }
    }
}
