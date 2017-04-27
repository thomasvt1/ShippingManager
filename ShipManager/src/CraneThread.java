public class CraneThread extends Thread {
	
	int i;
	Ship ship;
	Shore shore;
	
	boolean stop = false;
	
	public CraneThread(Ship ship, Shore shore, int i) {
		this.shore = shore;
		this.ship = ship;
		this.i= i;
	}
	
	@Override
	public void start() {
		System.out.println("Starting crane");
		try {
			sleep(ship.getRandomDelay());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		while (!stop) {
			//updateGUI();
			loop();
			ship.printStatus();
			shore.printStatus();
			//App.windowmanager.updateUI();
		}
			
	}
	
	synchronized private void loop() {
		try {
			while (ship.inUse) {
				System.out.println("Crane is waiting for other crane..");
				App.notifyTrucks();
				wait();
			}
			
			ship.inUse = true;
			Container c = ship.unloadContainer();
			App.windowmanager.updateShipProgressBar();
			App.windowmanager.setCheckbox("C", i, true);
			
			sleep(ship.getRandomDelay());
			
			App.notifyTrucks();
			
			ship.inUse = false;
			App.notifyCranes();
			
			while (shore.isFull()) {
				System.out.println("Crane is waiting for empty shore.." + i);
				wait();
			}
			
			shore.addContainer(c);
			App.windowmanager.updateShoreProgressBar();
			
			App.notifyTrucks();
			
			App.windowmanager.setCheckbox("C", i, false);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EmptyException e) {
			System.out.println("Crane got EmptyException... stopping CraneThread");
			e.printStackTrace();
		} catch (FullException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}