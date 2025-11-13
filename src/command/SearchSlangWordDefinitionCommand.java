package command;
import controller.Controller;

public class SearchSlangWordDefinitionCommand extends Command {
  public SearchSlangWordDefinitionCommand(Controller controller) {
    super(controller);
  }

  @Override
  public boolean execute() {
    return true;
  }
}
