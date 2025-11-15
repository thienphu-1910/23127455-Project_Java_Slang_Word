package slang;
import java.util.ArrayList;

public class SlangWord extends SlangEntry {
  private String word;
  private ArrayList<String> definition;

  public SlangWord(String word, ArrayList<String> definition) {
    this.word = word;
    this.definition = definition;
  }

  public SlangWord(SlangEntry slang) {
    this.word = slang.getWord();
    this.definition = slang.getDefinitions();
  }
  
  @Override
  public String getWord() {
    return this.word;
  }
  
  @Override
  public ArrayList<String> getDefinitions() {
    return this.definition;
  }  

  @Override
  public void addDefinition(String definition, int position) {
    if (position >= this.definition.size()) {
      this.definition.add(definition);
    } else if (position == -1) {
      this.definition.add(position, definition);
    }
  }

  @Override
  public String toString() {
    return this.word + "`" + this.definition;
  }
}
