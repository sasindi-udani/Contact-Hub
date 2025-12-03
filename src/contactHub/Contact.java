/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package contactHub;

/**
 *
 * @author Sasindi
 */
public class Contact {
    private static String id;
    private static String name;
    private static String phoneNumber;
    private static String company;
    private static double salary;
    private static String birthday;
    
    public Contact(){}
    public Contact(String id,String name,String phoneNumber,String company,double salary,String birthday){
        this.id=id;
        this.name=name;
        this.phoneNumber=phoneNumber;
        this.company=company;
        this.salary=salary;
        this.birthday=birthday;
    }
    
    public String getId(){
        return this.id;
    }
    public String getName(){
        return this.name;
    }
    public String getPhoneNumber(){
        return this.phoneNumber;
    }
    public String getCompany(){
        return this.company;
    }
    public double getSalary(){
        return this.salary;
    }
    public String getBirthday(){
        return this.birthday;
    }
            
    
}
