import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner;
import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;

public class TheReplacer{

  static void modifyFile(String filePath, String oldString, String newString)
      {
          File file_to_be_modified = new File(filePath);

          String oldContent = "";

          BufferedReader reader = null;

          FileWriter writer = null;

          try
          {
              reader = new BufferedReader(new FileReader(file_to_be_modified));

              String line = reader.readLine();

              while (line != null)
              {
                  oldContent = oldContent + line + System.lineSeparator();

                  line = reader.readLine();
              }

              String newContent = oldContent.replaceAll(oldString, newString);

              writer = new FileWriter(file_to_be_modified);

              writer.write(newContent);
          }
          catch (IOException e)
          {
              e.printStackTrace();
          }
          finally
          {
              try
              {
                  reader.close();

                  writer.close();
              }
              catch (IOException e)
              {
                  e.printStackTrace();
              }
          }
      }


      static void getAvailableFilesList(String dir_path){

        String[] file_list;


        File f = new File(dir_path);


        file_list = f.list();


        for (String file_name : file_list){
          //    modifyFile("/home/unknown/Downloads/javaclassfiles/TestFolder/" + file_name , "yolo", "class");
              modifyFile("C:\\Users\\AN40039580\\Documents\\TestFolder" + file_name , "operating", "Active");
              modifyFile("C:\\Users\\AN40039580\\Documents\\TestFolder" + file_name , "Operating", "Active");
              modifyFile("C:\\Users\\AN40039580\\Documents\\TestFolder" + file_name , "OPERATING", "Active");
            }

      }


      public static void main(String[] args)
      {

          //getAvailableFilesList("/home/unknown/Downloads/javaclassfiles/TestFolder");
          getAvailableFilesList("C:\\Users\\AN40039580\\Documents\\TestFolder");
          System.out.println("\ndone!");

      }


}
