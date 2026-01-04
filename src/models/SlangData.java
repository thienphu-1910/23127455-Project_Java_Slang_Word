package models;

public class SlangData {
  private String word;
  private String definition;

  // Constrcutor
  public SlangData() {}
  public SlangData(String word, String definition) {
    this.word = word;
    this.definition = definition;
  }
  // Copy constructor
  public SlangData(SlangData obj)  {
    this.word = obj.getWordCopy();
    this.definition = obj.getDefinitionCopy();
  }

  // Getter
  public String getWordCopy() {
    return new String(this.word);
  }
  public String getDefinitionCopy() {
    return new String(this.definition);
  }

  // Setter
  public void setWord(String word) {
    this.word = word;
  }
  public void setDefinition(String definition) {
    this.definition = definition;
  }
}
