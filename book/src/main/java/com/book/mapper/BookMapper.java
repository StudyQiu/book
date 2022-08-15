package com.book.mapper;

import com.book.entity.Books;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookMapper {

    /**
     * 添加
     * @param books
     * @return
     */
    Integer addBook(Books books);

    /**
     * 删除
     * @param id
     * @return
     */
    Integer delBookById(@Param("bookid") Integer id);

    /**
     * 修改
     * @param books
     * @return
     */
    Integer updateBook(Books books);

    /**
     * 根据id查询
     * @param bookid
     * @return
     */
    Books queryBookById(@Param("bookid") Integer bookid);

    /**
     * 查询全部
     * @return
     */
    List<Books> queryAllBook();

    /**
     * 模糊查询
     * @param bookname
     * @return
     */
    List<Books> queryBookByName(@Param("bookname") String bookname);

    List<Books> selectBookLike(@Param("bookname") String bookname);
}
