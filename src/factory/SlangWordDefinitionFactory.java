package factory;
import slang.SlangEntry;
import slang.SlangWordDefinition;

public class SlangWordDefinitionFactory extends SlangEntryFactory {
  @Override
  public SlangEntry createSlangEntry(String str) {
    return new SlangWordDefinition(str);
  }
}
