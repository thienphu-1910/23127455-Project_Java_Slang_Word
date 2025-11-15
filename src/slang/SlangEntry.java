package slang;
import java.util.ArrayList;

public abstract class SlangEntry {  
  public abstract String getWord();
  public abstract ArrayList<String> getDefinitions();    
  public abstract void overrideDefinition(String targetDefinition, String replacedDefinition);
  public abstract void duplicateDefinition(String definition);
  public abstract void deleteDefinition(String definition);  
  public abstract String toString();
}
