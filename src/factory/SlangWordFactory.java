package factory;
import slang.SlangEntry;
import slang.SlangWord;

public class SlangWordFactory extends SlangEntryFactory {
  @Override
  public SlangEntry createSlangEntry(String word, String definition) {
    return new SlangWord(word, definition);
  }
 
}
