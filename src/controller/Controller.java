package controller;

import command.Command;
import models.Glossary;
import models.SearchSlangData;

public class Controller {
  private Glossary dataContainer = new Glossary();
  private SearchSlangData searchingContainer = new SearchSlangData();

  public Controller() {}

  public Glossary getGlossary() {
    return new Glossary(this.dataContainer);
  }
  public SearchSlangData getSearchSlangData() {
    return new SearchSlangData(this.searchingContainer);
  }

  public void init() {

  }

  public void executeCommand(Command command) {

  }
}
