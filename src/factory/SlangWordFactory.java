package factory;
import slang.SlangEntry;
import slang.SlangWord;

public class SlangWordFactory extends SlangEntryFactory {
  @Override
  public SlangEntry createSlangEntry(String str) {
    return new SlangWord(str);
  }
 
}
