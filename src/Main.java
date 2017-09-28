import static java.awt.image.ImageObserver.HEIGHT;
import static java.awt.image.ImageObserver.WIDTH;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

import Arguments.AddsANewTask;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.*;

import java.awt.*;

public class Main {
  static int WIDTH = 320;
  static int HEIGHT = 343;


  public Main() {

  }


  public static void main(String[] args) {
    System.out.println("\nCommand Line Todo application\n=============================");
    System.out
        .println("Command line arguments:\n-l   Lists all the tasks\n-a   Adds a new task\n-r   "
            + "Removes a task"
            + "\n-c   Completes a task");

    List showlist = new List();
    System.out.println("Please enter a command: ");
    Scanner myScanner = new Scanner(System.in);
    if (myScanner.next().equals("-l")) {

      showlist.getList();
    }
    AddsANewTask AddTask = new AddsANewTask();
    Scanner AddScan = new Scanner(System.in);
    if (AddScan.next().equals("-a")) {
      AddTask.Add();
    }

    JFrame jFrame = new JFrame("Main");
    jFrame.setSize(new Dimension(WIDTH, HEIGHT));
    jFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    jFrame.add(new ImagePanel());
    jFrame.setLocationRelativeTo(null);
    jFrame.setVisible(true);

    JTextArea jTextArea = new JTextArea();
    jTextArea.append( "Hello World." );

    jFrame.add( jTextArea );


  }

  static class ImagePanel extends JPanel {

    @Override
    protected void paintComponent(Graphics graphics) {
      super.paintComponent(graphics);
      mainDraw(graphics);

    }
    public static void mainDraw(Graphics graphics){
      graphics.setColor(Color.blue);
      graphics.drawRect(0,0,WIDTH,HEIGHT);

    }

  }
}