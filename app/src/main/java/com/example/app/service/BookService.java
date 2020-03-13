package com.example.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.domain.Book;
import com.example.app.mappers.BookMapper;


@Service
public class BookService {

    @Autowired
    private BookMapper bookMapper;


    public List<Book> searchAllBook() {
        List<Book> bookList = bookMapper.findAll();
        return bookList;
    }


    public List<Book> searchByGenre(String genre,String name) {
        List<Book> bookList = bookMapper.findByGenre(genre,name);
        return bookList;
    }

    public List<Book> searchById(String id) {
        List<Book> bookList = bookMapper.findById(id);
        return bookList;

    }
    @Transactional
    public int updateById(String dateResult,String id) {
    	int line = bookMapper.updateById(dateResult,id);
    	return line;
    }
    public  List<Book> searchByLentFlag(){
    	List<Book> bookList = bookMapper.findByLentFlag();
    	return bookList;
    }

}
