import java.awt.Frame;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

public class WindowManager {
	
	FrameTools ft;
	Frame frame;
	
	public void setJFrame(JFrame frame) {
		this.frame = frame;
		ft = new FrameTools(frame);
	}
	
	public void updateUI() {
		
		updateShipProgressBar();
		updateShoreProgressBar();
	}
	
	public void setMainTime(long min, long sec, long milis) {
		JLabel lblTime = (JLabel) ft.getComponentByName("lblMainTime");
		
		if (lblTime == null)
			System.out.println("lblMainTime is NULL");
		
		lblTime.setText(min + ":" + sec + ":" + milis);
	}
	
	public void setCheckbox(String prefix, int i, boolean bool) {
		JCheckBox jCheckBox = (JCheckBox) ft.getComponentByName(prefix + i);
		if (jCheckBox == null) {
			System.out.println(prefix + i + " checkbox is NULL");
		}
			
		jCheckBox.setSelected(bool);
	}
	
	public void updateShipProgressBar() {
		JProgressBar progressBar = (JProgressBar) ft.getComponentByName("progressBarShip");
		
		if (progressBar == null)
			System.out.println("OBJECT IS NULL");
		
		progressBar.setMaximum(App.ship.getMaxCargo());
		progressBar.setValue(App.ship.getStorageSize());
	}
	
	public void updateShoreProgressBar() {
		JProgressBar progressBar = (JProgressBar) ft.getComponentByName("progressBarShore");
		
		if (progressBar == null)
			System.out.println("OBJECT IS NULL");
		
		progressBar.setMaximum(App.shore.getMaxCargo());
		progressBar.setValue(App.shore.getStorageSize());
	}
	
	public void updateFactoryProgressBar() {
		JProgressBar progressBar = (JProgressBar) ft.getComponentByName("progressBarFactory");
		
		if (progressBar == null)
			System.out.println("OBJECT IS NULL");
		
		progressBar.setMaximum(App.factory.getMaxCargo());
		progressBar.setValue(App.factory.getStorageSize());
	}
}