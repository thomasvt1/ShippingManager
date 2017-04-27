public class Ship {
	
	private Container[] storage;
	boolean inUse;

	public Ship(int size) {
		super();
		createShip(size);
	}
	
	private void createShip(int size) {
		Container[] container = new Container[size];
		
		for (int i = 0; i < container.length; i++) {
			container[i] = new Container(i);
		}
		
		storage = container;
	}
	
	void printStatus() {
		System.out.println("////////// ~ SHIP STATUS START \\\\\\\\\\\\\\\\\\\\\\");
		System.out.println("Max storage: " + storage.length);
		System.out.println("Currently used: " + getStorageSize());
		//System.out.println("////////// ~ SHIP STATUS END \\\\\\\\\\\\\\\\\\\\\\");
	}
	
	public int getRandomDelay() {
		return 1000 + (int)(Math.random() * 6000);
	}
	
	private int getFirstContainer() throws EmptyException {
		for (int i = 0; i < storage.length; i++) {
			if (storage[i] != null) {
				return i;
			}
		}
		throw new EmptyException();
	}
	
	synchronized public Container unloadContainer() throws EmptyException {
		int i = getFirstContainer();
		Container x = storage[i];
		
		storage[i] = null;
		
		return x;
	}
	
	int getMaxCargo() {
		return storage.length;
	}

	public int getStorageSize() {
		int x = 0;
		for (Container c : storage) {
			if (c != null)
				x++;
		}
		return x;
	}
}