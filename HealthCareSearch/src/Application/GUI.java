package Application;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import BussinessLayer.AppData;

@SuppressWarnings("serial")
public class GUI extends JFrame {
	public GUI() {
        this.setLayout(new GridLayout());
		setSize(200,250);
		this.setLocationRelativeTo(null);
	    JTextField userName = new JTextField(10);
	    JTextField passWord = new JTextField(10);
		JButton Log = new JButton("登录查询");
        JPanel jP = new JPanel();
        JLabel uL = new JLabel("用户名");
        JLabel pL = new JLabel("密   码");
        jP.add(uL);
        jP.add(userName);
        jP.add(pL);
        jP.add(passWord);
        jP.add(Log);
        this.add(jP);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Log.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
        		String username=userName.getText();
				String password=passWord.getText();
				AppData app=new AppData(username,password);
				try {
					Table(app);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
        });
	}
	public void Table(AppData app) throws SQLException 
	{ 
		List<Person> people = app.getPerson();
		for(int i=0;i<people.size();i++) 
		{ 
			System.out.println(people.get(i).getML()+"	"+people.get(i).getPID()+"	"+people.get(i).getPMN());
		}
	}
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		GUI gui=new GUI();
	}
}