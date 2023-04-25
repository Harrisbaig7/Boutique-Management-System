package BCS060;

import java.util.Scanner;
import java.util.Date;
import java.util.InputMismatchException;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileNotFoundException;

/*****
 Project Name:
 "BOUTIQUE MANAGEMENT SYSTEM"
 (Group No. 10)
 Group Members;
 Harris Baig           (FA20-BCS-052)
 Hassan Munawar        (FA20-BCS-056)
 Muhammad Maarij       (FA20-BCS-060)
 Sameet Fatima         (FA20-BCS-086)
 Shaheera Fatima       (FA20-BCS-087)
 *****/

public class boutiqueManagement {
    public static void menuStock() {
        /*
            This Method Control AND DISPLAY The Overall Production Of our Stock
         */
        Scanner input = new Scanner(System.in);
        int option = 0;
        boolean bool = true;

        // this loop check The input value and control exception
        while (bool) {
            try {
                option = input.nextInt();
                bool = false;
            }
            catch (InputMismatchException ex) {
                // If Input Is Not in Integer Again Ask The ADMIN to Select The Option
                input.nextLine();
                System.out.println("Try Again: Input Should Not Be String");
                System.out.println("\nEnter your choice again: ");
            }
        }

        /*
            This Switch Statement Execute When Admin Want TO CHANGE Something In The Stock
         */
        switch (option) {
            case 1:
                // Press 1 To View Stock
                System.out.println();
                System.out.println("\t\t\tVIEW DRESS STOCK   ");
                System.out.println("________________________________________________________________________________________________________________________");
                viewdress(dressInformation);
                System.out.println();
                // Again Ask the Admin To change Something
                System.out.println("\nEnter your Choice Again: ");
                menuStock();
                break;

            case 2:
                // Press 2 To Add Stock
                System.out.println();
                System.out.println("\t\t\tADD DRESS  ");
                System.out.println("________________________________________________________________________________________________________________________");
                System.out.println("Enter the following details of the dress to be added: ");
                addDress(dressInformation);
                System.out.println();
                // Again Ask the Admin To change Something
                System.out.println("\nEnter your choice Again: ");
                menuStock();
                break;

            case 3:
                // Press 3 To Delete Stock
                System.out.println();
                System.out.println("\t\t\tDELETE DRESS        ");
                System.out.println("________________________________________________________________________________________________________________________");
                System.out.println("Enter the ID of the dress to be deleted: ");
                deleteDress(dressInformation);
                System.out.println();
                // Again Ask the Admin To change Something
                System.out.println("\nEnter your choice Again: ");
                menuStock();
                break;

            case 4:
                // Press 4 To Search Stock
                System.out.println();
                System.out.println("\t\t\tSEARCH DRESS");
                System.out.println("________________________________________________________________________________________________________________________");
                System.out.println("Enter the ID of the dress to be searched: ");
                searchDress(dressInformation);
                System.out.println();
                // Again Ask the Admin To change Something
                System.out.print("\nEnter your choice Again: ");
                menuStock();
                break;

            case 5:
                System.out.println("Exit");
                break;

            default:
                // Press Any other Key To exit
                System.out.println("Enter an integer between 1 and 5:");
                menuStock();

        }
    }

    /*
        Dresses Information String is Default It may Change or Modify By the Admin Excess Only
     */
    public static String[][] dressInformation = {
            {"12345", "Dress 1", "Bridal", "12000", "10", "Blue"},
            {"23456", "Dress 2", "Bridal", "10000", "10", "Green"},
            {"34567", "Dress 3", "Party Wear", "5000", "10", "Red"},
            {"45678", "Dress 4", "Party Wear", "6000", "10", "Yellow"},
            {"56789", "Dress 5", "Casual", "3000", "10", "Orange"},
            {"13579", "Dress 6", "Casual", "2000", "10", "Black"},
            {"11111", "Dress 7", "Pret", "1500", "10", "Red"},
            {"22222", "Dress 8", "Pret", "1600", "10", "Green"},
            {"33333", "Dress 9", "Pret", "2300", "10", "Yellow"},
            {"44444", "Dress 10", "Unstitched", "2700", "10", "Plum"},
            {"55555", "Dress 11", "Unstitched", "3300", "10", "Skin"},
            {"66666", "Dress 12", "Unstitched", "3700", "10", "White"},
            {"77777", "Dress 13", "Formal", "4500", "10", "Black"},
            {"88888", "Dress 14", "Formal", "4200", "10", "Grey"},
            {"0", "0", "0", "0", "0", "0"},
            {"0", "0", "0", "0", "0", "0"},
            {"0", "0", "0", "0", "0", "0"},
            {"0", "0", "0", "0", "0", "0"},
            {"0", "0", "0", "0", "0", "0"},
            {"0", "0", "0", "0", "0", "0"}
    };

