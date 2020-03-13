package com.example.app.controller;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.app.containainer.responseform.DictionaryResponseForm;
import com.example.app.domain.Book;
import com.example.app.mappers.BookMapper;
import com.example.app.service.BookService;


@RestController
public class DictionaryController {

	@Autowired
	BookService bookService;

	@Autowired
	BookMapper bookMapper;


	@RequestMapping("/user")
	public Model message(Model model) {
		return model;
	}



	@GetMapping("/index")
	public ModelAndView index(ModelAndView model) throws Exception {

		DictionaryResponseForm responseForm = new DictionaryResponseForm();
		responseForm.setBookList(bookService.searchAllBook());
		List<Book> list = new ArrayList<Book>();


		list = responseForm.getBookList();

		model.addObject("list", list);
		model.setViewName("/index");

		return model;
	}

	@PostMapping("/index/result")
	public ModelAndView searchGenre(ModelAndView model,@RequestParam(name="genre")String genre,@RequestParam(name="name")String name)throws Exception{
		DictionaryResponseForm responseForm = new DictionaryResponseForm();
		List<Book> list = new ArrayList<Book>();
		responseForm.setBookList(bookService.searchByGenre(genre, name));
		list = responseForm.getBookList();



		model.setViewName("/index");
		model.addObject("list",list);

		return model;
	}

	@RequestMapping("/index/result/{name}")
	public ModelAndView detail(ModelAndView model ,@RequestParam("id")String id) {


		DictionaryResponseForm responseForm = new DictionaryResponseForm();
		List<Book> list = new ArrayList<Book>();
		responseForm.setBookList(bookService.searchById(id));
		list = responseForm.getBookList();


		model.setViewName("/detail");
		model.addObject("list",list);

		return model;
	}

	@PostMapping("/index/approve")
	public ModelAndView approve(ModelAndView model ,@RequestParam("id")String id) throws ParseException {

		DictionaryResponseForm responseForm = new DictionaryResponseForm();
		List<Book> list = new ArrayList<Book>();
		List<Book> resultList = new ArrayList<Book>();
		responseForm.setBookList(bookService.searchById(id));
		list = responseForm.getBookList();
		if(list.get(0).getLentFlag()!=1 && list.get(0).getStock() > 0) {

			Date date = new Date();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			String dateResult = dateFormat.format(date);

			int line = bookService.updateById(dateResult,id);
			responseForm.setBookList(bookService.searchById(id));
			resultList = responseForm.getBookList();
			model.addObject("list",resultList);
			model.setViewName("/detail");
		}else {
			model.setViewName("/index");
		}



		return model;
	}
	@RequestMapping("/check")
	public ModelAndView check(ModelAndView model) {
		DictionaryResponseForm responseForm = new DictionaryResponseForm();
		List<Book> list = new ArrayList<Book>();
		responseForm.setBookList(bookService.searchByLentFlag());
		list = responseForm.getBookList();

		model.addObject("list",list);
		model.setViewName("/check");

		return model;
	}

}