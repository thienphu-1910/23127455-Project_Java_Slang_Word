package command;
import controller.Controller;

public class RandomSlangWordCommand extends Command {
  public RandomSlangWordCommand(Controller controller) {
    super(controller);
  }

  @Override
  public boolean execute() {
    return true;
  }
}
