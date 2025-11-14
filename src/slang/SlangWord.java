package slang;

public class SlangWord extends SlangEntry {
  private String word;
  private String definition;

  public SlangWord(String word, String definition) {
    this.word = word;
    this.definition = definition;
  }

  @Override
  public String getWord() {
    return this.word;
  }

  @Override
  public String getDefinition() {
    return this.definition;
  }

  @Override
  public String toString() {
    return this.word + "`" + this.definition;
  }
}
