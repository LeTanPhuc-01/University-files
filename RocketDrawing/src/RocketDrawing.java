
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Color;

public class RocketDrawing{
    public static void main(String[] args){
        //innerclass: class created on the fly
        javax.swing.SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                createAndShowGUI();
            }
        });
    }
    
    private static void createAndShowGUI(){
        JFrame frame = new JFrame("Draw Rocket");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 400);
        
        DrawingPanel panel = new DrawingPanel();
        frame.add(panel);
        
        frame.setVisible(true);
    }
    static class DrawingPanel extends JPanel{
        public Dimension getPreferredSize(){
            return new Dimension(300,400);
        }
        protected void paintComponent(Graphics g){
            super.paintComponent(g);
            setBackground(Color.WHITE);
            g.setColor(Color.GRAY);
            //getWidth(),Heigth(): obtain width/height of panel
            g.fillRect(130, 100, 40, 100);
            g.setColor(Color.ORANGE);
            int[] xFirePoints = {140, 150, 160};
            int[] yFirePoints = {200, 230, 200};
            g.fillPolygon(xFirePoints, yFirePoints, 3);
            g.setColor(Color.RED);
            int[] xTriangle1 = {130, 150, 170};
            int[] yTriangle1 = {100, 60, 100};
            g.fillPolygon(xTriangle1, yTriangle1, 3);
            g.setColor(Color.BLUE);
            int[] xTriangle2 = {130, 130, 110};
            int[] yTriangle2 = {180, 150, 180}; 
            g.fillPolygon(xTriangle2, yTriangle2, 3);
            int[] xTriangle3 = {170, 170, 190};
            int[] yTriangle3 = {180, 150, 180}; 
            g.fillPolygon(xTriangle3, yTriangle3, 3);
            g.setColor(Color.YELLOW);
            g.fillOval(145,140,10,10);
            g.fillOval(145,125,10,10);
            g.fillOval(145,110,10,10);
            g.fillOval(40,270,40,40);
            g.setColor(Color.GRAY);
            g.fillOval(50,270,40,40);
            g.fillRect(280, 270, 40, 40);
        }
    }
         
}
