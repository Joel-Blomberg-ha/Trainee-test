package trainee_test;

import java.io.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

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


    public void first_read() {
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

    public void calc(List<Customer> customerList){
        for (int i = 0; i < customerList.size();i++)
        {
           /* System.out.println(customerList.get(i).getName());
            System.out.println(customerList.get(i).getTotal());
            System.out.println(customerList.get(i).getInterest());
            System.out.println(customerList.get(i).getYears());
            */

            System.out.println(
                    "Prospect"+ (i+1) + ": " + customerList.get(i).getName() + " wants to borrow " + customerList.get(i).getTotal() +
                            " for a period of " + customerList.get(i).getYears() + " years and pay " + customerList.get(i).getInterest() + " each month "
            );
            double calc_return = 0;
            Calc_function calc_function = new Calc_function();
            calc_return = calc_function.Mortage_calc(calc_return,customerList.get(i).getInterest(),customerList.get(i).getTotal(),customerList.get(i).getInterest());
            System.out.println("Mortage: " + calc_return);

        }
    }

    public void read(File myObj) throws IOException {

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
            info = nextLine.split(",");
            if(i>=1 && info.length < 5) {
                /* because of the inconsistency of the txt info ive had to change the way we read in information to be more specific to the text file
                * even though I would much rather have it not matter but the structure of the first and last lines demand it
                * */
                temp_customer.setName(info[0]);
                temp_customer.setTotal((int) Double.parseDouble(info[1]));
                temp_customer.setInterest((int) Double.parseDouble(info[2]));
                temp_customer.setYears((int) Double.parseDouble(info[3]));
                customerList.add(temp_customer);
            }
            else if( info.length >= 5)
            { // it is an ugly solution but I noticed it to late and couldn't find another one in time
                temp_customer.setName(info[0] + " " + info[1]);
                temp_customer.setTotal((int) Double.parseDouble(info[2]));
                temp_customer.setInterest((int) Double.parseDouble(info[3]));
                temp_customer.setYears((int) Double.parseDouble(info[4]));
                customerList.add(temp_customer);
            }
            i++;
        }
        calc(customerList);
        inFile.close();
    }
}



