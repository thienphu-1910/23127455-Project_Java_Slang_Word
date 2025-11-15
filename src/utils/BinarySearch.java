package utils;

import java.util.ArrayList;

public class BinarySearch {
  public static int binarySearch(ArrayList<String> arr, String target) {
    int low = 0, high = arr.size() -1;

    while (low <= high) {
        int mid = low + (high - low) / 2;
        
        if (arr.get(mid).contentEquals(target))
            return mid;
      
        if (arr.get(mid).compareTo(target) < 0)
            low = mid + 1;          
        else
            high = mid - 1;
      }
    
    return -1;
  }
}
