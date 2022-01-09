public class Customer extends User {
        private boolean vip;


    public Customer(String firstName, String lastName, String userName, String password,boolean vip){
        super(firstName,lastName,userName,password);
        this.vip=vip;
    }

    @Override
    public String toString() {
        if(vip) {
            return super.toString() + " " + "vip!";
        }
        else {
            return super.toString() + "!";
        }
    }

    public boolean isVip() {
        return vip;
    }

    public void setVip(boolean vip) {
        this.vip = vip;
    }
}
