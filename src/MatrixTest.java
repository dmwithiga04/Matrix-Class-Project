import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Scanner;

/**
 * A set of JUnit tests for the Matrix class.
 *
 * @author David Wolff
 */
public class MatrixTest {

    private Matrix twoByTwo, m1, m2, nonSquare, nonSquare2;

    /** 
     * The setUp method executes prior to each test method.  It creates a few
     * Matrix objects that can be used in tests.
     */ 
    @Before
    public void setUp() {
        twoByTwo = new Matrix();
        m1 = buildMatrix(3, 3, "1 2 3 4 5 6 7 8 9");
        m2 = buildMatrix(3, 3, "9 8 7 6 5 4 3 2 1");
        nonSquare = buildMatrix(4, 3, "1 2 3 3 2 1 1 2 3 3 2 1");
        nonSquare2 = buildMatrix(4, 3, "3 -1 2 0 1 0 0 1 1 1 1 1");
    }

    /**
     * This is a helper method used to create a Matrix object from a String
     * @param rows number of rows
     * @param cols number of columns
     * @param data a string containing the data for the Matrix in row-major order
     * @return a Matrix object of the given dimensions with data taken from the String parameter.
     */
    private Matrix buildMatrix(int rows, int cols, String data ) {
        Matrix m = new Matrix(rows, cols);
        Scanner scan = new Scanner(data);
        for( int r = 0; r < rows; r++ )
            for( int c = 0; c < cols; c++ )
                m.setElement(r,c,scan.nextInt());
        return m;
    }

    /**
     * Test that the default constructor creates a 2x2 matrix with zeros.
     */
    @Test
    public void testDefaultConstructor() {
        Assert.assertEquals(2, twoByTwo.getRows());
        Assert.assertEquals(2, twoByTwo.getColumns());
        for( int i = 0; i < 2; i++ )
            for( int j = 0; j < 2; j++ )
                Assert.assertEquals(0, twoByTwo.getElement(i, j));
    }

    /**
     * Test the (int, int) constructor with a 1x1 matrix.
     */
    @Test
    public void testMatrixConstructorIntInt01() {
        Matrix m = new Matrix(1, 1);

        Assert.assertEquals(1, m.getRows());
        Assert.assertEquals(1, m.getColumns());
    }

    /**
     * Test the (int, int) constructor with a 5x7 matrix.
     */
    @Test
    public void testMatrixConstructorIntInt02() {
        Matrix m2 = new Matrix(5, 7);

        Assert.assertEquals(5, m2.getRows());
        Assert.assertEquals(7, m2.getColumns());
    }

    /**
     * The (int, int) constructor should throw IllegalArgumentException
     * if given a negative value for the number of rows.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testMatrixConstructorIntInt03() {
        Matrix m3 = new Matrix(-1, 11);
    }

    /**
     * The (int, int) constructor should throw IllegalArgumentException
     * if given a negative value for the number of columns.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testMatrixConstructorIntInt04() {
        Matrix m3 = new Matrix(2, -1);
    }

    /**
     * The (int, int) constructor should throw IllegalArgumentException
     * if given a zero value for the number of rows.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testMatrixConstructorIntInt05() {
        Matrix m3 = new Matrix(0,1);
    }

    /**
     * The (int, int) constructor should throw IllegalArgumentException
     * if given a zero value for the number of columns.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testMatrixConstructorIntInt06() {
        Matrix m3 = new Matrix(2,0);
    }

    /**
     * The constructor with a Matrix parameter should make a deep copy 
     * of the parameter.
     */
    @Test
    public void testMatrixConstructorMatrix() {
        Matrix m1 = buildMatrix(2, 3, "1 2 3 4 5 6");
        Matrix m = new Matrix(m1);

        // Verify that it is the same size and content
        Assert.assertTrue( Matrix.isEqual(m, m1) );

        // Verify that it is not a shallow copy by modifying one element.
        m1.setElement(0, 0, 42);
        Assert.assertFalse( Matrix.isEqual(m, m1) );
    }

    /**
     * Matrix.isEqual() should return true when the matrices have the same
     * content and dimensions.
     */
    @Test 
    public void testIsEqual01() {
        Matrix m1 = buildMatrix(2, 3, "1 2 3 4 5 6");
        Matrix m2 = buildMatrix(2, 3, "1 2 3 4 5 6");
        Assert.assertTrue( Matrix.isEqual(m1, m2) );
    }

    /**
     * Matrix.isEqual() should return false when the matrices have different
     * content, but same dimensions.
     */
    @Test 
    public void testIsEqual02() {
        Matrix m1 = buildMatrix(2, 3, "1 2 3 4 5 6");
        Matrix m2 = buildMatrix(2, 3, "1 2 3 4 5 0");
        Assert.assertFalse( Matrix.isEqual(m1, m2) );
    }

