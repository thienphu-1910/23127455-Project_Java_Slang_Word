package factory;
import slang.SlangEntry;

public abstract class SlangEntryFactory {
  public abstract SlangEntry createSlangEntry(String word, String definition);

  // some operations
}

