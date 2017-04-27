
public class TruckThread extends Thread {
	
	boolean finished;
	
	int i;
	Factory factory;
	Shore shore;
	
	public TruckThread(Factory factory, Shore shore, int i) {
		this.shore = shore;
		this.factory = factory;
		this.i= i;
	}
	
	@Override
	public void start() {
		System.out.println("Starting truck");
		
		while (!finished) {
			App.notifyTrucks();
			loop();
		}
	}
	
	synchronized private void loop() {
			try {
				while (shore.isEmpty()) {
					System.out.println("Truck waiting for cargo..." + i);
					wait(500);
					sleep(App.getRandomDelay(0, 50));
				}
				Container c = shore.pickupContainer();
				App.windowmanager.updateShoreProgressBar();
				App.windowmanager.setCheckbox("T", i, true);
				App.notifyCranes();
				sleep(App.getRandomDelay(1000, 1500));
				
				factory.addContainer(c);
				App.windowmanager.setCheckbox("T", i, false);
				App.windowmanager.updateFactoryProgressBar();
				
				App.notifyCranes();
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (EmptyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (FullException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
