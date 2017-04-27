public class Factory {
	
	private Container[] storage;
	boolean inUse;

	public Factory(int size) {
		super();
		storage = new Container[size];
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
				System.out.println("FirstNextContainer: " + i);
				return i;
			}
				
		}
		throw new EmptyException();
	}
	
	public void addContainer(Container c) throws FullException {
		
		for (int i = 0 ; i < storage.length; i++) {
			if (storage[i] == null) {
				storage[i] = c;
				return;
			}
				
		}
		throw  new FullException();
	}
	
	public Container unloadContainer() throws EmptyException {
		int i = getFirstContainer();
		Container x = storage[i];
		
		storage[i] = null;
		
		return x;
	}
	
	public Container[] getStorage() {
		return storage;
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