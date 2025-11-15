package slang;

import java.util.ArrayList;

import utils.HeapSort;
import utils.BinarySearch;

public class SlangWord extends SlangEntry {
  private String word;
  private ArrayList<String> definition = new ArrayList<String>();

  public SlangWord(String word, ArrayList<String> definition) {
    this.word = word;
    this.definition = definition;
    this.definition = HeapSort.heapSort(definition);
  }

  // Copy constructor
  public SlangWord(SlangEntry slang) {
    this.word = slang.getWord();
    this.definition = slang.getDefinitions();
  }

  @Override
  public String getWord() {
    return this.word;
  }
  
  @Override
  public ArrayList<String> getDefinitions() {
    return this.definition;
  }  

  @Override
  public void overrideDefinition(String targetDefinition, String replacedDefinition) {
    if (this.definition == null) return;

    int position = BinarySearch.binarySearch(this.definition, replacedDefinition);
    this.definition.set(position, targetDefinition);
  }

  @Override 
  public void duplicateDefinition(String definition) {
    if (this.definition == null) return;
    int size = this.definition.size();
    // Enhance this loop
    for (int i = 0; i < size; ++i) {
      if (this.definition.get(i).compareTo(definition) > 0) {
        this.definition.add(i, definition);
        return;
      }
    }
    this.definition.add(definition);
  }

  @Override
  public void deleteDefinition(String definition) {
    if (this.definition == null) return;
    int position = BinarySearch.binarySearch(getDefinitions(), definition);
    this.definition.remove(position);
  }

  @Override
  public String toString() {
    return this.word + "`" + this.definition;
  }
}
