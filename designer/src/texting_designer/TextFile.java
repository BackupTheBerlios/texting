package texting_designer;

/**
 * <p>Title: TeXting Designer</p>
 *
 * <p>Description: IDE pro TeXting</p>
 *
 * <p>Copyright: Copyright (c) 2005</p>
 *
 * <p>Company: </p>
 *
 * @author Sef
 * @version 0.1
 */

import java.io.*;
import java.util.*;

public class TextFile extends ArrayList {
  // Tools to read and write files as single strings:
  public static String
  read(String fileName) throws IOException {
    StringBuffer sb = new StringBuffer();
    BufferedReader in =
      new BufferedReader(new FileReader(fileName));
    String s;
    while((s = in.readLine()) != null) {
      sb.append(s);
      sb.append("\n");
    }
    in.close();
    return sb.toString();
  }
  public static void
  write(String fileName, String text) throws IOException {
    PrintWriter out = new PrintWriter(
      new BufferedWriter(new FileWriter(fileName)));
    out.print(text);
    out.close();
  }
  public TextFile(String fileName) throws IOException {
    super(Arrays.asList(read(fileName).split("\n")));
  }
  public void write(String fileName) throws IOException {
    PrintWriter out = new PrintWriter(
      new BufferedWriter(new FileWriter(fileName)));
    for(int i = 0; i < size(); i++)
      out.println(get(i));
    out.close();
  }
  // Simple test:
 /* public static void main(String[] args) throws Exception {
    String file = read("TextFile.java");
    write("test.txt", file);
    TextFile text = new TextFile("test.txt");
    text.write("test2.txt");
  }*/
}
