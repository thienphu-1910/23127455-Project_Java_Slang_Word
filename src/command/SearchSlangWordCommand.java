package command;
import controller.Controller;

public class SearchSlangWordCommand extends Command {
  public SearchSlangWordCommand(Controller controller) {
    super(controller);
  }

  @Override
  public boolean execute() {
    return true;
  }
}
