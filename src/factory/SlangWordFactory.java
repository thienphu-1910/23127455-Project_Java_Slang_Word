package factory;
import java.util.ArrayList;
import slang.SlangEntry;
import slang.SlangWord;

public class SlangWordFactory extends SlangEntryFactory {
  @Override
  public SlangEntry createSlangEntry(String word, ArrayList<String> definitions) {
    return new SlangWord(word, definitions);
  }
 
}
