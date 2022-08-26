package br.com.projeto.ecommerce.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name = "product")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String brand;

    private String productType;

    private BigDecimal unitPrice;

    private BigDecimal unitCost;

    private String desc;
    
    @Column(name = "insert_product_date")
    private LocalDateTime insertProductDate;
    
    /* um produto pode estar relacionado a varios itens */
    @OneToMany(mappedBy = "itens")
    private List<OrderedEntity> itens;
    
	public ProductEntity() {
	}

	public ProductEntity(Integer id, String name, String brand, String productType, BigDecimal unitPrice,
			BigDecimal unitCost, String desc, LocalDateTime insertProductDate, List<OrderedEntity> itens) {
		this.id = id;
		this.name = name;
		this.brand = brand;
		this.productType = productType;
		this.unitPrice = unitPrice;
		this.unitCost = unitCost;
		this.desc = desc;
		this.insertProductDate = insertProductDate;
		this.itens = itens;
	}

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

	public List<OrderedEntity> getItens() {
		return itens;
	}

	public void setItens(List<OrderedEntity> itens) {
		this.itens = itens;
	}

	@Override
	public int hashCode() {
		return Objects.hash(brand, desc, id, insertProductDate, itens, name, productType, unitCost, unitPrice);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductEntity other = (ProductEntity) obj;
		return Objects.equals(brand, other.brand) && Objects.equals(desc, other.desc) && Objects.equals(id, other.id)
				&& Objects.equals(insertProductDate, other.insertProductDate) && Objects.equals(itens, other.itens)
				&& Objects.equals(name, other.name) && Objects.equals(productType, other.productType)
				&& Objects.equals(unitCost, other.unitCost) && Objects.equals(unitPrice, other.unitPrice);
	}

	@Override
	public String toString() {
		return "ProductEntity [id=" + id + ", name=" + name + ", brand=" + brand + ", productType=" + productType
				+ ", unitPrice=" + unitPrice + ", unitCost=" + unitCost + ", desc=" + desc + ", insertProductDate="
				+ insertProductDate + ", itens=" + itens + "]";
	}
    
    
}