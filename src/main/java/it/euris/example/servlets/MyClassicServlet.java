package it.euris.example.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.euris.example.models.User;

@WebServlet(
		  name = "myClassicServlet",
		  urlPatterns = {"/ciao", "/salve"},
		  loadOnStartup = 1
		)
public class MyClassicServlet extends HttpServlet{
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		User myUser = new User("Armando", "Donzelli");
		request.setAttribute("mioUtente", myUser);
		request.getRequestDispatcher("/WEB-INF/views/hiddenPage.jsp").forward(request,response);
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		this.doGet(request, response);
	}

}
