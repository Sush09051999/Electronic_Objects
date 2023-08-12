package Controlller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.ProductDAO;
import Model.ProductDTO;
@WebServlet("/prouctcontroller")
public class Product_Controller extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String product_name=req.getParameter("productname");
		int quantity=Integer.parseInt(req.getParameter("quantity"));
		String company=req.getParameter("company");
		ProductDTO d1=new ProductDTO();
	    d1.setProductname(product_name);
		d1.setQuantity(quantity); 
		d1.setCompany(company);
		ProductDAO d2=new ProductDAO();
		d2.getbill(d1);
		double finalbill=d1.getTotal();
	int databse=d1.getDatabaseq();
	req.setAttribute("total", finalbill);                                               
	req.setAttribute("database", databse);
	req.setAttribute("originalQ", quantity);      		
RequestDispatcher rd=req.getRequestDispatcher("display.jsp");                        		
	                                                                                    
	rd.forward(req, resp);                                                              		
		
		
}
	

}
