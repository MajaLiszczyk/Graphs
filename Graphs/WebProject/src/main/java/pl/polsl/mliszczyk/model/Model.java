/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.mliszczyk.model;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 * Model represents model part of MVC. It responses for calculates.
 * @author Maja Liszczyk
 * @version 1.0.0
 */

@ApplicationScoped
public class Model {
    
  
    /**
     * Dynamic matrix representing graph.
     */
    private Matrix matrix;
    
    /**
     * Entity manager.
     */
    private final EntityManager em;
    
    /**
     * Constructor. 
     */
    public Model(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("graph_persistence_unit");
        em = emf.createEntityManager();
    }
    
    public EntityManager getEntityManager(){
        return em;
    }
    
    /**
     * Main calculates to find cost of the shortest way between each pair of nodes.
     * 
     * @param mx matrix
     * 
     * @throws MatrixException when matrix is not square
     */
    public void mainAlgorithm(Matrix mx) throws MatrixException{
        this.matrix = mx;
        int size = matrix.getSize();    
        int start, end, intermediary;
       
        for (intermediary = 0; intermediary < size; intermediary++) {
            for (start = 0; start < size; start++) {
                for (end = 0; end < size; end++) {
                  if(isShorter(start, end, intermediary)){
                      matrix.setValue(start, end, matrix.getValue(start, intermediary)+ matrix.getValue(intermediary, end));
                  }
                }
            }
        }        
    }
    
    /**
     * Provide the cost of the shortest way between passed nodes.
     * 
     * @param from starting node
     * @param to ending node
     * @param matrix matrix
     * 
     * @return the cost of the shortest way (as a String)
     * 
     * @throws MatrixException when x or y is out of range
     */
    public String findWay(int from, int to, MatrixInterface<Integer> matrix) throws MatrixException{
        int value = matrix.getValue(from, to);
        if(value == Integer.MAX_VALUE){
            return "Infinity";
        }
        else{
            return String.valueOf(matrix.getValue(from, to));
        }
    }  
    
    /**
     * Checks if the path via intermediary node is shorter than direct one
     * 
     * @param start node
     * @param end node
     * @param intermediary node
     * @return is shorter path
     * @throws MatrixException when matrix is not square
     */
    private boolean isShorter(int start, int end, int intermediary) throws MatrixException{
        return matrix.getValue(start, intermediary)!= Integer.MAX_VALUE &&
                          matrix.getValue(intermediary, end) != Integer.MAX_VALUE &&
                          matrix.getValue(start, intermediary) + matrix.getValue(intermediary, end) 
                          < matrix.getValue(start, end);
    }
}
