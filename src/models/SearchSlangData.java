package models;

import java.util.ArrayList;

import slang.SlangEntry;
import slang.SlangWord;

public class SearchSlangData {
  private String targetSlang;
  private SlangEntry slangResult;
  private ArrayList<String> targetKeyword;
  private ArrayList<SlangEntry> slangListResult;

  public SearchSlangData() {
    this.targetSlang = "";
    this.slangResult = null;
    this.targetKeyword = null;
    this.slangListResult = null;
  }

  // Copy constructor
  public SearchSlangData(SearchSlangData obj) {
    this.targetSlang = obj.getTargetSlangCopy();
    this.slangResult = obj.getSlangResultCopy();
    this.targetKeyword = obj.getTargetKeywordCopy();
    this.slangListResult = obj.getSlangListResultCopy();
  }

  // Setter
  public void setTargetSlang(String targetSlang) {
    this.targetSlang = targetSlang;
  }
  public void setSlangResult(SlangEntry slangResult) {
    this.slangResult = slangResult;
  }
  public void setTargetKeyword(ArrayList<String> targetKeyword) {
    this.targetKeyword = targetKeyword;
  }
  public void setSlangListResult(ArrayList<SlangEntry> slangListResult) {
    this.slangListResult = slangListResult;
  }

  // Getter
  public String getTargetSlangCopy() {
    return new String(this.targetSlang);
  }
  public SlangEntry getSlangResultCopy() {
    return new SlangWord(this.slangResult);
  }
  public ArrayList<String> getTargetKeywordCopy() {
    return new ArrayList<String>(this.targetKeyword);
  }
  public ArrayList<SlangEntry> getSlangListResultCopy() {
      return new ArrayList<SlangEntry>(this.slangListResult);
  }

}
