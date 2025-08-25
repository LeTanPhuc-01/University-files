import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
//import the File and PrintWriter classes to create the input file and write to it
import java.io.File;
import java.io.PrintWriter;
public class TextFileCopy{
    public static void main(String[] args){
//set the input and output file paths       
        String inputPath = "inputMex.txt";
        String outputPath = "outputMex.txt";
//Create a File object for the input file
        File inputFile = new File(inputPath);
//check if the input file exists, if not create it. 
        if(!inputFile.exists()){
            try{
//create the input file and print a message to the console
                if(inputFile.createNewFile()){
                    System.out.println("Input file was created successfully");
//create a PrintWriter object to write to the input file
                    try(PrintWriter writer = new PrintWriter(new FileWriter(inputFile))){
//using the PrintWriter object(writer) to write to the input file. If an error occurs, print a message to the console. 
                        writer.println("This is a sample line of text.");
                        writer.println("This is another sample line of text.");
                        
                    }catch(IOException e){
                        System.out.println("Failed to write to the newly created input file.");
                        e.printStackTrace();
                    }
                }else{
                    System.out.println("Failed to create the input file.");
                    return;
                }
                }catch(IOException e){
                    System.out.println("An error occureed while trying to create the input file.");
                    e.printStackTrace();
                    return;
                }
            }
//create objects from the BufferedReader and BufferedWriter classes to read from the input file and write to the output file. Catch any exceptions that may occur during file processing and print a message to the console.
        try(BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath))){
//initialize a string variable to store the text read from the input file
                String line;
//while loop to read the text from the input file and write it to the output file
                while((line = reader.readLine()) != null){
//write the text read from the input file to the output file
                    writer.write(line);
//add a new line to the output file after copying each line from the input file
                    writer.newLine();
                }
                System.out.println("File has been successfully copied");
                
        }catch(IOException e){
                System.out.println("An error occurred during file processing");
                e.printStackTrace();
                
        }
    }
}
