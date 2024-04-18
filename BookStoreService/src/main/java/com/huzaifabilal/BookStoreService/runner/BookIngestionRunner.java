package com.huzaifabilal.BookStoreService.runner;

import com.huzaifabilal.BookStoreService.model.Book;
import com.huzaifabilal.BookStoreService.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class BookIngestionRunner implements ApplicationRunner {
    @Autowired
    private BookRepository bookRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        bookRepository.saveBook(new Book("1","Pirates Of Caribbean","https://globalbooks.com.pk/cdn/shop/products/product-1034_e1f00637-dbb6-4fb9-924f-3e7eb47a7d70.jpg?v=1666873661",99.99));
        bookRepository.saveBook(new Book("2","Jack and Grill","https://globalbooks.com.pk/cdn/shop/products/product-1034_e1f00637-dbb6-4fb9-924f-3e7eb47a7d70.jpg?v=1666873661",54.99));
        bookRepository.saveBook(new Book("3","Humpty Dumpty","https://globalbooks.com.pk/cdn/shop/products/product-1034_e1f00637-dbb6-4fb9-924f-3e7eb47a7d70.jpg?v=1666873661",22.99));
        bookRepository.saveBook(new Book("4","GooseBumps","https://globalbooks.com.pk/cdn/shop/products/product-1034_e1f00637-dbb6-4fb9-924f-3e7eb47a7d70.jpg?v=1666873661",109.99));
    }
}
