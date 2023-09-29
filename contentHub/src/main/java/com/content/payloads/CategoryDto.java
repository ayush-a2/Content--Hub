package com.content.payloads;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CategoryDto {

private Integer categoryId;
@NotBlank
@Size(min=4)
private String categorytitle;
@NotBlank
@Size(min=5)
private String categoryDescription;

public CategoryDto() {
	super();
}

public Integer getCategoryId() {
	return categoryId;
}

public void setCategoryId(Integer categoryId) {
	this.categoryId = categoryId;
}

public String getCategorytitle() {
	return categorytitle;
}

public void setCategorytitle(String categorytitle) {
	this.categorytitle = categorytitle;
}

public String getCategoryDescription() {
	return categoryDescription;
}

public void setCategoryDescription(String categoryDescription) {
	this.categoryDescription = categoryDescription;
}

@Override
public String toString() {
	return "CategoryDto [categoryId=" + categoryId + ", categorytitle=" + categorytitle + ", categoryDescription="
			+ categoryDescription + "]";
}

}
