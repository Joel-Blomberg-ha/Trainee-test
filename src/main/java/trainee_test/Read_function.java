package trainee_test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Read_function {


    /*read in the info from the text file*/

   /* public static void main(String[] args) throws Exception
    {

        // File path is passed as parameter
        File file = new File("C:\\crosskey_trainee_test\\src\\main\\resources\\prospects.txt");

        // Note:  Double backquote is to avoid compiler
        // interpret words
        // like \test as \t (ie. as a escape sequence)

        // Creating an object of BufferedReader class
        BufferedReader br
                = new BufferedReader(new FileReader(file));

        // Declaring a string variable
        String st;
        String[] Customers = {};
        // Condition holds true till
        // there is character in a string
        while ((st = br.readLine()) != null)

            // Print the string
            System.out.println(st);
    } */

    // Import the File class


    public static void main(String[] args) {
        File myObj = new File("C:\\crosskey_trainee_test\\src\\main\\resources\\prospects.txt");
        //List<Customer> list = (List<Customer>) new Customer();
        if (myObj.exists()) {
            System.out.println("File name: " + myObj.getName());
            System.out.println("Absolute path: " + myObj.getAbsolutePath());
            System.out.println("Writeable: " + myObj.canWrite());
            System.out.println("Readable " + myObj.canRead());
            System.out.println("File size in bytes " + myObj.length());
            try {
                read(myObj);
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        } else {
            System.out.println("The file does not exist.");
        }
    }

    public static void read(File myObj) throws IOException {
        /*try {
            List<Integer> integers = new ArrayList<>();
            Scanner myReader = new Scanner(myObj);
            int i = 0;
            while (myReader.hasNext()) {
                String data = myReader.nextLine();
                //String data = myReader.nextLine();
                //String[] word = data.split(",");

                System.out.println(data);
                if (myReader.hasNextInt()) {
                    integers.add(myReader.nextInt());
                }

                if(i>=1) {
                    /*Customer temp_customer = new Customer();
                    temp_customer.Name = word[0]; //change later
                    temp_customer.Total = Integer.parseInt(word[1]); //change later
                    temp_customer.Interest = Integer.parseInt(word[2]); //change later
                    temp_customer.Years = Integer.parseInt(word[3]); //change later
                    //list.add(temp_customer);
                    System.out.println(temp_customer);
                }
                System.out.println(integers);
                i++;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }*/

        String nextLine;
        List<Customer> customerList = new ArrayList<>();

        BufferedReader inFile = null;
        try {
            inFile = new BufferedReader(new FileReader(myObj));
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        String[] info;
        int i = 0;
        while((nextLine = inFile.readLine()) != null)
        {
            Customer temp_customer = new Customer();
            info = nextLine.split(",");//; would be the delimiter
            if(i>=1) {
                temp_customer.Name = info[0];
                temp_customer.Total = Integer.parseInt(info[1]);
                temp_customer.Interest = Integer.parseInt(info[2]);
                temp_customer.Years = Integer.parseInt(info[3]);
                System.out.println(temp_customer.Name);
                System.out.println(temp_customer.Total);
                System.out.println(temp_customer.Interest);
                System.out.println(temp_customer.Years);
                customerList.add(temp_customer);
            }
        }
        System.out.println(customerList);
        inFile.close();
    }
}



