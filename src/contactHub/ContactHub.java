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

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("                               Contact Hub                                    ");
        System.out.println("                           Contacts Organizer                                 ");
        menu();
    }
    
    public static void menu(){
        Scanner input = new Scanner(System.in);
        System.out.println("==================================================================================");
        System.out.println("\n[01] Add Contacts");
        System.out.println("[02] Update Contacts");
        System.out.println("[03] Delete Contacts");
        System.out.println("[04] Search Contacts");
        System.out.println("[05] List Contacts");
        System.out.println("[06] Exit");
        
        System.out.print("Enter an option to continue -> ");
        int x= input.nextInt();
        
        if(x == 1 || x==01){
            //addContact();
        }else if(x == 2 || x==02){
            //updateContact();
        }else if(x == 3 || x==03){
            //deleteContact();
        }else if(x == 4 || x==04){
            //searchContact();
        }else if(x == 5 || x==05){
            //listContact();
        }else if(x == 6 || x==06){
            //exit();
        }else{
            System.out.println("\n                  WARNING!!               ");
            System.out.println("Your input is incorrect. Please try again.");
            menu();
        }
        
        System.out.println("==================================================================================");

    }
    
}
