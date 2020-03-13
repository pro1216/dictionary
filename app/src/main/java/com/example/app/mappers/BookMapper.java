package com.example.app.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.app.domain.Book;

@Mapper
public interface BookMapper{

    /**
     * すべての単語を取得する
     *
     * @return 単語リスト
     */
    public List<Book> findAll();

	public List<Book> findByGenre(@Param("genre")String genre,@Param("name")String name);

	public List<Book> findById(String id);

	public int updateById(@Param("date")String date, @Param("id")String id);

	public List<Book> findByLentFlag();


}