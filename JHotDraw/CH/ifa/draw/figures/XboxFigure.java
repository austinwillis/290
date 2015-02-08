package CH.ifa.draw.figures;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

import javafx.scene.shape.Line;

public class XboxFigure extends RectangleFigure{

	/**
	 * 
	 */
	
	private LineFigure fdisplLine1;
	private LineFigure fdisplLine2;
	
	private static final long serialVersionUID = 1L;
	public XboxFigure() {
		super();
		fdisplLine1 = new LineFigure();
		fdisplLine2 = new LineFigure();
	}
	
	public XboxFigure(Point origin, Point corner) {
		super(origin,corner);
		fdisplLine1.addPoint(origin.x, origin.y);
		fdisplLine1.addPoint(corner.x, corner.y);
		fdisplLine2.addPoint(origin.x, corner.y);
		fdisplLine2.addPoint(corner.x, origin.y);
	}
	
	public void draw(Graphics g) {
		super.draw(g);
		fdisplLine1.draw(g);
		fdisplLine2.draw(g);
	}
	
	protected void basicMoveBy(int x, int y) {
		super.basicMoveBy(x, y);
		fdisplLine1.basicMoveBy(x, y);
		fdisplLine2.basicMoveBy(x, y);
	}
	
	public void basicDisplayBox(Point origin, Point corner) {
		super.basicDisplayBox(origin, corner);
		fdisplLine1 = new LineFigure();
		fdisplLine2 = new LineFigure();
		fdisplLine1.basicDisplayBox(origin, corner);
		Point o = new Point(origin.x, corner.y);
		Point c = new Point(corner.x, origin.y);
		fdisplLine2.basicDisplayBox(o, c);
	}
	
}
