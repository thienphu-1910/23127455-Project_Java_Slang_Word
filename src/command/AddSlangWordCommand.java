package command;

import controller.Controller;

public class AddSlangWordCommand extends Command {
  public AddSlangWordCommand(Controller controller) {
    super(controller);
  }

  // Add Condition Statement in this method
  private void addSlangWord(String word, String definition, String mode, int position) {    
    if (mode.contentEquals("override")) {      
      this.controller.getGlossary().accessSlangEntry(word).addDefinition(definition, position - 1);
    } 
    else if (mode.contentEquals("duplicate")) {
      position = -1;
      this.controller.getGlossary().accessSlangEntry(word).addDefinition(definition, position);
    } 
    else if (mode.contentEquals("new")) {
      this.controller.getGlossary().addSlangEntry(word, definition);
    }
  }

  @Override
  public boolean execute() {
    String addedWord = this.controller.getAddSlangData().getAddedWordCopy();
    String addedDefinition = this.controller.getAddSlangData().getAddedDefinitionCopy();

    boolean existed = this.isExisted(addedWord);

    String method = "new";
    int position = -1;
    // Get user requirement method here:

    //
    this.addSlangWord(addedWord, addedDefinition, method, position);
    
    return true;
  }
}

// Add a new one
// check the slangword in slangIdMap-> If is existed 
// -> the SlangEntry add to the definition list or override?
// Override -> user choose the definition to override