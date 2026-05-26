public class tryClass {

    
    public static void main(String[] args) {
    int width = 9;
    int length = 6;

    
        try {
        int ratio = width / length;
        System.out.println("Ratio is: " + ratio);
    }
    catch (Exception err) {
        err.getMessage();        
    }    
    }
    
}
