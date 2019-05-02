// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {
    Iterator<Integer> iterator;
    Integer buffer;
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    this.iterator = iterator;
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        if (buffer != null) {
            return buffer;
        }
        return buffer = iterator.next();
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    int val = buffer == null ? iterator.next() : buffer;
        buffer = null;
        return val;
	}

	@Override
	public boolean hasNext() {
	    return buffer != null || iterator.hasNext();
	}
}