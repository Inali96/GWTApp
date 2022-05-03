package com.exmaple.email.client;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.BorderStyle;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.HasKeyboardSelectionPolicy.KeyboardSelectionPolicy;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.FileUpload;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.FormPanel.SubmitCompleteEvent;
import com.google.gwt.user.client.ui.FormPanel.SubmitEvent;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.TabLayoutPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Emaill implements EntryPoint {
	/**
	 * This is the entry point method.
	 */
	public ArrayList<Email> emaile= new ArrayList<Email>();
	
	private MessageServiceAsync messageService = GWT.create(MessageService.class);
	private class MessageCallBack implements AsyncCallback<Message>
	{
		public void onFailure(Throwable caught)
		{
			Window.alert("Blad");
		}
		public void onSuccess(Message result)
		{
			Window.alert("Wyslano wiadomosc do: " + result.getMessage());
			
		}
	}
	
	private class MessageCallBack1 implements AsyncCallback<Message>
	{
		public void onFailure(Throwable caught)
		{
			Window.alert("Blad");
		}
		public void onSuccess(Message result)
		{
			Window.alert("Przeniesiono do folderu Spam: " + result.getMessage());
			
		}
	}

	private class MessageCallBack2 implements AsyncCallback<Message>
	{
		public void onFailure(Throwable caught)
		{
			Window.alert("Blad");
		}
		public void onSuccess(Message result)
		{
			Window.alert("Zapisano do wiadomosc roboczych: " + result.getMessage());
			
		}
	}
	
	private class MessageList implements AsyncCallback<ArrayList<Email>>
	{
		public void onFailure(Throwable caught)
		{
			
		}
		public void onSuccess(ArrayList<Email>result)
		{
			for(int i=0;i<result.size();i++)
			{
				emaile= result;
			}
			
			
		}
	}

  
	 
	public void onModuleLoad() {
		
		
		//messageService.insertMessage("costam", "costam", new MessageCallBack());
							
							 // Create a FormPanel and point it at a service.
						    final FormPanel rejestracja = new FormPanel();
						    final FormPanel logowanie = new FormPanel();
						    //rejestracja.setAction("/rejestracjaHandler");
						   // logowanie.setAction("/logowanieHandler");
						    // Because we're going to add a FileUpload widget, we'll need to set the
						    // form to use the POST method, and multipart MIME encoding.
						   // rejestracja.setEncoding(FormPanel.ENCODING_MULTIPART);
						   // rejestracja.setMethod(FormPanel.METHOD_POST);
						   // logowanie.setEncoding(FormPanel.ENCODING_MULTIPART);
						   // logowanie.setMethod(FormPanel.METHOD_POST);
						    // Create a panel to contains all of the form widgets.
						    VerticalPanel panel2 = new VerticalPanel();
						    panel2.setBorderWidth(1);
						    panel2.setSpacing(2);
						    rejestracja.setWidget(panel2);
						    panel2.setSize("70%","300px");
						    panel2.getElement().getStyle().setBackgroundColor("pink");
						    // Create a TextBox, giving it a name so that it will be submitted.
						    final TextBox tbb = new TextBox();
						    final PasswordTextBox tbb2 = new PasswordTextBox();
						    tbb.setText("Login");
						    tbb2.setText("Haslo");
						    panel2.add(tbb);
						    panel2.add(tbb2);
						    tbb.setSize("99%","12px");
						 
						    
						  //  rejestracja.setWidget(panel2);
						    
						    
						    
						   /* VerticalPanel panel3 = new VerticalPanel();
						    panel3.setBorderWidth(1);
						    panel3.setSpacing(2);
						    logowanie.setWidget(panel3);
						    panel3.setSize("70%","300px");
						    panel3.getElement().getStyle().setBackgroundColor("pink");
						    // Create a TextBox, giving it a name so that it will be submitted.
						    final TextBox tbbl = new TextBox();
						    final PasswordTextBox tbbl2 = new PasswordTextBox();
						    tbbl.setText("Login");
						    tbb2.setText("Haslo");
						    panel3.add(tbbl);
						    panel3.add(tbbl2);
						    tbbl.setSize("99%","12px");
						    tbbl2.setSize("99%","12px");
						    
						    logowanie.setWidget(panel3);
							   
							// Adding an event handler to the form.
							   rejestracja.addSubmitHandler(new FormPanel.SubmitHandler() {
							        public void onSubmit(SubmitEvent event) {
							            // This event is fired just before the form is submitted.
							            // this provides opportunity to perform validation.
							            if (tbb.getText().length() == 0) {
							                Window.alert("Wypelnij oba pola");
							                event.cancel();
							            }
							        }
							    });
							   
							   
							   
							   
							// Adding an event handler to the form.
							   logowanie.addSubmitHandler(new FormPanel.SubmitHandler() {
							        public void onSubmit(SubmitEvent event) {
							            // This event is fired just before the form is submitted.
							            // this provides opportunity to perform validation.
							            //if (tbb.getText().length() == 0) {
							               // Window.alert("Wypelnij oba pola");
							               // event.cancel();
							           // }
							        }
							    });
							  
							   RootPanel.get().add(rejestracja); 
							  // RootPanel.get("gwtContainer2").add(logowanie);*/ 
							   
							   
		 // Create a FormPanel and point it at a service.
	    final FormPanel form = new FormPanel();
	    form.setAction("/myFormHandler");
	    
	   
	    // Because we're going to add a FileUpload widget, we'll need to set the
	    // form to use the POST method, and multipart MIME encoding.
	    form.setEncoding(FormPanel.ENCODING_MULTIPART);
	    form.setMethod(FormPanel.METHOD_POST);
	 
	    // Create a panel to contains all of the form widgets.
	    VerticalPanel panel = new VerticalPanel();
	    panel.setBorderWidth(1);
	    panel.setSpacing(4);
	    form.setWidget(panel);
	    panel.setSize("70%","300px");
	    panel.getElement().getStyle().setBackgroundColor("pink");
	    // Create a TextBox, giving it a name so that it will be submitted.
	    final TextBox tb = new TextBox();
	    tb.setText("Tytul wiadomosci");
	    panel.add(tb);
	    tb.setSize("99%","12px");
	    // Create a TextBox, giving it a name so that it will be submitted.
	    final TextBox tb2 = new TextBox();
	    tb2.setText("Adresat");
	    panel.add(tb2);
	    tb2.setSize("99%","12px");
	    
	    final TextArea ta = new TextArea();
	    ta.setCharacterWidth(200);
	    ta.setVisibleLines(10);
	    panel.add(ta);
	    ta.setText("Tresc");
	    
	 
	    // Create a FileUpload widget.
	    final FileUpload upload = new FileUpload();
	    upload.setName("uploadForm");
	    panel.add(upload);
	 
	    // Adding a submit button.
	   panel.add(new Button("Wyslij wiadomosc", new ClickHandler() {
	        @Override
	        	 public void onClick(ClickEvent event) {
		        	 if (tb.getText().length() == 0||tb2.getText().length() == 0||ta.getText().length() == 0) 
		        	 {
			                Window.alert("Pola nie moga byc puste");
			            }else   
			            	
	            form.submit();
	        }
	    }));
	   
	   // Adding a submit button.
	   panel.add(new Button("Wyczysc pola", new ClickHandler() {
	        @Override
	        public void onClick(ClickEvent event) {
	        	form.reset();
	        	
	        }
	    }));
	  
	 
	   
	    // Adding an event handler to the form.
	    form.addSubmitHandler(new FormPanel.SubmitHandler() {
	        public void onSubmit(SubmitEvent event) {
	            // This event is fired just before the form is submitted.
	            // this provides opportunity to perform validation.
	            if (tb.getText().length() == 0) {
	                Window.alert("Pola nie moga byc puste");
	                event.cancel();
	            }
	        }
	    });
	    form.addSubmitCompleteHandler(new FormPanel.SubmitCompleteHandler() {
	        public void onSubmitComplete(SubmitCompleteEvent event) {
	         
		        	messageService.insertMessage(tb.getText(), tb2.getText(), ta.getText(),upload.getFilename(), new MessageCallBack());
		        		       
	            Window.alert(event.getResults());
	        }
	    });

	    
	    
	    
	    
		 // Make a new check box, and select it by default.
	

	   
	   
	
		 // Make a new list box, adding a few items to it.
	   
        
	    final ListBox lb = new ListBox();
		
	    lb.setSize("100%", "100%");
	    // Make enough room for all five items (setting this value to 1 turns it
	    // into a drop-down list).
	    lb.setVisibleItemCount(5);
	    lb.setTabIndex(1);
	    // Make a new list box, adding a few items to it.
	    final ListBox lb2 = new ListBox();
	   
	    lb2.setSize("100%", "100%");
	    // Make enough room for all five items (setting this value to 1 turns it
	    // into a drop-down list).
	    lb2.setVisibleItemCount(5);
	    // Make a new list box, adding a few items to it.
	    final ListBox lb3 = new ListBox();
	    lb3.addItem("foo");
	    lb3.addItem("tintin");
	    lb3.setSize("100%", "100%");
	    // Make enough room for all five items (setting this value to 1 turns it
	    // into a drop-down list).
	    lb3.setVisibleItemCount(5);
	    
	    // Make a new list box, adding a few items to it.
	    final ListBox lb4 = new ListBox();
	    lb4.addItem("foo");
	    lb4.addItem("tintin");
	    lb4.setSize("100%", "100%");
	    // Make enough room for all five items (setting this value to 1 turns it
	    // into a drop-down list).
	    lb4.setVisibleItemCount(5);
	    
	    
		final TabLayoutPanel p = new TabLayoutPanel(1.5, Unit.EM);
		p.add(lb, "Odebrane");
		p.add(lb2, "Spam");
		p.add(lb3, "Wyslane");
		p.add(lb4, "Robocze");
		p.setSize("100%", "300px");
		
		
		 
		 // scrollable text 
	    final HTML htmlString = new HTML("");
	 
	    // scrollpanel with text
	    final ScrollPanel scrollPanel = new ScrollPanel(htmlString);
	    scrollPanel.setSize("100%", "150px");
	    scrollPanel.getElement().getStyle().setBorderStyle(BorderStyle.SOLID);
	  
	    
	    final TextBox tbtytul = new TextBox();
	    final TextBox tbautor = new TextBox();
	    tbautor.setText("autor");
	    tbtytul.setText("tytul");
	    tbautor.setSize("60%","12px");
	    tbtytul.setSize("60%","12px");
	    tbautor.getElement().setAttribute("readonly", "readonly");
	    tbtytul.getElement().setAttribute("readonly", "readonly");
	    tbautor.getElement().getStyle().setBackgroundColor("pink");
	    tbtytul.getElement().getStyle().setBackgroundColor("pink");
	    
	    
	    FlowPanel flowPanel = new FlowPanel();
	    // Add buttons to flow Panel
	    flowPanel.setSize("100%", "100%");
	    
	    flowPanel.add(new Button("Odswiez", new ClickHandler() {
	        @Override
	        public void onClick(ClickEvent event) 
	        {
	        
	        	if(lb2.isVisible()) {
	        		lb2.clear();
		        	 messageService.getEmail("Spam", new MessageList());
		        	
		     	    for (int i = 0; i < emaile.size(); i++)
		     	    {
		     	    	
		                 lb2.addItem(emaile.get(i).gettytul());
		                 
		     	    }
	        	}
		     	    else if(lb.isVisible()) {
		        		lb.clear();
			        	 messageService.getEmail("Odebrane", new MessageList());
			        	
			     	    for (int i = 0; i < emaile.size(); i++)
			     	    {
			     	    	
			                 lb.addItem(emaile.get(i).gettytul());
			                 
			     	    }
		     	   
	        	}
		     	   else if(lb3.isVisible()) {
		        		lb3.clear();
			        	 messageService.getEmail("Wyslane", new MessageList());
			        	
			     	    for (int i = 0; i < emaile.size(); i++)
			     	    {
			     	    	
			                 lb3.addItem(emaile.get(i).gettytul());
			                 
			     	    }
		     	   
	        	}
		     	  else if(lb4.isVisible()) {
		        		lb4.clear();
			        	 messageService.getEmail("Robocze", new MessageList());
			        	
			     	    for (int i = 0; i < emaile.size(); i++)
			     	    {
			     	    	
			                 lb4.addItem(emaile.get(i).gettytul());
			                 
			     	    }
	        	}
	        	 
	        }
	    }));
	        Button btn = new Button("Utworz wiadomosc");
	        
	        btn.addClickHandler(new ClickHandler() {
	        	   @Override
	        	   public void onClick(ClickEvent event) {
	        		   form.setVisible(true);
	        		  

	        	   }
	        	   });
	        Label lbl = new Label("Tytul wiadomosci "); 
	        Label lbl2 = new Label("Nadawca wiadomosci "); 
	        Label lbl3 = new Label("Adresat wiadomosci "); 
	       final ListBox lb5 = new ListBox();
	       final ListBox lb6 = new ListBox();
	       final ListBox lb7 = new ListBox();
	       
	       lb5.setVisibleItemCount(0);
	       lb6.getElement().getStyle().setWidth(300, Unit.PX);
	       lb5.getElement().getStyle().setWidth(300, Unit.PX);
	       lb7.getElement().getStyle().setWidth(300, Unit.PX);
	        Button btn2 = new Button("Usun wyswietlana wiadomosc/nie usuwa z bazy");
	        Button btn3 = new Button("Przenies do spamu/nie pobiera id z bazy");
	        flowPanel.add(btn);
	        flowPanel.add(btn2);
	        flowPanel.add(btn3);
	     // Add buttons to flow Panel
	        
	       
	     
	        flowPanel.add(lbl);
	        flowPanel.add(lb5);
	        flowPanel.add(lbl2);
	        flowPanel.add(lb6);
	        flowPanel.add(lbl3);
	        flowPanel.add(lb7);
		    FlowPanel flowPanel2 = new FlowPanel();
		    
		     
			        
			        
			        
		final DockLayoutPanel mainPanel = new DockLayoutPanel(Unit.PX);
		    mainPanel.setSize("100%", "1000px");
		    VerticalPanel leftPanel = new VerticalPanel();
		    
		   // Label treeStr1 = new Label("Lista emaili");
		   // treeStr1.setSize("100%", "100px");
		   // Label treeStr2 = new Label("Tree Str2");
		   // treeStr2.setSize("100%", "300px");
		    HorizontalPanel row01 = new HorizontalPanel();
		    row01.setWidth("100%");
		    row01.setHeight("40px");
		    
		    leftPanel.add(p);
		    leftPanel.add(row01);
		    leftPanel.setSize("98%", "300px");
		    leftPanel.getElement().getStyle().setBorderStyle(BorderStyle.SOLID);
		    
		  
		

		    VerticalPanel centralArea = new VerticalPanel();
		    
		    centralArea.setSize("100%", "100%");
		    centralArea.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		    centralArea.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		    HorizontalPanel row0 = new HorizontalPanel();
		    row0.setWidth("100%");
		    row0.setHeight("20px");
		    row0.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		    HorizontalPanel row1 = new HorizontalPanel();
		    row1.setWidth("90%");
		    row1.setHeight("80%");
		    row1.getElement().getStyle().setBackgroundColor("pink");
		    row1.setVerticalAlignment(HasVerticalAlignment.ALIGN_TOP);
		    row1.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		    HorizontalPanel row2 = new HorizontalPanel();
		    row2.setWidth("70%");
		    row2.setHeight("400px");
		    row2.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		    HorizontalPanel row3 = new HorizontalPanel();
		    row3.setWidth("100%");
		    row3.setHeight("100%");
		    row3.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
	
		    centralArea.add(row0);
		    centralArea.add(row1);
		    centralArea.add(row2);
		    centralArea.add(flowPanel2);
		    
		   
		  
		  
		    
		    HTML ca2 = new HTML("Content Area 2");
		    ca2.setSize("60%", "60px");
		    ca2.getElement().getStyle().setBorderStyle(BorderStyle.SOLID);
		    HTML ca3 = new HTML("Content Area 3");
		    ca3.setSize("30%", "60px");
		    ca3.getElement().getStyle().setBorderStyle(BorderStyle.SOLID);

		    row0.add(flowPanel);
		    row1.add(scrollPanel);
		    
		    row2.add(row3);
		   
		    row3.add(form);
		    //row3.add(flowPanel3);
		    mainPanel.addNorth(new HTML(
		            "<h1>Zmail</h1>"), 150);
		    mainPanel.addWest(leftPanel, 400);
		    mainPanel.add(centralArea);
		    RootPanel.get().add(mainPanel);
		    
		    form.setVisible(false);
		    
		    
		    
		 
		    // Adding a submit button.
			   panel2.add(new Button("Zarejestruj", new ClickHandler() {
			        @Override
			        public void onClick(ClickEvent event) {
			            rejestracja.submit();
			        }
			    }));
			   panel2.add(new Button("Jestem zarejestrowany/a", new ClickHandler() {
			        @Override
			        public void onClick(ClickEvent event) {
			          
			        	RootPanel.get().clear();
			        	RootPanel.get().add(logowanie);

			        }
			    }));
	            

			  /* // Adding a submit button.
			   panel3.add(new Button("Zaloguj", new ClickHandler() {
			        @Override
			        public void onClick(ClickEvent event) {
			            logowanie.submit();
			        }
			    }));
			// Adding a submit button.
			   panel3.add(new Button("Rejestracja", new ClickHandler() {
			        @Override
			        public void onClick(ClickEvent event) {
			        	RootPanel.get().remove(logowanie);
			        	RootPanel.get().add(rejestracja);
			        }
			    }));
			   logowanie.addSubmitCompleteHandler(new FormPanel.SubmitCompleteHandler() {
			        public void onSubmitComplete(SubmitCompleteEvent event) {
			        	//messageService.insertMessage("login", "haslo", new MessageCallBack());
			            // This event fired after the form submission is successfully completed.
			            // Assuming the service returned a response of type text/html,
			            // we can get the result text here.

			        	RootPanel.get().add(mainPanel);
			        	RootPanel.get().remove(logowanie);
			        }
			    });	           
			   rejestracja.addSubmitCompleteHandler(new FormPanel.SubmitCompleteHandler() {
			        public void onSubmitComplete(SubmitCompleteEvent event) {
			        	//messageService.insertMessage("login", "haslo", new MessageCallBack());
			            // This event fired after the form submission is successfully completed.
			            // Assuming the service returned a response of type text/html,
			            // we can get the result text here.
			        	logowanie.setVisible(true);
			            Window.alert(event.getResults());
			        }
			    });
			   btn01.addClickHandler(new ClickHandler() {
	        	   @Override
	        	   public void onClick(ClickEvent event) {
	        		   RootPanel.get().add(logowanie);
	        		   RootPanel.get().remove(mainPanel);

	        	   }
	        	   });*/
			   
			   
			   
			  
			   p.addSelectionHandler(new SelectionHandler<Integer>() {
					@Override
					public void onSelection(SelectionEvent<Integer> event) {
						
						lb.clear();
						 lb2.clear();
						 lb3.clear();
						 lb4.clear();
						 
						
						/* messageService.getEmail("Odebrane", new MessageList());
			        	  for (int i = 0; i < emaile.size(); i++)
				     	    {
				     	    	
				                 lb.addItem(emaile.get(i).gettytul());
				                 
				     	    }
			        	  messageService.getEmail("Spam", new MessageList());
			        	  for (int i = 0; i < emaile.size(); i++)
				     	    {
				     	    	
				                 lb2.addItem(emaile.get(i).gettytul());
				                 
				     	    }*/
			        	 
					}
			   });
			   
			  
			  
			   
			   lb.addClickHandler(new ClickHandler() {//przenosi tytul do prawego listboxa

				@Override
				public void onClick(ClickEvent event) {
					lb5.clear();
					lb6.clear();
					lb7.clear();
					 messageService.getEmail("", new MessageList());
					 
					
			     	    for (int i = 0; i < lb.getItemCount(); i++)
					{
					    if (lb.isItemSelected(i)) //jezeli jest wybrana wiadomosc
					    {
					    	 lb5.addItem(emaile.get(i).gettytul());
				             lb6.addItem(emaile.get(i).getnadawca());
				             lb7.addItem(emaile.get(i).getadresat());
				             htmlString.setText(emaile.get(i).gettresc());
				            
					    }
					}
				}
				
				   
			   });
			   lb2.addClickHandler(new ClickHandler() {//przenosi tytul do prawego listboxa

					@Override
					public void onClick(ClickEvent event) {
						lb5.clear();
						lb6.clear();
						lb7.clear();
						 messageService.getEmail("", new MessageList());
						 
						
				     	    for (int i = 0; i < lb2.getItemCount(); i++)
						{
						    if (lb2.isItemSelected(i)) //jezeli jest wybrana wiadomosc
						    {
						    	 lb5.addItem(emaile.get(i).gettytul());
					             lb6.addItem(emaile.get(i).getnadawca());
					             lb7.addItem(emaile.get(i).getadresat());
					             htmlString.setText(emaile.get(i).gettresc());
					            
						    }
						}
					}
					   
				   });
			   lb3.addClickHandler(new ClickHandler() {//przenosi tytul do prawego listboxa

					@Override
					public void onClick(ClickEvent event) {
						lb5.clear();
						lb6.clear();
						lb7.clear();
						 messageService.getEmail("", new MessageList());
						 
						
				     	    for (int i = 0; i < lb3.getItemCount(); i++)
						{
						    if (lb3.isItemSelected(i)) //jezeli jest wybrana wiadomosc
						    {
						    	 lb5.addItem(emaile.get(i).gettytul());
					             lb6.addItem(emaile.get(i).getnadawca());
					             lb7.addItem(emaile.get(i).getadresat());
					             htmlString.setText(emaile.get(i).gettresc());
					            
						    }
						}
					}
					   
				   });
			   lb4.addClickHandler(new ClickHandler() {//przenosi tytul do prawego listboxa

					@Override
					public void onClick(ClickEvent event) {
						lb5.clear();
						lb6.clear();
						lb7.clear();
						 messageService.getEmail("", new MessageList());
						 
						
				     	    for (int i = 0; i < lb4.getItemCount(); i++)
						{
						    if (lb4.isItemSelected(i)) //jezeli jest wybrana wiadomosc
						    {
						    	 lb5.addItem(emaile.get(i).gettytul());
					             lb6.addItem(emaile.get(i).getnadawca());
					             lb7.addItem(emaile.get(i).getadresat());
					             htmlString.setText(emaile.get(i).gettresc());
					            
						    }
						}
					}
					   
				   });
			   
			   btn2.addClickHandler(new ClickHandler() {
	        	   @Override
	        	   public void onClick(ClickEvent event) {
	        		   if(lb.isVisible()) {
	        		   for (int i = 0; i < emaile.size(); i++) {
	        			   if(lb.isItemSelected(i)){
	        				  
	        				   lb.removeItem(i);
	        			   }
	        			
	        		   }
	        		   }
	        		   else if(lb2.isVisible()) {
		        		   for (int i = 0; i < emaile.size(); i++) {
		        			   if(lb2.isItemSelected(i)){
		        				  
		        				   lb2.removeItem(i);
		        			   }
		        			
		        		   }
		        		   }
	        		   else if(lb3.isVisible()) {
		        		   for (int i = 0; i < emaile.size(); i++) {
		        			   if(lb3.isItemSelected(i)){
		        				  
		        				   lb3.removeItem(i);
		        			   }
		        			
		        		   }
		        		   }
	        		   else if(lb4.isVisible()) {
		        		   for (int i = 0; i < emaile.size(); i++) {
		        			   if(lb4.isItemSelected(i)){
		        				  
		        				   lb4.removeItem(i);
		        			   }
		        			
		        		   }
		        		   }
	        	   }
	        	   });
			   
			   btn3.addClickHandler(new ClickHandler() {
	        	   @Override
	        	   public void onClick(ClickEvent event) {
	        		   
	        		   if(lb.isVisible()) {
	        			   
	        			  // messageService.insertMessageSpam(lb.getElement().getId(), new MessageCallBack1());//nie dziala pobieranie id
	        			   messageService.insertMessageSpam(lb.getTabIndex(), new MessageCallBack1());//pobiera id z tablicy nie z bazy
				     	    for (int i = 0; i < emaile.size(); i++)
				     	    {
				     	    	 
				                 lb2.addItem(emaile.get(i).gettytul());
				                 
				     	    }
			     	   

	        	   }
	        	   }
	});
			// Adding a submit button.
			   panel.add(new Button("Zapisz do roboczych", new ClickHandler() {
			        @Override
			        public void onClick(ClickEvent event) {
			        	 if (tb.getText().length() == 0||tb2.getText().length() == 0||ta.getText().length() == 0) {
				                Window.alert("Pola nie moga byc puste");
				               
				            }else
			        	messageService.insertMessagerobocze(tb.getText(), tb2.getText(), ta.getText(),upload.getFilename(), new MessageCallBack2());
			        		        }
			    }));
			   // Adding a submit button.
			   panel.add(new Button("Zamknij", new ClickHandler() {
			        @Override
			        public void onClick(ClickEvent event) {
			            form.setVisible(false);
			        }
			    }));
			   
			   }
}



	

//przez problem podwojnego odswiezania nie moglam dodac wczytywania listy emaili po kliknieciu w kategorie, musialam dodac przycisk odswiez
//trzeba 2 razy odswiezyc, usuwanie i przenoszenie do spamu nie dziala(w bazie), poniewaz nie bylam w stanie znalezc mozliwosci pobrania id z bazy, jedynie pobiera id z listy, probowalam kazdej metody
//nie da sie wyslac emaila na prawdziwy adres, jedynie do bazy, poniewaz nie bylam w stanie tego zrobic 
   
    //dodac adresata do wyslanych, usunac odbiorce  
	//usuwanie wiadomosci z bazy
    //po kliknieciu utworz wiadomosc ma sie pojawic okienko dolne   -jest
	//dodac zapisywanie w bazie jako robocza i wyslana   - jest
	//dodac wysylanie wiadomosci na emaila  - ciezko
	//dodac czyszczenie forma
	//dodac zaznaczanie wszystkiego i usuwanie -nie da sie na listboxie
	//dodac tytul nad wyswietlona wiadomoscia - jest
