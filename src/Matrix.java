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
        if ((r > 0) || (c>0)) {

            // set mtrx to the correct size and assign parameters to the correct variables
            mtrx = new int[r][c];
            rows = r;
            columns = c;

        }

        else {
            //TODO: is this retarted? can I just call the 1st constructer intead?
            // sets the matrix to the default size (2*2)
            mtrx = new int[2][2];

            // assigns rows and column variable to appropriate number
            rows = mtrx.length;
            columns = mtrx[0].length;
        }

        // sets all elements in mtrx to zero 
        for (int i = 0; i < mtrx.length; i++) {
            for (int j = 0; j < mtrx[i].length; j++) {
                mtrx[i][j] = 0;
            }
        }

    }

    //TODO: to create after making the getter and setter method
    public Matrix (Matrix other) {
        
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

        // check element in position and if r and c are positive (non-zero) numbers
        if ((r>0||rows>r) || (c>0||rows>c)) {
            
            // -1 is becuase of how an array count of elements starts from zero
            mtrx[r-1][c-1] = val;

        }
        // throw exception if element position is invalid as per the above conditions
        else{
            throw new IllegalArgumentException ("the element does not exist in the position specified");
        }
    } 
}
