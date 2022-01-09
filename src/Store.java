import java.util.Scanner;

public class Store {
    private Employee[] employees;
    private Customer[] customers;
    private Product[] products;

    public void createUser(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("which user you want create:(1.employees  \n2.customer");
        int usertype=scanner.nextInt();
        if(usertype==1){
            createEmployees();
        }

    }
    public void createEmployees(){
        String firstName;
        String lastName;
        String userName;
        String password;
        String rank1 = "";
        int rank;
        Employee employee;
        Scanner scanner=new Scanner(System.in);
        System.out.println("enter your firstName:");
        boolean a=onlyLetters(firstName=scanner.next());
        System.out.println("enter your lastName:");
        boolean b=onlyLetters(lastName=scanner.next());
        System.out.println("enter your userName:");
        boolean c=notExists(userName=scanner.next());
        System.out.println("enter your password:");
        boolean d=passwordIsProper(password=scanner.next());
        do {
            System.out.println("what your rank?:(1-regular_user\n2.manager\n3.Management_team");
            rank = scanner.nextInt();
        }
        while (rank<1 || rank>3);
        if(rank==1){
            rank1="regular_user";

        }
        if(rank==2){
            rank1="manager";

        }
        if(rank==3){
            rank1="Management_team";
        }
        if(a && b && c && d){
            addEmployeesToArray(employee= new Employee(firstName,lastName,userName,password,rank1));
        }
    }
    public void create_customer(){

    }
    public boolean onlyLetters(String str){
        boolean check=false;
        for (int i=0;i<str.length();i++){
            char c1=str.charAt(i);
            if (Character.isLetter(c1)){
                check=true;
            }
            else {
                check=false;
                break;
            }
        }
        return check;
    }

    public boolean notExists(String userName){
        boolean notExists=true;
        for (int i=0;i<employees.length;i++){
            if(employees[i].getUserName().equals(userName)){
                notExists=false;
                break;
            }
        }
        return notExists;
    }
    public boolean passwordIsProper(String password){
        boolean passwordCheck=false;
        if (password.length()>=6){
            passwordCheck=true;
        }
        return passwordCheck;
    }
    public void addEmployeesToArray(Employee employee){
        Employee[] newArray = new Employee[this.employees.length + 1];
        for (int i = 0; i < this.employees.length; i++) {
            newArray[i] = this.employees[i];
        }
        Employee propertyToAdd = employee;
        newArray[this.employees.length] = propertyToAdd;
        this.employees = newArray;
    }
}
