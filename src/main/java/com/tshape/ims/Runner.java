package com.tshape.ims;

import com.tshape.ims.model.Customer;
import com.tshape.ims.model.Item;
import com.tshape.ims.repo.CustomerRepo;
import com.tshape.ims.repo.ItemRepo;
import org.apache.commons.logging.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class Runner implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(Runner.class);

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private ItemRepo itemRepo;

    Scanner input = new Scanner(System.in);

    @Override
    public void run(String... args) throws Exception {
        populateData();
        runMainMenu();
    }


    // Not sure why this wont pull out, get a null pointer on the autowired repos
    private void populateData(){
        customerRepo.save(new Customer("Darren"));
        customerRepo.save(new Customer("John"));
        customerRepo.save(new Customer("David"));
        customerRepo.save(new Customer("Grant"));

        itemRepo.save(new Item("item1", 2.20));
        itemRepo.save(new Item("item2", 16.99));
        itemRepo.save(new Item("item3", 1.49));
    }

    private void runMainMenu() {

        int choice;
        while (true) {
            System.out.println("-------------------------------------------");
            System.out.println("Main Menu\n");
            System.out.println("---------------------");
            System.out.print("1.) Customer Actions \n");
            System.out.print("2.) Item Actions \n");
            System.out.print("3.) Order Actions \n");
            System.out.println("---------------------");
            System.out.print("4.) Exit \n");
            System.out.println("-------------------------------------------");

            System.out.print("\nEnter Your Menu Choice: ");

            choice = input.nextInt();

            switch (choice) {

                case 1:
                    logger.info("Customer Actions");
                    CustomerSubMenu();
                    break;
                case 2:
                    logger.info("Item Actions");
                    ItemSubMenu();
                    break;
                case 3:
                    logger.info("Order Actions");
                    OrderSubMenu();
                    break;
                case 4:
                    System.out.println("Exiting");
                    System.exit(0);
                    break;

                default:
                    System.out.println("This is not a valid Menu Option! Please Select Another");
                    break;

            }
        }
    }

    private void CustomerSubMenu(){
        int choice;
        boolean loop = true;
        while (loop) {
            System.out.println("-------------------------------------------");
            System.out.println("Customer Menu\n");
            System.out.println("---------------------");

            System.out.print("1.) Add Customer \n");
            System.out.print("2.) View Customers \n");
            System.out.print("3.) Update Customer \n");
            System.out.print("4.) Delete Customer \n");

            System.out.println("---------------------");

            System.out.print("5.) Back \n");
            System.out.print("6.) Exit \n");

            System.out.println("-------------------------------------------");

            System.out.print("\nEnter Your Menu Choice: ");

            choice = input.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("Customer - Option 1");
                    break;
                case 2:
                    System.out.println("Customer - Option 2");
                    customerRepo.findAll().forEach((customer) -> {
                        System.out.println(customer.getName() + " " + customer.getId());
                    });
                    break;
                case 3:
                    System.out.println("Customer - Option 3");
                    break;
                case 4:
                    System.out.println("Customer - Option 4");
                    break;

                case 5:
                    System.out.println("Going Back");
                    loop = false;
                    break;

                case 6:
                    System.out.println("Exiting");
                    System.exit(0);
                    break;

                default:
                    System.out.println("This is not a valid Menu Option! Please Select Another");
                    break;

            }
        }
    }

    private void ItemSubMenu(){
        int choice;
        boolean loop = true;
        while (loop) {
            System.out.println("-------------------------------------------");
            System.out.println("Items Menu\n");
            System.out.println("---------------------");

            System.out.print("1.) Add Item \n");
            System.out.print("2.) View Items \n");
            System.out.print("3.) Update Item \n");
            System.out.print("4.) Delete Item \n");

            System.out.println("---------------------");

            System.out.print("5.) Back \n");
            System.out.print("6.) Exit \n");

            System.out.println("-------------------------------------------");

            System.out.print("\nEnter Your Menu Choice: ");

            choice = input.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("Item - Option 1");
                    break;
                case 2:
                    System.out.println("Item - Option 2");
                    itemRepo.findAll().forEach((item) -> {
                        System.out.println(item.getName() + " " + item.getCost() + " " + item.getId());
                    });
                    break;
                case 3:
                    System.out.println("Item - Option 3");
                    break;
                case 4:
                    System.out.println("Item - Option 4");
                    break;

                case 5:
                    System.out.println("Going Back");
                    loop = false;
                    break;

                case 6:
                    System.out.println("Exiting");
                    System.exit(0);
                    break;

                default:
                    System.out.println("This is not a valid Menu Option! Please Select Another");
                    break;

            }
        }
    }

    private void OrderSubMenu(){
        int choice;
        boolean loop = true;
        while (loop) {
            System.out.println("-------------------------------------------");
            System.out.println("Order Menu\n");
            System.out.println("---------------------");
            System.out.print("1.) Create Order \n");
            System.out.print("2.) View Orders \n");
            System.out.print("3.) Delete Order \n");
            System.out.print("4.) Add Item to Order \n");
            System.out.print("5.) Calculate Cost of Order \n");
            System.out.print("6.) Remove Item from Order\n");
            System.out.println("---------------------");
            System.out.print("7.) Back \n");
            System.out.print("8.) Exit \n");
            System.out.println("-------------------------------------------");

            System.out.print("\nEnter Your Menu Choice: ");

            choice = input.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("Order - Option 1");
                    break;
                case 2:
                    System.out.println("Order - Option 2");
                    break;
                case 3:
                    System.out.println("Order - Option 3");
                    break;
                case 4:
                    System.out.println("Order - Option 4");
                    break;
                case 5:
                    System.out.println("Order - Option 5");
                    break;
                case 6:
                    System.out.println("Order - Option 6");
                    break;

                case 7:
                    System.out.println("Going Back");
                    loop = false;
                    break;

                case 8:
                    System.out.println("Exiting");
                    System.exit(0);
                    break;

                default:
                    System.out.println("This is not a valid Menu Option! Please Select Another");
                    break;

            }
        }
    }


}
