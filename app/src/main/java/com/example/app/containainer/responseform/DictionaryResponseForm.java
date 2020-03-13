package com.example.app.containainer.responseform;

import java.util.ArrayList;
import java.util.List;

import com.example.app.domain.Book;

public class DictionaryResponseForm {
	/*
	 * 辞書用レスポンスフォーム
	 */


	/** 単語リスト */
	private List<Book> bookList = new ArrayList<>();

	public List<Book> getBookList() {
		return bookList;
	}

	public void setBookList(List<Book> bookList) {
		this.bookList = bookList;
	}

}

