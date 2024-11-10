package javajerry;
public class Customer{

    private String name;
    private int idNum;
    
    public Customer(String name, int idNum) {
        this.name = name;
        this.idNum = idNum;
    }

    // An overload constructor
    public Customer(String name, int idNum, String gender) {
        this.name = name;
        this.idNum = idNum;
    }

    public String getName() {
        return this.name;
    }

    // An overload method
    public String getName(int num) {
        return this.name;
    }

    public int getID() {
        return this.idNum;
    }

    public int compareCustomer(Customer other) {
        if (this.getID() > other.getID()) {
            return 1;
        } else if (this.getID() == other.getID()) {
            return 0;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        Customer c1 = new Customer("David", 1001);
        Customer c2 = new Customer("Scott", 1002);
        Customer c3 = new Customer("Ben", 1003);

        // This is an example of overloaded object
        Customer c4 = new Customer("Trump", 100000, "Male");

        System.out.println(c2.compareCustomer(c1));
        System.out.println(c2.compareCustomer(c2));
        System.out.println(c2.compareCustomer(c3));
    }
}
    

    
    
    