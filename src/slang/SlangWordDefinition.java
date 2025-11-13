package slang;

public class SlangWordDefinition extends SlangEntry {
  private String word;

  public SlangWordDefinition(String word) {
    this.word = word;
  }

  public String getWord() {
    return this.word;
  }

  @Override
  public String toString() {
    return this.word;
  }
}
