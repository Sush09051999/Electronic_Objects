package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Controlller.Product_Controller;


public class ProductDAO {

	static Connection con;
	static {
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja8","root","sql@123");
        } catch (SQLException e) {
        	
        
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
	}
	public void getbill(ProductDTO d1) {
	
		double final_ammount=0;
		Statement stmt;
		PreparedStatement pstmt;
		ResultSet rs;
		String querry="select * from purchase_prod where appliance_name='"+d1.getProductname()+"' and appliance_company= '"+d1.getCompany()+"'";
	
		
		try {
			stmt=con.createStatement();
			rs=stmt.executeQuery(querry);
			while(rs.next())
			{
			double price=rs.getDouble(5);
			int quantity=rs.getInt(4);
			
			if(quantity>=d1.getQuantity())
			{
				int cgst=9;
				int remaining=quantity-d1.getQuantity();
				final_ammount=d1.getQuantity()*price;
				double total=final_ammount+final_ammount*cgst/100;
				
				d1.setTotal(total);
				d1.setDatabaseq(quantity);
				
				String Querrrry="update purchase_prod set appliance_quantity=? where appliance_name=? and  appliance_company=? ";
				pstmt=con.prepareStatement(Querrrry);
				pstmt.setInt(1,remaining);
				pstmt.setString(2, d1.getProductname());
				pstmt.setString(3, d1.getCompany());
				pstmt.executeUpdate();
			}
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		
}
