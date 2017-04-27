
public class App {
	
	static CraneThread[] cranes;
	static TruckThread[] trucks;
	
	static WindowManager windowmanager;
	
	static Factory factory;
	static Shore shore;
	static Ship ship;
	static Window w;
	
	public static void main(String[] args) {
		windowmanager = new WindowManager();
		factory = new Factory(100);
		ship = new Ship(100);
		shore = new Shore(5);
		w = new Window();
		w.launchWindow();
		
		fillCranes(2);
		fillTrucks(3);
	}
	
	static void startCranes() {
		for (CraneThread crane : cranes) {
			new Thread(() -> {
				crane.start();
			}).start();
		}
	}
	
	static void startTrucks() {
		for (TruckThread truck : trucks) {
			new Thread(() -> {
				truck.start();
			}).start();
		}
	}
	
	static void notifyTrucks() {
		for (TruckThread truck : trucks) {
			new Thread(() -> {
				synchronized (truck) {
					truck.notify();
				}
			}).start();
		}
	}

	static void notifyCranes() {
		for (CraneThread crane : cranes) {
			synchronized (crane) {
				new Thread(() -> {
					synchronized (crane) {
						crane.notify();
					}
				}).start();
			}
		}
	}
	
	private static void fillCranes(int size) {
		cranes = new CraneThread[size];
		
		for (int i = 0; i < cranes.length; i ++) {
			cranes[i] = new CraneThread(ship, shore, i + 1);
		}
	}
	
	private static void fillTrucks(int size) {
		trucks = new TruckThread[size];
		
		for (int i = 0; i < trucks.length; i ++) {
			trucks[i] = new TruckThread(factory, shore, i + 1);
		}
	}
	
	static public int getRandomDelay(int min, int max) {
		return min + (int)(Math.random() * max);
	}
}