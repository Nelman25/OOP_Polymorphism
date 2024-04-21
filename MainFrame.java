import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.Normalizer;

import javax.swing.*;

public class MainFrame implements ActionListener{

    String[] Array= {"Rectangle", "Circle", "Triangle"};

    JFrame frame = new JFrame();
    JPanel mainPanel, inputPanel;
    JComboBox shapes = new JComboBox(Array);
    JButton button = new JButton();
    JTextField textfield1, textfield2;
    JLabel solvefor = new JLabel("Area of:");
    JLabel Title, Formula, shapeImage, Answer;

    ImageIcon enterImg = new ImageIcon("C:\\Users\\Jonel Villaver\\Downloads\\enterButton.png");
    ImageIcon circleAreaImg = new ImageIcon("C:\\Users\\Jonel Villaver\\Downloads\\CircleArea.png");
    ImageIcon rectangleAreaImg = new ImageIcon("C:\\Users\\Jonel Villaver\\Downloads\\RectangleArea.png");
    ImageIcon triangleAreaImg = new ImageIcon("C:\\Users\\Jonel Villaver\\Downloads\\TriangleArea.png");

    MainFrame() {
        frame.setSize(1300,690);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.getContentPane().setBackground(new Color(242,241,241));

        mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        mainPanel.setBackground(Color.white);
        mainPanel.setBounds(60,80,1180,500);

        inputPanel = new JPanel();
        inputPanel.setLayout(null);
        inputPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        inputPanel.setBounds(430,50,670,410);
        inputPanel.setBackground(new Color(242,241,241));

        shapes.setFont(new Font("Times New Roman", Font.PLAIN,22));
        shapes.setBounds(150, 52, 150, 30);
        shapes.addActionListener(this);

        shapeImage = new JLabel();
        shapeImage.setBounds(90,160,250,200);

        Title = new JLabel("Area Calculator");
        Title.setFont(new Font("Poppins", Font.BOLD, 40));
        Title.setBounds(60, 20, 350, 50);

        Formula = new JLabel();
        Formula.setBounds(100,410,250,50);
        Formula.setFont(new Font("Poppins",Font.BOLD,30));

        solvefor.setFont(new Font("Poppins", Font.BOLD, 25));
        solvefor.setBounds(40, 50, 150, 30);

        Answer = new JLabel();
        Answer.setBounds(50,340,470,50);
        Answer.setBorder(BorderFactory.createLineBorder(Color.black));
        Answer.setFont(new Font("Poppins", Font.BOLD,20));

        button.setBounds(570,340,65,40);
        button.setIcon(enterImg);
        button.addActionListener(this);

        textfield1 = new JTextField();
        textfield2 = new JTextField();

        mainPanel.add(shapes);
        mainPanel.add(solvefor);
        mainPanel.add(inputPanel);
        mainPanel.add(Formula);
        mainPanel.add(shapeImage);
        inputPanel.add(textfield1);
        inputPanel.add(textfield2);
        inputPanel.add(button);
        inputPanel.add(Answer);
        frame.add(Title);
        frame.add(mainPanel);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        textfield1.setFont(new Font("Poppins",Font.PLAIN,20));
        textfield1.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        textfield2.setFont(new Font("Poppins",Font.PLAIN,20));
        textfield2.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        textfield1.setBounds(150,120,300,50);
        textfield2.setBounds(150,210,300,50);

        if(e.getSource()==shapes) {
            if(shapes.getSelectedItem().equals("Rectangle")) {
                Formula.setText("A = wl");
                shapeImage.setIcon(rectangleAreaImg);
                textfield1.setText("Enter Length");
                textfield2.setText("Enter Width");
                textfield2.setVisible(true);
            }
            if(shapes.getSelectedItem().equals("Circle")) {
                Formula.setText("A = πr^2");
                shapeImage.setIcon(circleAreaImg);
                textfield1.setText("Enter Radius");
                textfield2.setText("0");
                textfield2.setVisible(false);
            }
            if(shapes.getSelectedItem().equals("Triangle")) {
                Formula.setText("A = hb/2");
                shapeImage.setIcon(triangleAreaImg);
                textfield2.setVisible(true);
                textfield1.setText("Enter Base");
                textfield2.setText("Enter Height");
            }
        }
        try {
            if (e.getSource() == button) {
                double inputtedNumber1 = Double.valueOf(textfield1.getText());
                double inputtedNumber2 = Double.valueOf(textfield2.getText());

                Circle circle = new Circle(inputtedNumber1);
                Rectangle rectangle = new Rectangle(inputtedNumber1,inputtedNumber2);
                Triangle triangle = new Triangle(inputtedNumber1,inputtedNumber2);

                if(shapes.getSelectedItem().equals("Rectangle")) {
                    Answer.setText("The Area of Rectangle is " + rectangle.calculateArea());
                }
                else if(shapes.getSelectedItem().equals("Circle")) {
                    Answer.setText("The Area of Circle is " + circle.calculateArea());
                }
                else if(shapes.getSelectedItem().equals("Triangle")) {
                    Answer.setText("The Area of Triangle is " + triangle.calculateArea());
                }
            }
        }catch(Exception e1){
            JOptionPane.showMessageDialog(null, "Wrong Input");
            System.out.println("Exception" + e1);
        }
    }
}