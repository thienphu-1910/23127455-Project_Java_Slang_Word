package controller;

import command.Command;
import models.Glossary;
import models.SearchSlangData;
import models.SlangData;
import slang.SlangWord;

public class Controller {
  private Glossary glossary = new Glossary();
  private SearchSlangData searchSlangData = new SearchSlangData();
  private SlangData addSlangData = new SlangData();
  private SlangData deleteSlangData = new SlangData();  
  private String editedSlangWord;
  private SlangWord randomSlang;

  public Controller() {}

  public Glossary accessGlossary() {
    return this.glossary;
  }

  public Glossary getGlossary() {
    return new Glossary(this.glossary);
  }
  public SearchSlangData getSearchSlangData() {
    return new SearchSlangData(this.searchSlangData);
  }
  private SlangData getSlangData(SlangData data) {
    return new SlangData(data);
  }
  public SlangData getAddSlangData() {
    return getSlangData(this.addSlangData);
  }
  public SlangData getDeleteSlangData() {
    return getSlangData(this.deleteSlangData);
  }
  public String getEditedSlangWord() {
    return new String(this.editedSlangWord);
  }
  public SlangWord getRandomSlang() {
    return new SlangWord(randomSlang);
  }

  public void setRandomSlang(SlangWord slang) {
    this.randomSlang = new SlangWord(slang);
  }
  public void init() {

  }

  public void executeCommand(Command command) {

  }
}
