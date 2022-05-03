package com.exmaple.email.client;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class MessageServiceImpl extends RemoteServiceServlet
implements MessageService
{
	 private static final long serialVersionUID = 1L;
	 
	 
	 public Message getMessage(String user, String passwd) 
	 {
		 Message message = new Message();
		
		 final String sqlstat = "insert into uzytkownicy (login, haslo) VALUES (?,?)";
	
		
		 		 
		 try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/projektemail","root","");
	        PreparedStatement preparedStatement = conn.prepareStatement(sqlstat)) 
		 	{
			 	

					  preparedStatement.setString(1, user);
			          preparedStatement.setString(2, passwd);
			          message.setMessage(user);
			          
			          int row = preparedStatement.executeUpdate();
			          System.out.println(row); //1

	        } catch (SQLException e) {
	            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

		 return message;
	 }
	 
	 		  
	 public Message insertMessage(String tytul, String adresat,String tresc,String zdjecie) 
	 {
		 Message message = new Message();
		
		 final String sqlstat = "insert into emaile (tytul, adresat, tresc, nadawca,kategoria,zdjecie) VALUES (?,?,?,'TY@zmail.com','Wyslane',?)";
	
		
		 		 
		 try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/projektemail","root","");
	        PreparedStatement preparedStatement = conn.prepareStatement(sqlstat)) 
		 	{
			 	

					  preparedStatement.setString(1, tytul);
			          preparedStatement.setString(2, adresat);
			          preparedStatement.setString(3, tresc);
			          preparedStatement.setString(4, zdjecie);
			          message.setMessage(adresat);
			          
			          int row = preparedStatement.executeUpdate();
			          System.out.println(row); //1

	        } catch (SQLException e) {
	            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

		 return message;
	 }

	private final Connection connect() 
	{
		Connection conn = null;
		 try 
		 {
		       //Class.forName("com.mysql.jdbc.Driver");
			   Class.forName("com.mysql.cj.jdbc.Driver");
		        conn = DriverManager.getConnection ("jdbc:mysql://localhost/projektemail","root","");
		       System.out.println("Connection successful");	      
		 } 
		 
		 catch (Exception e) {
		       System.err.println(e);
		 }
		 return conn;
	}

	 public ArrayList<Email> getEmail(String kategoria)
	 {
		ArrayList<Email> emaile = new ArrayList<>();
		 try
		 {
			 PreparedStatement ps = connect().prepareStatement("select tytul,nadawca,adresat,tresc from emaile where kategoria='"+kategoria+"'");
			 ResultSet result = ps.executeQuery();
			 
			 while (result.next()) 
			 {
				 Email email = new Email();
				 
				 email.settytul(result.getString(1));
				 email.setnadawca(result.getString(2));
				 email.setadresat(result.getString(3));
				 email.settresc(result.getString(4));
				 emaile.add(email);
				
			 }
			 
			 result.close();
			 ps.close();
		 }
		 catch(SQLException sql)
		 {
			 System.out.println(sql);
		 }
		return emaile;
	 }
	 
	 public Message insertMessagerobocze(String tytul, String adresat,String tresc,String zdjecie) 
	 {
		 Message message = new Message();
		
		 final String sqlstat = "insert into emaile (tytul, adresat, tresc, nadawca,kategoria,zdjecie) VALUES (?,?,?,'TY@zmail.com','Robocze',?)";
	
		
		 		 
		 try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/projektemail","root","");
	        PreparedStatement preparedStatement = conn.prepareStatement(sqlstat)) 
		 	{
			 	

					  preparedStatement.setString(1, tytul);
			          preparedStatement.setString(2, adresat);
			          preparedStatement.setString(3, tresc);
			          preparedStatement.setString(4, zdjecie);
			          message.setMessage(adresat);
			          
			          int row = preparedStatement.executeUpdate();
			          System.out.println(row); //1

	        } catch (SQLException e) {
	            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

		 return message;
	 }
	 public Message insertMessageSpam(int id) //int nie dziala na pobieranie, string tez 
	 {
		 Message message = new Message();
		
		 final String sqlstat = "update emaile set kategoria='Spam' where id=?";
		
		
		 		 
		 try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/projektemail","root","");
	        PreparedStatement preparedStatement = conn.prepareStatement(sqlstat)) 
		 	{
			 	

			 		preparedStatement.setInt(1, id); 
			 	
			 		message.setMessage2(id);
			          int row = preparedStatement.executeUpdate();
			          System.out.println(row); //1

	        } catch (SQLException e) {
	            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

		 return message;
	 }




	 
	 
} 
