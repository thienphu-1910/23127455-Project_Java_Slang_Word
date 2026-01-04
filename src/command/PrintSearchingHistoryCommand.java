package command;
import controller.Controller;

public class PrintSearchingHistoryCommand extends Command {
  public PrintSearchingHistoryCommand(Controller controller)   {
    super(controller);
  }

  @Override
  public boolean execute() {
    return true;
  }
}
