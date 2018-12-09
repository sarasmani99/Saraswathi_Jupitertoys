package pages.dtos;

public class ProductInfo {
	
	private String name;
	
	public String getName()
	{
		return name;
	}
	public void setName(String itemName)
	{
		this.name = itemName;
	}
	
	private Float price;
	
	public Float getPrice()
	{		
		return price;
	}
	
	public void setPrice(Float itemPrice)
	{
		this.price = itemPrice;
	}
}
