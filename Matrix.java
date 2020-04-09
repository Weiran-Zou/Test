package matrix;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * A generic 2D-matrix.
 * @param <E> the cell type.
 */
public class Matrix<E> implements Iterable {
    private ArrayList<ArrayList<E>> list;

    /**
     * Constructs a Matrix.
     *
     * @param rows - the number of rows.
     * @param columns - the number of columns.
     */
    public Matrix(int rows, int columns) {
        list = new ArrayList<ArrayList<E>>();
        for (int i = 0; i < rows; i++){
            list.add(new ArrayList<E>());
        }
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < columns; j++){
                list.get(i).add(null);
            }
        }
    }

    /**
     * Assigns a value to a given cell, specified by its row, column coordinates.
     *
     * @param row - the row index with 0-based indexing.
     * @param column - the column index with 0-based indexing.
     * @param value - the value to be assigned to the given cell.
     */
    public void insert(int row, int column, E value) {
        list.get(row).set(column, value);
    }

    /**
     * Gets the value at a given cell, specified by its row, column coordinates.
     *
     * @param row - the row index with 0-based indexing.
     * @param column - the column index with 0-based indexing.
     * @return the value located at the given cell.
     */
    public E get(int row, int column) {
        return list.get(row).get(column);
    }

    /**
     * Gets the total number of cells in the matrix.
     *
     * @return an int equal to the total number of cells in the matrix.
     */
    public int size() {
        return list.size() * list.get(0).size();
    }

    /**
     * Converts the matrix to String format.
     *
     * @return a String representation of the matrix.
     */
    public String toString() {
        String matrix = "";
        for(int i = 0; i < list.size(); i++){
            for(int j = 0; j < list.get(0).size(); j++){
                matrix += get(i,j);
                if (j != list.get(0).size()-1){
                    matrix += "\t";
                }
            }
            if (i != list.size()-1) {
                matrix += "\n";
            }
        }
        return matrix;
    }


    /**
     * Gets an iterator for the matrix. The iterator follows column-major order.
     *
     * @return an iterator for the matrix.
     */

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            final int rows = list.size();
            final int cols = list.get(0).size();
            int row = 0;
            int col = 0;
            public boolean hasNext() {
                return col < cols;
            }
            public E next() {
                E result = list.get(row++).get(col);
                if (row == rows) {
                    row = 0;
                    col++;
                }
                return result;
            }
        };
    }


    public static void main(String[] args) {
        Matrix m = new Matrix(2, 2);

        m.insert(0, 0, "a");
        m.insert(0, 1, "b");
        m.insert(1, 0, 4);
        m.insert(1, 1, "d");


        System.out.println(m + "\n");

        for (Object element : m) {
            System.out.println(element);
        }
    }


}