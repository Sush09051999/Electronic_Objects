package Model;

public class ProductDTO {
	private String Productname;
	
	private int quantity;
	private String company;
	private double total;
	private int databaseq;

	
	public int getDatabaseq() {
		return databaseq;
	}

	public void setDatabaseq(int databaseq) {
		this.databaseq = databaseq;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public ProductDTO()
	{
		
	}
	
	public String getProductname() {
		return Productname;
	}

	public void setProductname(String productname) {
		Productname = productname;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public ProductDTO(String productname, int quantity) {
		super();
		Productname = productname;
		this.quantity = quantity;
	}
	
}
