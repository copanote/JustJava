package iterator;

public class BookShelf implements Aggregate {
	private Book[] books;
	private int last = 0;
	public BookShelf(int maxsize) {
		this.books = new Book[maxsize];
	}
	
	public Book getBookAt(int index) {
		return books[index];
	}
	
	public void appendBook(Book book) {
		this.books[last++] = book;
	}
	public int getLength() {
		return last;
	}

	@Override
	public Iterator iterator() {
		// TODO Auto-generated method stub
		return new BookShelfIterator();
	}
	
	private class BookShelfIterator implements Iterator {
		private int index = 0;

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			if (index < last) {
				return true;
			} 
			return false;
		}

		@Override
		public Object next() {
			// TODO Auto-generated method stub
			Book book = getBookAt(index++);
			return book;
		} 
		
	}

}
