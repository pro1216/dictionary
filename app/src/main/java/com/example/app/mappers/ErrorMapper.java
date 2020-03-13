package com.example.app.mappers;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ErrorMapper {

    /**
     * エラー文言を取得
     *
     * @return エラー
     */
    public String findMessage(@Param("keyword")String keyword,@Param("word")String word);
}
