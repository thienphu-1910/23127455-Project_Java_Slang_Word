package command;

import controller.Controller;

import models.Glossary;
import slang.SlangWord;

public class RandomSlangWordCommand extends Command {
  public RandomSlangWordCommand(Controller controller) {
    super(controller);
  }

  @Override
  public boolean execute() {
    Glossary glossary = this.controller.getGlossary();
    int position = (int)(Math.random() * (glossary.getSlangListLength() - 1));

    SlangWord slang = glossary.getSlang(position);
    this.controller.setRandomSlang(slang);
    
    return true;
  }
}