    public static void viewdress(String[][] dressInformation) {
        // create A String File Path Variable
        String filePath = "DRESS.txt";
        // Default Writer in Null
        PrintWriter writer = null;

        try {
            // Write the Overall Code In the Given File Path
            writer = new PrintWriter(filePath);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        /*
            THis Method Execute To View Data on The Terminal
         */
        System.out.print("""
                 \s
                \t\t    Dress ID \t\tDress Name \t\t\t Dress Type\t\t\tDress Price (in Rs.)\tQuantity.\t\t    Colour

                """);
        /*
            Print Data In the File To VIEW ADD AND REMOVE DATA In the Following Way
         */
        assert writer != null;
        writer.printf("""
                 \s
                \t     Dress ID \t\t    Dress Name \t\t    Dress Type\t\t Dress Price (in Rs.)\t\tQuantity.\t\tColour

                """);
        writer.println();

        int srNo = 1;

        for (int i = 0; i < dressInformation.length; i++) {
            if (dressInformation[i][0].equals("0")) {
                continue;
            }
            // For Terminal
            System.out.printf("%-4s", srNo + ".");
            // For File
            writer.printf("%-4s", srNo + ".");
            for (int j = 0; j < dressInformation[i].length; j++) {
                // For Terminal
                System.out.printf("%16s", dressInformation[i][j] + "\t\t");
                // For File
                writer.printf("%16s", dressInformation[i][j] + "\t\t");
            }
            // For Terminal
            System.out.println();
            // For File
            writer.println();
            srNo++;

        }
        // Display on Terminal After Execution
        System.out.print("________________________________________________________________________________________________________________________");
        writer.print("_______________________________________________________________________________________________________________________________________________");
        // After Written data File Writer Closes AND store DATA
        writer.close();
    }

    public static void addDress(String[][] dressInformation) {
    /*
        This Method Execute To ADD DATA on the Terminal And in The File
     */

        Scanner input = new Scanner(System.in);
        for (int i = 0; i < dressInformation.length; i++){
            if (dressInformation[i][0].equals("0")) {

                dressInformation[i][0] = String.valueOf(Math.round(Math.random() * 100000));

                System.out.println("Enter Dress Name :");
                dressInformation[i][1] = input.next();

                System.out.println("Enter Dress type:");
                dressInformation[i][2] = input.next();
                boolean b1 = true;
                while(b1){
                    try{
                        System.out.println("Enter Dress Price(in Rs.):");
                        dressInformation[i][3] = String.valueOf(input.nextInt());
                        b1 = false;
                    }
                    catch (InputMismatchException ex){
                        System.out.println("INPUT MUST BE INTEGER, TRY AGAIN");
                        input.nextLine();
                    }
                }

                boolean b2 = true;
                while(b2){
                    try{
                        System.out.println("Enter Quantity :");
                        dressInformation[i][4] = String.valueOf(input.nextInt());
                        b2 = false;
                    }
                    catch (InputMismatchException ex){
                        System.out.println("INPUT MUST BE INTEGER, TRY AGAIN");
                        input.nextLine();
                    }
                }


                System.out.println("Enter Colour :");
                dressInformation[i][5] = input.next();

                System.out.println("Dress added successfully. ");
                break;

            }
        }
    }

    public static void deleteDress(String[][] dressInformation) {
        /*
            This Method Execute When Admin wants to Delete on terminal
         */
        Scanner input = new Scanner(System.in);
        boolean b = true;
        while(b){
            try{
                String ID = String.valueOf(input.nextInt());
                int k = 0;
                while (k < dressInformation.length) {
                    if (ID.equals(dressInformation[k][0])) {
                        System.out.println("Dress Deleted Successfully");

                        dressInformation[k][0] = "0";
                        dressInformation[k][1] = "0";
                        dressInformation[k][2] = "0";
                        dressInformation[k][3] = "0";
                        dressInformation[k][4] = "0";
                        dressInformation[k][5] = "0";
                    }
                    k++;
                }
                b = false;
            }
            catch (InputMismatchException ex){
                System.out.println("INPUT MUST BE INTEGER");
                input.nextLine();
            }
        }
    }

    public static void searchDress(String[][] dressInformation) {
        /*
            This Method execute To Search Dress in Terminal
         */
        Scanner input = new Scanner(System.in);
        boolean bool = true;
        while(bool){
            try{
                String ID = String.valueOf(input.nextInt());
                int i = 0;
                while (i < dressInformation.length) {
                    if (ID.equals(dressInformation[i][0])) {
                        System.out.print("""
                 \s
                \t\t    Dress ID \t\tDress Name \t\t\t Dress Type\t\t\tDress Price (in Rs.)\t\tQuantity.\t\t    Colour

                """);
                        System.out.printf("\t\t\t %s \t\t\t%s \t\t\t %s \t\t\t\t%s \t\t\t\t\t %s \t\t\t\t%s",dressInformation[i][0],dressInformation[i][1],
                                dressInformation[i][2],dressInformation[i][3],dressInformation[i][4],dressInformation[i][5]);
                    }
                    i++;
                }
                bool = false;
            }
            catch (InputMismatchException ex){
                System.out.println("INPUT MUST BE INTEGER");
                input.nextLine();
            }
        }
    }

    public static void Customerlogin() throws FileNotFoundException {
        /*
            This Method Execute When Customer Want to login And Create ACount
         */

        // THis file is Created to Store All Data In a Text file Entered bY the User
        File file = new File("CustomerLogin.txt");
        // printwriter display result in the file you create
        PrintWriter out = new PrintWriter(file);
        // it Execute the Current Time
        long millis = System.currentTimeMillis();
        // It execute the current Date
        Date date = new Date(millis);

        /*
            This Code Execute and Display Customer login In FIle
         */
        out.println("\t---->C U S T O M E R  L O G I N<----\r\n");

        /*
            Ask the User to create Your Account SignUp
         */
        System.out.println("Create Your Account For Access");
        Scanner User = new Scanner(System.in);
        // Enter Your Name
        System.out.println("Enter Your Name: ");
        String name1 = User.next();
        // Enter Your Password
        System.out.println("Create Your Password: ");
        String pass1 = User.next();

        // Display All in File
        out.println("Your Name is: " + name1);
        out.println("Your Password is: " + pass1);
        out.println("Account Created at: " +date);
        // Display In File
        out.println("\nNow You Can Login Your Account\n");

        // Display on Terminal
        System.out.println("\nNow You Can Login Your Account\n");
        // Enter Your Name
        System.out.println("Enter Your Name:");
        String name = User.next();
        // Enter Your Password
        System.out.println("Enter Your Password: ");
        String pass = User.next();

        /*
            This loop check the The name created By the user is equal to login name
            if not Then loop again ask the user to enter your name
         */
        while(!name.equals(name1)){
            // For Wrong Input
            System.out.println("Invalid UserName Please Try again");
            // Enter your name
            System.out.println("Enter Your Name:");
            name = User.next();
        }

         /*
            This loop check the The Password created By the user is equal to login Password
            if not Then loop again ask the user to enter your password
         */
        while(!pass.equals(pass1)){
            // For wrong Input
            System.out.println("Invalid Password Please Try again");
            // Enter Your password
            System.out.println("Enter Your Password:");
            pass = User.next();
        }
        // this line execute when You Entered correct inputs
        System.out.println("Access Granted!");
        out.println("\r\n_______________________________________________________________________________________________________\r\n");
        out.close();
    }

    public static void SaleProduct() throws FileNotFoundException {
        // THis file is Created to Store All Data In a Text file Entered bY the User
        File file = new File("CustomerBuy.txt");
        // printwriter display result in the file you create
        PrintWriter out = new PrintWriter(file);
        out.println("\t-----> C U S T O M E R  B U Y I N G  D E T A I L S <-----\r\n");
        long millis = System.currentTimeMillis();
        // It execute the current Date
        Date date = new Date(millis);
        System.out.println("Do you Like to Buy Our Products! Yes/No");
        // Enters Yes or No only
        Scanner input = new Scanner(System.in);
        String Customer = input.next();

        /*
            This loop execute when user entered another input except Yes/yes or No/no
         */
        while (!Customer.equals("Yes") && !Customer.equals("No") && !Customer.equals("yes") && !Customer.equals("no")) {
            System.out.println("Wrong Command Please Try Again!");
            Customer = input.next();
        }
        if (Customer.equals("Yes") || Customer.equals("yes")) {
            // If YES,then Select the following categories given Below
            System.out.println("Select the type: i.e., \n1.bridal\n2.casual\n3.party\n4.fashion ware\n5.saris");
            String Select = input.next();
            out.println("You Have Order: " + Select + " Dress" );

            /*
                This loop Again again execute when user entered another input Except These given Products
            */
            while (!Select.equals("bridal") && !Select.equals("casual") && !Select.equals("party") && !Select.equals("fashion ware") && !Select.equals("saris")) {
                System.out.println("Sorry We don't have it would you like to buy between \n1.bridal\n2.casual\n3.party\n4.fashion ware\n5.saris");
                Select = input.next();
            }

            switch (Select) {
                case "bridal" -> {
                    System.out.println("Yes it is available in Stock. Do you want to BUY it? Yes/No");
                    // Enters Yes and No only
                    String type = input.next();

                    /*
                        This loop execute when User Enter other inputs except Yes/yes or No/no
                    */
                    while (!type.equals("Yes") && !type.equals("No") && !type.equals("yes") && !type.equals("no")) {
                        System.out.println("Wrong Command Please Try Again!");
                        type = input.next();
                    }
                    if (type.equals("Yes") || type.equals("yes")) {
                        // If Yes, Then Select the Colors Given Below
                        System.out.println("Sir! Select the Color of bridal! \n1.Yellow\n2.Blue\n3.Red\n4.White");
                        // If you Want to BUY then Enters Yellow , Blue , Red  and White Only.
                        String Color = input.next();
                        out.println("COLOR of Your BRIDAL DRESS is: " + Color);

                        /*
                            This loop Execute When User Enter Wrong Input Colors
                        */
                        while (!Color.equals("Yellow") && !Color.equals("Blue") && !Color.equals("Red") && !Color.equals("White")) {
                            System.out.println("Sorry We don't have it would you like to buy between \n1.Yellow\n2.Blue\n3.Red\n4.White");
                            Color = input.next();
                        }
                        switch (Color) {
                            case "Yellow", "Blue", "Red", "White" -> {
                                // Display Result in File
                                System.out.println("PRICE of Your DRESS is: " + "RS. 12000");
                                out.println("PRICE of Your DRESS is: " + "RS. 12000");
                                out.println("Ok Take Your Order!\r\nThankYou for Shopping Sir!");
                                out.println(date);
                            }
                            default ->
                                    // If User Enter Another Color Then Result is:
                                    System.out.println("This Color in Not Available Yet.\nSORRY!");
                        }
                    }
                }

                case "casual" -> {
                    System.out.println("Yes it is available in Stock. Do you want to BUY it? Yes/No");
                    // Enters Yes and No only
                    String type = input.next();

                    /*
                        This loop execute when User Enter other inputs except Yes/yes or No/no
                    */
                    while (!type.equals("Yes") && !type.equals("No") && !type.equals("yes") && !type.equals("no")) {
                        System.out.println("Wrong Command Please Try Again!");
                        type = input.next();
                    }
                    if (type.equals("Yes") || type.equals("yes")) {
                        // If Yes, Then Select the Colors Given Below
                        System.out.println("Sir! Select the Color of bridal! \n1.Blue\n2.Red\n3.Orange\n4.White");
                        String Color = input.next();
                        out.println("COLOR of Your CASUAL DRESS is: " + Color);

                        /*
                            This loop Execute When User Enter Wrong Input Colors
                        */
                        while (!Color.equals("Orange") && !Color.equals("Blue") && !Color.equals("Red") && !Color.equals("White")) {
                            System.out.println("Sorry We don't have it would you like to buy between : \n1.Blue\n2.Red\n3.Orange\n4.White");
                            Color = input.next();
                        }
                        // If you Want to BUY then Enters  Blue , Red , Orange and White Only.
                        switch (Color) {
                            case "Blue" -> {
                                // Display Result in File
                                System.out.println("PRICE of Your DRESS is: " + "RS. 5000");
                                out.println("PRICE of Your DRESS is: " + "RS. 5000");
                                out.println("Ok Take Your Order!\r\nThankYou for Shopping Sir!");
                                out.println(date);
                            }
                            case "Red" -> {
                                // Display Result in File
                                System.out.println("PRICE of Your DRESS is: " + "RS. 6000");
                                out.println("PRICE of Your DRESS is: " + "RS. 6000");
                                out.println("Ok Take Your Order!\r\nThankyou for Shopping Sir!");
                                out.println(date);
                            }
                            case "Orange" -> {
                                // Display Result in File
                                System.out.println("PRICE of Your DRESS is: " + "RS. 5000");
                                out.println("PRICE of Your DRESS is: " + "RS. 5000");
                                out.println("Ok Take Your Order!\r\nThankyou for Shopping Sir!");
                                out.println(date);
                            }
                            default -> {
                                // Display Result in File
                                System.out.println("PRICE of Your DRESS is: " + "RS. 6000");
                                out.println("PRICE of Your DRESS is: " + "RS. 6000");
                                out.println("Ok Take Your Order!\r\nThankYou for Shopping Sir!");
                                out.println(date);
                            }
                        }
                    }
                }

                case "party" -> {
                    System.out.println("Yes it is available in Stock. Do you want to BUY it? Yes/No");
                    // Enters Yes and No only
                    String type = input.next();

                    /*
                        This loop execute when User Enter other inputs except Yes/yes or No/no
                    */
                    while (!type.equals("Yes") && !type.equals("No") && !type.equals("yes") && !type.equals("no")) {
                        System.out.println("Wrong Command Please Try Again!");
                        type = input.next();
                    }
                    if (type.equals("Yes") || type.equals("yes")) {
                        // If Yes, Then Select the Colors Given Below
                        System.out.println("Sir! Select the Color of bridal! \n1.Blue\n2.Black\n3.Green\n4.White");
                        String Color = input.next();
                        out.println("Color of Your PARTY DRESS is: " + Color);

                        /*
                            This loop Execute When User Enter Wrong Input Colors
                        */
                        while (!Color.equals("Black") && !Color.equals("Blue") && !Color.equals("Green") && !Color.equals("White")) {
                            System.out.println("Sorry We don't have it would you like to buy between : \n1.Blue\n2.Black\n3.Green\n4.White");
                            Color = input.next();
                        }
                        switch (Color) {
                            case "Blue" -> {
                                // Display Result in File
                                System.out.println("PRICE of Your DRESS is: " + "RS. 7000");
                                out.println("PRICE of Your DRESS is: " + "RS. 7000");
                                out.println("Ok Take Your Order!\r\nThankYou for Shopping Sir!");
                                out.println(date);
                            }
                            case "Black" -> {
                                // Display Result in File
                                System.out.println("PRICE of Your DRESS is: " + "RS. 7000");
                                out.println("PRICE of Your DRESS is: " + "RS. 7000");
                                out.println("Ok Take Your Order!\r\nThankYou For Shopping Sir!");
                                out.println(date);
                            }
                            case "Green" -> {
                                // Display Result in File
                                System.out.println("PRICE of Your DRESS is: " + "RS. 8000");
                                out.println("PRICE of Your DRESS is: " + "RS. 8000");
                                out.println("Ok Take Your Order!\r\nThankyou for Shopping Sir!");
                                out.println(date);
                            }
                            default -> {
                                // Display Result in File
                                System.out.println("PRICE of Your DRESS is: " + "RS. 8000");
                                out.println("PRICE of Your DRESS is: " + "RS. 8000");
                                out.println("Ok Take Your Order!\r\nThankYou for Shopping Sir!");
                                out.println(date);
                            }
                        }
                    }
                }

                case "fashion ware" -> {
                    System.out.println("Yes it is available in Stock. Do you want to BUY it? Yes/No");
                    // Enter YEs and No Only
                    String type = input.next();

                    /*
                        This loop execute when User Enter other inputs except Yes/yes or No/no
                    */
                    while (!type.equals("Yes") && !type.equals("No") && !type.equals("yes") && !type.equals("no")) {
                        System.out.println("Wrong Command Please Try Again!");
                        type = input.next();
                    }
                    if (type.equals("Yes") || type.equals("yes")){
                        // If Yes, Then Select the Colors Given Below
                        System.out.println("Sir! Select the Color of bridal! \n1.Red\n2.Black\n3.Green\n4.Pink");
                        // If you Want to BUY then Enters Red , Black , Green and White Only.
                        String Color = input.next();
                        out.println("Color of Your FASHION_WARE DRESS is: " + Color);

                        /*
                            This loop Execute When User Enter Wrong Input Colors
                        */
                        while (!Color.equals("Red") && !Color.equals("Black") && !Color.equals("Green") && !Color.equals("Pink")) {
                            System.out.println("Sorry We don't have it would you like to buy between : \n1.Red\n2.Black\n3.Green\n4.Pink");
                            Color = input.next();
                        }
                        switch (Color) {
                            case "Red" -> {
                                // Display Result in File
                                System.out.println("PRICE of Your DRESS is: " + "RS. 9000");
                                out.println("PRICE of Your DRESS is: " + "RS. 9000");
                                out.println("Ok Take Your Order!\r\nThankYou For Shopping Sir!");
                                out.println(date);
                            }
                            case "Black" -> {
                                // Display Result in File
                                System.out.println("PRICE of Your DRESS is: " + "RS. 10000");
                                out.println("PRICE of Your DRESS is: " + "RS. 10000");
                                out.println("Ok Take Your Order!\r\nThankYou for Shopping Sir!");
                                out.println(date);
                            }
                            case "Green" -> {
                                // Display Result in File
                                System.out.println("PRICE of Your DRESS is: " + "RS. 10000");
                                out.println("PRICE of Your DRESS is: " + "RS. 10000");
                                out.println("Ok Take Your Order!\r\nThankyou for Shopping Sir!");
                                out.println(date);
                            }
                            default -> {
                                // Display Result in File
                                System.out.println("PRICE of Your DRESS is: " + "RS. 9000");
                                out.println("PRICE of Your DRESS is: " + "RS. 9000");
                                out.println("Ok Take Your Order!\r\nThankYou for Shopping Sir!");
                                out.println(date);
                            }
                        }
                    }
                }

                case "saris" -> {
                    System.out.println("Yes it is available in Stock. Do you want to BUY it? Yes/No");
                    // Enter YES or No Only
                    String type = input.next();

                    /*
                        This loop execute when User Enter other inputs except Yes/yes or No/no
                     */
                    while (!type.equals("Yes") && !type.equals("No") && !type.equals("yes") && !type.equals("no")) {
                        System.out.println("Wrong Command Please Try Again!");
                        type = input.next();
                    }
                    if (type.equals("Yes") || type.equals("yes")) {
                        // If Yes, Then Select the Colors Given Below
                        System.out.println("Sir! Select the Color of bridal! \n1.Black\n2.Red\n3.Blue\n4.Green");
                        // If you Want to BUY then Enters  Black , Blue , Red and Green Only.
                        String Color = input.next();
                        out.println("Color of Your SARIS DRESS is: " + Color);

                        /*
                            This loop Execute When User Enter Wrong Input Colors
                         */
                        while (!Color.equals("Black")  && !Color.equals("Red") && !Color.equals("Green") && !Color.equals("Blue")) {
                            System.out.println("Sorry We don't have it would you like to buy between : \n1.Black\n2.Red\n3.Blue\n4.Green");
                            Color = input.next();
                        }
                        switch (Color) {
                            case "Blue" -> {
                                // Display Result in File
                                System.out.println("PRICE of Your DRESS is: " + "RS. 9000");
                                out.println("PRICE of Your DRESS is: " + "RS. 9000");
                                out.println("Ok Take Your Order!\r\nThankYou for Shopping Sir!");
                                out.println(date);
                            }
                            case "Black" -> {
                                // Display Result in File
                                System.out.println("PRICE of Your DRESS is: " + "RS. 9000");
                                out.println("PRICE of Your DRESS is: " + "RS. 9000");
                                out.println("Ok Take Your Order!\r\nThankYou For Shopping Sir!");
                                out.println(date);
                            }
                            case "Green" -> {
                                // Display Result in File
                                System.out.println("PRICE of Your DRESS is: " + "RS. 10000");
                                out.println("PRICE of Your DRESS is: " + "RS. 10000");
                                out.println("Ok Take Your Order!\r\nThankyou for Shopping Sir!");
                                out.println(date);
                            }
                            default -> {
                                // Display Result in File
                                System.out.println("PRICE of Your DRESS is: " + "RS. 10000");
                                out.println("PRICE of Your DRESS is: " + "RS. 10000");
                                out.println("Ok Take Your Order!\r\nThankYou for Shopping Sir!");
                                out.println(date);
                            }
                        }
                    }
                }

                // If User Select No input This message will Display on Terminal
                default -> System.out.println("This Product is not Available yet!!!");
            }
        }

        else {
            //If User Enters No Then This program is execute on terminal
            System.out.println("Okay No Problem Sir!");
            out.print("\r\n___________________________________________________________________\n");
        }
        out.print("\r\n____________________________________________________________________\n");
        // It closes the file When This Method ends
        out.close();
    }

    public static void customerDetailsFeedback() throws IOException {

        /*
            This Method Display the Customer Details of the User Entered Data.
        */

        // THis file is Created to Store All Data In a Text file Entered bY the User
        File file = new File("FeedbackDetails.txt");
        // print writer display result in the file you create
        PrintWriter out = new PrintWriter(file);

        // it Execute the Current Time
        long milliS = System.currentTimeMillis();
        // It execute the current Date
        Date date = new Date(milliS);

        String[] name;
        String[] email;
        String[] address;
        String[] City;
        String[] ratingStar = new String[99];
        // Phone number MUST be In Digit
        long[] phone;
        // Rate btw 0-----5
        int[] rate;
        Scanner sc = new Scanner(System.in);
        int numCustomers = 0;
        boolean bool = true;
        boolean bool2 = true;

        while (bool2 || bool){
            try {
                System.out.println("Enter Total Customers Whom Details Are To Be Added: ");
                numCustomers = sc.nextInt();
                bool2 = false;
                if (numCustomers < 0) {
                    System.out.println("Invalid Input Try Again");
                }
                else {
                    bool = false;
                }
            }
            catch (InputMismatchException ex) {
                // In case of Wrong Input This Statement Execute
                sc.nextLine();
                System.out.println("Invalid Input Try Again");
            }

        }



        name = new String[numCustomers];
        email = new String[numCustomers];
        City = new String[numCustomers];
        address = new String[numCustomers];
        phone = new long[numCustomers];
        rate = new int[numCustomers];

        for (int i = 0; i < numCustomers; i++) {
            // Enter your Name i.e., xyz
            System.out.print("Enter Your Name " + (i + 1) + " ---> ");
            name[i] = sc.next();

            // Enter your Email i.e., xyz@gmail.com
            System.out.print("Enter Your Email " + (i + 1) + " ---> ");
            email[i] = sc.next();

            // Enter your City i.e., ABC
            System.out.print("Enter Your City " + (i + 1) + " ---> ");
            City[i] = sc.next();

            // Enter Your Address Without Spaces
            System.out.print("Enter Your Address " + (i + 1) + " ---> ");
            address[i] = sc.next();

            // Enter your Number Use only Digits i.e.,122345
            boolean b1 = true;

            // this loop check The input value and control exception
            while (b1) {
                try {
                    System.out.print("Enter Your Phone " + (i + 1) + " ---> ");
                    phone[i] = sc.nextLong();
                    b1 = false;
                }
                catch (InputMismatchException ex) {
                    // In case of Wrong Input This Statement Execute
                    sc.nextLine();
                    System.out.println("Invalid Input Try Again");
                    System.out.println("Phone Number Must Be in Integer\n");
                }
            }

            // Enter The Digit btw 0 to 6
            boolean b2 = true;

            boolean bool3 = true;

            // this loop check The input value and control exception
            while (b2 || bool3) {
                try {
                    System.out.print("Rate Our Products Out of 5: ");
                    rate[i] = sc.nextInt();
                    b2 = false;
                    if (rate[i] < 0 || rate[i] > 5) {
                        System.out.println("TRY AGAIN");
                    }
                    else {
                        bool3 = false;
                    }
                }
                catch (InputMismatchException ex) {
                    // In case of Wrong Input This Statement Execute
                    sc.nextLine();
                    System.out.println("Invalid Input Try Again");
                    System.out.println("Rate Our Products in Integer Only\n");
                }
            }



            /*
                 This Conditional statement Check The Rating Then Print Star
            */
            if (rate[i] == 1) {
                ratingStar[i] = "*\t(disappointing)" +
                        "\r\n\t\tSorry for your experience!";
            }
            else if (rate[i] == 2) {
                ratingStar[i] = "* *\t(unsatisfactory)" +
                        "\r\n\t\tSorry for your experience!";
            }
            else if (rate[i] == 3) {
                ratingStar[i] = "* * *\t(somewhat satisfactory)" +
                        "\r\n\t\tSorry for your experience!";
            }
            else if (rate[i] == 4) {
                ratingStar[i] = "* * * *\t(satisfactory)" +
                        "\r\n\t\tI'm glad you liked our company!";
            }
            else if (rate[i] == 5) {
                ratingStar[i] = "* * * * *\t(excellent)" +
                        "\r\n\t\tI'm glad you liked our company!";
            }
            else {
                break;
            }
        }

        /*
              It Display The overall Data When Users Entered Data.
              This loop Represents The Customer feedback in output.
         */
        out.println("\t\t-----> C U S T O M E R  F E E D B A C K <-----\r\n");
        for (int i = 0; i < numCustomers; i++) {

            out.println("NAME          : " + name[i]);
            out.println("EMAIL         : " + email[i]);
            out.println("CITY          : " + City[i]);
            out.println("ADDRESS       : " + address[i]);
            out.println("PHONE NUMBER  : " + phone[i]);
            out.println("RATING        : " + ratingStar[i]);
            out.println("""
                CONTACT INFO  : 03498950236\r
                \t\twww.facebook.com/boutiqueofficial/\r
                \t\twww.twitter.com/boutiqueofficial/\r
                \t\tboutiqueofficial@gmail.com""");
            out.println("DATE AND TIME : " + date);
        }
        out.print("\r\n____________________________________________________\n");
        // It Closes the file when Data Is entered
        out.close();
    }

    /*
        Employee DATA String is Default It may Change or Modify By the Admin Excess Only
     */
    public static String [][] employeeData = {
            {"Manager","Ali","11111","30000"},
            {"Cashier","Umer","22222","20000"},
            {"Cashier","Afaq","33333","20000"},
            {"Salesman","Naeem","44424","15000"},
            {"Salesman","Adil","55555","15000"},
            {"Salesman","Obaid","66666","15000"},
            {"Guard","Hassan","77777","15000"},
            {"Guard","Omer","88888","15000"},
            {"Accountant","Zaki","99999","15000"},
            {"Accountant","Awais","12345","15000"},
            {"Salesman","Qasim","23456","10000"},
            {"Salesman","Ahmed","34567","10000"},
            {"Guard","Ahmad","45678","15000"},
            {"Salesman","Nouman","56789","15000"},
            {"Salesman","Asim","67890","15000"},
            {"0","0","0","0"},
            {"0","0","0","0"},
            {"0","0","0","0"},
            {"0","0","0","0"},
            {"0","0","0","0"}
    };

    public static void menuEmployee() {
         /*
            This Method Control AND DISPLAY The Overall Employee Management System
         */
        Scanner input = new Scanner(System.in);
        int opt = 0;

        boolean bool = true;

        // this loop check The input value and control exception
        while (bool) {
            try {
                opt = input.nextInt();
                bool = false;
            }
            catch (InputMismatchException ex) {
                // If Input Is Not in Integer Again Ask The ADMIN to Select The Option
                input.nextLine();
                System.out.println("Try Again: Input Should Not Be String");
                System.out.println("\nEnter your choice again: ");
            }
        }

        /*
            This Switch Statement Execute When Admin Want TO CHANGE And ADD Employee DATA
        */
        switch (opt) {
            case 1:
                // Press 1 To View Employee DATA
                System.out.println();
                System.out.println("\t\t\tVIEW EMPLOYEES DETAILS  ");
                System.out.println("____________________________________________________________________________________________");
                ViewEmployeeDATA(employeeData);
                // Again Ask the Admin To change Something
                System.out.println("\nEnter your choice again: ");
                menuEmployee();
                break;

            case 2:
                // Press 2 To ADD Employee DATA
                System.out.println();
                System.out.println("\t\t\tADD EMPLOYEE  ");
                System.out.println("______________________________________________________________________________________________");
                System.out.println("Enter the following details of the employee to be added: ");
                addEmployee(employeeData);
                // Again Ask the Admin To change Something
                System.out.println("\nEnter your choice again: ");
                menuEmployee();
                break;

            case 3:
                // Press 3 To Delete Employee DATA
                System.out.println();
                System.out.println("\t\t\tDELETE EMPLOYEE      ");
                System.out.println("_____________________________________________________________________________________________");
                System.out.println("Enter the ID of the employee to be deleted: ");
                deleteEmployee(employeeData);
                // Again Ask the Admin To change Something
                System.out.println("\nEnter your choice again: ");
                menuEmployee();
                break;

            case 4:
                // Press 4 To Search Employee DATA
                System.out.println();
                System.out.println("\t\t\tSEARCH EMPLOYEE");
                System.out.println("______________________________________________________________________________________________");
                System.out.println("Enter the ID of the employee to be searched: ");
                searchEmployee(employeeData);
                // Again Ask the Admin To change Something
                System.out.print("\nEnter your choice again: ");
                menuEmployee();
                break;

            case 5:
                System.out.println("Exit");
                break;

            default:
                // Press Any other Key To exit
                System.out.println("Enter an integer between 1 and 5:");
                menuEmployee();

        }
    }

    public static void ViewEmployeeDATA(String[][] employeeData) {
         /*
            THis Method Execute To View Employee Data on The Terminal
         */

        // create A String File Path Variable
        String filePath = "EMPLOYEE.txt";
        // Default Writer in Null
        PrintWriter writer = null;

        try {
            // Write the Overall Code In the Given File Path
            writer = new PrintWriter(filePath);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.print("""
                \s

                \t\t    Status \t\t\tEmployee Name \t\t  Employee ID\t\t    Salary (in Rs.)\t\t\s

                """);
        assert writer != null;
        writer.printf("""
                 \s

                \t    Status\t\t\tEmployee Name \t\t Employee ID\t\t Salary (in Rs.)\t\t\s

                """);
        writer.println();

        int srNo = 1;

        for (int i = 0; i < employeeData.length; i++) {
            if (employeeData[i][0].equals("0")) {
                continue;
            }
            System.out.printf("%-4s", srNo + ".");
            writer.printf("%-4s", srNo + ".");
            for (int j = 0; j < employeeData[i].length; j++) {

                System.out.printf("%16s", employeeData[i][j] + "\t\t");
                writer.printf("%16s", employeeData[i][j] + "\t\t");
            }
            System.out.println();
            writer.println();
            srNo++;
        }
        System.out.print("______________________________________________________________________________________________\n");
        writer.print("_____________________________________________________________________________________________________________");
        // After Written data File Writer Closes AND store DATA
        writer.close();
    }

    public static void addEmployee(String[][] employeeData) {
    /*
        This Method Execute To ADD Employee DATA on the Terminal
     */

        Scanner input = new Scanner(System.in);
        for (int j = 0; j < employeeData.length; j++) {
            if (employeeData[j][0].equals("0")) {

                System.out.println("Enter rank:");
                employeeData[j][0] = input.nextLine();

                System.out.println("Enter employee Name :");
                employeeData[j][1] = input.nextLine();

                employeeData[j][2] = String.valueOf(Math.round(Math.random() * 100000));
                boolean b2 = true;
                while(b2){
                    try{
                        System.out.println("Salary(in Rs.):");
                        employeeData[j][3] = String.valueOf(input.nextInt());
                        b2 = false;
                    }
                    catch (InputMismatchException ex){
                        System.out.println("INPUT MUST BE INTEGER, TRY AGAIN");
                        input.nextLine();
                    }
                }

                System.out.println("Employee added successfully. :");
                break;

            }
        }
    }

    public static void deleteEmployee(String[][] employeeData) {
        /*
            This Method Execute To DELETE Employee DATA on the Terminal
        */
        Scanner input = new Scanner(System.in);
        boolean b1 = true;

        while (b1){
            try{
                String ID = String.valueOf(input.nextInt());
                int k = 0;
                while (k < employeeData.length) {
                    if (ID.equals(employeeData[k][2])) {
                        System.out.println("Employee Deleted Successfully");

                        employeeData[k][0] = "0";
                        employeeData[k][1] = "0";
                        employeeData[k][2] = "0";
                        employeeData[k][3] = "0";

                    }
                    k++;
                }
                b1 = false;
            }
            catch (InputMismatchException ex) {
                System.out.println("INPUT MUST BE INTEGER< TRY AGAIN!");
                input.nextLine();
            }
        }
    }

    public static void searchEmployee(String[][] employeeData) {
        /*
            This Method execute To Search Employee DATA in Terminal
        */
        Scanner input = new Scanner(System.in);
        boolean b2 = true;
        while (b2){
            try{
                String ID = String.valueOf(input.nextInt());
                int i = 0;
                while (i < employeeData.length) {
                    if (ID.equals(employeeData[i][2])) {
                        System.out.print("""
                \s

                \t\t    Status \t\t\tEmployee Name \t\tEmployee ID\t    Salary (in Rs.)\t\t\s

                """);
                        System.out.printf("\t\t\t%s\t \t\t\t%s \t\t\t %s \t\t\t\t%s",employeeData[i][0],employeeData[i][1],
                                employeeData[i][2],employeeData[i][3]);

                    }
                    i++;
                }
                b2 = false;
            }
            catch (InputMismatchException ex) {
                System.out.println("INPUT MUST BE INTEGER< TRY AGAIN!");
                input.nextLine();
            }
        }
    }

    public static void validityCheck(String[] array1){
        /*
            This Method Check The Validity of User Name And Password Attempts ANd then Display Result
         */
        Scanner input = new Scanner (System.in);
        /*
            User have Only Three Attempts To Access the Admin
            OtherWise User Don't be Able to Access The Admin
         */
        boolean test = true;
        for (int passAttempts = 0; passAttempts < 3 && test; passAttempts++) {
            System.out.println("Enter the username: ");
            String username = input.next();
            System.out.println("Enter the Password: ");
            String password = input.next();
            // If user Enters Wrong Username or Password Then This Program Execute
            if ((username.equals(array1[0]))&&(password.equals(array1[1]))){
                test = false;
            }

            else {
                // If User 3 Attempts Fails Then Again Ask The User
                System.out.println("Incorrect username or password try again.");

            }


        }
        if (test == true) {
            System.exit(0);
        }
    }

    public static double[][] dataArray(){
        /*
            This Method Control And Execute The Budget Of our Total Products
         */
        Scanner in = new Scanner(System.in);
        int r = 0;

        boolean b = true;

        boolean bool = true;

        // this loop check The input value and control exception
        while (b || bool){
            try {
                System.out.println("Enter the number of products: ");
                System.out.println();
                r = in.nextInt();
                if (r<0){
                    System.out.println("Invalid: NegativeArraySizeException");
                }
                else {
                    bool = false;
                }

                b = false;
            }
            catch (InputMismatchException ex) {
                in.nextLine();
                System.out.println(" Try Again: Input Should not be String");
                System.out.println("*");
            }
        }

        double[][] arr = new double[r][4];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < 4; j++) {
                if (arr[i][j] == arr[i][0]) {
                    boolean b1 = true;
                    boolean bb = true;
                    // this loop check The input value and control exception
                    while (b1 || bb) {
                        try {
                            System.out.println("Enter product ID number: ");
                            arr[i][0] = in.nextInt();
                            if(arr[i][0] < 0){
                                System.out.println("Try Again: Input Should not be in Negative");
                            }
                            else{
                                b1 = false;
                            }
                            bb = false;
                        }
                        catch (InputMismatchException ex) {
                            // IN CASE OF WRONG INPUT IT EXECUTE
                            in.nextLine();
                            System.out.println("Try Again: Input Should not be String");
                        }
                    }
                }
                else if (arr[i][j] == arr[i][1]) {
                    boolean b2 = true;
                    boolean bb1 = true;
                    // this loop check The input value and control exception
                    while (b2 || bb1) {
                        try {
                            System.out.println("Enter product price $: ");
                            arr[i][1] = in.nextDouble();
                            if(arr[i][1] < 0){
                                System.out.println("Try Again: Input Should not be in Negative");
                            }
                            else{
                                b2 = false;
                            }
                            bb1 = false;
                        }
                        catch (InputMismatchException ex) {
                            // IN CASE OF WRONG INPUT IT EXECUTE
                            in.nextLine();
                            System.out.println("Try Again: Input Should not be String");
                        }
                    }
                }

                else if (arr[i][j] == arr[i][2]) {
                    boolean b3 = true;
                    boolean bb2 = true;
                    // this loop check The input value and control exception
                    while (b3 || bb2) {
                        try {
                            System.out.println("Enter product quantity: ");
                            arr[i][2] = in.nextInt();

                            if(arr[i][2] < 0){
                                System.out.println("Try Again: Input Should not be in Negative");
                            }
                            else{
                                b3 = false;
                            }
                            bb2 = false;
                        }
                        catch (InputMismatchException ex) {
                            // IN CASE OF WRONG INPUT IT EXECUTE
                            in.nextLine();
                            System.out.println("Try Again: Input Should not be String");
                        }
                    }
                }

                else if (arr[i][j] == arr[i][3]) {
                    boolean b4 = true;

                    // this loop check The input value and control exception
                    while (b4) {
                        try {
                            arr[i][3] = arr[i][2] * arr[i][1];
                            System.out.println("Sales: " + arr[i][3]);
                            b4 = false;
                        }
                        catch (InputMismatchException ex) {
                            // IN CASE OF WRONG INPUT IT EXECUTE
                            in.nextLine();
                            System.out.println("Try Again: Input Should not be String");
                        }
                    }
                }
            }
        }

        /*
            This Code Reads DATA From the Terminal AND Create file and Stores DATA in IT
         */
        try {
            PrintWriter file = new PrintWriter(new FileOutputStream("arr.txt"), true);
            file.println("\t\t\t-----> Data is ready to view <-----");
            file.print("""
                    \s

                    \t   ID no. \t\t\tProduct price\t\t   Quantity\t       \tSale\t\t\s

                    """);

            file.println();
            int srNo = 1;

            for (int i = 0; i < arr.length; i++) {
                file.printf("%-4s", srNo + ".");
                for (int j = 0; j < arr[i].length; j++) {

                    file.printf("%16s", arr[i][j] + "\t\t");
                }
                file.println();
                srNo++;

            }
            file.print("________________________________________________________________________________________________\n");
            file.close();

            /*
                 This Code Display The Overall DATA in the form of Array
            */
            System.out.println("\t\t\t\t\t\t-----> Data is ready to view <-----");
            System.out.print("""
                    \s

                    \t\t    ID no. \t\t\tProduct price \t\t\t  Quantity\t\t   Sale\t\t\s

                    """);

            int srNum = 1;

            for (int i = 0, arrLength = arr.length; i < arrLength; i++) {
                double[] doubles = arr[i];

                System.out.printf("%-4s", srNum + ".");

                for (int j = 0; j < doubles.length; j++) {
                    double aDouble = doubles[j];

                    System.out.printf("%16s", aDouble + "\t\t");
                }
                System.out.println();
                srNum++;

            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.print("______________________________________________________________________________________________\n");
        System.out.println();
        return arr;
    }

    public static double totalIncome(double[][] arr) {
        /*
            This Method Calculate AND DISPLAY The TotalIncome
         */
        double sum = 0;
        for (int i = 0, arrLength = arr.length; i < arrLength; i++) {
            double[] doubles = arr[i];
            sum += doubles[3];
        }
        System.out.println("The total income is: " + sum);
        return (sum);
    }

    public static void monthlyCalc(int month, int year, double[][] arr){

        /*
            This Method Calculate Monthly And Yearly Income AND DISPLAY in Terminal
         */
        if (month == 4 || month == 6 || month == 9 || month == 11){
            double monthly_income = totalIncome(arr) * 30;
            System.out.println("The monthly income is for this month is: " + monthly_income);
            System.out.println();
        }
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12){
            double monthly_income = totalIncome(arr) * 31;
            System.out.println("The monthly income is for this month is: " + monthly_income);
            System.out.println();
        }
        if (month == 2){
            double monthly_income;
            if (year % 4 == 0){
                monthly_income = totalIncome(arr) * 29;
            }
            else {
                monthly_income = totalIncome(arr) * 28;
            }
            System.out.println("The monthly income is for this month is: " + monthly_income);
            System.out.println();
        }
    }

    public static void Expense(double[][] arr){
        /*
            This METHOD Calculate Total Expenses OF Our Management System
         */
        Scanner in = new Scanner (System.in);
        double stock = 0;
        double staff = 0;
        double inventory = 0;
        double bill = 0;
        double add = 0;

        boolean boolean1 = true;
        // this loop check The input value and control exception
        while (boolean1) {
            try {
                System.out.println("Enter Stocks Expense: ");
                stock = in.nextDouble();
                System.out.println();
                boolean1 = false;
            }
            catch (InputMismatchException ex) {
                // I Case of Wrong Input It Execute
                System.out.println("Try Again: Input Should not be String");
                System.out.println();
                in.nextLine();
            }
        }

        boolean boolean2 = true;
        // this loop check The input value and control exception
        while (boolean2) {
            try {
                System.out.println("Enter Staff Expense: ");
                staff = in.nextDouble();
                System.out.println();
                boolean2 = false;
            }
            catch (InputMismatchException ex) {
                // I Case of Wrong Input It Execute
                System.out.println("Try Again: Input Should not be String");
                System.out.println();
                in.nextLine();
            }
        }

        boolean boolean3 = true;
        // this loop check The input value and control exception
        while (boolean3) {
            try {
                System.out.println("Enter Inventory Expense: ");
                inventory = in.nextDouble();
                System.out.println();
                boolean3 = false;
            }
            catch (InputMismatchException ex) {
                // I Case of Wrong Input It Execute
                System.out.println("Try Again: Input Should not be String");
                System.out.println();
                in.nextLine();
            }
        }

        boolean boolean4 = true;
        // this loop check The input value and control exception
        while (boolean4) {
            try {
                System.out.println("Enter Bills Expense: ");
                bill = in.nextDouble();
                System.out.println();
                boolean4 = false;
            }
            catch (InputMismatchException ex) {
                // I Case of Wrong Input It Execute
                System.out.println("Try Again: Input Should not be String");
                System.out.println();
                in.nextLine();
            }
        }

        boolean boolean5 = true;
        // this loop check The input value and control exception
        while (boolean5) {
            try {
                System.out.println("Enter Additional Expenses: ");
                add = in.nextDouble();
                System.out.println();
                boolean5 = false;
            }
            catch (InputMismatchException ex) {
                // I Case of Wrong Input It Execute
                System.out.println("Try Again: Input Should not be String");
                System.out.println();
                in.nextLine();
            }
        }
        System.out.println();

        // CALCULATE TOTAL EXPENSE DISPLAY RESULT
        double total_expense = stock + staff + inventory + bill + add;
        System.out.println("--Checking total expense--");
        System.out.println("The total expense is: " + total_expense);

        // DISPLAY PROFIT OR LOSS IN EXPENSE
        profAndLoss(total_expense,stock,arr);

        // DISPLAY REMAINING BUDGET IN EXPENSE
        remainingBudget(total_expense);
    }

    public static void profAndLoss(double total_expense, double stock, double[][] arr){
        /*
            This Method Calculate And Display Expenses(Profit/Loss)
        */
        double profit_loss = (totalIncome(arr) - total_expense); //total income
        System.out.println("--Checking Profit and Loss--");

        if (profit_loss > 0){

            System.out.println("Surplus! Adding to Stock Expense!"); //Value in Positive
            System.out.println();
            double stock_expense = stock + profit_loss;
            System.out.println("Stock Expense with profit: " + stock_expense);
            System.out.println();

        }
        else if (profit_loss < 0){
            System.out.println("Deficit! Cutting down Stock Expenses! "); //Value in negative
            System.out.println();
            double stock_expense = stock - profit_loss;
            System.out.println("Stock Expense with loss: " + stock_expense);
            System.out.println();
        }
    }

    public static void remainingBudget(double total_expense){
        /*
            This Method Calculate And Display The Remaining Budget
        */
        double fixed_budget = 10000000; //minus expense
        System.out.println("--Checking Remaining Budget --");
        System.out.println("The remaining budget is: " + (fixed_budget - total_expense));
        System.out.println();
    }

    public static void ExpenseBudget() {
        /*
            This Code Execute The Overall Data OF Budget Of Boutique Management System
         */
        System.out.println("-----> Welcome to Finance <-----");
        System.out.println();
        System.out.println("-----> Before Gaining Access, Enter Data As Required <-----");
        double[][] arr = dataArray();
        menu(arr);
    }

    public static void menu (double[][] arr){
        /*
            This Code Execute The Overall Data OF Budget Of Boutique Management System
         */

        Scanner in = new Scanner (System.in);
        int entry = 0;

        while (entry <= 3) {
            boolean bool6 = true;

            // this loop check The input value and control exception
            while (bool6) {
                try {
                    System.out.println("---------ENTER 1-3 TO GAIN ACCESS---------");
                    System.out.print("\n 1 -> INCOME \n 2 -> EXPENSE \n 3 -> EXIT");
                    System.out.println();
                    entry = in.nextInt();
                    bool6 = false;
                }
                catch (InputMismatchException ex) {
                    // I Case of Wrong Input It Execute
                    System.out.println("Try Again: Input Should not be String");
                    System.out.println();
                    in.nextLine();
                }
            }

            // To view INCOME
            if (entry == 1) {
                System.out.println("-----> Welcome To Income <-----");
                System.out.println("-----> Computing Income - [Monthly] <-----");
                System.out.println();
                boolean bool = true;
                boolean bl = true;
                int month = 0;
                int year = 0;

                // this loop check The input value and control exception
                while (bool || bl) {
                    try {
                        System.out.println("Enter the month number [1 - 12]: ");
                        month = in.nextInt();
                        System.out.println();
                        if (month < 0){
                            System.out.println("Try Again: Input Should not be in Negative");
                        }
                        else{
                            bool = false;
                        }
                        bl = false;
                    }

                    catch (InputMismatchException ex) {
                        // In Case Of Wrong Input it Execute
                        System.out.println("Try Again: Input Should not be String");
                        System.out.println();
                        in.nextLine();
                    }
                }

                boolean bool1 = true;
                boolean booll = true;
                // this loop check The input value and control exception
                while (bool1 || booll) {
                    System.out.println();
                    bool1 = false;
                    try {
                        System.out.println("Enter the year: ");
                        year = in.nextInt();
                        System.out.println();
                        if (year<1000 || year>9999){
                            System.out.println("Try again: Enter year again: ");
                        }
                        else {
                            booll = false;
                        }
                        bool1 = false;

                    }
                    catch (InputMismatchException ex) {
                        // In Case of Wrong Input it execute
                        System.out.println("Try Again: Input Should not be String");
                        System.out.println();
                        in.nextLine();
                    }
                }
                totalIncome(arr);
                monthlyCalc(month, year, arr);

            }

            // To View Expense
            if (entry == 2) {
                System.out.println("-----> Welcome To Expense <-----");
                System.out.println("-----> Computing Expense <-----");
                System.out.println();
                Expense(arr);
            }

            // To EXit AND BACK TO THE MAIN MENU
            else if (entry == 3){
                System.out.println("-----> EXIT <-----");
                break;
            }
        }
        if(entry > 3 || entry < 1){
            System.out.println("Invalid Entry: Please Enter Integer BETWEEN 1-3 ");
            menu(arr);
        }
    }


    public static void ProductionAndStock(){

        System.out.println("\t\t\tP R O D U C T I O N   S T O C K");

        System.out.print("""
                1. View Dress Stock
                2. Add Dress
                3. Delete Dress
                4. Search Dress
                5. EXIT
                """);

        System.out.println("Enter your choice : ");
        menuStock();
    }
    public static void EmployeeManagement() {

        /*
            This Method Execute And Control The Overall Employee Data
        */
        System.out.println("\t\t\tE M P L O Y E E      M A N A G E M E N T");

        System.out.print("""
                1. View Employees Details
                2. Add Employee
                3. Delete Employee
                4. Search Employee
                5. EXIT
                """);

        System.out.println("Enter your choice : ");
        menuEmployee();

    }

    /************
     * MAIN CODE *
     **+********/
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        String[] adminAccess = {"@boutique1234", "qwerty6789"};
        int choice1 = 0;

        /*
            This loop Call Different Functions When User Enters 1 AND 2
         */
        while(true) {
            System.out.println("""
                    W E L C O M E   T O   B O U T I Q U E   M A N A G E M E N T   S Y S T E M
                    1-Admin login
                    2-Customer Login
                    Press any other key to exit.""");
            boolean bool = true;

            // this loop check The input value and control exception
            while (bool) {
                try {
                    choice1 = input.nextInt();
                    bool = false;
                }
                catch (InputMismatchException ex) {
                    // In case of Wrong Input It execute
                    input.nextLine();
                    System.out.println("Try Again: Input Should not be String");
                    System.out.println("\nEnter Your choice Again: ");
                }
            }

            while(choice1<0){
                System.out.println("INVALID INPUT");
                System.out.println("ENTER YOUR CHOICE AGAIN");
                choice1 = input.nextInt();
            }

            // Press 1 IF You are Admin
            if (choice1 == 1){
                validityCheck(adminAccess);
                int choice3 =0;

                /*
                    This loop Execute After Admin Excess
                 */
                while(choice3<3){
                    System.out.println("""
                            ------>W E L C O M E   T O   A D M I N<------
                            1-Employee Management\s
                            2-Production and Stock
                            3-Expenses and Budget
                            Press any other key to exit.
                            """);
                    boolean bool1 = true;

                    // this loop check The input value and control exception
                    while (bool1) {
                        try {
                            choice3 = input.nextInt();
                            bool1 = false;
                        }
                        catch (InputMismatchException ex) {
                            // In case of Wrong Input It execute
                            input.nextLine();
                            System.out.println("Try Again: Input Should not be String");
                            System.out.println("\nEnter Your choice Again: ");
                        }
                    }

                    while (choice3<0){
                        System.out.println("INVALID INPUT");
                        System.out.println("ENTER YOUR CHOICE AGAIN");
                        choice3 = input.nextInt();
                    }

                    if (choice3 == 1) {
                        // Press 1 For Employee Management
                        EmployeeManagement();
                    }
                    else if (choice3 == 2) {
                        // Press 2 for ProductionANDSTOCK
                        ProductionAndStock();
                    }
                    else if (choice3==3){
                        // Press 3 For Expenses
                        ExpenseBudget();
                    }
                    else {
                        break;
                    }
                }
            }

            // Press 2 If You Are Customer
            else if (choice1 == 2) {
                Customerlogin();
                int choice2 = 0;

                /*
                    This loop Execute After Customer Login
                 */
                while (true) {
                    System.out.println("""
                            ---------->W E L C O M E  T O  C U S T O M E R<-----------
                            1-Buy Products
                            2-Customer Feedback
                            Press any other key to exit.""");
                    boolean bool2 = true;

                    // this loop check The input value and control exception
                    while (bool2) {
                        try {
                            choice2 = input.nextInt();
                            bool2 = false;
                        }
                        catch (InputMismatchException ex) {
                            // In case of Wrong Input It execute
                            input.nextLine();
                            System.out.println("Try Again: Input Should not be String");
                            System.out.println("\nEnter Your choice Again: ");
                        }
                    }
                    while (choice2<0){
                        System.out.println("INVALID INPUT");
                        System.out.println("ENTER YOUR CHOICE AGAIN");
                        choice2 = input.nextInt();
                    }

                    if (choice2 == 1) {
                        //Press 1 Foe Buying Product
                        SaleProduct();
                    }
                    else if (choice2 == 2) {
                        // Press 2 For Feedback
                        customerDetailsFeedback();
                    }
                    else {
                        break;
                    }
                }
            }

            // Press 0 to Exit System
            else{
                System.exit(0);
            }
        }
    }
}

