package br.com.projeto.ecommerce.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ProductDto {

    private Integer id;

    private String name;

    private String brand;

    private String productType;

    private BigDecimal unitPrice;

    private BigDecimal unitCost;

    private String desc;

    private LocalDateTime insertProductDate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	public BigDecimal getUnitCost() {
		return unitCost;
	}

	public void setUnitCost(BigDecimal unitCost) {
		this.unitCost = unitCost;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public LocalDateTime getInsertProductDate() {
		return insertProductDate;
	}

	public void setInsertProductDate(LocalDateTime insertProductDate) {
		this.insertProductDate = insertProductDate;
	}
    
    

}
