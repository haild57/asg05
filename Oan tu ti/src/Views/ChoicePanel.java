/*
 * Created by JFormDesigner on Fri May 09 17:48:18 ICT 2014
 */

package Views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;

import Source.Choice;
import Source.Computer;
import Source.KetQua;
import Source.Round;
import Source.SavingData;
import Source.VertaranReport;
import Source.Vetaran;

/**
 * @author Bui Trung
 */
public class ChoicePanel {

	
	public ChoicePanel(Computer computer) {
		initComponents(computer);
	}

	private void buttonActionPerformed(ActionEvent e) {
		// TODO add your code here
		Choice currentUserChoice = Choice.Rock;
		Choice currentComputerChoice;
		KetQua result;
		
		if(e.getSource() == button1)	
			currentUserChoice = Choice.Rock;
		if(e.getSource() == button2)
			currentUserChoice = Choice.Scissor;
		if(e.getSource() == button3)
			currentUserChoice = Choice.Paper;
		
		currentComputerChoice = computer.makeChoice();
		if(computer instanceof Vetaran)
			if(roundNumber >0 && roundNumber %2 ==0)
				reportList.add3LastChoice(SavingData.get3LastChoice());
			
		Round round = new Round();
		round.setRound(currentUserChoice,currentComputerChoice);
		SavingData.Saving(round);
		result = round.Check();
		
		//change display of panel
		changeDisplay(currentUserChoice,currentComputerChoice,result.toString());
		if(computer instanceof Vetaran)
			if(roundNumber %20 ==0)
				reportList.writeReportFile();
			
		roundNumber ++;//round ke tiep
	}
	
	private void button4ActionPerformed(ActionEvent e){
		JFrame parent = Utitilities.findJFrameOf(this.getPanel());
		
		if(parent != null)
		{
			helpPanel.setTextAreaEmpty();
			parent.setContentPane(helpPanel);
			parent.pack();
		}
		else
		{
			JOptionPane.showMessageDialog(parent,"Panel ChoicePanel only used form JFrame");
			System.exit(1);
		}
	}
	

