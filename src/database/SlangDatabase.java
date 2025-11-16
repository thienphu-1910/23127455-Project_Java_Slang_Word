package database;

import java.io.BufferedReader;
//import java.io.DataInput;
import java.io.FileReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.io.IOException;

import controller.Controller;
import slang.SlangEntry;
import slang.SlangWord;

public class SlangDatabase {
  private final String defaultPath = "./input/slang.txt";  
  private String fastStartupFilePath = "./input/slang_fast_startup_origin.bin";
  private String workedDataFilePath = "./input/slang_save.bin";
  private String regex = "`";

  // Define constructor
  public SlangDatabase() {}

  // Split the string into two parts, the first one is slang one, the second one is its definition
  public String[] splitString(String str) {
    String[] splittedStrings = str.split(this.regex);
    return splittedStrings;
  }

  // Import data
  public HashMap<String, String> importSlangWord() {
    HashMap<String, String> slangwords = new HashMap<String, String>();
    try (BufferedReader br = new BufferedReader(new FileReader(this.defaultPath))) {
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

  private SlangEntry loadSlangEntry(DataInputStream dis) {
    try {
      String word = dis.readUTF();
      int defListSize = dis.readInt();
      ArrayList<String> defList = new ArrayList<String>(defListSize);
      for (int i = 0; i < defListSize; ++i) {
        String definition = dis.readUTF();
        defList.add(definition);
      }

      SlangEntry newEntry = new SlangWord(word, defList);
      return newEntry;
    }
    catch (IOException e) {
      e.printStackTrace();
    }

    return null;
  }

  private HashMap<String, SlangEntry> loadSlangMap(DataInputStream dis) {
    try {
      int size = dis.readInt();
      HashMap<String, SlangEntry> slangMap = new HashMap<String, SlangEntry>(size);
      for (int i = 0; i < size; ++i) {
        String key = dis.readUTF();
        SlangEntry newEntry = loadSlangEntry(dis);
        if (newEntry != null) slangMap.put(key, newEntry);
      }
      return slangMap;
    } 
    catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }

  private HashMap<String, HashSet<SlangEntry>> loadKeywordMap(DataInputStream dis) {
    try {
      int size = dis.readInt();
      HashMap<String, HashSet<SlangEntry>> keywordMap = new HashMap<String, HashSet<SlangEntry>>(size);
      for (int i = 0; i < size; ++i) {
        String key = dis.readUTF();
        int slangSetSize = dis.readInt();
        HashSet<SlangEntry> slangSet = new HashSet<SlangEntry>(slangSetSize);
        for (int j = 0; j < slangSetSize; ++i) {
          SlangEntry newEntry = loadSlangEntry(dis);
          if (newEntry != null) slangSet.add(newEntry);
        }
        keywordMap.put(key, slangSet);
        return keywordMap;
      }
    }
    catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }

  private ArrayList<SlangEntry> loadSlangWord(DataInputStream dis) {
    try {
      int size = dis.readInt();
      ArrayList<SlangEntry> slangWord = new ArrayList<SlangEntry>(size);
      for (int i = 0; i < size; ++i) {
        SlangEntry newEntry = loadSlangEntry(dis);
        if (newEntry != null) slangWord.add(newEntry);
      }

      return slangWord;
    }
    catch (IOException e) {
      e.printStackTrace();
    }

    return null;
  }

  private void loadData(Controller controller, String filePath) {
    try (DataInputStream dis = new DataInputStream(new FileInputStream(filePath))) {
      HashMap<String, SlangEntry> slangMap = loadSlangMap(dis);
      HashMap<String, HashSet<SlangEntry>> keywordMap = loadKeywordMap(dis);
      ArrayList<SlangEntry> slangWord = loadSlangWord(dis);

      controller.accessGlossary().setAll(slangMap, keywordMap, slangWord);
    }
    catch (IOException e) {
      e.printStackTrace();
    }    
  }

  public void fastStartup(Controller controller) {
    loadData(controller, this.fastStartupFilePath);
  }

  public void loadWorkedData(Controller controller) {
    loadData(controller, this.workedDataFilePath);
  }

  // Export data 
  private void saveSlangEntry(DataOutputStream dos, SlangEntry entry) {
    try {
      if (entry instanceof SlangWord) {
        //SlangWord word = (SlangWord)entry;
        dos.writeUTF(entry.getWord());
        ArrayList<String> defList = entry.getDefinitions();
        dos.writeInt(defList.size());
        for (String def : defList) {
          dos.writeUTF(def);
        }
      }
      else {
        System.out.println("Error: Cannot process SlangEntry as it is not a SlangWord.");
      }
    }
    catch (IOException e) {
      e.printStackTrace();
    }
  }

  private void saveSlangMap(DataOutputStream dos, HashMap<String, SlangEntry> slangMap) {
    try {
      int size = slangMap.size();
      dos.writeInt(size);
      for (String key : slangMap.keySet()) {
        dos.writeUTF(key);
        SlangEntry entry = slangMap.get(key);
        saveSlangEntry(dos, entry);
      }
    }
    catch (IOException e) {
      e.printStackTrace();
    }
  }

  private void saveKeywordMap(DataOutputStream dos, HashMap<String, HashSet<SlangEntry>> keywordMap) {
    try {
      int size = keywordMap.size();
      dos.writeInt(size);
      for (String key : keywordMap.keySet()) {
        dos.writeUTF(key);
        HashSet<SlangEntry> slangSet = keywordMap.get(key);        
        dos.writeInt(slangSet.size());

        for (SlangEntry entry : slangSet) {
          saveSlangEntry(dos, entry);
        }
      }
    }
    catch (IOException e) {
      e.printStackTrace();
    }
  }

  private void saveSlangWord(DataOutputStream dos, ArrayList<SlangEntry> slangWord) {
    try {
      int size = slangWord.size();
      dos.writeInt(size);
      for (SlangEntry entry : slangWord) {
        saveSlangEntry(dos, entry);
      }
    }
    catch (IOException e) {
      e.printStackTrace();
    }
  }

  private void saveGlossary(Controller controller, String filePath) {
    try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(filePath))) {
      saveSlangMap(dos, controller.getGlossary().getSlangMapCopy());
      saveKeywordMap(dos, controller.getGlossary().getKeywordMapCopy());
      saveSlangWord(dos, controller.getGlossary().getSlangWordCopy());
    }
    catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void saveToStartupFile(Controller controller) {
    saveGlossary(controller, this.fastStartupFilePath);
  }

  public void saveWorkedData(Controller controller) {
    saveGlossary(controller, this.workedDataFilePath);
  }

  
}
