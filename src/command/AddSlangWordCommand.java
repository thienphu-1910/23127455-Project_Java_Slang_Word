package command;

import controller.Controller;
import models.SlangData;
import slang.SlangEntry;

public class AddSlangWordCommand extends Command {
  public AddSlangWordCommand(Controller controller) {
    super(controller);
  }

  private void overrideSlangWord(String word, String targetDefinition, String replacedDefinition) {    
    SlangEntry slang = this.controller.getGlossary().accessSlangEntry(word);
    if (slang == null) return;
    
    slang.overrideDefinition(targetDefinition, replacedDefinition);
  }
  private void duplicateSlangWord(String word, String definition) {
    SlangEntry slang = this.controller.getGlossary().accessSlangEntry(word);
    if (slang == null) return;

    slang.duplicateDefinition(definition);
  }

  // Add Condition Statement in this method
  private void addSlangWord(String word, String targetDefinition, String mode, String replacedDefinition) {    
    if (mode.contentEquals("override")) {      
      this.overrideSlangWord(word, targetDefinition, replacedDefinition);
    } 
    else if (mode.contentEquals("duplicate")) {
      this.duplicateSlangWord(word, targetDefinition);
    } 
    else if (mode.contentEquals("new")) {
      this.controller.getGlossary().addSlangEntry(word, targetDefinition);
    }
  }

  @Override
  public boolean execute() {
    SlangData data = this.controller.getAddSlangData();
    String addedWord = data.getWordCopy();
    String addedDefinition = data.getDefinitionCopy();

    boolean existed = this.isExisted(addedWord);

    String method = "new";
    String replacedDefinition = "";
    // Get user requirement method here:

    //
    this.addSlangWord(addedWord, addedDefinition, method, replacedDefinition);
    
    return true;
  }
}

// Add a new one
// check the slangword in slangIdMap-> If is existed 
// -> the SlangEntry add to the definition list or override?
// Override -> user choose the definition to override