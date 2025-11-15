package command;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import controller.Controller;
import slang.SlangEntry;

public class SearchByDefinitionCommand extends Command {
  public SearchByDefinitionCommand(Controller controller) {
    super(controller);
  }

  @Override
  public boolean execute() {
    ArrayList<String> targetKeywordCopy = controller.getSearchSlangData().getTargetKeywordCopy();
    HashMap<String, ArrayList<SlangEntry>> keywordMapCopy = controller.getGlossary().getKeywordMapCopy();
    HashSet<SlangEntry> slangList = new HashSet<SlangEntry>();

    for (String target : targetKeywordCopy) {
      ArrayList<SlangEntry> tempList = keywordMapCopy.get(target);
      if (tempList != null) {
        for (SlangEntry slang : tempList) {
          slangList.add(slang);
        }
      }
    }

    if (slangList != null && slangList.size() > 0) {
      ArrayList<SlangEntry> slangListArray = new ArrayList<SlangEntry>();

      for (SlangEntry slang : slangList) {
        slangListArray.add(slang);
      }

      controller.getSearchSlangData().setSlangListResult(slangListArray);
    }

    return true;
  }
}
