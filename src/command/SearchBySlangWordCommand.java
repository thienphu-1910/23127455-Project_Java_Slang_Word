package command;

import java.util.HashMap;

import controller.Controller;
import slang.SlangEntry;

public class SearchBySlangWordCommand extends Command {
  public SearchBySlangWordCommand(Controller controller) {
    super(controller);
  }

  @Override
  public boolean execute() {
    String targetSlang = controller.getSearchingContainer().getTargetSlangCopy();
    HashMap<String, SlangEntry> slangMapCopy = controller.getDataContainer().getSlangMapCopy();
    SlangEntry slang = slangMapCopy.get(targetSlang);

    if (slang != null) {
      controller.getSearchingContainer().setSlangResult(slang);
      return true;
    }
    
    return false;
  }
}
