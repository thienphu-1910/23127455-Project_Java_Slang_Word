package models;

import java.util.ArrayList;
import java.util.HashMap;

import slang.SlangEntry;

public class DataContainer {
  private HashMap<String, SlangEntry> slangMap;
  private HashMap<String, ArrayList<SlangEntry>> keywordMap;
  private ArrayList<SlangEntry> slangWord;

  public DataContainer() {}
  // Copy constructor
  public DataContainer(DataContainer obj) {
    this.slangMap = obj.getSlangMapCopy();
    this.keywordMap = obj.getKeywordMapCopy();
    this.slangWord = obj.getSlangWordCopy();
  }

  // Getter
  public HashMap<String, SlangEntry> getSlangMapCopy() {
    return new HashMap<String, SlangEntry>(this.slangMap);
  }
  public HashMap<String, ArrayList<SlangEntry>> getKeywordMapCopy() {
    return new HashMap<String, ArrayList<SlangEntry>>(this.keywordMap);
  }
  public ArrayList<SlangEntry> getSlangWordCopy() {
    return new ArrayList<SlangEntry>(this.slangWord);
  }

  // Setter
  public void setSlangMap(HashMap<String, SlangEntry> slangMap) {
    this.slangMap = slangMap;
  }
  public void setKeywordMap(HashMap<String, ArrayList<SlangEntry>> keywordMap) {
    this.keywordMap = keywordMap;
  }
  public void setSlangWord(ArrayList<SlangEntry> slangWord) {
    this.slangWord = slangWord;
  }
  public void setAll(HashMap<String, SlangEntry> slangMap,
                     HashMap<String, ArrayList<SlangEntry>> keywordMap,
                     ArrayList<SlangEntry> slangWord) {
    this.setSlangMap(slangMap);                      
    this.setKeywordMap(keywordMap);
    this.setSlangWord(slangWord);
  }

  // Adjust data methods?
}
