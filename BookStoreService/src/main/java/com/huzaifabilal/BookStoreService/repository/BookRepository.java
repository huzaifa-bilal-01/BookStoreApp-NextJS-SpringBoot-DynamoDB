package com.huzaifabilal.BookStoreService.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.huzaifabilal.BookStoreService.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookRepository {

    @Autowired
    private DynamoDBMapper dynamoDBMapper;

    public void saveBook(final Book book) {
        dynamoDBMapper.save(book);
    }

    public Book getBookByBookId(final String bookId) {
        return dynamoDBMapper.load(Book.class,bookId);
    }

    public void updateBook(final Book book) {
        saveBook(book);
    }

    public void deleteBookByBookId(final String bookId) {
        Book book = new Book();
        book.setBookID(bookId);
        dynamoDBMapper.delete(book);
    }

    public List<Book> getAllBooks() {
        return dynamoDBMapper.scan(Book.class, new DynamoDBScanExpression());
    }
}
