package factory;
import java.util.ArrayList;

import slang.SlangEntry;

public abstract class SlangEntryFactory {
  public abstract SlangEntry createSlangEntry(String word, ArrayList<String> definitions);

  // some operations
}

