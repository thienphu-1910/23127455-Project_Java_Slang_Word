package models;

import java.util.ArrayList;
import java.util.HashSet;

import slang.SlangEntry;

public class SearchHistoryData {
  private HashSet<SlangEntry> historySet;
  private ArrayList<SlangEntry> recentSearching;

  public SearchHistoryData() {
    this.historySet = new HashSet<SlangEntry>();
    this.recentSearching = new ArrayList<SlangEntry>();
  }

  public void insert(SlangEntry entry) {
    boolean isExisted = historySet.contains(entry);
    if (isExisted == true) {
      recentSearching.remove(entry);    
    }
    recentSearching.add(entry);
  }

  public ArrayList<SlangEntry> getRecentSearchResultCopy() {
    return new ArrayList<SlangEntry>(recentSearching);
  }
}
