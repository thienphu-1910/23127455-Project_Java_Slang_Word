package factory;
import java.util.ArrayList;
import slang.SlangEntry;
import slang.SlangWord;

public class SlangWordFactory extends SlangEntryFactory {
  @Override
  public SlangEntry createSlangEntry(String word, ArrayList<String> definition) {
    return new SlangWord(word, definition);
  }
 
}
