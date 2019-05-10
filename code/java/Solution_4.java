// binary search
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int x = nums1.length;
        int y = nums2.length;
        int low = 0;
        int high = x;
        while (low <= high) {
            int partitionX = low + (high - low) / 2;
            int partitionY = (x + y + 1) / 2 - partitionX;
            int maxLeftX = partitionX == 0 ? Integer.MIN_VALUE : nums1[partitionX - 1];
            int minRightX = partitionX == x ? Integer.MAX_VALUE : nums1[partitionX];
            int maxLeftY = partitionY == 0 ? Integer.MIN_VALUE : nums2[partitionY - 1];
            int minRightY = partitionY == y ? Integer.MAX_VALUE : nums2[partitionY];
            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                if ((x + y) % 2 == 0) {
                    return (Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2.0;
                } else {
                    return Math.max(maxLeftX, maxLeftY);
                }
            } else if (maxLeftX > minRightY) {
               high =  partitionX - 1;
            } else {
                low = partitionX + 1;
            }
        }
        throw new IllegalArgumentException();
    }
}

// divide and conquer 

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        return (findKth(nums1, nums2, 0, 0, (m + n - 1) / 2 + 1) + findKth(nums1, nums2, 0, 0, (m + n) / 2 + 1)) / 2.0;
    }
    
    public int findKth(int[] a, int[] b, int aLeft, int bLeft, int k)  {
        if (aLeft >= a.length) {
            return b[bLeft + k - 1];
        } else if (bLeft >= b.length) {
            return a[aLeft + k - 1];
        } else if (k == 1) {
            return Math.min(a[aLeft], b[bLeft]);
        }
        int aHalfK = aLeft + k / 2 - 1 >= a.length ? Integer.MAX_VALUE : a[aLeft + k / 2 - 1];
        int bHalfK = bLeft + k / 2 - 1 >= b.length ? Integer.MAX_VALUE : b[bLeft + k / 2 - 1];
        if (aHalfK > bHalfK) {
            return  findKth(a, b, aLeft, bLeft + k / 2, k - k / 2);
        } else {
            return  findKth(a, b, aLeft + k / 2, bLeft, k - k / 2);
        }
    }
}
