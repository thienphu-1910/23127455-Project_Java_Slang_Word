package controller;

import command.Command;
import models.Glossary;
import models.SearchSlangData;
import models.SlangData;

public class Controller {
  private Glossary glossary = new Glossary();
  private SearchSlangData searchSlangData = new SearchSlangData();
  private SlangData addSlangData = new SlangData();
  private SlangData deleteSlangData = new SlangData();

  public Controller() {}

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

  public void init() {

  }

  public void executeCommand(Command command) {

  }
}
