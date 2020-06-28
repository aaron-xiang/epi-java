package algorithms;

import java.util.Collections;
import java.util.Random;

public class ArrayUtils {
    public static boolean isSorted(int[] data) {
        if (data == null || data.length == 1) return true;
        for (int i = 0; i < data.length - 1; i++) {
            if (data[i] > data[i+1]) return false;
        }
        return true;
    }

    public static void shuffle(int[] data) {
        Random r = new Random();
        for (int n = data.length - 1; n > 0; n--) {
            int j = r.nextInt(n);
            int temp = data[j];
            data[j] = data[n-1];
            data[n-1] = temp;
        }

    }
}
