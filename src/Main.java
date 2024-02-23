public class Main {
    public static void main(String[] args) {

        Matrix m1 = new Matrix();
        Matrix m2 = new Matrix(2,4);
        
        m1.setElement(1, 1, 19);
        m1.setElement(1, 0, 14);


        Matrix m3 = new Matrix(m1);
    }
    
}
