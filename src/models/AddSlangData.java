package models;

public class AddSlangData {
  private String addedWord;
  private String addedDefinition;

  // Constrcutor
  public AddSlangData() {}
  // Copy constructor
  public AddSlangData(AddSlangData obj)  {
    this.addedWord = obj.getAddedWordCopy();
    this.addedDefinition = obj.getAddedDefinitionCopy();
  }

  // Getter
  public String getAddedWordCopy() {
    return new String(this.addedWord);
  }
  public String getAddedDefinitionCopy() {
    return new String(this.addedDefinition);
  }

  // Setter
  public void setAddedWord(String addedWord) {
    this.addedWord = addedWord;
  }
  public void setAddedDefinition(String addedDefinition) {
    this.addedDefinition = addedDefinition;
  }
}
