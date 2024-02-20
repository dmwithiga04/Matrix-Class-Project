//TODO: Add intro template and add Javadocs

public class Matrix {

    //initialize needed variables
    private int rows;
    private int columns;
    private int[][] mtrx;

    // constructer Methods
    public Matrix() {

        // sets the matrix to the default size (2*2)
        mtrx = new int[2][2];

        // assigns rows and column variable to appropriate number
        rows = mtrx.length;
        columns = mtrx[0].length;

        // sets all elements in mtrx to zero 
        for (int i = 0; i < mtrx.length; i++) {
            for (int j = 0; j < mtrx[i].length; j++) {
                mtrx[i][j] = 0;
            }
        }

    }

    public Matrix (int r, int c) {

        // check to see if r and c are positive integers (non-zero)
        if ((r>0) && (c>0)) {

            // set mtrx to the correct size and assign parameters to the correct variables
            mtrx = new int[r][c];
            rows = r;
            columns = c;

             // sets all elements in mtrx to zero 
            for (int i = 0; i < mtrx.length; i++) {
                for (int j = 0; j < mtrx[i].length; j++) {
                    mtrx[i][j] = 0;
                }
            }

        }

        // throw if conditions not met
        else {
            throw new IllegalArgumentException ("Invalid rows and columns values (values should be positive(non-zero integers)");
        }

    }

    // Makes this Matrix an independent copy of Matrix other
    public Matrix (Matrix other) {

        // set variables in this Matrix in copy of other.
        mtrx = new int[other.getRows()][other.getColumns()];
        rows = other.getRows();
        columns = other.getColumns();

        for (int i = 0; i < mtrx.length; i++) {
            for (int j = 0; j < mtrx[i].length; j++) {

                // +1 becuase of how the getElement interprates value of rows and columns
                mtrx[i][j] = other.getElement(i+1, j+1);
            }
        }


    }


    // Getter and Setter Methods

    //returns number of rows
    public int getRows(){
        return rows;
    }

    //returns number of columns
    public int getColumns(){
        return columns;
    }

    //assigns an element in a specified location
    public void setElement (int r, int c, int val) {

        // check element in position and if r and c are positive (non-zero) numbers and an index in the array
        if ((r>0 && c>0) && (r<=rows && c<= columns))  {
            
            // -1 is used due to the array index starting at 0
            mtrx[r-1][c-1] = val;

        }
        // throw exception if element position is invalid as per the above conditions
        else{
            throw new IllegalArgumentException ("the element does not exist in the position specified");
        }
    }

    //returns the value of the element in row r and column c
    public int getElement(int r, int c){
        
        // check element in position and if r and c are positive (non-zero) numbers
        if ((r>0) && (c>0) && (r<=rows && c<= columns)) {    
        
            // -1 is used due to the array index starting at 0
            return mtrx[r-1][c-1];
    
        }

        // throw exception if element position is invalid as per the above conditions
        else{
            throw new IllegalArgumentException ("the element does not exist in the position specified");
        }
    }
    //return a String representation of the Matrix class to the specifications of the lab
    public String toString(){
        return null;
    }

    //adds two matrices
    public Matrix plus(Matrix other){
        return null;
    }

    // subtracts two matrices
    public Matrix minus(Matrix other){
        return null;
    }

    //checks if matrix is diagonal
    public boolean isDiagonal(){
        return false;
    }

    //checks if two matraces are equal and returns boolean
    public static boolean isEqual(Matrix a, Matrix b){
        return false;
    }
}
