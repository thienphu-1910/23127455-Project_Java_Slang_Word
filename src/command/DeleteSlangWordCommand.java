package command;
import controller.Controller;

public class DeleteSlangWordCommand extends Command {
  public DeleteSlangWordCommand(Controller controller) {
    super(controller);
  }

  @Override
  public boolean execute() {
    return true;
  }
}
