/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grid;

import javafx.scene.layout.GridPane;

/**
 *
 * @author dale
 */
public abstract class Grid {
    protected double width;
    protected double height;
    protected int rows;
    protected int columns;
    protected double rectangleWidth;
    protected double rectangleHeight;
    protected GridPane gridPane;
    
    public Grid(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
       
        gridPane = new GridPane();
    }
    
    public GridPane build(double width, double height) {
        clear();
        this.width = width;
        this.height = height;
        rectangleWidth = Math.ceil(width / (double)columns);
        rectangleHeight = Math.ceil(height / (double)rows);
        //rectangleWidth = width / (double)columns;
        //rectangleHeight = height / (double)rows;
        gridPane.setPrefWidth(width);
        gridPane.setPrefHeight(height);
        
        return gridPane;
    }
    
    public void clear() {
        if(gridPane != null){
            gridPane.getChildren().clear();
        }
    }
        
    
    public GridPane getBoard() {
        return gridPane;
    }
    
    public int getRows() {
        return rows;
    }
    
    public int getColumns() {
        return columns;
    }
    
    public double getWidth() {
        return width;
    }
    
    public double getHeight() {
        return height;
    }
    
    public double getRectangleWidth() {
        return rectangleWidth;
    }
    
    public double getRectangleHeight() {
        return rectangleHeight;
    }
    
}
