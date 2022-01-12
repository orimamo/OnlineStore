import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Store {
    private Employee[] employees;
    private Customer[] customers;
    private Product[] products;

    public Store() {
        this.employees = new Employee[0];
        this.customers = new Customer[0];
        this.products = new Product[0];
    }

    public void createUser() {
        Scanner scanner = new Scanner(System.in);
        int userType;
        do {
            System.out.println("which user you want create:(1.employees  \n2.customer");
            userType = scanner.nextInt();
        } while (userType != 1 && userType != 2);
        createAccount(userType);

    }

    public void createAccount(int userType) {
        final int EMPLOYEES = 1;
        String firstName;
        String lastName;
        String userName;
        String password;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("enter your firstName:");
        } while (!onlyLetters(firstName = scanner.next()));
        do {
            System.out.println("enter your lastName:");

        } while (!onlyLetters(lastName = scanner.next()));
        do {
            System.out.println("enter your userName:");

        } while (isUsernameExist(userName = scanner.next(), userType));
        do {
            System.out.println("enter your password:");

        } while (!passwordIsProper(password = scanner.next()));
        if (userType == EMPLOYEES) {
            String rank = employeesRank();
            Employee employee = new Employee(firstName, lastName, userName, password, rank);
            addEmployeesToArray(employee);
        } else {
            String result = vip();
            boolean vip;
            if (result == "yes") {
                vip = true;
            } else {
                vip = false;
            }
            Customer customer = new Customer(firstName, lastName, userName, password, vip);
            addCustomerToArray(customer);
        }

    }

    public String employeesRank() {
        final int REGULAR_USER = 1;
        final int MANAGER = 2;
        Scanner scanner = new Scanner(System.in);
        String rank;
        int choise;
        System.out.println("what your rank?:(1-regular_user \n2.manager \n3.Management_team ");
        choise = scanner.nextInt();
        if (choise == REGULAR_USER) {
            rank = "regular_user";
        } else if (choise == MANAGER) {
            rank = "manager";
        } else {
            rank = "Management_team";
        }
        return rank;
    }

    public String vip() {
        Scanner scanner = new Scanner(System.in);
        String vipMember;
        do {
            System.out.println("do you want to be member in vip?:(1.yes\n2.no)");
            vipMember = scanner.next();
        } while (vipMember != "yes" || vipMember != "no");
        return vipMember;
    }

    public boolean onlyLetters(String str) {
        boolean check = false;
        for (int i = 0; i < str.length(); i++) {
            char c1 = str.charAt(i);
            if (Character.isLetter(c1)) {
                check = true;
            } else {
                check = false;
                break;
            }
        }
        return check;
    }

    public boolean isUsernameExist(String userName, int userType) {
        boolean notExists = false;
        if (userType == 1) {
            if (this.employees.length == 0) {
                notExists = false;
            } else {
                for (int i = 0; i < this.employees.length; i++) {
                    if (this.employees[i].getUserName().equals(userName)) {
                        notExists = true;
                        break;
                    }
                }
            }
        } else {
            if (this.customers.length == 0) {
                notExists = false;
            } else {
                for (int i = 0; i < this.customers.length; i++) {
                    if (this.customers[i].getUserName().equals(userName)) {
                        notExists = false;
                        break;
                    }
                }
            }
        }
        return notExists;
    }

    public boolean passwordIsProper(String password) {
        boolean passwordCheck = false;
        if (password.length() >= 6) {
            passwordCheck = true;
        }
        return passwordCheck;
    }

    public void addEmployeesToArray(Employee employee) {
        Employee[] newArray = new Employee[this.employees.length + 1];
        for (int i = 0; i < this.employees.length; i++) {
            newArray[i] = this.employees[i];
        }
        Employee propertyToAdd = employee;
        newArray[this.employees.length] = propertyToAdd;
        this.employees = newArray;
    }

    public void addCustomerToArray(Customer customer) {
        Customer[] newArray = new Customer[this.customers.length + 1];
        for (int i = 0; i < this.customers.length; i++) {
            newArray[i] = this.customers[i];
        }
        Customer propertyToAdd = customer;
        newArray[this.customers.length] = propertyToAdd;
        this.customers = newArray;
    }

    public Object login() {
        Scanner scanner = new Scanner(System.in);
        Object objects = new Object();
        boolean details = false;
        String username = null;
        String password = null;
        int userType;
        System.out.println("which user you are?:1.employees  \n2.customer");
        userType = scanner.nextInt();
        System.out.println("insert your username:");
        username = scanner.next();
        System.out.println("insert your password:");
        password = scanner.next();
        if (isUsernameExist(username, userType)) {
            if (isPasswordCorrect(username, password, userType)) {
                details = true;
            }
        }
        if (details) {
            if (userType == 1) {
                objects = employees[indexOfTheUsername(username, userType)];
            } else {
                objects = customers[indexOfTheUsername(username, userType)];
            }
        } else {
            System.out.println("there isn't user like this");
        }
        return objects;

    }

    public boolean isPasswordCorrect(String username, String password, int userType) {
        boolean passwordCorrect = false;
        if (userType == 1) {
            if (isUsernameExist(username, userType)) {
                int index = indexOfTheUsername(username, userType);
                if (employees[index].getPassword().equals(password)) {
                    passwordCorrect = true;
                }
            }
        } else {
            if (isUsernameExist(username, userType)) {
                int index = indexOfTheUsername(username, userType);
                if (customers[index].getPassword().equals(password)) {
                    passwordCorrect = true;
                }
            }
        }
        return passwordCorrect;
    }

    public int indexOfTheUsername(String username, int userType) {
        int index = -1;
        if (userType == 1) {
            for (int i = 0; i < this.employees.length; i++) {
                User currentUser = this.employees[i];
                if (currentUser.getUserName().equals(username)) {
                    index = i;
                    break;
                }
            }
        } else {
            for (int i = 0; i < this.customers.length; i++) {
                User currentUser = this.customers[i];
                if (currentUser.getUserName().equals(username)) {
                    index = i;
                    break;
                }
            }
        }
        return index;
    }

    public void secondMenu(User user) {


    }

    public void purchase(User user) {
        Scanner scanner = new Scanner(System.in);
        int choose;
        int amount;
        Cart cart = new Cart(user);
        do {
            for (int i = 0; i < this.products.length; i++) {
                System.out.print((i + 1) + "." + this.products[i] + ",");
            }
            System.out.println("choose the number of the product you want to add to cart or -1 to finish");
            choose = scanner.nextInt();
            if ((choose - 1) < this.products.length && choose != -1) {
                cart.addProductToCart(this.products[choose - 1]);
                System.out.println("how much you want:");
                amount = scanner.nextInt();
                cart.addAmount(amount);
                cart.printCart();
                System.out.println(cart.getCost());
            }
        } while (choose != -1);
    }
}
