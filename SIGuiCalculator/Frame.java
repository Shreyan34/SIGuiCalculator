//importing all the necessary modules
import java.awt.*;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Frame extends JFrame implements ActionListener
{
    JTextField principal, rate, time; //declaring the three textfields
    JLabel SI, AMOUNT, ERROR; //declaring the three labels
    JButton button; //declaring the conversion button

    Frame() {
        principal = new JTextField(15); //making the principal texfield
        principal.setText("Enter the principal amount"); //setting the placeholder text of the principal textfield

        rate = new JTextField(15); //making the rate textfield
        rate.setText("Enter the rate per annum"); //setting the placeholder text of the rate textfield

        time = new JTextField(15); //making the time textfield
        time.setText("Enter the time"); //setting the placeholder text of the time textfield

        button = new JButton(); //making the conversion button
        button.setText("Find SI"); //setting the text of the button
        button.addActionListener(this); //adding the action listener to the button

        //creating the label for displaying the SI
        SI = new JLabel();
        SI.setVisible(false);

        //creating the label for displaying the Amount
        AMOUNT = new JLabel();
        AMOUNT.setVisible(false);

        //creating the label for displaying the Error (if any)
        ERROR = new JLabel();
        ERROR.setVisible(false);


        //Following are all frame-related operations

        //making two variables to track the height and width of the canvas
        int width = 250;  
        int height = 275;
        this.setVisible(true); //displaying the frame
        this.setSize(new Dimension(width, height)); //setting the size of the frame
        this.setLayout(new FlowLayout()); //setting the layout of the frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //setting the close operation of the frame
        this.setTitle("SI Calculator - Java"); //setting the title of the frame

        //adding elements to the frame
        this.add(principal);
        this.add(rate);
        this.add(time);
        this.add(button);
        this.add(SI);
        this.add(AMOUNT);
        this.add(ERROR);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            // getting the value of the principal
            String principal_string = principal.getText();
            double principal_amount = Double.parseDouble(principal_string);

            //getting the value of the rate
            String rate_string = rate.getText();
            double rate_amount = Double.parseDouble(rate_string);

            //getting the value of the time
            String time_string = time.getText();
            double time_amount = Double.parseDouble(time_string);

            //The Formula of SI
            double si = (principal_amount * rate_amount * time_amount) / 100;
            double amount = principal_amount + si;
            
            //Displaying the SI and the Amount
            SI.setText("The Simple Interest is: " + si);
            SI.setVisible(true);

            AMOUNT.setText("The Amount Is: " + amount);
            AMOUNT.setVisible(true);

            ERROR.setVisible(false);
        } 
        catch (Exception e1) {
            ERROR.setText("Oopsie! Try inputting numbers!");
            ERROR.setVisible(true);
        }
    }
}
