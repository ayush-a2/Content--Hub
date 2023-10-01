package com.content.payloads;

import java.util.List;

public class PostResponse {
private List<PostDto>content;
private int pageNumber;
private int pageSize;
private long totalElements;
private int totalPages;

private boolean lastPage;

public PostResponse() {
	super();
}

public List<PostDto> getContent() {
	return content;
}

public void setContent(List<PostDto> content) {
	this.content = content;
}

public int getPageNumber() {
	return pageNumber;
}

public void setPageNumber(int pageNumber) {
	this.pageNumber = pageNumber;
}

public int getPageSize() {
	return pageSize;
}

public void setPageSize(int pageSize) {
	this.pageSize = pageSize;
}

public long getTotalElements() {
	return totalElements;
}

public void setTotalElements(long l) {
	this.totalElements = l;
}

public int getTotalPages() {
	return totalPages;
}

public void setTotalPages(int totalPages) {
	this.totalPages = totalPages;
}

public boolean isLastPage() {
	return lastPage;
}

public void setLastPage(boolean lastPage) {
	this.lastPage = lastPage;
}

}
