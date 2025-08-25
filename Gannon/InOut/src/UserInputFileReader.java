import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.io.File;
import java.io.InputStreamReader;
 
public class UserInputFileReader{
    public static void main(String [] args){
        String filePath = "user_input.txt";
        
        getUserInputAndWriteToFile(filePath);
        createFileIfNotExists(filePath);
        int lineCount = countLines(filePath);
        if(lineCount >=0){
            System.out.println("Number of lines in the file: " + lineCount);
        }else{
            System.out.println("File not found or unable to read the file.");
        }
        
    }
    public static void getUserInputAndWriteToFile(String filePath){
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            FileWriter writer = new FileWriter(filePath)){
                System.out.println("Enter text and press Enter to change line");
                System.out.println("(Press Enter with no text to finish):");
                String line;
                while((line = br.readLine()) != null && !line.isEmpty()){
                    writer.write(line + System.lineSeparator());
                }
                System.out.println("Text has been saved to the file: " + filePath);
            }catch(IOException e){
                System.out.println("An error occureed while writing to the file");
                e.printStackTrace();
            }
    }
    public static void createFileIfNotExists(String filePath){
        File file = new File(filePath);
        if(!file.exists()){
            try{
                file.createNewFile();
                System.out.println("File created: " + filePath);
                
            }catch(IOException e){
                System.out.println("Unable to create the file: " + filePath);
                e.printStackTrace();
            }
        }
    }
    public static int countLines(String filePath){
        int count = 0;
        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))){
            while(reader.readLine() != null){
                count++;
            }
        }catch(IOException e){
            e.printStackTrace();
            return -1;
        }
        return count;
    }
}

