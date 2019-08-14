import java.util.HashSet;
import java.util.Set;

public class Solution2 implements Solution {

    @Override
    public double medianOfTwoSortedArray(int[] nums1, int[] nums2) {
        if (nums1.length == 0) {
            return median(nums2);
        } else if (nums2.length == 0) {
            return median(nums1);
        } else {
            int half;
            if ((nums1.length+nums2.length)%2 == 1) {
                half = (nums1.length+nums2.length)/2;
                int id1 = nums1.length-1, id2;
                Set<Integer> set = new HashSet<>();
                while (!set.contains(id1)) {
                    id2 = half-id1;
                    while (id2 < 0 || id2 > nums2.length-1) {
                        if (!set.contains(id1)) {
                            set.add(id1);
                        } else {
                            break;
                        }
                        if (id2 < 0) {
                            id1 = id1/2;
                        } else {
                            id1 = (id1+nums1.length-1)/2;
                        }
                        id2 = half-id1;
                    }
                    if (id2 >= 0 && id2 < nums2.length) {
                        set.add(id1);
                        if (nums2[id2] == nums1[id1]) {
                            return nums1[id1];
                        } else if (nums2[id2] < nums1[id1]) {
                            id1 = id1 / 2;
                        } else {
                            if (id2 == 0 || id2 > 0 && nums2[id2-1] <= nums1[id1]) {
                                return nums1[id1];
                            } else {
                                id1 = (nums1.length - 1 + id1) / 2;
                            }
                        }
                    } else {
                        break;
                    }
                }

                id2 = nums2.length-1;
                set.clear();
                while (!set.contains(id2)) {
                    id1 = half-id2;
                    while (id1 < 0 || id1 > nums1.length-1) {
                        if (!set.contains(id2)) {
                            set.add(id2);
                        } else {
                            break;
                        }
                        if (id1 < 0) {
                            id2 = id2/2;
                        } else {
                            id2 = (id2+nums2.length-1)/2;
                        }
                        id1 = half-id2;
                    }
                    if (id1 >= 0 && id1 < nums1.length) {
                        set.add(id2);
                        if (nums1[id1] == nums2[id2]) {
                            return nums2[id2];
                        } else if (nums1[id1] < nums2[id2]) {
                            id2 = id2 / 2;
                        } else {
                            if (id1 == 0 || id1 > 0 && nums1[id1-1] < nums2[id2]) {
                                return nums2[id2];
                            } else {
                                id2 = (nums2.length - 1 + id2) / 2;
                            }
                        }
                    } else {
                        break;
                    }
                }
            } else {
                half = (nums1.length+nums2.length)/2;
                int id1 = nums1.length-1, id2;
                Set<Integer> set = new HashSet<>();
                while (!set.contains(id1)) {
                    id2 = half-id1;
                    while (id2 < 0 || id2 > nums2.length-1) {
                        if (!set.contains(id1)) {
                            set.add(id1);
                        } else {
                            break;
                        }
                        if (id2 < 0) {
                            id1 = id1/2;
                        } else {
                            id1 = (id1+nums1.length-1)/2;
                        }
                        id2 = half-id1;
                    }
                    if (id2 >= 0 && id2 < nums2.length) {
                        set.add(id1);
                        if (nums2[id2] == nums1[id1]) {
                            double result;
                            if (id2 > 0 && id1 > 0) {
                                result = (nums2[id2] + Math.max(nums1[id1 - 1], nums2[id2 - 1])) / 2.0;
                            } else if (id2 > 0) {
                                result = (nums2[id2] + nums2[id2 - 1]) / 2.0;
                            } else {
                                result = (nums2[id2] + nums1[id1 - 1]) / 2.0;
                            }
                            return result;
                        } else if (nums2[id2] < nums1[id1]) {
                            id1 = id1 / 2;
                        } else {
                            if (id2 == 0 || id2 > 0 && nums2[id2-1] <= nums1[id1]) {
                                double result;
                                if (id1 > 0 && id2 > 0) {
                                    result = (nums1[id1] + Math.max(nums1[id1 - 1], nums2[id2-1])) / 2.0;
                                } else if (id1 > 0) {
                                    result = (nums1[id1] + nums1[id1-1]) / 2.0;
                                } else {
                                    result = (nums1[id1] + nums2[id2-1])/2.0;
                                }
                                return result;
                            } else {
                                id1 = (nums1.length - 1 + id1) / 2;
                            }
                        }
                    } else {
                        break;
                    }
                }

                id2 = nums2.length-1;
                set.clear();
                while (!set.contains(id2)) {
                    id1 = half-id2;
                    while (id1 < 0 || id1 > nums1.length-1) {
                        if (!set.contains(id2)) {
                            set.add(id2);
                        } else {
                            break;
                        }
                        if (id1 < 0) {
                            id2 = id2/2;
                        } else {
                            id2 = (id2+nums2.length-1)/2;
                        }
                        id1 = half-id2;
                    }
                    if (id1 >= 0 && id1 < nums1.length) {
                        if (nums1[id1] == nums2[id2]) {
                            double result;
                            if (id2 > 0 && id1 > 0) {
                                result = (nums2[id2] + Math.max(nums1[id1 - 1], nums2[id2 - 1])) / 2.0;
                            } else if (id2 > 0) {
                                result = (nums2[id2] + nums1[id2 - 1]) / 2.0;
                            } else {
                                result = (nums2[id2] + nums1[id1 - 1]) / 2.0;
                            }
                            return result;
                        } else if (nums1[id1] < nums2[id2]) {
                            id2 = id2 / 2;
                        } else {
                            if (id1 == 0 || id1 > 0 && nums1[id1-1] <= nums2[id2]) {
                                double result;
                                if (id2 > 0 && id1 > 0) {
                                    result = (nums2[id2] + Math.max(nums2[id2 - 1], nums1[id1-1])) / 2.0;
                                } else if (id2 > 0) {
                                    result = (nums2[id2] + nums2[id2-1]) / 2.0;
                                } else {
                                    result = (nums2[id2] + nums1[id1-1])/2.0;
                                }
                                return result;
                            } else {
                                id2 = (nums1.length - 1 + id1) / 2;
                            }
                        }
                    } else {
                        break;
                    }
                }
            }
        }
        return 0;
    }

    private boolean isNumAt(int[] nums, int target, int idx) {
        return nums[idx] == target;
    }

    private double median(int[] nums) {
        if (nums.length%2 == 1) {
            return nums[nums.length/2];
        } else {
            return (nums[nums.length/2]+nums[nums.length/2-1])/2.0;
        }
    }
}
