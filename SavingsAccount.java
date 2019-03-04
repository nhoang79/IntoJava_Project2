import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * #14 Creating a FileDisplay class that includes:
 *        1. A contructor that take the name of a file as an argument.
 *        
 *        2. A displayHead method that only display the first five lines
 *           of file's contents. (If there is less than five lines of content,
 *           the method should display the entire contents.
 *  
 *        3. A displayContents method that display the entire contents of the
 *           file, the name of which was passed to the contructor.
 *        
 *        4. A displayWithLineNumbers method that display file's contents,
 *           the name of which was passed to the constructor. 
 *           (Each line should has a number and a colin in front & the line
 *           numbering should starts with 1)
 */

/**
 * @author Ngan
 */
public class FileDisplay {
    
    //Data fields
    private String fileName;
    int number = 1; //to do numbering in displayWithLineNumbers method
    
    //Creating a constructor
    public FileDisplay (String name)
    {
       fileName = name; 
    }
    
    
    //displayHead method to display first five lines of content from the file.
    public void displayHead () throws FileNotFoundException
    {
        //Open fileName
        File theFile = new File(fileName);
        Scanner fileLine = new Scanner(theFile);
        
        //Loop to display first 5 lines of contents from theFile
        for (int number = 1; number <= 5; number++)
        {
            //Storing information read into contents
            String line = fileLine.nextLine();
            
            //display content read into output window
            System.out.println(line);
        }
        //Close file
        fileLine.close();
    }
    
    /**displayContents method to display entire contents of the file,
     *  the name of which was passed to the constructor 
     */
    public void displayContents() throws FileNotFoundException
    {
        //Open fileName
        File theFile = new File(fileName);
        Scanner fileContents = new Scanner(theFile);
        
        //Loop to read entire contents
        while (fileContents.hasNext())
        {
            String content = fileContents.nextLine();
            System.out.println(content);
        }
        
        //Close file
        fileContents.close();
    }
    
    //method to display content in order
    public void displayWithLineNumbers() throws FileNotFoundException
    {
        //Open fileName
        File lineNumbersContent = new File(fileName);
        Scanner contentWithNumbers = new Scanner(lineNumbersContent);
        
        while(contentWithNumbers.hasNext())
        {
            String moreContent = contentWithNumbers.nextLine();
            System.out.println(number + ": " + moreContent);
            number++; 
        }
        
        //Close file
        contentWithNumbers.close();
    }   
}
