public class App {
    public static void main(String[] args) throws Exception {
        String s1 = "Hello World"; 
        String s2 = s1;
        s1 = "Test";
        s2 = s1;
        System.out.println(s2);
    }
}
