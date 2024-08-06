/** Currency Converter Made by Alim A., Maaz, Anas
A project for Java Lab.
FIrst enter Amount then click convert while selecting desired currency.
Hope you like it :)
*/
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CurrencyConverter extends JFrame
{
    private JPanel inputPanel;                               //panels
    private JPanel resultPanel;
    private JPanel menuPanel;
    private JLabel promptLabel;                              //Labels
    private JLabel resultLabel;
    private JLabel selectLabel;
    //menu for the list of currencies
    private JMenu currencyMenu;
    private JMenuBar currencyMenuBar;
    //input field for user to enter currency
    private JTextField inputField;
    private JButton convertButton;
    //initial values for each currency to 1 rupees
    private double euros = 0.012;
    private double japaneseYen = 1.54;
    private double pound= 0.01;
    private double usDollars = 0.014;
    private double kuwaitDinar = 0.004;
    public CurrencyConverter()                      
    {
        super();
        this.setSize(400, 300);                         			 //set size of the window
        this.setLayout(new GridLayout(3, 1));           			 //split the grid with panels
        this.setTitle("Currency Converter");    					 //set window title
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 		 //This will close the window
        this.selectLabel = new JLabel("Select a currency to convert to: ", JLabel.RIGHT);
        this.resultLabel = new JLabel(" ", JLabel.CENTER);
        this.currencyMenu = new JMenu("(Click here to select a currency)");         //create a menu of currencies
        JMenuItem Euros = new JMenuItem("Euros");                       			//store the string Euros as a menu item
        Euros.addActionListener(new java.awt.event.ActionListener()    			    //add a listener to this item
        {
            public void actionPerformed(java.awt.event.ActionEvent evt) //listen for event
            {
                menuChanged(evt);
            }
        });
        this.currencyMenu.add(Euros);
        JMenuItem JapaneseYen = new JMenuItem("Japanese Yen");              //store the string Japanese Yen as a menu item
        JapaneseYen.addActionListener(new java.awt.event.ActionListener()   //add a listener to this item
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                menuChanged(evt);
            }
        });
        this.currencyMenu.add(JapaneseYen);
        JMenuItem pound = new JMenuItem("Britain Pound");           //store the string britain pound as a menu item
        pound.addActionListener(new java.awt.event.ActionListener()    //add a listener to this item
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                menuChanged(evt);
            }
        });
        this.currencyMenu.add(pound);
        JMenuItem CD = new JMenuItem("Kuwaiti Dinar");          //store the string kuwaitDinar as a menu item
        CD.addActionListener(new java.awt.event.ActionListener()   //add a listener to this item
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                menuChanged(evt);
            }
        });
        this.currencyMenu.add(CD);
        JMenuItem USD = new JMenuItem("US Dollars");                    //store the string US Dollars as a menu item
        USD.addActionListener(new java.awt.event.ActionListener()       //add a listener to this item
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                menuChanged(evt);
            }
        });
        this.currencyMenu.add(USD);
        currencyMenuBar = new JMenuBar();               //initialise a new menubar and add it to the currency menu
        currencyMenuBar.add(currencyMenu);
        this.menuPanel = new JPanel();
        this.menuPanel.add(this.selectLabel);
        this.menuPanel.add(this.currencyMenuBar);
        this.add(this.menuPanel);
        this.promptLabel = new JLabel("Enter amount in Rupees: Rs.", JLabel.RIGHT);
        this.resultLabel = new JLabel(" ", JLabel.CENTER);
        this.inputField = new JTextField(" ", 15);
        this.convertButton = new JButton("Convert");
        convertButton.addActionListener(new java.awt.event.ActionListener()
        {
			public void actionPerformed(java.awt.event.ActionEvent evt)
            { buttonclicked(evt);}
        });
        this.inputPanel = new JPanel();
        this.inputPanel.add(this.promptLabel);
        this.inputPanel.add(this.inputField);
        this.inputPanel.add(this.convertButton);
        this.add(this.inputPanel);
        this.resultPanel = new JPanel();
        this.resultPanel.add(this.resultLabel);
        this.add(this.resultPanel);
    }
    /* change the state of the menu bar depending on the selected currency*/
    public void menuChanged(ActionEvent e)
    {
        if (e.getActionCommand().equals("Euros"))
        {
            currencyMenu.setText("Euros");
        }
        if (e.getActionCommand().equals("Japanese Yen")) {
            currencyMenu.setText("Japanese Yen");
        }

        if (e.getActionCommand().equals("Britain Pound")) {
            currencyMenu.setText("Britain Pound");
        }
        
        if (e.getActionCommand().equals("Kuwaiti Dinar")) {
            currencyMenu.setText("Kuwaiti Dinar");
        }

        if (e.getActionCommand().equals("US Dollars")) {
            currencyMenu.setText("US Dollars");
        }
	}
    /*output*/
    public void buttonclicked(ActionEvent evt)
    {
        if(currencyMenu.getText().equals("Euros"))
        {
            resultLabel.setText(inputField.getText() +" Rs.  =  "+ EurosToRupees() + " Euros.");
        }
        if(currencyMenu.getText().equals("Japanese Yen"))
        {
            resultLabel.setText(inputField.getText() + " Rs.  =   " + JapaneseYenToRupees() + " Japanese Yen.");
        }
        if(currencyMenu.getText().equals("Britain Pound"))
        {
            resultLabel.setText(inputField.getText() + " Rs.  =   " + PoundToRupees() + " Britain Pound.");
        }
        if(currencyMenu.getText().equals("Kuwaiti Dinar"))
        {
            resultLabel.setText(inputField.getText() + " Rs.  =   " + KuwaitiDinarToRupees() + " Kuwaiti Dinar.");
        }   
        if(currencyMenu.getText().equals("US Dollars"))
        {
            resultLabel.setText(inputField.getText() + " Rs.  =  " +USDollarToRupees() + " US Dollars.");
        }
    }
	//calculate the rate for euros
    double EurosToRupees()
    {
        double calcTotal = Double.parseDouble(inputField.getText()) * euros;
        return calcTotal;
    }
    //calculate the conversion rate for japanese yen
    double JapaneseYenToRupees()
    {
        double calcTotal = Double.parseDouble(inputField.getText()) * japaneseYen;
        return calcTotal;
    }
    //calculate the rate for pound
    double PoundToRupees()
    {
        double calcTotal = Double.parseDouble(inputField.getText()) * pound;
        return calcTotal;
    }
    //calculate the rate for us dollars
    double USDollarToRupees()
    {
        double calcTotal = Double.parseDouble(inputField.getText()) * usDollars;
        return calcTotal;
    }
	//calculate the rate for kuwaitDinar
	double KuwaitiDinarToRupees()
    {
        double calcTotal = Double.parseDouble(inputField.getText()) * kuwaitDinar;
        return calcTotal;
    }
    /* main method to initialise CurrencyConverter*/
    public static void main(String[] args)
    {
        CurrencyConverter CurCon = new CurrencyConverter();
        CurCon.setVisible(true);
    }
}

 