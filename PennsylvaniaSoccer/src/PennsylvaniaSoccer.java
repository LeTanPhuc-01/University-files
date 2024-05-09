import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;

public class PennsylvaniaSoccer {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Pennsylvania Soccer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.add(new PennsylvaniaSoccerPanel());
        frame.setVisible(true);
    }
    static class PennsylvaniaSoccerPanel extends JPanel {
        public PennsylvaniaSoccerPanel() {
            setPreferredSize(new Dimension(800, 600));
        }
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            setBackground(Color.GRAY);
            g.setColor(Color.GREEN);
            g.fillRect(100, 100, 200, 100);
            g.setColor(Color.BLACK);
            g.fillOval(175, 125, 50, 50);
            g.setColor(Color.RED);
            g.fillRect(100,60,8,40);
            g.fillRect(292,60,8,40);
            g.setColor(Color.BLUE);
            int [] Triangle1X = {108, 125, 108};
            int [] Triangle1Y = {65, 72, 80};
            g.fillPolygon(Triangle1X, Triangle1Y, 3);
            int [] Triangle2X = {300, 320, 300};
            int [] Triangle2Y = {60, 70, 80};
            g.fillPolygon(Triangle2X, Triangle2Y, 3);
            g.setColor(Color.WHITE);
            g.fillOval(150,10,100,50);


            // g.setColor(Color.BLUE);
            // g.fillOval(375, 300, 50, 50);
            // g.setColor(Color.RED);
            // g.fillRect(200, 300, 400, 50);
        }
    }
}
