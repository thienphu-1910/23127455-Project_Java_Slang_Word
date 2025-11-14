package controller;

import command.Command;
import models.DataContainer;
import models.SearchingContainer;

public class Controller {
  private DataContainer dataContainer = new DataContainer();
  private SearchingContainer searchingContainer = new SearchingContainer();

  public Controller() {}

  public DataContainer getDataContainer() {
    return new DataContainer(this.dataContainer);
  }
  public SearchingContainer getSearchingContainer() {
    return new SearchingContainer(this.searchingContainer);
  }

  public void init() {

  }

  public void executeCommand(Command command) {

  }
}
