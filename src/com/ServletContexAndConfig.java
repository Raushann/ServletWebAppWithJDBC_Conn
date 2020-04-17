package com;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ServletContexAndConfig extends HttpServlet {
	ServletConfig scfg ;
	@Override
	public void init(ServletConfig config) throws ServletException {
		this.scfg=config;
	}
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		try {
			String clientReqBrowser = req.getParameter("browsername");
			
			/*
			 config parameter common for all user
			 but specific for servlet
			*/
			//ServletConfig scfg = getServletConfig();
			String configDataOwner = scfg.getInitParameter("owner");
			
			ServletContext sctx = scfg.getServletContext();
			String contexDataWebsite = sctx.getInitParameter("website");
			
			String responseData = "clientReqBrowser -> "+clientReqBrowser +" |configDataOwner -> "
					              +configDataOwner + " |contexDataWebsite -> "+ contexDataWebsite; 
			Writer out=res.getWriter();
			out.write(responseData);
			 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
