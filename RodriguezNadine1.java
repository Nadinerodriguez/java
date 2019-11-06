import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class RodriguezNadine1 {
  public static void main(String[] args) throws FileNotFoundException {
    String targetString = args[0];
    String textName = args[1];
    File f = new File(textName);
   
    if(!f.exists()) { /* If file doesn't exist */
      System.out.println("File cannot be found!");
      System.exit(0); /* Program will terminate here if file isn't found */
    }
   
    Scanner search = new Scanner(f); /* This scanner object looks for the target string in the file */
    int fileLine = 0;/* Initialized at 0 and starts at 1 when it enters the while loop (fileLine++)*/
    boolean matchFound = false;  /* Initialized as false and becomes true when it enters the while loop */
    int matchNum = 0; /* Number of occurences that the target string is found */
    
    while(search.hasNextLine()) {
      fileLine++;
      String currLine = search.nextLine(); /* Returns the text at the current line */
      if(currLine.contains(targetString)){
        matchFound = true;
        matchNum++; /* Count for the number of occurences that the target string is found */
        int index = currLine.indexOf(targetString);
        System.out.println(fileLine + ":" + index + " " + currLine); /* Prints the line number, the index of the target string and the whole line */

        /* If more text is found on the same line */
        String[] temp = currLine.split(targetString,2); /* This split method will split the current line into 2 substrings */
        String moreFound = temp[1];

        while(moreFound.contains(targetString)){
          matchNum++; /* Count for the number of occurences that the target string is found */
          index = index + targetString.length() + moreFound.indexOf(targetString);
          System.out.println(fileLine + ":" + index + " " + currLine);

          String[] temp2 = moreFound.split(targetString,2);
          moreFound = temp2[1];
        }
      }
    }
    
    search.close();
    if(matchFound){
      System.out.println("There are " + matchNum + " number of occurrences in this file");
    }
    else{
      System.out.println("There are no matches!");
    }
  }
}
