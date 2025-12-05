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
import java.time.*;

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
        String birthday;
        double salary = 0.0;
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

            L4:
            do{
                try{
                    System.out.print("Enter your salary -> ");
                    salary = input.nextDouble();
                }catch(Exception ex){
                    System.out.println("Salary format is incorrect!!");
                    salary=0.0;
                    input.nextLine();
                    continue L4;
                }
            }while(salary ==0.0);
            
            L3:
            do {
                System.out.print("Enter your Birthday (YYYY-MM-DD) -> ");
                birthday = input.next();

                if (!isValidBirthday(birthday)) {
                    System.out.println("Birthday is invalid!!");
                    System.out.print("Do you want to add again? (y/n)");
                    char replyBirthday = input.next().charAt(0);
                    if (replyBirthday == 'Y' || replyBirthday == 'y') {
                        continue L3;
                    } else if (replyBirthday == 'N' || replyBirthday == 'n') {
                        menu();
                        break;
                    } else {
                        menu();
                        break;
                    }
                }
            } while (!isValidBirthday(birthday));

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

    public static boolean isValidBirthday(String birthday) {
        String year;                        //yyyy-mm-dd
        String month;                       //0123456789
        String date;
        try {
            year = birthday.substring(0, 4);                        //yyyy-mm-dd
            month = birthday.substring(5, 7);                       //0123456789
            date = birthday.substring(8, 10);
        } catch (Exception ex) {
            System.out.println("Date format is incorrect");
            return false;
        }
        int yearNew;
        int monthNew;
        int dayNew;
        try {
            yearNew = Integer.parseInt(year);
            monthNew = Integer.parseInt(month);
            dayNew = Integer.parseInt(date);
        } catch (Exception ex) {
            System.out.println("Birthday is Invalid!!!");
            return false;
        }
        if ((monthNew > 12) || (monthNew < 1) || (dayNew < 1)) {
            return false;
        }

        LocalDate currentDate = LocalDate.now();
        int currentYear = currentDate.getYear();
        int currentMonth = currentDate.getMonthValue();
        int currentDay = currentDate.getDayOfMonth();
        if (yearNew > currentYear) {
            return false;
        } else if (yearNew == currentYear) {
            if (monthNew > currentMonth) {
                return false;
            } else if (monthNew == currentMonth) {
                if (dayNew > currentDay) {
                    return false;
                }
            }
        }
        if (((monthNew == 2) || (monthNew == 02)) && (yearNew % 4 != 0)) {
            if (dayNew > 28) {
                return false;
            }
        }
        if ((yearNew % 4 == 0) && (yearNew % 100 != 0) && ((monthNew == 2) || (monthNew == 02))) {
            if (dayNew > 29) {
                return false;
            }
        }
        if ((monthNew == 1) || (monthNew == 3) || (monthNew == 5) || (monthNew == 7) || (monthNew == 10) || (monthNew == 12) || (monthNew == 8)) {
            if (dayNew > 31) {
                return false;
            }
        }
        if ((monthNew == 4) || (monthNew == 6) || (monthNew == 9) || (monthNew == 11)) {
            if (dayNew > 30) {
                return false;
            }
        }
        return true;
    }

    public static boolean isValidPhoneNumber(String phoneNumber) {
        if (phoneNumber.charAt(0) == '0' && phoneNumber.length() == 10) {
            for (int i = 1; i < phoneNumber.length(); i++) {
                if (Character.isDigit(phoneNumber.charAt(i))) {
                    return true;
                }
            }
        }
        return false;
    }

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

    public static void viewContacts() {
        System.out.println("\n=============================================================================================");
        System.out.printf("%-10s%-20s%-15s%-20s%-15s%-15s", "ID", "Name", "Phone Number", "Company", "Salary", "Birthday");
        for (int i = 0; i < contactsArray.length; i++) {
            System.out.print("\n\n");
            System.out.printf("%-10s%-20s%-15s%-20s%-15f%-15s", contactsArray[i].getId(), contactsArray[i].getName(), contactsArray[i].getPhoneNumber(), contactsArray[i].getCompany(), contactsArray[i].getSalary(), contactsArray[i].getBirthday());
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
