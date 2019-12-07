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

//      COLOR SECTION
        JPanel colorPanel = new JPanel();
        contentPane.add(colorPanel, BorderLayout.WEST);
        colorPanel.setBackground(Color.WHITE);
        colorPanel.setLayout(new GridLayout(3,1));
        ColorButtonListener colorBL = new ColorButtonListener(theText);

        JButton red = new JButton("Red");
        red.setBackground(Color.RED);
        red.setOpaque(true);
        red.setBorderPainted(false);
        red.addActionListener(colorBL);
        colorPanel.add(red);

        JButton yellow = new JButton("Yellow");
        yellow.setBackground(Color.YELLOW);
        yellow.setOpaque(true);
        yellow.setBorderPainted(false);
        colorPanel.add(yellow);
        yellow.addActionListener(colorBL);

        JButton green = new JButton("Green");
        green.setBackground(Color.GREEN);
        green.setOpaque(true);
        green.setBorderPainted(false);
        colorPanel.add(green);
        green.addActionListener(colorBL);
//      END OF COLOR SECTION

//      STYLE SECTION
        JPanel stylePanel = new JPanel();
        contentPane.add(stylePanel, BorderLayout.EAST);
        stylePanel.setBackground(Color.WHITE);
        stylePanel.setLayout(new GridLayout(3,1));
        StyleButtonListener styleBL = new StyleButtonListener(theText);

        JButton bold = new JButton("Bold");
        bold.setFont(new Font(Font.SERIF,Font.BOLD,20));
        stylePanel.add(bold);
        bold.addActionListener(styleBL);

        JButton italic = new JButton("Italic");
        italic.setFont(new Font(Font.SERIF,Font.ITALIC,20));
        stylePanel.add(italic);
        italic.addActionListener(styleBL);

        JButton plain = new JButton("Plain");
        plain.setFont(new Font(Font.SERIF,Font.PLAIN,20));
        stylePanel.add(plain);
        plain.addActionListener(styleBL);
//      END OF STYLE SECTION

//      FONT SECTION
        JPanel fontPanel = new JPanel();
        contentPane.add(fontPanel, BorderLayout.SOUTH);
        fontPanel.setBackground(Color.WHITE);
        fontPanel.setLayout(new FlowLayout());
        theSizeText = new JTextField(Float.toString((float)(textFont.getSize())), 5); // Needed for the extra credit
        FontButtonListener fontBL = new FontButtonListener(theText,theSizeText);

        JButton serif = new JButton("Serif");
        fontPanel.add(serif);
        serif.addActionListener(fontBL);

        JButton sansSerif = new JButton("Sans-serif");
        fontPanel.add(sansSerif);
        sansSerif.addActionListener(fontBL);
//      END OF FONT SECTION

//      Size SECTION (EXTRA CREDIT)
        JPanel sizePanel = new JPanel();
        contentPane.add(sizePanel, BorderLayout.NORTH);
        sizePanel.setBackground(Color.WHITE);
        sizePanel.setLayout(new FlowLayout());

        JButton size = new JButton("Change Font Size");
        size.addActionListener(fontBL);
        sizePanel.add(theSizeText);
        sizePanel.add(size);
//      END OF SIZE SECTION
     }
}
class ColorButtonListener implements ActionListener {
    private JTextField textField;

    public ColorButtonListener(JTextField t) {
        this.textField = t;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Red")) this.textField.setBackground(Color.RED);
        if(e.getActionCommand().equals("Yellow")) this.textField.setBackground(Color.YELLOW);
        if(e.getActionCommand().equals("Green")) this.textField.setBackground(Color.GREEN);
    }
}
class StyleButtonListener implements ActionListener {
    private JTextField textField;

    public StyleButtonListener(JTextField t) {
        this.textField = t;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Bold")) this.textField.setFont(textField.getFont().deriveFont(Font.BOLD));
        if(e.getActionCommand().equals("Italic")) this.textField.setFont(textField.getFont().deriveFont(Font.ITALIC));
        if(e.getActionCommand().equals("Plain")) this.textField.setFont(textField.getFont().deriveFont(Font.PLAIN));
    }
}
class FontButtonListener implements ActionListener {
}
