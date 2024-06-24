import java.io.*;

public class Main {

    public static void main(String[] args) {

  /*   File file = new File("file");
        String string = new String("Ola");
        String string2 = new String("Mundo");
        System.out.println(string.concat(file.separator).concat(string2));


        // EXERCISE 1
        String directory = askUserFor("Enter Directory you want to print to txtWithAllFiles.txt");
        File file = new File(directory);

        String[] filesOnDisk = file.list();

        writeToFile("files.txt", filesOnDisk);

        // EXERCISE 2

        String checkDir = askUserFor("Write a directory to check : ");
        String checkFileName = askUserFor("Write the file name to check : ");
        String fullCheckPath = checkDir.concat(File.separator).concat(checkFileName);
        File checkFile = new File(fullCheckPath);
        if (checkFile.exists()) {
            println("The file exists");
            //  System.out.println(fullCheckPath);
        } else {
            println("File doesnt exist");
        }
*/
        //Exercise 3

        String createDir = askUserFor("Write a directory to create new file : ");
        String createFileName = askUserFor("Write the new file name  : ");
        String fullCreatePath = createDir.concat(File.separator).concat(createFileName);
        File createFile = new File(fullCreatePath);

        try {

            if (createFile.createNewFile()) {
                println("New file was created " + createFile.getAbsolutePath());
                //  System.out.println(fullCheckPath);
            }
        } catch (IOException e) {
            println("Error on creating file" + e.getMessage());
        }


        /**

         // Enter data using BufferReader
         BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
         // Reading data using readLine
         println("Enter your phrase: ");
         String read = "";
         while (!(read = reader.readLine()).equals("exit")) {
         println(read);
         }*/


    }

    private static void writeToFile(String file, String[] filesOnDisk) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            for (String s : filesOnDisk) {
                writer.write(s);
                writer.newLine();
            }
            writer.flush();
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String askUserFor(String question) {
        println(question);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void println(String message) {
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        try {
            writer.write(message);
            writer.newLine();
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}