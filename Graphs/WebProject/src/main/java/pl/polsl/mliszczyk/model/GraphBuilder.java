/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.mliszczyk.model;

import jakarta.enterprise.context.ApplicationScoped;

/**
 *
 * @author Maja
 */
@ApplicationScoped
public class GraphBuilder {
    
    /**
     * Graph
     */
    private Matrix graph = new Matrix ();
    
    /**
     * Adds element to matrix.
     * @param x position on x-axis. 
     * @param y position on y-axis.
     * @param value to add.
     * @throws MatrixException if wrong symbol in matrix- not x, not number
     */
    public void addElement(int x, int y, String value) throws MatrixException{
        try{                    
            MatrixElement el;
            if(value.compareTo("x") == 0){
              el = new MatrixElement(x, y, Integer.MAX_VALUE);
            }
            else{
               el = new MatrixElement(x, y, Integer.parseInt(value));
            }
            graph.addValue(el);
        }
        catch(NumberFormatException e){
            throw new MatrixException("Wrong symbol in matrix - not x, not number in  (" + x + ", " + y + "). Try again");
        } 
    }
    
    /**
     * Builds matrix.
     * @return new Matrix
     */
    public Matrix build(){
        Matrix m = graph;
        graph = new Matrix();
        return m;
    }
    
    /**
     * Sets matrix graph.
     * @param size of matrix.
     */
    public void setSize(int size){
        graph.setSize(size);
    }
    
    /**
     * Sets matrix name.
     * @param matrixName to set. 
     */
    public void setMatrixName(String matrixName){
        graph.setMatrixName(matrixName);
    }  
}
