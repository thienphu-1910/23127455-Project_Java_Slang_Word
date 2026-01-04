package command;

import controller.Controller;

// Ref: https://refactoring.guru/design-patterns/command
public abstract class Command {
  protected Controller controller;

  Command(Controller controller) {
    this.controller = controller;
  }

  public boolean isExisted(String word) {
    return (this.controller.getGlossary().getSlangMapCopy().get(word) != null);
  }

  public abstract boolean execute();
}
