public abstract class User {
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private Cart [] carts;

    public User(String firstName, String lastName, String userName, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.carts=new Cart[0];
    }

    public String toString() {
        return "hello " + firstName + " " + lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public Cart[] getCarts() {
        return carts;
    }

    public void setCarts(Cart[] carts) {
        this.carts = carts;
    }
    public void addUserCart(Cart cart){
        Cart [] carts1=new Cart[this.carts.length+1];
        for (int i = 0; i < this.carts.length; i++) {
            carts1[i] = this.carts[i];
        }
        Cart propertyToAdd = cart;
        carts1[this.carts.length] = propertyToAdd;
        this.carts = carts1;
        }


}
