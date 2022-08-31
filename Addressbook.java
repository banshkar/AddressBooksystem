import jdk.swing.interop.SwingInterOpUtils;
import java.util.Scanner;
import java.util.*;
class Persion{
    private int ID;
    private String fullName;
    private String email;
    private String city;
    private String state;
    private String zipcode;
    private String phoneNumber;
    Persion(int ID,String fullName, String email,String city,String state,String zipcode,String phoneNumber){
        this.ID=ID;
        this.fullName=fullName;
        this.email=email;
        this.city=city;
        this.state=state;
        this.zipcode=zipcode;
        this.phoneNumber=phoneNumber;
     }
     public  static int autoid(){
         String id="";
         int auto_id=0;
         String alphabet = "123456789";
         java.util.Random r = new java.util.Random();
         for(int i=1; i<=5; i++){
             char c = alphabet.charAt((r.nextInt(alphabet.length())));
             id = String.valueOf(c)+id;
             auto_id = auto_id+Integer.parseInt(id);
         }
       return auto_id;
     }
     public int getID(){
         return ID;
     }
     public String getFullName(){
         return fullName;
     }
     public String getEmail(){
         return email;
     }
     public String getCity() {
         return city;
     }
     public String getState(){
         return state;
     }
     public String getZipcode(){
         return zipcode;
     }
     public String getPhoneNumber(){
         return phoneNumber;
     }
     public String toString(){
         String details = ID+" "+fullName+" "+email+" "+city+" "+state+" "+zipcode+" "+phoneNumber;
         return details;
      }
 }
public class Addressbook{
    public static void main(String[] args) {
        System.out.println();
        System.out.println("................WELCOME TO ADDRESS BOOk SYSTEM...........");
        List<Persion> list = new ArrayList<Persion>();
        int choice;
        do {
            System.out.println("1. Add new Persion");
            System.out.println("2. Display Details ");
            System.out.println("3.Search ");
            System.out.println("4.Delete ");
            System.out.println("5.Update");
            System.out.println("0.Exit");
            System.out.println("your choice option here enter number");
            Scanner sc = new Scanner(System.in);
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    String fullNam;
                    int id = Persion.autoid();
                    String fullName = sc.nextLine();
                    System.out.println("Enter first name :");
                    String firstName = sc.nextLine();
                    System.out.println("Enter last name :");
                    String lastname = sc.nextLine();
                    System.out.println("Enter  email :");
                    String email = sc.nextLine();
                    System.out.println("Enter city name :");
                    String city = sc.nextLine();
                    System.out.println("Enter state name :");
                    String state = sc.nextLine();
                    System.out.println("Enter zipcode  :");
                    String zipcode = sc.nextLine();
                    System.out.println("Enter phone Number :");
                    String phoneNumber = sc.nextLine();
                    fullNam = firstName+" "+lastname;
                    list.add(new Persion(id, fullNam, email, city, state, zipcode, phoneNumber));
                    System.out.println("Your ID is " + id + " " + " save ");
                    System.out.println("your details add successfully");
                    break;
                case 2:
                    System.out.println(".......................");
                    Iterator<Persion> i = list.iterator();
                    while (i.hasNext()){
                        Persion p = i.next();
                        System.out.println(p);
                    }
                    System.out.println(".......................");
                    break;
                case 3:
                     boolean found = false;
                     System.out.println("Enter your id to Search");
                     int  Id =sc.nextInt();
                     System.out.println(".......................");
                     i = list.iterator();
                     while (i.hasNext()){
                        Persion p = i.next();
                        if(p.getID()== Id){
                            System.out.println(p);
                            found = true;
                        }
                    }
                     if(!found){
                         System.out.println("Record Not  Found");
                         System.out.println();
                     }
                    System.out.println(".......................");
                    break;
                case 4:
                     found = false;
                     System.out.println("Enter your id to Search");
                     Id =sc.nextInt();
                     i = list.iterator();
                     while (i.hasNext()){
                        Persion p = i.next();
                        if(p.getID()== Id){
                           i.remove();
                           found = true;
                        }
                     }
                     if(!found){
                        System.out.println("Record Not  Found");
                        System.out.println();
                     }
                     else{
                        System.out.println("Record is Deleted successfully....!");
                         System.out.println();
                     }
                    break;
                case 5:
                    found = false;
                    System.out.println("Enter your id to Search");
                    Id =sc.nextInt();
                    ListIterator<Persion> listN= list.listIterator();
                    while (listN.hasNext()){
                        Persion p = listN.next();
                        if(p.getID()== Id){
                            String line = sc.nextLine();
                            System.out.println("Enter New id");
                            id = sc.nextInt();
                            String line_1 = sc.nextLine();
                            System.out.println("Enter new  full name :");
                            fullNam = sc.nextLine();
                            System.out.println("Enter new   email :");
                            email = sc.nextLine();
                            System.out.println("Enter new city name :");
                            city = sc.nextLine();
                            System.out.println("Enter new  state name :");
                            state = sc.nextLine();
                            System.out.println("Enter new  zipcode  :");
                            zipcode = sc.nextLine();
                            System.out.println("Enter  new  phone Number :");
                            phoneNumber = sc.nextLine();
                            listN.set(new Persion(id,fullNam,email,city,state,zipcode,phoneNumber));
                            found = true;
                        }
                    }
                    if(!found){
                        System.out.println("Record Not  Found");
                        System.out.println();
                    }
                    else{
                        System.out.println("Record is Update successfully....!");
                        System.out.println();
                    }
                    break;
            }
        }while (choice!=0);
    }
}
