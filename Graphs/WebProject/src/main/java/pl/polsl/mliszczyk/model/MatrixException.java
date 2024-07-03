/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.mliszczyk.model;

/**
 * Exception class related to the matrix.
 * 
 * @author Maja Liszczyk
 * @version 1.0.0
 */
public class MatrixException extends Exception {
    
    /**
     * Constructor
     * @param message inform about error
     */
    public MatrixException(String message){
        super(message);
    }
}
