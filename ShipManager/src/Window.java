import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.SystemColor;
import javax.swing.JProgressBar;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class Window {

	JFrame frame;
	
	/**
	 * Launch the application.
	 */
	public void launchWindow() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window window = new Window();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Window() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 518, 360);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.inactiveCaption);
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(12, 5, 201, 52);
		panel.add(panel_1);
		
		JProgressBar progressBarShip = new JProgressBar();
		progressBarShip.setName("progressBarShip");
		panel_1.add(progressBarShip);
		
		JLabel lblShipCargo = new JLabel("Ship Cargo");
		panel_1.add(lblShipCargo);
		
		JButton btnStart = new JButton("START");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnStart.setEnabled(false);
				new ClickHandler(frame);
			}
		});
		btnStart.setBounds(216, 275, 97, 25);
		panel.add(btnStart);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(228, 5, 48, 52);
		panel.add(panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panel_2.rowHeights = new int[]{0, 0, 0};
		gbl_panel_2.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("");
		chckbxNewCheckBox.setEnabled(false);
		GridBagConstraints gbc_chckbxNewCheckBox = new GridBagConstraints();
		gbc_chckbxNewCheckBox.insets = new Insets(0, 0, 5, 5);
		chckbxNewCheckBox.setName("C1");
		gbc_chckbxNewCheckBox.gridx = 0;
		gbc_chckbxNewCheckBox.gridy = 0;
		panel_2.add(chckbxNewCheckBox, gbc_chckbxNewCheckBox);
		
		JCheckBox checkBox = new JCheckBox("");
		GridBagConstraints gbc_checkBox = new GridBagConstraints();
		gbc_checkBox.insets = new Insets(0, 0, 5, 5);
		checkBox.setName("C2");
		gbc_checkBox.gridx = 1;
		gbc_checkBox.gridy = 0;
		panel_2.add(checkBox, gbc_checkBox);
		checkBox.setEnabled(false);
		
		JLabel lblNewLabel = new JLabel("C1");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		panel_2.add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblC = new JLabel("C2");
		GridBagConstraints gbc_lblC = new GridBagConstraints();
		gbc_lblC.insets = new Insets(0, 0, 0, 5);
		gbc_lblC.gridx = 1;
		gbc_lblC.gridy = 1;
		panel_2.add(lblC, gbc_lblC);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(12, 70, 201, 52);
		panel.add(panel_3);
		
		JProgressBar progressBarShore = new JProgressBar();
		progressBarShore.setName("progressBarShore");
		panel_3.add(progressBarShore);
		
		JLabel lblShore = new JLabel("Shore Cargo");
		panel_3.add(lblShore);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(12, 135, 201, 52);
		panel.add(panel_4);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setName("progressBarFactory");
		panel_4.add(progressBar);
		
		JLabel lblFinish = new JLabel("Factory Cargo");
		panel_4.add(lblFinish);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(288, 5, 72, 52);
		panel.add(panel_5);
		GridBagLayout gbl_panel_5 = new GridBagLayout();
		gbl_panel_5.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panel_5.rowHeights = new int[]{0, 0, 0};
		gbl_panel_5.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_5.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel_5.setLayout(gbl_panel_5);
		
		JCheckBox checkBox_1 = new JCheckBox("");
		checkBox_1.setName("T1");
		checkBox_1.setEnabled(false);
		GridBagConstraints gbc_checkBox_1 = new GridBagConstraints();
		gbc_checkBox_1.insets = new Insets(0, 0, 5, 5);
		gbc_checkBox_1.gridx = 0;
		gbc_checkBox_1.gridy = 0;
		panel_5.add(checkBox_1, gbc_checkBox_1);
		
		JCheckBox checkBox_2 = new JCheckBox("");
		checkBox_2.setName("T2");
		checkBox_2.setEnabled(false);
		GridBagConstraints gbc_checkBox_2 = new GridBagConstraints();
		gbc_checkBox_2.insets = new Insets(0, 0, 5, 5);
		gbc_checkBox_2.gridx = 1;
		gbc_checkBox_2.gridy = 0;
		panel_5.add(checkBox_2, gbc_checkBox_2);
		
		JCheckBox checkBox_3 = new JCheckBox("");
		checkBox_3.setName("T3");
		checkBox_3.setEnabled(false);
		GridBagConstraints gbc_checkBox_3 = new GridBagConstraints();
		gbc_checkBox_3.insets = new Insets(0, 0, 5, 0);
		gbc_checkBox_3.gridx = 2;
		gbc_checkBox_3.gridy = 0;
		panel_5.add(checkBox_3, gbc_checkBox_3);
		
		JLabel lblT_1 = new JLabel("T1");
		GridBagConstraints gbc_lblT_1 = new GridBagConstraints();
		gbc_lblT_1.insets = new Insets(0, 0, 0, 5);
		gbc_lblT_1.gridx = 0;
		gbc_lblT_1.gridy = 1;
		panel_5.add(lblT_1, gbc_lblT_1);
		
		JLabel lblT_2 = new JLabel("T2");
		GridBagConstraints gbc_lblT_2 = new GridBagConstraints();
		gbc_lblT_2.insets = new Insets(0, 0, 0, 5);
		gbc_lblT_2.gridx = 1;
		gbc_lblT_2.gridy = 1;
		panel_5.add(lblT_2, gbc_lblT_2);
		
		JLabel lblT = new JLabel("T3");
		GridBagConstraints gbc_lblT = new GridBagConstraints();
		gbc_lblT.gridx = 2;
		gbc_lblT.gridy = 1;
		panel_5.add(lblT, gbc_lblT);
		
	}
}