package slang;
import java.util.ArrayList;

public abstract class SlangEntry {  
  public abstract String getWord();
  public abstract ArrayList<String> getDefinitions();  
  public abstract void addDefinition(String definition, int position);
  public abstract String toString();
}
