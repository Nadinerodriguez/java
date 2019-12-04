import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener

public class Assignment4 {
    public static void main(String[] args) {
        BannerMaker gui = new BannerMaker();
        gui.setVisible(true);
    }
}
class BannerMaker extends JFrame{
    public static final int WIDTH = 550;
    public static final int HEIGHT = 500;
    private Container contentPane;
    private JTextField theText, theSizeText;
    private static Font textFont = new Font(Font.SERIF,Font.PLAIN,20);
    
    public BannerMaker(){
        super();
        setSize(WIDTH, HEIGHT);
        setTitle("Banner Maker");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        
//      CENTER SECTION
        JPanel textPanel = new JPanel();
        contentPane.add(textPanel, BorderLayout.CENTER);
        textPanel.setBackground(Color.WHITE);
        textPanel.setLayout(new BorderLayout());

        theText = new JTextField("Center Text");
        textPanel.add(theText);
        theText.setFont(textFont);
//      END OF CENTER SECTION
     }
}
