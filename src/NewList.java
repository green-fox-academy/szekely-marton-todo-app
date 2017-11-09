import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class NewList {

  public static void main(String[] args) {

    if (args.length == 0) {
      printUsage();
    } else if (args[0].equals("-y")) {
      listTasks();
    } else if (args[0].equals("-a") && args.length == 2) {
      addTask(args[1]);
    } else if (args[0].equals("-a") && args.length == 1) {
      System.out.println("Unable to add: no task provided");
    } else if (args[0].equals("-r") && args.length == 2) {
      removeTask(Integer.parseInt(args[1]));
    } else if (args[0].equals("-r") && args.length == 1) {
      System.out.println("Unable to remove: no index provided");
    } else if (args[0].equals("-c") && (args.length > 1)) {
      checkTask(Integer.parseInt(args[1]));
    } else {
      System.out.println("");
    }
  }

  private static void listTasks() {
    Path path = Paths.get("/Users/Ezzo/Desktop/greenfox/szekely-marton-todo-app/MyText.txt");
    try {
      List<String> data = Files.readAllLines(path);
      if (data.size() == 0) {
        System.out.println("No todos for today! :)");
      } else {
        for (int i = 0; i < data.size(); i++) {
          System.out.println(i + 1 + " - " + data.get(i));
        }
      }
    } catch (IOException ex) {
      ex.printStackTrace();
      System.out.println("Error");
    }
  }

  public static void removeTask(int taskToRemove) {
    Path path = Paths.get("/Users/Ezzo/Desktop/greenfox/szekely-marton-todo-app/MyText.txt");
    try {
      List<String> data = Files.readAllLines(path);
      if (data.size() > 2) {
        data.remove(taskToRemove - 1);
      }
      Files.write(path, data);
    } catch (IOException ex) {
      ex.printStackTrace();
      System.out.println("Error");
    }
  }

  public static void checkTask(int taskToCheck) {
    Path path = Paths.get("/Users/Ezzo/Desktop/greenfox/szekely-marton-todo-app/MyText.txt");
    try {
      List<String> data = Files.readAllLines(path);
      String newString = data.get(taskToCheck - 1);
      newString = "[X]" + newString;
      data.set(taskToCheck - 1, newString);
      Files.write(path, data);
    } catch (IOException ex) {
      ex.printStackTrace();
      System.out.println("Error");
    }
  }

  public static void addTask(String newTask) {
    Path path = Paths.get("/Users/Ezzo/Desktop/greenfox/szekely-marton-todo-app/MyText.txt");
    try {
      List<String> data = Files.readAllLines(path);
      String task = newTask;
      data.add(newTask);
      Files.write(path, data);
    } catch (IOException ex) {

    }

  }

  public static void printUsage() {
    Path path = Paths.get("/Users/Ezzo/Desktop/greenfox/szekely-marton-todo-app/MyList.txt");
    try {
      List<String> usageInfos = Files.readAllLines(path);
      for (int i = 0; i < usageInfos.size(); i++) {
        System.out.println(usageInfos.get(i));
      }
    } catch (IOException ex) {
      ex.printStackTrace();
      System.out.println("Error");
    }
  }
}




