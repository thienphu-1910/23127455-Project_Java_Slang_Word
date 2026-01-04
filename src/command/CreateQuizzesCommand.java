package command;
import controller.Controller;

public class CreateQuizzesCommand extends Command {
  public CreateQuizzesCommand(Controller controller) {
    super(controller);
  }

  @Override
  public boolean execute() {
    return true;
  }
}
