package models;

import java.util.ArrayList;
import java.util.HashMap;

import slang.SlangEntry;
import slang.SlangWord;

public class Glossary {
  private HashMap<String, SlangEntry> slangMap;
  private HashMap<String, ArrayList<SlangEntry>> keywordMap;
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
  private void adjustKeywordReference(SlangEntry targetSlang, String targetDefinition) {
    String regex = "[^A-Za-z0-9]+";
    String[] keyword = targetDefinition.split(regex);    

    for (String key : keyword) {
      ArrayList<SlangEntry> refList = this.keywordMap.get(key);
      if (refList != null) {
        refList.add(targetSlang);
      }
      else if (refList == null) {
        ArrayList<SlangEntry> newRefList = new ArrayList<SlangEntry>();
        newRefList.add(targetSlang);
        this.keywordMap.put(key, newRefList);
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
}
