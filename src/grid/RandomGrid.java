/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grid;

import java.util.Random;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author dale
 */
public class RandomGrid extends Grid {
    
    private Color[] colors = {Color.CORAL, Color.DEEPPINK, Color.BISQUE, Color.AZURE, Color.SEAGREEN};
    
    public RandomGrid(int rows, int columns) {
        super(rows, columns);
    }
    
    @Override
    public GridPane build(double width, double height) {
        super.build(width, height);

        Random rn = new Random();
        int numColors = colors.length;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col <columns; col++) {
                Color color = colors[rn.nextInt(numColors)];
                Rectangle rect = new Rectangle(rectangleWidth, rectangleHeight, color);
                
                gridPane.add(rect, row, col);
            }
        }
        
        return gridPane;
    }
}
