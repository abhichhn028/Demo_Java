package com.api.book.enteties.services;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.api.book.enteties.Book;

@Component
public class BookService {
	private static List<Book> list=new ArrayList<>();
	
	static {
		list.add(new Book(12, "Java Complete Reference","XYZ"));
		list.add(new Book(36, "Head First Book to Java","ABC"));
		list.add(new Book(122, "Thing to Java","LMN"));
	}
	
//	get All Books
	public List<Book> getAllBooks(){
		return list;
	}
	
//	get single Book By id
	public Book getBookById(int id) {
		Book book=null;
		book=list.stream().filter(e->e.getId()==id).findFirst().get();
		return book;
	}
	
//	add the book
	
	public Book addBook(Book b) {
		list.add(b);
		return b;
	}
	
//	delete Books
	public void deleteBook(int id) {
		list=list.stream().filter(e->{
			if(e.getId()!=id)
			{
				return true;
			}
			else
			{
				return false;
			}
		}).collect(Collectors.toList());
	}
	
// update Books
	public void updateBook(Book book, int id) {
		list.stream().map(b->{
			if(b.getId()==id) {
				b.setTitle(book.getTitle());
				b.setAuthor(book.getAuthor());
			}
			return b;
		}).collect(Collectors.toList());
	}
	
}
