package command;
import controller.Controller;

public class CreateDefinitionQuizzesCommand extends Command {
  public CreateDefinitionQuizzesCommand(Controller controller) {
    super(controller);
  }

  @Override
  public boolean execute() {
    return true;
  }
}
