package stroke;

import canvas.Drawable;
import canvas.command.DrawCommand;
import name.LayerIdentifier;
import util.Vector2;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;

public class StrokeTypeText {
    public void paintLine(LayerIdentifier identifier, Drawable canvas, Color color, int strokeWidth, int x1, int y1, int x2, int y2, Vector2 velocity, int symetry) {
        List<DrawCommand> result = new LinkedList<DrawCommand>();
        BasicStroke stroke = new BasicStroke(5, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);


    }
}
