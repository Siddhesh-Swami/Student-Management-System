import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.regex.*;

class UpdateFrame extends JFrame
{
	Container c;
	JLabel lblRno , lblName;
	JTextField txtRno, txtName;
	JButton btnSave , btnBack;
	JPanel p1,p2;

	UpdateFrame()
	{
		c = getContentPane();
		c.setLayout(new BoxLayout(c , BoxLayout.Y_AXIS));
		c.setBackground(Color.orange);

		p1 = new JPanel();
		lblRno = new JLabel("Rno: ");
		txtRno = new JTextField((4));
		lblName = new JLabel("Name: ");
		txtName = new JTextField((10));
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

		setTitle("Update Student Info.");
		setLocationRelativeTo(null);
	setSize(500,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);


		btnBack.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
			MainFrame a = new MainFrame();
			dispose();
			}
		});

		btnSave.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				try{
				String rno = txtRno.getText();
				String name = txtName.getText();
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
				
				db.UpdateStudent(Integer.parseInt(rno),name);
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

			}
		});

	}

	public static void main(String[] args)
	{
		UpdateFrame uf = new UpdateFrame();	
}

}