package glossary;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import slang.SlangEntry;
import slang.SlangWord;

public abstract class Dictionary {
  private static HashMap<String, SlangEntry> slangMap;
  private static HashMap<String, ArrayList<SlangEntry>> keywordMap;

  private static ArrayList<SlangEntry> slangWord;

  // Searching
  public SlangEntry searchBySlangWord(String word) {
    return slangMap.get(word);
  }

  public HashSet<SlangEntry> searchByDefinition(ArrayList<String> keyword) {
    HashSet<SlangEntry> slangSet = new HashSet<SlangEntry>();

    for (String word : keyword) {
      ArrayList<SlangEntry> slangList = keywordMap.get(word);
      if (slangList != null) {
        for (SlangEntry slang : slangList) {
          slangSet.add(slang);
        }
      }
    }

    return slangSet;
  }
  
  public SlangEntry isExist(String word) {
    return slangMap.get(word);
  }  

  // Adding
  // position: should start from 1 (UX)
  public void addSlangWord(String word, String definition, String mode, int position) {
    if (mode.contentEquals("override")) {      
      slangMap.get(word).addDefinition(definition, position - 1);
    } 
    else if (mode.contentEquals("duplicate")) {
      position = -1;
      slangMap.get(word).addDefinition(definition, position);
    } 
    else if (mode.contentEquals("new")) {
      ArrayList<String> defList = new ArrayList<String>();
      defList.add(definition);
      SlangEntry slang = new SlangWord(word, defList);
      slangMap.put(word, slang);
    }
  }

  // Deleting
  public void deleteSlangWord(String word, String definition, String mode, int position) {
    
  }
}


// HashMap<String, ArrayList<SlangEntry>> keywordMap;
// HashMap<String, SlangEntry> slangIdMap;

// Only for random purpose:
// ArrayList<SlangEntry> slangWord;

// Add a new one
// check the slangword in slangIdMap-> If is existed 
// -> the SlangEntry add to the definition list or override?
// Override -> user choose the definition to override

// Delete a slang word
// find it -> If existed
// -> ask user which definition want to delete -> delete that definition or delete all
// If no more def = delete all

// Edit a slang word
// find it -> If existed
// Edit slangword or definition
// If the new slangword is existed (compare to the old version first if the same -> do nothing)
// -> merge to the existed
// How?
// Find that existed, add all defs of the edited -> delete the edited