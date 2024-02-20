public class Main {
    public static void main(String[] args) {

        Matrix m1 = new Matrix();
        Matrix m2 = new Matrix(2,4);
        
        m1.setElement(2, 2, 19);
        m1.setElement(2, 1, 14);

        System.out.println(m1.getElement(2, 1));
        System.out.println(m1.getElement(2, 2));

        Matrix m3 = new Matrix(m1);

        System.out.println(m3.getElement(2, 1));
        System.out.println(m3.getElement(2, 2));

        m3.setElement(2, 1, 21);

        System.out.println(m3.getElement(2, 1));
    }
    
}
