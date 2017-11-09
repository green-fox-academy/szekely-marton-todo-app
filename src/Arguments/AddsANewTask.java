package Arguments;

import java.awt.List;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class AddsANewTask extends List {

  public ArrayList<String> TodoListAdd = new ArrayList<>();

  public AddsANewTask() {

  }

  public void Add() {

    System.out.println("Enter the item you would like to add");
    Scanner UserText = new Scanner(System.in);
    String ListElement = UserText.next();

    try {
      String filename = "/Users/Ezzo/Desktop/greenfox/szekely-marton-todo-app/MyText.txt";
      FileWriter fw = new FileWriter(filename, true);
      fw.write("\n" + ListElement);
      fw.close();

    } catch (IOException e) {
      e.printStackTrace();
    }
//    while (UserText.hasNext()) {
//      String i = UserText.next();
//      TodoListAdd.add(i);
//      break;
//    }

  }


}
