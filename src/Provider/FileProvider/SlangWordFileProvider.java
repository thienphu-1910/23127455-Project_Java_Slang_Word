package Provider.FileProvider;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;

public class SlangWordFileProvider {
  private String filePath = "";
  private String regex = "`";

  // Define constructor
  public SlangWordFileProvider(String filePath) {
    this.filePath = filePath;
  }

  // Split the string into two parts, the first one is slang one, the second one is its definition
  public String[] splitString(String str) {
    String[] splittedStrings = str.split(this.regex);
    return splittedStrings;
  }

  // Import original data from text file
  public HashMap<String, String> importSlangWord() {
    HashMap<String, String> slangwords = new HashMap<String, String>();
    try (BufferedReader br = new BufferedReader(new FileReader(this.filePath))) {
      String line;

      while ((line = br.readLine()) != null) {
        String[] splittedString = splitString(line);
        slangwords.put(splittedString[0], splittedString[1]);
      }

    } catch (Exception e) {
      System.out.println(e.getMessage());
    }

    return slangwords;
  }
}
