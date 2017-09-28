
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class List {

  public ArrayList<String> TodoList = new ArrayList<>();


  public List() {


    try (BufferedReader br = new BufferedReader(new FileReader("MyText.txt")))
    {

      String sCurrentLine;

      while ((sCurrentLine = br.readLine()) != null) {
        TodoList.add(sCurrentLine);
      }

    } catch (IOException e) {
      e.printStackTrace();
    }


  }

  public void getList() {

    String content;

    try {
      content = new String(Files.readAllBytes(Paths.get("MyText.txt")));
      System.out.println(content);
    } catch (IOException e) {
      e.printStackTrace();
    }

    //    try {
//      Scanner in = new Scanner(new FileReader("MyText.txt"));
//      System.out.println(new FileReader("MyText.txt"));
//    } catch (FileNotFoundException e) {
//      e.printStackTrace();
//    }


  }


}
