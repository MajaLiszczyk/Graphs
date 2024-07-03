/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pl.polsl.mliszczyk.model;

/**
 *
 * @author Maja Liszczyk
 * @param <T>
 */
public interface MatrixInterface<T> {
    
        public int getValue(int x, int y) throws MatrixException;
        public void setValue(int x, int y, int value) throws MatrixException;
        public int getSize() throws MatrixException;  
       
}
