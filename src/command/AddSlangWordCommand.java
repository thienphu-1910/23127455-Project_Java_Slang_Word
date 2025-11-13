package command;
import controller.Controller;

public class AddSlangWordCommand extends Command {
  public AddSlangWordCommand(Controller controller) {
    super(controller);
  }

  @Override
  public boolean execute() {
    return true;
  }
}
