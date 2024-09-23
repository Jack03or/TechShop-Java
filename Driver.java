
/**
 * Write a description of class Driver here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.Scanner;
import java.util.ArrayList;

public class Driver
{
    ArrayList<Technology> list;

    int interestL =0;
    int interestC=0;

    int LaptopsSold =0;
    int ConsolesSold =0;

    public Driver()
    {
        Console c;
        Laptops l;

        list = new ArrayList<Technology>();
        c = new Console("Xbox" , "1tb" , 450 , 3 , 0 ,"black" ,  "Xbox wireless controller" , true);
        list.add(c);

        c = new Console("Playstation 4" , "600GB" , 300 , 3 , 0 , "white" , "Dualshock" , true);
        list.add(c);

        l = new Laptops("HP" , "48GB" , 600 , 5 , 0 , "i5" , 5 , 15.4);
        list.add(l);

        l = new Laptops("Toshiba" , "56GB" , 500 , 5 , 0 , "i5" , 5 , 17.2);
        list.add(l);

        generalMenu();
    }

    public void generalMenu()
    {
        Scanner scan = new Scanner(System.in);
        System.out.print("\f");
        int option = 0;

        do
        {
            System.out.print("\f");
            String password;

            System.out.println("\nO'Riordans Tech-Stock Control System");
            System.out.println("=====================================");
            System.out.println("1.Customer Menu\n");
            System.out.println("2.Staff Menu (password protected)\n");
            System.out.println("3.Exit System\n");

            option = scan.nextInt();

            if (option == 1)
            {
                customerMenu();
            }

            if (option == 2)
            {
                System.out.println("Please enter the staff password (ORT2003)");
                scan.nextLine();
                password = scan.nextLine();
                while (!password.equalsIgnoreCase("ORT2003")) 
                {
                    System.out.println("Incorrect password , please try again"); 
                    password = scan.nextLine();
                }

                if (password.equalsIgnoreCase("ORT2003"))
                {
                    staffMenu(); 
                }
            }

            if (option == 3)
            {
                exitSystem();
            }
        }while(option != 3);
    }

    /** exit sysyem */
    public void exitSystem()
    {
        System.out.print("\f");
        System.out.println("System Exited");
    }

    /** Customer Menu */
    public void customerMenu()
    {
        Scanner scan = new Scanner(System.in);
        int option = 0;

        do
        { 
            System.out.print("\f");

            System.out.println("\nO'Riordans Tech-Customer Menu");
            System.out.println("=====================================");
            System.out.println("1.Display all Consoles for sale\n");
            System.out.println("2.Display all Laptops for sale\n");
            System.out.println("3.Buy a Console\n");
            System.out.println("4.Buy a Laptop\n");
            System.out.println("5.Exit System\n");

            option = scan.nextInt();

            if (option == 1)
            {
                displayConsoles();
            }
            if (option == 2)
            {
                displayLaptops();
            }
            if (option == 3)
            {
                buyConsole();
            }
            if (option == 4)
            {
                buyLaptop();
            }
            if (option == 5)
            {
                System.out.println("\f");
            }
        }while(option != 5) ;
    }

    public void displayConsoles()
    {
        System.out.println("\f");
        Scanner scan = new Scanner(System.in);

        boolean found = false;
        System.out.println("\nConsoles");
        System.out.println("============");
        for (Technology c : list)
        {
            if (c instanceof Console)
            {
                found = true;
                System.out.println(c.toString());
            }
        }
        if (!found)
        {
            System.out.println("Sorry , there are no consoles in stock");
        }

        interestC = interestC + 1;

        scan.nextLine();
    }

    public void displayLaptops()
    {
        System.out.println("\f");
        Scanner scan = new Scanner(System.in);

        boolean found = false;
        System.out.println("\nLaptops");
        System.out.println("==========");
        for (Technology l : list)
        {
            if (l instanceof Laptops)
            {
                found = true;
                System.out.println(l.toString());
            }

        }
        if (!found)
        {
            System.out.println("Sorry , there are no Laptops in stock");
        }

        interestL = interestL + 1;

        scan.nextLine();
    }

    public void buyConsole()
    {
        System.out.print("\f");
        Scanner scan = new Scanner(System.in);

        String model;
        String storage;
        String colour;

        String customerName;
        String email;
        String contactNumber;

        boolean found = false;

        do
        {

            System.out.println("Please enter the model of the console ");
            model = scan.nextLine();

            System.out.println("Please enter the storage size of the console");
            storage = scan.nextLine();

            System.out.println("Please enter the colour of the console");
            colour = scan.nextLine();

            for (Technology t : list) {
                if (t instanceof Console) 
                {
                    Console c = (Console) t;
                    if (model.equalsIgnoreCase(c.getModel()) && storage.equalsIgnoreCase(c.getStorage()) &&  colour.equalsIgnoreCase(c.getColour())) 
                    {
                        if (c.getStock() == 0)
                        {
                            found = true;
                            System.out.println("Sorry this item is out of stock"); 
                        }
                        else 
                        {
                            found = true;

                            System.out.println("To buy " + model + " for a total of " + (c.getPrice()) + "€ , please enter payement details ");
                            System.out.println("Email Adress:");
                            email = scan.nextLine();
                            System.out.println("Contact number"); 
                            contactNumber = scan.nextLine();
                            System.out.println("Card number:");
                            scan.nextLine();
                            System.out.println("Card name :");
                            customerName = scan.nextLine();
                            System.out.println("Expiration :");
                            scan.nextLine();
                            System.out.println("CVC :");
                            scan.nextLine();

                            System.out.println("Thank you for your purchase , Please see your reciept below ");
                            System.out.println("Purchase " + model );
                            System.out.println("Name : " + customerName );
                            System.out.println("Contact Number :" + contactNumber);
                            System.out.println("Email Adress :" + email);
                            System.out.println("Total : "  + "€" + (c.getPrice()));

                            c.setStock(c.getStock() -1);

                            c.setTimesBought(c.getTimesBought() +1);

                            ConsolesSold = ConsolesSold + 1;

                        }
                    }
                }
            }

            if (!found)
            {
                System.out.println("Sorry , this console does not exist please try again");
            }
        }while((!found));
    }

    public void buyLaptop()
    {
        System.out.print("\f");
        Scanner scan = new Scanner(System.in);

        String model;
        String storage;
        String processor;

        String customerName;
        String email;
        String contactNumber;

        boolean found = false;

        do
        {

            System.out.println("Please enter the model of the Laptop ");
            model = scan.nextLine();

            System.out.println("Please enter the storage size of the Laptop");
            storage = scan.nextLine();

            System.out.println("Please enter the processor of the Laptop");
            processor = scan.nextLine();

            for (Technology t : list) {
                if (t instanceof Laptops) 
                {
                    Laptops l = (Laptops) t;
                    if (model.equalsIgnoreCase(l.getModel()) && storage.equalsIgnoreCase(l.getStorage()) &&  processor.equalsIgnoreCase(l.getProcessor())) 
                    {
                        if (l.getStock() == 0)
                        {
                            found = true;
                            System.out.println("Sorry this item is out of stock"); 
                        }
                        else 
                        {
                            found = true;

                            System.out.println("To buy " + model + " for a total of " + (l.getPrice()) + "€ , please enter payement details ");
                            System.out.println("Email Adress:");
                            email = scan.nextLine();
                            System.out.println("Contact number"); 
                            contactNumber = scan.nextLine();
                            System.out.println("Card number:");
                            scan.nextLine();
                            System.out.println("Card name :");
                            customerName = scan.nextLine();
                            System.out.println("Expiration :");
                            scan.nextLine();
                            System.out.println("CVC :");
                            scan.nextLine();

                            System.out.println("Thank you for your purchase , Please see your reciept below ");
                            System.out.println("Purchase " + model );
                            System.out.println("Name : " + customerName );
                            System.out.println("Contact Number :" + contactNumber);
                            System.out.println("Email Adress :" + email);
                            System.out.println("Total : "  + "€" + (l.getPrice()));

                            l.setStock(l.getStock() -1);

                            l.setTimesBought(l.getTimesBought() +1);

                            LaptopsSold = LaptopsSold + 1;

                        }
                    }
                }
            }

            if (!found)
            {
                System.out.println("Sorry , this console does not exist please try again");
            }
        }while((!found));
    }

    /** Staff Menu */
    public void staffMenu()
    {
        Scanner scan = new Scanner(System.in);
        System.out.print("\f");
        int option = 0;

        do
        {
            System.out.print("\f");

            System.out.println("\nO'Riordans Tech-Staff Menu");
            System.out.println("=====================================");
            System.out.println("1.Add a new Console to the stock list\n");
            System.out.println("2.Add a new Laptop to the stock list\n");
            System.out.println("3.Update the Stock number for an existing Console or Laptop\n");
            System.out.println("4.Company Analytics\n");
            System.out.println("5.Exit System\n");

            option = scan.nextInt();

            if (option == 1)
            {
                addConsole();
            }
            if (option == 2)
            {
                addLaptop();
            }
            if (option == 3)
            {
                updateStock();
            }
            if (option == 4)
            {
                companyAnalytics();
            }
            if (option == 5)
            {
                System.out.println("\f");
            }
        }while(option != 5) ;
    }

    public void addConsole()
    {
        System.out.print("\f");
        Scanner scan = new Scanner(System.in);

        String model;
        String storage;
        double price=0;
        String colour;
        String controller;
        boolean headset;
        int stock =0;
        int timesBought =0;

        Console c;

        list = new ArrayList<Technology>();

        System.out.println("\n1.Enter the console model");
        model = scan.nextLine();

        System.out.println("\n2.Enter the consoles storage");
        storage = scan.nextLine();

        System.out.println("\n3.Enter the consoles price");
        price = scan.nextDouble();

        scan.nextLine();

        System.out.println("\n4.Enter the consoles colour");
        colour = scan.nextLine();

        System.out.println("\n4.Enter the consoles controller");
        controller = scan.nextLine();

        System.out.println("\n5.Does the console come with a headset");
        headset = scan.nextBoolean();

        System.out.println("\n6.Enter the amount in stock");
        stock = scan.nextInt();

        /** 2.4 Add the event and its details to the list */
        c = new Console(model, storage, price, stock, timesBought, colour, controller, headset);
        list.add(c);
    }

    public void addLaptop()
    {
        System.out.print("\f");
        Scanner scan = new Scanner(System.in);

        String model;
        String storage;
        double price=0;
        String processor;
        int batteryLife = 0;
        double screenSize = 0;
        int stock = 0;
        int timesBought =0;

        Laptops l;
        list = new ArrayList<Technology>();
        System.out.println("\n1.Enter the laptops model");
        model = scan.nextLine();

        System.out.println("\n2.Enter the Laptops storage");
        storage = scan.nextLine();

        System.out.println("\n3.Enter the Laptops price");
        price = scan.nextDouble();

        scan.nextLine();

        System.out.println("\n4.Enter the Laptops processor");
        processor = scan.nextLine();

        System.out.println("\n4.Enter the Laptops Battery Life");
        batteryLife = scan.nextInt();

        System.out.println("\n5.Does the Laptops screensize");
        screenSize = scan.nextDouble();

        System.out.println("\n6.Enter the amount in stock");
        stock = scan.nextInt();

        /** 2.4 Add the event and its details to the list */
        l = new Laptops(model, storage, price, stock, timesBought, processor, batteryLife, screenSize);
        list.add(l);
    }

    public void updateStock()
    {
        System.out.print("\f");
        Scanner scan = new Scanner(System.in);

        String item;
        String model;
        String storage;
        double price=0;
        String colour;
        String controller;
        boolean headset;
        int updatedStock = 0;

        String processor;
        int batteryLife =0;
        double screenSize =0;

        boolean found = false;
        System.out.println("\nWhich product's stock would you like to update: consoles or laptops?");
        item = scan.nextLine();

        switch (item.toLowerCase()) {
            case "consoles" :

                System.out.println("\nPlease enter the following details regarding the console:");

                System.out.print("\n1. Enter the console model: ");
                model = scan.nextLine();

                System.out.print("\n2. Enter the console's storage: ");
                storage = scan.nextLine();

                System.out.print("\n3. Enter the console's price: ");
                price = scan.nextDouble(); scan.nextLine();

                System.out.print("\n4. Enter the console's colour: ");
                colour = scan.nextLine();

                System.out.print("\n5. Enter the console's controller: ");
                controller = scan.nextLine();

                for (Technology t : list) {
                    if (t instanceof Console) 
                    {
                        Console c = (Console) t;
                        if (model.equalsIgnoreCase(c.getModel()) && storage.equalsIgnoreCase(c.getStorage()) && price == (c.getPrice()) && colour.equalsIgnoreCase(c.getColour()) && controller.equalsIgnoreCase(c.getController()))
                        {
                            found = true;
                            System.out.println("How many have been delivered ?");
                            updatedStock = scan.nextInt();
                            c.setStock(c.getStock() + updatedStock);
                            System.out.println("Stock on this item has been updated to " + c.getStock());
                            scan.nextLine();
                            scan.nextLine();
                        }

                    }
                }

                break;
            case "laptops":
                // code for updating laptop stock
                System.out.println("\nPlease enter the following details regarding the Laptop");

                System.out.println("\n1.Enter the Laptop model");
                model = scan.nextLine();

                System.out.println("\n2.Enter the Laptops storage");
                storage = scan.nextLine();

                System.out.println("\n3.Enter the Laptops price");
                price = scan.nextDouble(); scan.nextLine();

                System.out.println("\n4.Enter the laptops processor");
                processor = scan.nextLine();

                System.out.println("\n4.Enter the Laptops Battery Life");
                batteryLife = scan.nextInt();

                System.out.println("\n5.Enter the Laptops screensize");
                screenSize = scan.nextDouble();

                for (Technology t : list) {
                    if (t instanceof Laptops) 
                    {
                        Laptops l = (Laptops) t;
                        if (model.equalsIgnoreCase(l.getModel()) && storage.equalsIgnoreCase(l.getStorage()) && price == (l.getPrice()) && processor.equalsIgnoreCase(l.getProcessor()) && (l.getBatteryLife() == batteryLife) &&  (l.getScreenSize() == screenSize))
                        {
                            found = true;
                            System.out.println("How many have been delivered ?");
                            updatedStock = scan.nextInt();
                            l.setStock(l.getStock() + updatedStock);
                            System.out.println("Stock on this item has been updated to " + l.getStock());
                            scan.nextLine();
                            scan.nextLine();
                        }
                        else
                        {
                            scan.nextLine();
                        }
                    }
                }

                break;
            default:
                System.out.print("\f");
                System.out.println("Invalid product selected. Please try again.");
                scan.nextLine();
                break;                
        }

        if (!found) 
        {
            System.out.println("This product dosent exist , Please try again");
            scan.nextLine();
        }

    }

    public void companyAnalytics()
    {
        System.out.print("\f");
        Scanner scan = new Scanner(System.in);

        int maxTimesBoughtC =0;
        String modelConMostBought = "";

        int maxTimesBoughtL =0;
        String modelLapMostBought = "";
        
        System.out.println("\nCompanies Analytics");
        System.out.println("============");

        System.out.println("\nTotal laptops sold : " + LaptopsSold);
        System.out.println("\nTotal consoles sold : " + ConsolesSold);

        if (ConsolesSold > LaptopsSold) {
            System.out.println("\nBest selling product : Consoles ");
        } else if (LaptopsSold > ConsolesSold) {
            System.out.println("\nBest selling product : Laptops ");
        } else {
            System.out.println("\nBest selling product : Both laptops and consoles have sold the same amount of products ");
        }

        if (interestC > interestL) {
            System.out.println("\nCustomer interest : Customers are more interested in Consoles ");
        } else if (interestL > interestC) {
            System.out.println ("\nCustomer interest : Customers are more interested in Laptops ");
        } else {
            System.out.println("\nCustomer interest : Analytics show that both Laptops and consoles share  the same amount of interets among customers ");
        }

        for (Technology c : list) {
            if (c instanceof Console) {
                if (c.getTimesBought() > maxTimesBoughtC) {
                    maxTimesBoughtC = c.getTimesBought();
                    modelConMostBought = c.getModel();
                }
            }
        }

        System.out.println("\nMost Popular Console :  " + modelConMostBought + " with " + maxTimesBoughtC + " purchases.");

        for (Technology l : list) {
            if (l instanceof Laptops) {
                if (l.getTimesBought() > maxTimesBoughtL) {
                    maxTimesBoughtL = l.getTimesBought();
                    modelLapMostBought = l.getModel();
                }
            }
        }

        System.out.println("\nMost Popular Laptop :  " + modelLapMostBought + " with " + maxTimesBoughtL + " purchases.");

        scan.nextLine();
    }

    public static void main(String[] args) 
    {
        new Driver();
    }

}

