package command;

import controller.Controller;
import database.SlangDatabase;

public class ResetOriginalListCommand extends Command {
  public ResetOriginalListCommand(Controller controller) {
    super(controller);
  }

  @Override
  public boolean execute() {
    SlangDatabase db = new SlangDatabase();
    db.fastStartup(this.controller);
    
    return true;
  }
}
