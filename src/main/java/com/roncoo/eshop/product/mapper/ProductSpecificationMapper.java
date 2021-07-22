package com.roncoo.eshop.product.mapper;

import org.apache.ibatis.annotations.*;

import com.roncoo.eshop.product.model.ProductSpecification;

@Mapper
public interface ProductSpecificationMapper {
	
	@Insert("INSERT INTO product_specification(name,value,product_id) VALUES(#{name},#{value},#{productId})")  
	public void add(ProductSpecification productSpecification);
	
	@Update("UPDATE product_specification SET name=#{name},value=#{value},product_id=#{productId} WHERE id=#{id}")  
	public void update(ProductSpecification productSpecification);
	
	@Delete("DELETE FROM product_specification WHERE id=#{id}")  
	public void delete(Long id);
	
	@Select("SELECT * FROM product_specification WHERE id=#{id}")
	@Results({
			@Result(column = "product_id", property = "productId")
	})
	public ProductSpecification findById(Long id);
	
	@Select("SELECT * FROM product_specification WHERE product_id=#{productId}")
	@Results({
			@Result(column = "product_id", property = "productId")
	})
	public ProductSpecification findByProductId(Long productId);
	
}
