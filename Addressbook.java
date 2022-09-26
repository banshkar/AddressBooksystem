import java.util.*;
import java.util.stream.Collectors;
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
         String details = ID+" = "+fullName+" = "+email+" = "+city+" = "+state+" = "+zipcode+" = "+phoneNumber;
         return details;
      }
    public String getFullName(Persion persion) {
        return persion.getFullName();
    }
    public String getCity(Persion persion) {
        return persion.getCity();
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
            System.out.println("6.counting");
            System.out.println("7.sorting by Name");
            System.out.println("8.sorting by city");
            System.out.println("9.sorting by state");
            System.out.println("10.sorting by zipcode");
            System.out.println("0.Exit");
            System.out.println("your choice option here enter number");
            Scanner sc = new Scanner(System.in);
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    boolean found =false;
                    String fullName;
                    String fullNam = sc.nextLine();
                    System.out.println("Enter first name :");
                    String firstName = sc.nextLine();
                    System.out.println("Enter last name :");
                    String lastname = sc.nextLine();
                    fullName = firstName+" "+lastname;
                    Iterator<Persion> iterator= list.iterator();
                    while (iterator.hasNext()){
                        Persion persion = iterator.next();
                        if(persion.getFullName().equals(fullName)){
                            found=true;
                        }
                    }
                    if(!found){
                        int id = Persion.autoid();
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
                        list.add(new Persion(id, fullName, email, city, state, zipcode, phoneNumber));
                        System.out.println("Your ID is " + id + " " + " save ");
                        System.out.println("your details add successfully");
                    }
                    else {
                        System.out.println("exit");
                    }
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
                      found = false;
                     System.out.println("Enter your Name or city or state to Search");
                     String  check =sc.nextLine();
                     System.out.println(".......................");
                     i = list.iterator();
                     while (i.hasNext()){
                        Persion p = i.next();
                        if(p.getFullName().equals(check)||p.getCity().equals(check)||p.getState().equals(check)){
                            System.out.println("name:"+p.getFullName()+"City: "+p.getCity()+"state: "+p.getState());
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
                    int Id =sc.nextInt();
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
                            int id = sc.nextInt();
                            String line_1 = sc.nextLine();
                            System.out.println("Enter new  full name :");
                            fullNam = sc.nextLine();
                            System.out.println("Enter new   email :");
                            String email = sc.nextLine();
                            System.out.println("Enter new city name :");
                            String  city = sc.nextLine();
                            System.out.println("Enter new  state name :");
                            String  state = sc.nextLine();
                            System.out.println("Enter new  zipcode  :");
                            String  zipcode = sc.nextLine();
                            System.out.println("Enter  new  phone Number :");
                            String  phoneNumber = sc.nextLine();
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
                case 6:
                    Iterator<Persion> iterator_second= list.iterator();
                    long countCity=0;
                    long countPersion=0;
                    long countState=0;
                    while (iterator_second.hasNext()){
                        Persion persion =iterator_second.next();
                     countCity=  list.stream().filter(city -> persion.getCity()!=null).count();
                     countPersion=  list.stream().filter(city -> persion.getCity()!=null).count();
                     countState=  list.stream().filter(city -> persion.getCity()!=null).count();
                    }
                    System.out.println("city :"+countCity);
                    System.out.println("state :"+countState);
                    System.out.println("Persion :"+countPersion);
                    break;
                case 7:
                    List<Persion> sortedByName =list.stream().sorted(Comparator.comparing(Persion::getFullName)).collect(Collectors.toList());
                    for(int index=0; index<sortedByName.size(); index++){
                        System.out.println(sortedByName.get(index));
                    }
                   break;
                case 8:
                    List<Persion> sortedByCity =list.stream().sorted(Comparator.comparing(Persion::getCity)).collect(Collectors.toList());
                    for(int index=0; index<sortedByCity.size(); index++){
                        System.out.println(sortedByCity.get(index));
                    }
                    break;
                case 9:
                    List<Persion> sortedByState =list.stream().sorted(Comparator.comparing(Persion::getState)).collect(Collectors.toList());
                    for(int index=0; index< sortedByState.size(); index++){
                        System.out.println( sortedByState.get(index));
                    }
                    break;
                case 10:
                    List<Persion> sortedByZipPin =list.stream().sorted(Comparator.comparing(Persion::getZipcode)).collect(Collectors.toList());
                    for(int index=0; index<sortedByZipPin.size(); index++){
                        System.out.println(sortedByZipPin.get(index));
                    }
                    break;
            }
        }while (choice!=0);
    }
}
