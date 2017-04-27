import javax.swing.JFrame;

public class ClickHandler {
	
	JFrame frame;
	
	public ClickHandler(JFrame frame) {
		System.out.println("~ Button pressed ~");
		this.frame = frame;
		
		App.windowmanager.setJFrame(frame);
		updateUI();
		App.startCranes();
		App.startTrucks();
	}
	
	private void updateUI() {
		App.windowmanager.updateShipProgressBar();
		App.windowmanager.updateShoreProgressBar();
	}
}
