package command;
import controller.Controller;

public class EditSlangWordCommand extends Command {
  public EditSlangWordCommand(Controller controller) {
    super(controller);
  }

  @Override
  public boolean execute() {
    return true;
  }
}
