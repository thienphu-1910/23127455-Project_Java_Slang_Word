package slang;

public class SlangWord extends SlangEntry {
  private String word;

  public SlangWord(String word) {
    this.word = word;
  }

  @Override
  public String getWord() {
    return this.word;
  }

  @Override
  public String toString() {
    return this.word;
  }
}
