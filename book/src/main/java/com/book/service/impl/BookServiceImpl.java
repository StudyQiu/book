package com.book.service.impl;

import com.book.mapper.BookMapper;
import com.book.entity.Books;
import com.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookMapper bookMapper;

    @Override
    public Integer addBook(Books books) {
        return bookMapper.addBook(books);
    }

    @Override
    public Integer delBookById(Integer id) {
        return bookMapper.delBookById(id);
    }

    @Override
    public Integer updateBook(Books books) {
        return bookMapper.updateBook(books);
    }

    @Override
    public Books queryBookById(Integer id) {
        return bookMapper.queryBookById(id);
    }

    @Override
    public List<Books> queryAllBook() {
        return bookMapper.queryAllBook();
    }

    @Override
    public List<Books> queryBookByName(String bookname) {
        return bookMapper.queryBookByName(bookname);
    }

    @Override
    public List<Books> selectBookLike(String bookname) {
        return bookMapper.selectBookLike(bookname);
    }
}
