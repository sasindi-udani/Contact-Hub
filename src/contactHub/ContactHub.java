/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package contactHub;

/**
 *
 * @author Sasindi
 */
import java.util.*;

public class ContactHub {

    static Contact[] contactsArray = new Contact[0];

    public static void main(String[] args) {
        System.out.println("                               Contact Hub                                    ");
        System.out.println("                           Contacts Organizer                                 ");
        menu();
    }

    public static void menu() {
        Scanner input = new Scanner(System.in);
        System.out.println("\n\n                           Menu                                 ");
        System.out.println("==================================================================================");
        System.out.println("\n[01] Add Contacts");
        System.out.println("[02] Update Contacts");
        System.out.println("[03] Delete Contacts");
        System.out.println("[04] Search Contacts");
        System.out.println("[05] List Contacts");
        System.out.println("[06] View Contacts");
        System.out.println("[07] Exit");
        

        System.out.print("Enter an option to continue -> ");
        int x = input.nextInt();

        if (x == 1 || x == 01) {
            addContact();
        } else if (x == 2 || x == 02) {
            //updateContact();
        } else if (x == 3 || x == 03) {
            //deleteContact();
        } else if (x == 4 || x == 04) {
            //searchContact();
        } else if (x == 5 || x == 05) {
            //listContact();
        } else if (x == 6 || x == 06) {
            viewContacts();
        } else if (x == 7 || x == 07) {
            //exit();
        } else {
            System.out.println("\n                  WARNING!!               ");
            System.out.println("Your input is incorrect. Please try again.");
            menu();
        }

    }

    public static void extendsArray() {
        Contact[] tempContactArray = new Contact[contactsArray.length + 1];
        for (int i = 0; i < contactsArray.length; i++) {
            tempContactArray[i] = contactsArray[i];
        }
        contactsArray = tempContactArray;
    }

    public static void addContact() {
        Scanner input = new Scanner(System.in);
        String phoneNumber;
        System.out.println("               ADD CONTACT INTO THE LIST        ");
        L1:
        do {
            String id = generateID();
            System.out.println("============================");
            System.out.println("Contact ID : " + id);
            System.out.println("============================");
            System.out.print("Enter name -> ");
            String name = input.next();

            L2:
            do {
                System.out.print("Enter Mobile Number -> ");
                phoneNumber = input.next();
                if (!isValidPhoneNumber(phoneNumber)) {
                    System.out.println("Phone number is invalid!!");
                    System.out.print("Do you want to add again? (y/n)");
                    char replyNumber = input.next().charAt(0);
                    if (replyNumber == 'Y' || replyNumber == 'y') {
//                        System.out.print("\033[3A");
//                        // Clear the lines 
//                        System.out.print("\033[0J");
                        continue L2;
                    } else if (replyNumber == 'N' || replyNumber == 'n') {
                        menu();
                        break;
                    } else {
                        menu();
                        break;
                    }
                }
            } while (!isValidPhoneNumber(phoneNumber));

            System.out.print("Enter your company name -> ");
            String company = input.next();
            System.out.print("Enter your salary -> ");
            double salary = input.nextDouble();
            
            System.out.print("Enter your Birthday -> ");
            String birthday = input.next();
            
            extendsArray();
            Contact c1 = new Contact(id, name, phoneNumber, company, salary, birthday);
            contactsArray[contactsArray.length - 1] = c1;
            System.out.println(name + " added to the system successfully");
            System.out.print("Do you want to add another contact? (y/n)");
            char reply = input.next().charAt(0);
            if (reply == 'Y' || reply == 'y') {
                continue L1;
            } else if (reply == 'N' || reply == 'n') {
                menu();
            } else {
                menu();
            }
        } while (true);
    }

    public static boolean isValidPhoneNumber(String phoneNumber) {
        if (phoneNumber.charAt(0) == '0' && phoneNumber.length() == 10) {
            for (int i = 1; i < phoneNumber.length(); i++) {
                if (Character.isDigit(phoneNumber.charAt(i))){
                    return true;
                }
            }
        }
        return false;
    }
    
//    public static boolean isValidBirthday(String birthday){
//        
//    }

    public static String generateID() {
        String id = null;
        if (contactsArray.length == 0) {
            return "C0001";
        } else {
            id = contactsArray[contactsArray.length - 1].getId();
            int lastNo = Integer.parseInt(id.substring(1));
            return String.format("C%04d", lastNo + 1);
        }
    }
    
    public static void viewContacts(){
        System.out.println("\n=============================================================================================");
        System.out.printf("%-10s%-20s%-15s%-20s%-15s%-15s", "ID","Name","Phone Number","Company","Salary","Birthday");
        for(int i=0;i<contactsArray.length;i++){
            System.out.print("\n\n");
            System.out.printf("%-10s%-20s%-15s%-20s%-15f%-15s", contactsArray[i].getId(),contactsArray[i].getName(),contactsArray[i].getPhoneNumber(),contactsArray[i].getCompany(),contactsArray[i].getSalary(),contactsArray[i].getBirthday());
        }
        System.out.println("\n=============================================================================================");
        menu();
    }

//    public final static void clearConsole() {
//        try {
//            final String os = System.getProperty("os.name");
//            if (os.contains("Windows")) {
//                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
//            } else {
//                System.out.print("\033[H\033[2J");
//                System.out.flush();
//            }
//        } catch (final Exception e) {
//            e.printStackTrace();
//        }
//    }
}