	private void initComponents(Computer computer) {
		
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - Bui Trung
		this.computer = computer;
		if(computer instanceof Vetaran)
		{
			reportList = new VertaranReport();
			reportList.creatReportList();
		}
		roundNumber =0;
		SavingData.initiateData();
		ChoicePanel = new JPanel();
		label1 = new JLabel();
		label2 = new JLabel();
		label3 = new JLabel();
		label4 = new JLabel();
		label5 = new JLabel();
		button1 = new JButton();
		button2 = new JButton();
		button3 = new JButton();
		label6 = new JLabel();
		button4 = new JButton();

		//======== ChoicePanel ========
		{

			/*
			// JFormDesigner evaluation mark
			ChoicePanel.setBorder(new javax.swing.border.CompoundBorder(
				new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
					"JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
					javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
					java.awt.Color.red), ChoicePanel.getBorder())); ChoicePanel.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});
			*/

			//---- label1 ----
			label1.setText("Player");
			label1.setIcon(new ImageIcon(getClass().getResource("/Views/human_rock.png")));
			label1.setVerticalAlignment(SwingConstants.TOP);
			label1.setFont(label1.getFont().deriveFont(label1.getFont().getStyle() | Font.BOLD));
			label1.setToolTipText("Player's choice");
			label1.setPreferredSize(new Dimension(269, 148));
			label1.setMaximumSize(new Dimension(269, 148));
			label1.setMinimumSize(new Dimension(269, 148));

			//---- label2 ----
			label2.setText("Computer");
			label2.setIcon(new ImageIcon(getClass().getResource("/Views/computer_rock.png")));
			label2.setVerticalAlignment(SwingConstants.TOP);
			label2.setToolTipText("Computer's choice");
			label2.setFont(label2.getFont().deriveFont(label2.getFont().getStyle() | Font.BOLD));

			//---- label3 ----
			label3.setText("Player");
			label3.setFont(label3.getFont().deriveFont(label3.getFont().getStyle() | Font.BOLD));

			//---- label4 ----
			label4.setText("Computer");
			label4.setFont(label4.getFont().deriveFont(label4.getFont().getStyle() | Font.BOLD));

			//---- label5 ----
			label5.setText("VS");
			label5.setHorizontalAlignment(SwingConstants.CENTER);
			label5.setFont(new Font("Tahoma", Font.BOLD, 24));

			//---- button1 ----
			button1.setText("Rock");
			button1.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					buttonActionPerformed(e);
				}
			});

			//---- button2 ----
			button2.setText("Scissors");
			button2.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					buttonActionPerformed(e);
				}
			});

			//---- button3 ----
			button3.setText("Paper");
			button3.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					buttonActionPerformed(e);
				}
			});

			//---- label6 ----
			label6.setHorizontalAlignment(SwingConstants.CENTER);
			label6.setFont(new Font("Tahoma", Font.BOLD, 30));
			label6.setText(" ");
			label6.setHorizontalTextPosition(SwingConstants.CENTER);

			//---- button4 ----
			button4.setText("Help");
			button4.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					button4ActionPerformed(e);
				}

			});

			GroupLayout ChoicePanelLayout = new GroupLayout(ChoicePanel);
			ChoicePanel.setLayout(ChoicePanelLayout);
			ChoicePanelLayout.setHorizontalGroup(
				ChoicePanelLayout.createParallelGroup()
					.addGroup(ChoicePanelLayout.createSequentialGroup()
						.addGap(81, 81, 81)
						.addComponent(label3)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(label4)
						.addGap(75, 75, 75))
					.addGroup(GroupLayout.Alignment.TRAILING, ChoicePanelLayout.createSequentialGroup()
						.addContainerGap()
						.addComponent(label1, GroupLayout.PREFERRED_SIZE, 199, GroupLayout.PREFERRED_SIZE)
						.addGap(13, 13, 13)
						.addComponent(label5, GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
						.addGap(10, 10, 10)
						.addComponent(label2, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
						.addContainerGap())
					.addGroup(ChoicePanelLayout.createSequentialGroup()
						.addGroup(ChoicePanelLayout.createParallelGroup()
							.addGroup(ChoicePanelLayout.createSequentialGroup()
								.addGap(102, 102, 102)
								.addComponent(button1, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
								.addGap(35, 35, 35)
								.addComponent(button2)
								.addGap(30, 30, 30)
								.addComponent(button3, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE))
							.addGroup(ChoicePanelLayout.createSequentialGroup()
								.addContainerGap()
								.addComponent(button4)))
						.addContainerGap(93, Short.MAX_VALUE))
					.addGroup(GroupLayout.Alignment.TRAILING, ChoicePanelLayout.createSequentialGroup()
						.addContainerGap(181, Short.MAX_VALUE)
						.addComponent(label6, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
						.addGap(175, 175, 175))
			);
			ChoicePanelLayout.setVerticalGroup(
				ChoicePanelLayout.createParallelGroup()
					.addGroup(GroupLayout.Alignment.TRAILING, ChoicePanelLayout.createSequentialGroup()
						.addContainerGap()
						.addComponent(label6)
						.addGap(29, 29, 29)
						.addGroup(ChoicePanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
							.addComponent(label4)
							.addComponent(label3))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(ChoicePanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
							.addComponent(label1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(label5, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
							.addComponent(label2))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
						.addGroup(ChoicePanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
							.addComponent(button2, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
							.addComponent(button1, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
							.addComponent(button3, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(button4)
						.addGap(9, 9, 9))
			);
		}
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}
	
	public void changeDisplay(Choice currentUserChoice,Choice currentComputerChoice,String result){
		
		//change display of human's choice
		if(currentUserChoice.toString().equals("rock"))
			label1.setIcon(new ImageIcon(getClass().getResource("/Views/human_rock.png")));
		if(currentUserChoice.toString().equals("paper"))
			label1.setIcon(new ImageIcon(getClass().getResource("/Views/human_paper.png")));
		if(currentUserChoice.toString().equals("scissor"))
			label1.setIcon(new ImageIcon(getClass().getResource("/Views/human_scissors.png")));
		//change display of computer's choice
		if(currentComputerChoice.toString().equals("rock"))
			label2.setIcon(new ImageIcon(getClass().getResource("/Views/computer_rock.png")));
		if(currentComputerChoice.toString().equals("paper"))
			label2.setIcon(new ImageIcon(getClass().getResource("/Views/computer_paper.png")));
		if(currentComputerChoice.toString().equals("scissor"))
			label2.setIcon(new ImageIcon(getClass().getResource("/Views/computer_scissors.png")));
		//change display result of match
		label6.setText(result);
	}
	
	public void setNextPanel(HelpPanel panel)
	{
		helpPanel = panel;
	}
	public JPanel getPanel(){
		return ChoicePanel;
	}
	// JForm Designer - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - Bui Trung
	private JPanel ChoicePanel;
	private HelpPanel helpPanel;
	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	private JLabel label4;
	private JLabel label5;
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JLabel label6;
	private JButton button4;
	
	private Computer computer;
	private VertaranReport reportList;
	private int roundNumber;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
	
	public static void main(String args[]){
		JFrame frame = new JFrame("Oan Tu Ti");
		ChoicePanel choicePanel = new ChoicePanel(new Vetaran());
		choicePanel.getPanel().setBackground(Color.GRAY);
		HelpPanel helpPanel = new HelpPanel();
		
		choicePanel.setNextPanel(helpPanel);
		helpPanel.setBackPanel(choicePanel.getPanel());
		frame.add(choicePanel.getPanel());
		frame.pack();
		
		Dimension frameSize = frame.getSize();
		Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation((int)((screenSize.getWidth() - frameSize.getWidth()) / 2),
				(int)((screenSize.getHeight() - frameSize.getHeight()) / 2));
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
	}
	
}
