/*
 * Created by JFormDesigner on Sun May 11 08:50:32 ICT 2014
 */

package Views;

import java.awt.*;
import java.awt.event.*;
import java.util.List;

import javax.swing.*;

import Source.KetQua;
import Source.SavingData;

import com.jgoodies.forms.layout.*;

/**
 * @author Bui Trung
 */
public class HelpPanel extends JPanel {
	public HelpPanel() {
		initComponents();
	}
	public void setBackPanel(JPanel panel){
		choicePanel = panel;
	}
	public void setTextAreaEmpty(){
		textArea1.setText("");
	}
	private void button2ActionPerformed(ActionEvent e) {
		// TODO add your code here
		List<KetQua> list = SavingData.getKetQua();
		int win = 0;
		int lose = 0;
		int tie = 0;
		
		for (int i = 0; i < list.size(); i++){
			switch (list.get(i)){
			case WIN:
				win++; break;
			case LOSE:
				lose++; break;
			case TIE:
				tie++; break;
			default:
				System.out.println("Error here!");
			}
		}
		
		String text = String.format("%s\n\t%s%d\n\t%s%d\n\t%s%d\n","Ket qua hien tai: ",
				"You win: ",win,
				"You lose: ",lose,
				"You tie: ",tie
				);
		textArea1.setText(text);
		
	}

	private void button3ActionPerformed(ActionEvent e) {
		// TODO add your code here
		String title = String.format("%5s %10s %10s\n", "STT", "Nguoi choi", "May tinh");
		textArea1.setText(title);
		
		List<String> list1 = SavingData.getPlayerChoice();
		List<String> list2 = SavingData.getComputerChoice();
		
		for (int i = 0; i < list1.size(); i++){
			String text = String.format("%5d %10s %10s\n", i + 1, list1.get(i), list2.get(i));
			textArea1.append(text);
		}
	}

	private void button4ActionPerformed(ActionEvent e) {
		// TODO add your code here
		String text = String.format("%s%s%s%s",
				"Nguoi choi chon 1 trong cac lua chon sau\n",
				 "Rock  Scissor  Paper\n",
				 "Chon Help de duoc tro giup :\n",
				 "\tResult\n\tGuide\n\tRounds\n"
				);
		textArea1.setText(text);
		String text1 = String.format("%s%s%s",
				"Chon 'Result' de xem ket qua choi hien tai.\n",
				"Chon 'Rounds' de xem cac luot di truoc cua nguoi va may\n",
				"Chon 'Guide' de duoc huong dan cach choi");
		textArea1.append(text1);
	}

	private void button1ActionPerformed(ActionEvent e) {
		// TODO add your code here
		JFrame parent = Utitilities.findJFrameOf(this);
		
		if(parent != null)
		{
			parent.setContentPane(choicePanel);
			parent.pack();
		}
		else
		{
			JOptionPane.showMessageDialog(parent,"Panel HelpPanel only used for JFrame");
			System.exit(1);
		}
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - Bui Trung
		setBackground(Color.GRAY);
		button1 = new JButton();
		button2 = new JButton();
		button3 = new JButton();
		button4 = new JButton();
		scrollPane1 = new JScrollPane();
		textArea1 = new JTextArea();
		textArea1.setEditable(false);
		label1 = new JLabel();

		//======== this ========
		/*
		// JFormDesigner evaluation mark
		setBorder(new javax.swing.border.CompoundBorder(
			new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
				"JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
				javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
				java.awt.Color.red), getBorder())); addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});
		*/

		//---- button1 ----
		button1.setText("Back ");
		button1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				button1ActionPerformed(e);
			}
		});

		//---- button2 ----
		button2.setText("Result");
		button2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				button2ActionPerformed(e);
			}
		});

		//---- button3 ----
		button3.setText("Rounds");
		button3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				button3ActionPerformed(e);
			}
		});

		//---- button4 ----
		button4.setText("Guide");
		button4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				button4ActionPerformed(e);
			}
		});

		//======== scrollPane1 ========
		{
			scrollPane1.setViewportView(textArea1);
		}

		//---- label1 ----
		label1.setText("Display Help");
		label1.setFont(new Font("Tahoma", Font.BOLD, 20));
		label1.setForeground(Color.orange);

		GroupLayout layout = new GroupLayout(this);
		setLayout(layout);
		layout.setHorizontalGroup(
			layout.createParallelGroup()
				.addGroup(layout.createSequentialGroup()
					.addGap(105, 105, 105)
					.addComponent(button2, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
					.addGap(27, 27, 27)
					.addComponent(button3)
					.addGap(37, 37, 37)
					.addComponent(button4, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
					.addGap(0, 99, Short.MAX_VALUE))
				.addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
					.addContainerGap(81, Short.MAX_VALUE)
					.addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 314, GroupLayout.PREFERRED_SIZE)
					.addGap(80, 80, 80))
				.addGroup(layout.createSequentialGroup()
					.addGroup(layout.createParallelGroup()
						.addGroup(layout.createSequentialGroup()
							.addContainerGap()
							.addComponent(button1))
						.addGroup(layout.createSequentialGroup()
							.addGap(165, 165, 165)
							.addComponent(label1)))
					.addContainerGap(184, Short.MAX_VALUE))
		);
		layout.setVerticalGroup(
			layout.createParallelGroup()
				.addGroup(layout.createSequentialGroup()
					.addContainerGap(23, Short.MAX_VALUE)
					.addComponent(label1)
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE)
					.addGap(43, 43, 43)
					.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(button3, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
						.addComponent(button4, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
						.addComponent(button2, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
					.addGap(11, 11, 11)
					.addComponent(button1)
					.addContainerGap())
		);
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - Bui Trung
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JButton button4;
	private JScrollPane scrollPane1;
	private JTextArea textArea1;
	private JLabel label1;
	
	private JPanel choicePanel;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
