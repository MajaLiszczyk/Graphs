/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.mliszczyk.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents graph as a listMatrix. 
 * 
 * @author Maja Liszczyk
 * @version 1.0.0
 */

@Entity
public class Matrix implements MatrixInterface<MatrixElement> , Serializable{
    
        /**
         * Represents graph as a dynamic arrays.
         */
        @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
        )
        @JoinColumn(name = "matrix_id")
        private List<MatrixElement> listMatrix = new ArrayList<MatrixElement>();
        
        /**
         * Matrix size.
         */
        private int size;
        
        /**
         * Matrix name.
         */
        private String nameMatrix;
        
        /**
         * Matrix id.
         */
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;

        /**
         * Constructor with parameter.
         * @param matrix to initialize.
         */
        public Matrix(List<MatrixElement> matrix){
            this.listMatrix = matrix;
        }
        
        /**
         * Constructor
         */
        public Matrix(){
        }
        
        /**
         * Sets matrix size.
         * @param size of matrix.
         */
        public void setSize(int size){
            this.size = size;
        }
        
        /**
         * Sets matrix name.
         * @param name of matrix.
         */
        public void setMatrixName(String name){
            nameMatrix = name;
        }
        
        /**
         * Gets list.
         * @return matrix list.
         */
        public List<MatrixElement> getList(){
            return listMatrix;
        }
        
        /**
         * Get matrix id.
         * @return matrix id.
         */
        public Long getID(){
            return id;
        }
        
        /**
         * Gets value from matrix.
         * @param x position on x-axis.
         * @param y position on y-axis.
         * @return value
         * @throws MatrixException when x or y is out of range.
         */
        @Override
        public int getValue(int x, int y) throws MatrixException {
       
            if((x<getSize()) && (x>=0) && (y < getSize()) && (y>=0)){
                for (MatrixElement el : listMatrix){
                    if((el.getX() == x) && (y == el.getY())){
                        return el.getValue(x, y);
                    }
                }
            }
            throw new MatrixException("x or y out of range (" + x + ", " + y + ")" );
        }
        
        
        /**
         * Sets value in matrix.
         * @param x position on x-axis.
         * @param y position on y-axis.
         * @param value to set.
         * @throws MatrixException when x or y is out of range
         */
        @Override
        public void setValue(int x, int y, int value) throws MatrixException{
            if((x<getSize()) && (x>=0) && (y < getSize()) && (y>=0)){ 
                for (MatrixElement el : listMatrix){
                    if((el.getX() == x) && (y == el.getY())){
                        el.setValue(value);
                    }
                }
            }
            else{
                throw new MatrixException("x or y out of range ("  + x + ", " + y + ")");
            }
        }
        
        
        /**
         * Add value on the end since it is dynamic listMatrix
         * 
         * @param value value to add
         */        
        void addValue(MatrixElement el){
            listMatrix.add(el);
        }
        
        /**
         * Check if listMatrix is square.
         * 
         * @return false if listMatrix is square, true otherwise
         */
        public boolean isSquareMatrix(){
            int rows = listMatrix.size();
            for(int i = 0; i<rows; i++){
                int column = listMatrix.size();
                if(column != rows){
                    return false;
                }
            }
            return true;
        }
        
        /**
         * Get the size of the listMatrix.
         * 
         * @return the size of the listMatrix
         * @throws MatrixException when listMatrix is not square
         */
        @Override
        public int getSize() throws MatrixException{
            if(isSquareMatrix()){
                return size;
            }
            throw new MatrixException("No square matrix");
        }
        
        /**
         * Gets matrix name.
         * @return matrix name.
         */
        public String getMatrixName(){
            return nameMatrix;
        }
        
                
        /**
         * Clear listMatrix.
         */
        //void clearMatrix(){
         //   listMatrix.removeAll(listMatrix);
        //}
}
