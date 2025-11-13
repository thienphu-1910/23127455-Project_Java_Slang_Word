package command;
import controller.Controller;

public class ResetOriginalListCommand extends Command {
  public ResetOriginalListCommand(Controller controller) {
    super(controller);
  }

  @Override
  public boolean execute() {
    return true;
  }
}
