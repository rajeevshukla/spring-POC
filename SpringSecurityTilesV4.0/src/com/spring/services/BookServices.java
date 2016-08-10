package com.spring.services;

import org.springframework.cache.annotation.CacheConfig;

import com.spring.models.Book;

@CacheConfig(cacheNames="books")
public class BookServices {

	
	public Book findBookById(String bookId){
	
		return null;
	}
}
