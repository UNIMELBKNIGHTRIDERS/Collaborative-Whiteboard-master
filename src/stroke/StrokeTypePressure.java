package stroke;

import java.awt.BasicStroke;
import java.awt.Color;
import java.util.LinkedList;
import java.util.List;

import name.LayerIdentifier;
import util.Vector2;
import canvas.Drawable;
import canvas.Pixel;
import canvas.command.DrawCommand;
import canvas.command.DrawCommandLine;
/**
 * Stroke that changes draw commands based on pressure
 * Implements StrokeType
 *
 *
 */
public final class StrokeTypePressure implements StrokeType {
    
	/**
     * Creates a series of draw commands based on the mouse movement
     * @param identifier of layer
     * @param canvas to draw on
     * @param color of stroke
     * @param strokeWidth
     * @param x1 start x value
     * @param y1 start y value
     * @param x2 end x value
     * @param y2 end y value
     * @param velocity vector of stroke
     * @param symetry of image
     * @return Drawcommands for layer
     */
    @Override
    public DrawCommand[] paintLine(LayerIdentifier identifier, Drawable canvas, Color color, int strokeWidth, int x1, int y1, int x2, int y2, Vector2 velocity, int symetry) {
        List<DrawCommand> result = new LinkedList<DrawCommand>();  
        
        double speed = Math.sqrt(Math.pow(velocity.x(),2)+ Math.pow(velocity.y(), 2));
        BasicStroke stroke = new BasicStroke(strokeWidth - (int)(Math.min(speed/2,strokeWidth)), BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
        result.add(new DrawCommandLine(identifier, new Pixel(x1, y1, new Color(color.getRed(), color.getGreen(), color.getBlue(), (int)Math.max(255-speed*10, 1))), new Pixel(x2,y2, new Color(color.getRed(), color.getGreen(), color.getBlue(), (int)Math.max(255-speed*10, 1))), stroke, symetry));

        
        return result.toArray(new DrawCommand[result.size()]);
    }
    
    /**
     * Returns string representation of stroke
     */
    @Override
    public String toString() {
        return "Pressure";
    }

}