package mdmUtil.controller;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mdmUtil.model.MDMConnection;
import mdmUtil.model.User;

@Controller
public class FormController {

	@Autowired
	MDMConnection mdmConnection;

	@RequestMapping("/myLogin")
	public String contactForm() {

		System.out.println("In the login URL");
		return "login";
	}

	@RequestMapping(value = { "/", "home" })
	public String home(Model model) {
		System.out.println("In the home URL");
		getOrsList();

		return "home";
	}

	@RequestMapping(path = "/userDetails", method = RequestMethod.POST)
	public String contactProcess(@ModelAttribute User user, Model model) {
		System.out.println(user);
		return "index";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "redirect:/";
	}

	public void getOrsList() {
		System.out.println("In the get ors list method");
		Context ctx = null;
		Hashtable ht = new Hashtable();
		ht.put(Context.INITIAL_CONTEXT_FACTORY, mdmConnection.getInitcontextFactory());
		ht.put(Context.PROVIDER_URL, mdmConnection.getNamingFactory());
		try {
			ctx = new InitialContext(ht);
			javax.sql.DataSource ds = (javax.sql.DataSource) ctx.lookup("java:jboss/datasources/jdbc/siperian-cmx_system-ds");
			java.sql.Connection conn = ds.getConnection();
			// You can now use the conn object to create
			// Statements and retrieve result sets:
			Statement stmt = conn.createStatement();
			stmt.execute("select database_desc,database_id from c_repos_database where master_ind = 0;");
			ResultSet rs = stmt.getResultSet();
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnsNumber = rsmd.getColumnCount();
			   while (rs.next()) {
			       for (int i = 1; i <= columnsNumber; i++) {
			           if (i > 1) System.out.print(",  ");
			           String columnValue = rs.getString(i);
			           System.out.print(columnValue + " " + rsmd.getColumnName(i));
			       }
			       System.out.println("");
			   }
			// Close the statement and connection objects when you are finished:
			stmt.close();
			conn.close();
		} catch (Exception e) {
			// a failure occurred
		} finally {
			try {
				ctx.close();
			} catch (Exception e) {
				// a failure occurred
			}
		}

	}

}
