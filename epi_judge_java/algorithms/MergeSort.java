package algorithms;

public class MergeSort {
    private int[] data;
    private int[] temp;

    public MergeSort(int[] data) {
        this.data = data;
        this.temp = new int[data.length];
    }

    public void sort(int[] data) {
        sort(data, 0, data.length - 1);
    }

    private void sort(int[] data, int start, int end) {
        if (start >= end) return;
        int mid = start/2 + end/2;
        sort(data, start, mid);
        sort(data, mid + 1, end);
        merge(data, start, mid, end);
    }

    private void merge(int[] data, int start, int mid, int end) {
//        System.arraycopy(data, start, temp, start,end - start + 1);
        for (int i = start; i <= end; i++) {
            temp[i] = data[i];
        }
        int i = start, j = mid + 1;
        for (int k = start; k < data.length; k++) {
            if (j > end || temp[i] < temp[j]) data[k] = temp[i++];
            else data[k] = temp[j++];
        }

    }
}
