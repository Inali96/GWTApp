package com.exmaple.email.client;

import java.util.ArrayList;


import com.google.gwt.user.client.rpc.AsyncCallback;

public interface MessageServiceAsync 
{
	void insertMessage(String tytul, String adresat, String tresc,String zdjecie, AsyncCallback<Message> callback);
	void getEmail(String kategoria, AsyncCallback<ArrayList<Email>>callback);
	void insertMessagerobocze(String tytul, String adresat, String tresc,String zdjecie, AsyncCallback<Message> callback);
	void insertMessageSpam(int id, AsyncCallback<Message> callback);
}
