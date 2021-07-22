package com.roncoo.eshop.product.mapper;

import org.apache.ibatis.annotations.*;

import com.roncoo.eshop.product.model.ProductProperty;

@Mapper
public interface ProductPropertyMapper {
	
	@Insert("INSERT INTO product_property(name,value,product_id) VALUES(#{name},#{value},#{productId})")  
	public void add(ProductProperty productProperty);
	
	@Update("UPDATE product_property SET name=#{name},value=#{value},product_id=#{productId} WHERE id=#{id}")  
	public void update(ProductProperty productProperty);
	
	@Delete("DELETE FROM product_property WHERE id=#{id}")  
	public void delete(Long id);
	
	@Select("SELECT * FROM product_property WHERE id=#{id}")  
	public ProductProperty findById(Long id);
	
	@Select("SELECT * FROM product_property WHERE product_id=#{productId}")
	@Results({
			@Result(column = "product_id", property = "productId")
	})
	public ProductProperty findByProductId(Long productId);
	
}
