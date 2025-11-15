package utils;

import java.util.ArrayList;

public class HeapSort {
  private static void heapify(ArrayList<String> arr, int n, int i) {
    int largest = i;
    int left = 2 * i + 1;
    int right = 2 * i + 2;

    if (left < n && arr.get(left).compareTo(arr.get(largest)) > 0) {
      largest = left;
    }

    if (right < n && arr.get(right).compareTo(arr.get(largest)) > 0) {
      largest = right;
    }

    if (largest != i) {
      String temp = arr.get(i);
      arr.add(i, arr.get(largest));
      arr.add(largest, temp);

      heapify(arr, n, largest);
    }
  }

  public static ArrayList<String> heapSort(ArrayList<String> arr) {
    int n = arr.size();

    for (int i = n / 2 - 1; i >= 0; --i) {
      heapify(arr, n, i);
    }

    for (int i = n - 1; i > 0; i--) {
        // Move current root to end
        String temp = arr.get(0);
        arr.add(0, arr.get(i));
        arr.add(i, temp);        

        // Call max heapify on the reduced heap
        heapify(arr, i, 0);
    }

    return arr;
  }
}
