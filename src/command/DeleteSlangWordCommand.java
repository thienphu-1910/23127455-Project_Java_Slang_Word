package command;

import controller.Controller;
import models.SlangData;
import slang.SlangEntry;

public class DeleteSlangWordCommand extends Command {
  public DeleteSlangWordCommand(Controller controller) {
    super(controller);
  }

  private void deleteDefinition(String word, String definition) {
    SlangEntry slang = this.controller.getGlossary().accessSlangEntry(word);
    if (slang == null) return;

    slang.deleteDefinition(definition);
    if (slang.getDefinitions().size() == 0) {
      deleteAll(word);
    }    
  }

  private void deleteAll(String word) {
    this.controller.getGlossary().deleteSlangEntry(word);
  }

  private void deleteSlangWord(String word, String definition, String mode) {
    if (mode == "specified") {
      this.deleteDefinition(word, definition);
    }
    else if (mode == "all") {
      this.deleteAll(word);
    }
  }

  @Override
  public boolean execute() {
    SlangData data = this.controller.getDeleteSlangData();
    String word = data.getWordCopy();
    String definition = data.getDefinitionCopy();

    boolean existed = this.isExisted(word);
    if (existed == false) {
      return false;
    }

    String mode = "";    

    // User requirement

    this.deleteSlangWord(word, definition, mode);

    return true;
  }
}

// Delete a slang word
// find it -> If existed
// -> ask user which definition want to delete -> delete that definition or delete all
// If no more def = delete all