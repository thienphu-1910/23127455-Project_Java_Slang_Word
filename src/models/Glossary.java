package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import slang.SlangEntry;
import slang.SlangWord;

public class Glossary {
  private HashMap<String, SlangEntry> slangMap;
  private HashMap<String, HashSet<SlangEntry>> keywordMap;
  private ArrayList<SlangEntry> slangWord;

  public Glossary() {}
  // Copy constructor
  public Glossary(Glossary obj) {
    this.slangMap = obj.getSlangMapCopy();
    this.keywordMap = obj.getKeywordMapCopy();
    this.slangWord = obj.getSlangWordCopy();
  }

  // Getter
  public HashMap<String, SlangEntry> getSlangMapCopy() {
    return new HashMap<String, SlangEntry>(this.slangMap);
  }
  public HashMap<String, HashSet<SlangEntry>> getKeywordMapCopy() {
    return new HashMap<String, HashSet<SlangEntry>>(this.keywordMap);
  }
  public ArrayList<SlangEntry> getSlangWordCopy() {
    return new ArrayList<SlangEntry>(this.slangWord);
  }
  public SlangWord getSlang(int index) {
    return new SlangWord(this.slangWord.get(index));
  }
  public int getSlangListLength() {
    return this.slangWord.size();
  }

  // Setter
  public void setSlangMap(HashMap<String, SlangEntry> slangMap) {
    this.slangMap = new HashMap<String, SlangEntry>(slangMap);
  }
  public void setKeywordMap(HashMap<String, HashSet<SlangEntry>> keywordMap) {
    this.keywordMap = new HashMap<String, HashSet<SlangEntry>>(keywordMap);
  }
  public void setSlangWord(ArrayList<SlangEntry> slangWord) {
    this.slangWord = new ArrayList<SlangEntry>(slangWord);
  }
  public void setAll(HashMap<String, SlangEntry> slangMap,
                     HashMap<String, HashSet<SlangEntry>> keywordMap,
                     ArrayList<SlangEntry> slangWord) {
    this.setSlangMap(slangMap);                      
    this.setKeywordMap(keywordMap);
    this.setSlangWord(slangWord);
  }
  
  // Adjust data methods?
  private void adjustKeywordReference(SlangEntry targetSlang, String targetDefinition) {
    String regex = "[^A-Za-z0-9]+";
    String[] keyword = targetDefinition.split(regex);    

    for (String key : keyword) {
      HashSet<SlangEntry> refSet = this.keywordMap.get(key);
      if (refSet != null) {
        refSet.add(targetSlang);
      }
      else if (refSet == null) {
        HashSet<SlangEntry> newRefSet = new HashSet<SlangEntry>();
        newRefSet.add(targetSlang);
        this.keywordMap.put(key, newRefSet);
      }
    }
  }
  public SlangEntry accessSlangEntry(String targetWord) {
    return this.slangMap.get(targetWord);
  }
  public void addSlangEntry(String targetWord, String targetDefinition) {
    ArrayList<String> defList = new ArrayList<String>();
    defList.add(targetDefinition);
    SlangEntry addedSlang = new SlangWord(targetWord, defList);
    this.slangMap.put(targetWord, addedSlang);
    this.slangWord.add(addedSlang);
    this.adjustKeywordReference(addedSlang, targetDefinition);
  }
  public void deleteSlangEntry(String targetWord) {
    SlangEntry slang = this.slangMap.get(targetWord);
    this.slangWord.remove(slang);
    for (String keyword : keywordMap.keySet()) {
      this.keywordMap.get(keyword).remove(slang);
    }
    this.slangWord.remove(slang);
    this.slangMap.remove(targetWord);
  }
}
