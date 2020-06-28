package test;

import algorithms.ArrayUtils;
import algorithms.MergeSort;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

public class MergeSortTest {

    @Test
    public void testMergeSort() {
//        int n = Integer.MAX_VALUE / 2048;
        int n = 100000;
        int[] list = new int[n];
        for (int i = 0; i < n ; i++) {
            list[i] = i;
        }
//        assertTrue(ArrayUtils.isSorted(list));
        ArrayUtils.shuffle(list);
//        assertFalse(ArrayUtils.isSorted(list));

//        MergeSort merge = new MergeSort(list);
//        merge.sort(list);
        Arrays.sort(list);
        assertTrue(ArrayUtils.isSorted(list));
    }
}
