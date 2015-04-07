package algorithm.leetcode._004_MedianOfTwo;

import static org.junit.Assert.*;

import org.junit.Test;

/**  using divide and conquer idea, each time find the mid of both arrays **/
public class Solution {
   
    public double findMedianSortedArrays(int A[], int B[]) {
            /* A[0, 1, 2, ..., n-1, n] */
            /* A[0, 1, 2, ..., m-1, m] */
	    int m =A.length;
	    int n =B.length;
            int k = (m + n + 1) / 2;   // plus 1 for the middle, for example the median of [1,2,3] is [2], index is 1. (length +1) /2 -1 =1  
            double v = (double)findKth(A, 0, m - 1, B, 0, n - 1, k);

            if ((m+n) % 2 == 0) {
                int k2 = k+1;
                double v2 = (double)findKth(A, 0, m - 1, B, 0, n - 1, k2);
                v = (v + v2) / 2.0;
            }

            return v;
        }

        // find the kth element int the two sorted arrays
        // let's assume: A[aMid] <= B[bMid], x: mid length of A, y: mid length of B, then we can know
        // 
        // (1) there will be at least (x + 1 + y) elements before bMid
        // (2) there will be at least (m - x - 1 + n - y) = m + n - (x + y +1) elements after aMid
        // therefore
        // if k <= x + y + 1, find the kth element in a and b, but unconsidering bMid and its suffix
        // if k > x + y + 1, find the k - (x + 1) th element in a and b, but unconsidering aMid and its prefix
        int findKth(int A[], int aL, int aR, int B[], int bL, int bR, int k) {
            if (aL > aR) return B[bL + k - 1];
            if (bL > bR) return A[aL + k - 1];

            int aMid = (aL + aR) / 2;
            int bMid = (bL + bR) / 2;

            if (A[aMid] <= B[bMid]) {
                if (k <= (aMid - aL) + (bMid - bL) + 1) 
                    return findKth(A, aL, aR, B, bL, bMid - 1, k);
                else
                    return findKth(A, aMid + 1, aR, B, bL, bR, k - (aMid - aL) - 1);
            }
            else { // A[aMid] > B[bMid]
                if (k <= (aMid - aL) + (bMid - bL) + 1) 
                    return findKth(A, aL, aMid - 1, B, bL, bR, k);
                else
                    return findKth(A, aL, aR, B, bMid + 1, bR, k - (bMid - bL) - 1);
            }
        }
        
        @Test
        public void testCase1(){
            int[] a= {};
            int[] b= {};
            assertEquals(0, findMedianSortedArrays(a,b),0.000001);
        }
        
        @Test
        public void testCase2(){
            int[] a= {1};
            int[] b= {2};
            assertEquals(1.5, findMedianSortedArrays(a,b),0.000001);
        }
        
        @Test
        public void testCase3(){
            int[] a= {1,2};
            int[] b= {};
            assertEquals(1.5, findMedianSortedArrays(a,b),0.000001);
        }
        
        @Test
        public void testCase4(){
            int[] a= {};
            int[] b= {1,2};
            assertEquals(1.5, findMedianSortedArrays(a,b),0.000001);
        }
        
        @Test
        public void testCase5(){
            int[] a= {1,3};
            int[] b= {2,4,5};
            assertEquals(3.0, findMedianSortedArrays(a,b),0.000001);
        }
        
        
        
}
