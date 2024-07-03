/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.mliszczyk.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import java.io.Serializable;

/**
 *
 * @author Maja
 */
@Entity
public class MatrixElement implements Serializable{
    
    /**
     * x position on x-axis.
     */
    private int x;
    
    /**
     * y position on y-axic
     */
    private int y;
    
    /**
     * value in matrix.
     */
    private int value;
    
    /**
     * Matrix id.
     */
    @Id
    @GeneratedValue
    private Long id;
    
    /**
     * Constructor with parameters.
     * @param x position on x-axic.
     * @param y position on y-axic.
     * @param value in matrix.
     */
    public MatrixElement(int x, int y, int value){
        this.x = x;
        this.y = y;
        this.value = value;        
    }
    
    /**
     * Constructor.
     */
    public MatrixElement(){}
    
    public int getX(){
        return x;
    }
    
    public int getY(){
        return y;
    }
    
    public int getValue(int x, int y){
        return value;
    }
    
    public void setValue(int v){
        this.value = v;
    }
}
