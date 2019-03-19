// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {

    Integer peekedValue;
    Iterator<Integer> it;
    
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
        it = iterator;
        peekedValue = it.hasNext() ? it.next() : null;
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return peekedValue;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
        if( peekedValue != null ) {
            int returnVal = peekedValue;
            peekedValue = it.hasNext() ? it.next() : null; // update peeked value 
            return returnVal; // but return current value
        }
        throw new java.util.NoSuchElementException();
	}

	@Override
	public boolean hasNext() {
        return peekedValue != null;
	    
	}
}