    /**
     * Matrix.isEqual() should return false when the matrices have similar
     * content, but different dimensions.
     */
    @Test 
    public void testIsEqual03() {
        Matrix m1 = buildMatrix(2, 3, "1 2 3 4 5 6");
        Matrix m2 = buildMatrix(3, 2, "1 2 3 4 5 6");
        Assert.assertFalse( Matrix.isEqual(m1, m2) );
    }

    /**
     * setElement should change the value of an element within the matrix.
     */
    @Test
    public void testSetElement01() {
        m1.setElement(2, 1, -79);
        Assert.assertEquals(-79, m1.getElement(2, 1));
    }

    /**
     * setElement should change the value of an element within the matrix.
     */
    @Test
    public void testSetElement02() {
        m1.setElement(0, 0, 42);
        Assert.assertEquals(42, m1.getElement(0, 0));
    }

    /**
     * setElement should throw an exception if an invalid row or column is provided.
     */
    @Test(expected=IllegalArgumentException.class)
    public void testSetElement03() {
        // Invalid row
        m1.setElement(3, 0, 42);
    }

    /**
     * plus(Matrix) should add components together.
     */
    @Test
    public void testPlus01() {
        Matrix result = m1.plus(m2);
        Matrix expected = buildMatrix(3, 3, "10 10 10 10 10 10 10 10 10");
        Assert.assertTrue(Matrix.isEqual(expected, result));
    }

    /**
     * plus(Matrix) should add matrix components together
     */
    @Test
    public void testPlus02() {
        Matrix result = nonSquare.plus(nonSquare2);
        Matrix expected = buildMatrix(4, 3, "4 1 5 3 3 1 1 3 4 4 3 2");
        Assert.assertTrue(Matrix.isEqual(expected, result));
    }

    /**
     * plus(Matrix) should throw an IllegalArgumentException if the dimensions of
     * this and the parameter are not the same.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testPlus03() {
        Matrix result = nonSquare.plus(m1);
    }

    /**
     * minus(Matrix) should subtract matrix components
     */
    @Test
    public void testMinus01() {
        Matrix result = m1.minus(m2);
        Matrix expected = buildMatrix(3, 3, "-8 -6 -4 -2 0 2 4 6 8");
        Assert.assertTrue(Matrix.isEqual(expected, result));
    }

    /**
     * minus(Matrix) should subtract matrix components
     */
    @Test
    public void testMinus02() {
        Matrix result = nonSquare.minus(nonSquare2);
        Matrix expected = buildMatrix(4, 3, "-2 3 1 3 1 1 1 1 2 2 1 0");
        Assert.assertTrue(Matrix.isEqual(expected, result));
    }

    /**
     * minus(Matrix) should throw an IllegalArgumentException when the dimensions do
     * not match.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testMinus03() {
        Matrix result = nonSquare.minus(m1);
    }

    /**
     * toString() should return a String representation of the matrix
     */
    @Test
    public void testToString01() {
        String expected = "1 2 3\n" +
                          "4 5 6\n" +
                          "7 8 9";
        Assert.assertEquals(expected, m1.toString());
    }

    /**
     * toString() should return a String representation of the matrix
     */
    @Test
    public void testToString02() {
        String expected = "1 2 3\n" +
                          "3 2 1\n" +
                          "1 2 3\n" +
                          "3 2 1";
        Assert.assertEquals(expected, nonSquare.toString());
    }

    /**
     * isDiagonal() should return true with a 3x3 matrix that has all zeroes
     * except along the diagonal
     */
    @Test
    public void testIsDiagonal01() {
        Matrix m = buildMatrix(3, 3, "1 0 0 0 1 0 0 0 1");
        Assert.assertTrue(m.isDiagonal());
    }

    /**
     * isDiagonal() should return true with a 3x3 matrix that has all zeroes
     * except along the diagonal, when the elements along the diagonal are
     * not equal
     */
    @Test
    public void testIsDiagonal02() {
        Matrix m = buildMatrix(3, 3, "2 0 0 0 1 0 0 0 0");
        Assert.assertTrue(m.isDiagonal());
    }

    /**
     * isDiagonal() should return false with a 3x2 matrix that has all zeroes
     * except along the "diagonal"
     */
    @Test
    public void testIsDiagonal03() {
        Matrix m = buildMatrix(3, 2, "1 0 0 1 0 0");
        Assert.assertFalse(m.isDiagonal());
    }

    /**
     * isDiagonal() should return false with a 3x3 matrix that doesn't have all zeroes
     * except along the diagonal.
     */
    @Test
    public void testIsDiagonal04() {
        Matrix m = buildMatrix(3, 3, "1 0 0 0 1 -1 0 0 1");
        Assert.assertFalse(m.isDiagonal());
    }
}
