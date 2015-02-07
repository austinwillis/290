package CH.ifa.draw.figures;

import java.awt.Point;

public class XboxFigure extends RectangleFigure{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public XboxFigure() {
		super();
	}

	public XboxFigure(Point origin, Point corner) {
		super(origin,corner);
		LineFigure line = new LineFigure();
		line.setPoints(origin, corner);
		LineFigure line2 = new LineFigure();
		Point o2 = new Point(),c2 = new Point();
		o2.setLocation(origin.getX(),corner.getY());
		c2.setLocation(corner.getX(), origin.getY());
		line2.setPoints(o2, c2);
	}

}
