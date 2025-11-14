package command;

import controller.Controller;

public abstract class Command {
  protected Controller controller;

  Command(Controller controller) {
    this.controller = controller;
  }

  public abstract boolean execute();
}
