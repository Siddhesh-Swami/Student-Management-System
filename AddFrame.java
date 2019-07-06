import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.regex.*;

class AddFrame extends JFrame
{
	Container c;
	JLabel lblRno, lblName;
	JTextField txtRno,txtName;
	JButton btnSave, btnBack;
	JPanel p1,p2;

	AddFrame()
	{
		c =getContentPane();
		c.setLayout(new BoxLayout(c , BoxLayout.Y_AXIS));
		c.setBackground(Color.orange);
		
		p1 = new JPanel();
		lblRno = new JLabel("Rno:");
		txtRno = new JTextField(4);
		lblName = new JLabel("Name:");
		txtName = new JTextField(10);

		p1.add(lblRno);
		p1.add(txtRno);
		p1.add(lblName);
		p1.add(txtName);
		p1.setBackground(Color.orange);
		c.add(p1);

		p2 = new JPanel();
		btnSave = new JButton("Save");
		btnSave.setBackground(Color.orange);
		btnBack = new JButton("Back");
		btnBack.setBackground(Color.orange);
		p2.add(btnSave);
		p2.add(btnBack);
		c.add(p2);
    
		btnSave.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae) {
				try
				{
				String rno = txtRno.getText();
				String name = txtName.getText();
				System.out.println(name);
				DbHandler db = new DbHandler();
				if(  txtName.getText().isEmpty())
				{
					throw new InvalidFieldException();
				}
				if(Integer.parseInt(rno)<0)
				{
					throw new NumberGreaterException();	
				}
				if(Pattern.matches("[a-zA-Z]+", name) == false){
					throw new Exception();
				}
				//if
				//throw new StringOnlyException("name");

				db.addStudent(Integer.parseInt(rno),name);
				}
				catch(NumberFormatException nfe)
				{
					JOptionPane.showMessageDialog(new JDialog(), "Please Enter Integer");
				}
				catch(NumberGreaterException nge)
				{
					JOptionPane.showMessageDialog(new JDialog(), "Number should be greater than 0");	
				}
				catch(InvalidFieldException iae)
				{
					JOptionPane.showMessageDialog(new JDialog(), "Field(s) should not be blank");		
				}
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(new JDialog(), "Name should not contain Integers");
				}
				/*
				catch(StringOnlyException soe)
				{
					JOptionPane.showMessageDialog(new JDialog(), "Number not allowed");	
				}
				*/
			}});
	
		btnBack.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				MainFrame a = new MainFrame();
				dispose();
			}});
	


		setTitle("Add Student");
		setSize(500,400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);		

		}
} // end of class Addframe

class NumberGreaterException extends Exception
{
}

class InvalidFieldException extends Exception
{	
}

/*
class StringOnlyException extends Exception
{
	public StringOnlyException(String s)
	{
		//name = this.name;
		super(s);
		//JOptionPane.showMessageDialog( new JDialog(), name);
	}
}
*/

