package com.example.app.containainer.responseform;

import java.util.ArrayList;
import java.util.List;

/*
 * 処理結果クラス
 */
public class WebResponseResult<T> {

    /** レスポンスフォーム */
    private T responseForm;

    /** インフォメッセージリスト */
    List<String> infoMessageList = new ArrayList<>();

    /** エラーメッセージリスト */
    List<String> errorMessageList = new ArrayList<>();

    public T getResponseForm() {
        return responseForm;
    }

    public void setResponseForm(T responseForm) {
        this.responseForm = responseForm;
    }

    public List<String> getInfoMessageList() {
        return infoMessageList;
    }

    public void setInfoMessageList(List<String> infoMessageList) {
        this.infoMessageList = infoMessageList;
    }

    public List<String> getErrorMessageList() {
        return errorMessageList;
    }

    public void setErrorMessageList(List<String> errorMessageList) {
        this.errorMessageList = errorMessageList;
    }
}
