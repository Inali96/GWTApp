package com.exmaple.email.client;
import java.util.ArrayList;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("message")
public interface MessageService extends RemoteService
{
	
	Message insertMessage(String tytul, String adresat, String tresc,String zdjecie); 
	Message insertMessagerobocze(String tytul, String adresat, String tresc,String zdjecie); 
	ArrayList<Email>getEmail(String kategoria);
	Message insertMessageSpam(int id); 
}
