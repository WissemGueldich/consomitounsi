package tn.esprit.consomitounsi.modal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "stocks")
public class Stock {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name = "Product_number")
	private int ProductNumber;
	@Column(name = "stock_name")
	private String StockName;
	@Column(name = "stock_category")
	private String StockCategory;
	@Column(name = "stock_type")
	private String StockType;
	
	
	public Stock() {
		super();
	}
	public Stock(long id, int productNumber, String stockName, String stockCategory, String stockType) {
		super();
		this.id = id;
		this.ProductNumber = productNumber;
		StockName = stockName;
		StockCategory = stockCategory;
		StockType = stockType;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getStockNumber() {
		return ProductNumber;
	}
	public void setStockNumber(int stockNumber) {
		ProductNumber = stockNumber;
	}
	public String getStockName() {
		return StockName;
	}
	public void setStockName(String stockName) {
		StockName = stockName;
	}
	public String getStockCategory() {
		return StockCategory;
	}
	public void setStockCategory(String stockCategory) {
		StockCategory = stockCategory;
	}
	public String getStockType() {
		return StockType;
	}
	public void setStockType(String stockType) {
		StockType = stockType;
	}
}
