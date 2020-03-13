package com.example.app.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.app.domain.User;

@Mapper
public interface UserMapper{

    /**
     * ユーザーを検索
     *
     * @return 名前
     */
	public List<User> findName(@Param("id") String id,@Param("password") String password);


}