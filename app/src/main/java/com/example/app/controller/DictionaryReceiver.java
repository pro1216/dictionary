package com.example.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.app.containainer.responseform.DictionaryResponseForm;
import com.example.app.service.BookService;

@Component
public class DictionaryReceiver  {

    @Autowired
    BookService bookService;



    public List<DictionaryResponseForm> init() {
        List<DictionaryResponseForm> result = new ArrayList<DictionaryResponseForm>();

        DictionaryResponseForm responseForm = new DictionaryResponseForm();
        responseForm.setBookList(bookService.searchAllBook());

        result.add(responseForm);

        return result;
    }
}
