package es.usantatecla.aX_listas.a0_classes;

class SentinelList extends List {

	public boolean includes(Interval interval) {
		this.insertLast(interval);
		Node sentinel = this.getLast();
		Node current = this.getFirst();
		while (!current.getInterval().equals(interval)) {
			current = current.getNext();
		}
		this.removeLast();
		return current != sentinel;
	}

}
