import java.util.HashMap;

import provider.SlangWordFileProvider;

public class Main {
  public static void main(String[] args) {
    String filePath = "./input/slang.txt";
    SlangWordFileProvider provider = new SlangWordFileProvider(filePath);
    HashMap<String, String> slangwords = provider.importSlangWord();

    //Set<String> set = slangwords.keySet();
    System.out.println(slangwords.size());
  }
}
