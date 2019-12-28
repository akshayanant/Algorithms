package bl;

import java.util.ArrayList;

/**
 * Created by Akshay Hegde on 3/16/2019.
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * <p>
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * <p>
 * You may assume nums1 and nums2 cannot be both empty.
 */
public class MediaOfTwoSortdArray {

    private double soultion(int[] nums1, int nums2[]) {
        ArrayList<Integer> res = new ArrayList<>();
        if (nums1.length == 0) {
            for (int aNum2 : nums2) {
                res.add(aNum2);
            }
        } else {
            for (int aNum1 : nums1) {
                res.add(aNum1);
            }
        }
        if (nums1.length != 0) {
            for (int aNum2 : nums2) {
                merge(res, aNum2);
            }
        }
        if (res.size() % 2 != 0) {
            return res.get(res.size() / 2);
        }
        return (res.get(res.size() / 2 - 1) + res.get(res.size() / 2)) / 2;
    }


    private void merge(ArrayList<Integer> res, int a) {
        int low = 0;
        int high = res.size() - 1;
        boolean merged = false;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (res.get(mid) == a) {
                res.add(mid, a);
                merged = true;
                break;
            }
            if (res.get(mid) > a) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        if (!merged) {
            res.add(high + 1, a);
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2};
        int[] nums2 = {3,4};
        MediaOfTwoSortdArray array = new MediaOfTwoSortdArray();
        System.out.println(array.soultion(nums1,nums2));
    }
}
