package es.usantatecla.aX_dispensers.a7_exceptions;

class BoundedQueue extends BoundedDisepenser {

	private int first;

	public BoundedQueue(int capacity) {
		super(capacity);
		this.first = 0;
	}

	public void add(Interval element) throws FullDispenserException {
		super.add(element);
		if (this.next == this.elements.length) {
			this.next = 0;
		}
	}

	public Interval remove() throws EmptyDispenserException {
		super.remove();
		this.size--;
		Interval element = this.elements[this.first];
		this.first = (this.first + 1) % this.elements.length;
		return element;
	}

	public Interval[] getElements() {
		Interval[] elements = new Interval[this.size];
		for (int position = 0; position < this.size; position++) {
			elements[position] = this.elements[(position + this.first) % this.elements.length];
		}
		return elements;
	}

	public void duplicate() {
		Interval[] news = new Interval[2 * this.elements.length];
		int i = this.first;
		for (int j = 0; j < this.size; j++) {
			news[j] = this.elements[j];
			i = (i + 1) % this.elements.length;
		}
		this.elements = news;
		this.first = 0;
	}

}
