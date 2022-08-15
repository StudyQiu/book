package com.book.controller;

import com.book.entity.Books;
import com.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;

    //查询全部书籍，进行数据渲染
    @RequestMapping("/allBook")
    public String queryAllBook(Model model){
        List<Books> list = bookService.queryAllBook();
        model.addAttribute("list",list);
        return "allBook";
    }

    //跳转新增页面
    @RequestMapping("/toAddBook")
    public String toAddPaper(){
        return "addbook";
    }

    //添加书籍
    @RequestMapping("/addBook")
    public String addBook(Books books){
        bookService.addBook(books);
        return "redirect:/book/allBook";//重定向到@RequestMapping("/allBook")请求
    }

    //跳转修改页面
    @RequestMapping("/toUpdateBook")
    public String toUpdatePaper(Integer bookid,Model model){
        Books books = bookService.queryBookById(bookid);
        model.addAttribute("book",books);
        return "updateBook";
    }

    //编辑书籍
    @RequestMapping("/updateBook")
    public String updateBook(Books books){
        bookService.updateBook(books);
        return "redirect:/book/allBook";//重定向到@RequestMapping("/allBook")请求
    }

    //删除书籍
    @RequestMapping("/delBookById")
    public String delBookById(Integer id){
        bookService.delBookById(id);
        return "redirect:/book/allBook";//重定向到@RequestMapping("/allBook")请求
    }

    //搜索 模糊查询
    @RequestMapping("/queryBook")
    public String queryBook(String queryBookName,Model model){
//        List<Books> books = bookService.queryBookByName(queryBookName);
        if (queryBookName == null || queryBookName == "") {
            model.addAttribute("msg","未找到相关数据");
        } else {
            model.addAttribute("list",bookService.selectBookLike(queryBookName));
        }
        return "allBook";
    }
}
