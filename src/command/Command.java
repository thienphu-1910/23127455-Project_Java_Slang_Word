package command;
import controller.Controller;

public abstract class Command {
  public Controller controller;

  Command(Controller controller) {
    this.controller = controller;
  }

  public abstract boolean execute();
}
