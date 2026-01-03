import javax.swing.*;
import java.awt.*;

public class ShapeCanvas extends JPanel {

    private ShapeCollection shapes;

    public ShapeCanvas(ShapeCollection shapes) {
        this.shapes = shapes;
        this.setPreferredSize(new Dimension(800, 600));
        this.setBackground(Color.WHITE);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        drawGrid(g2d);
        for (GeometricShape shape : shapes) {
            if (shape instanceof Circle) {
                drawCircle(g2d, (Circle) shape);
            } else if (shape instanceof Rectangle) {
                drawRectangle(g2d, (Rectangle) shape);
            } else if (shape instanceof Line) {
                drawLine(g2d, (Line) shape);
            }
        }
    }

    private void drawCircle(Graphics2D g2d, Circle circle) {
        g2d.setColor(Color.RED);

        int x = (int) (circle.getCenter().getX() - circle.getRadius());
        int y = (int) (circle.getCenter().getY() - circle.getRadius());
        int size = (int) (circle.getRadius() * 2);
        g2d.fillOval(x, y, size, size);
        g2d.setColor(Color.BLACK);
        g2d.drawOval(x, y, size, size);
    }

    private void drawRectangle(Graphics2D g2d, Rectangle rectangle) {
        g2d.setColor(Color.BLUE);

        int x = (int) rectangle.getAnchor().getX();
        int y = (int) rectangle.getAnchor().getY();
        int width = (int) rectangle.getWidth();
        int height = (int) rectangle.getHeight();
        g2d.fillRect(x, y, width, height);
        g2d.setColor(Color.BLACK);
        g2d.drawRect(x, y, width, height);
    }

    private void drawLine(Graphics2D g2d, Line line) {
        g2d.setColor(Color.GREEN);
        g2d.setStroke(new BasicStroke(3));
        g2d.drawLine((int) line.getP1().getX(), (int) line.getP1().getY(), (int) line.getP2().getX(), (int) line.getP2().getY());

    }

    private void drawGrid(Graphics2D g2d) {
        int width = this.getWidth();
        int height = this.getHeight();
        int step = 50;
        g2d.setFont(new Font("Arial", Font.PLAIN, 10));

        for (int i = 0; i < width; i += step) {
            if (i == 0) g2d.setColor(Color.BLACK);
            else g2d.setColor(new Color(220, 220, 220));

            g2d.drawLine(i, 0, i, height);

            g2d.setColor(Color.GRAY);
            g2d.drawString(String.valueOf(i), i + 2, 12);
        }

        for (int i = 0; i < height; i += step) {
            if (i == 0) g2d.setColor(Color.BLACK);
            else g2d.setColor(new Color(220, 220, 220));
            g2d.drawLine(0, i, width, i);
            g2d.setColor(Color.GRAY);
            g2d.drawString(String.valueOf(i), 2, i-2);
        }
    }


}
