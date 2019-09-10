package com.rajeev.spring5webapp.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import com.rajeev.spring5webapp.domain.Author;
import com.rajeev.spring5webapp.domain.Book;
import com.rajeev.spring5webapp.repositories.AuthorRepository;
import com.rajeev.spring5webapp.repositories.BookRepository;

public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

	private AuthorRepository authorRepo;
	private BookRepository bookRepo;

	public DevBootstrap(AuthorRepository authorRepo, BookRepository bookRepo) {
		this.authorRepo = authorRepo;
		this.bookRepo = bookRepo;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		initData();
	}

	private void initData() {
		// Rajeev
		Author rajeev = new Author("Rajeev", "Gupta");
		Book ddd = new Book("Domain driven design", "1234", "juhi harela");
		rajeev.getBooks().add(ddd);
		ddd.getAuthors().add(rajeev);
		
		authorRepo.save(rajeev);
		bookRepo.save(ddd);

		// Ishika
		Author ishika = new Author("Ishika", "Gupta");
		Book ejb = new Book("J2ee development with ejb", "2344", "ruth");
		ishika.getBooks().add(ejb);
		ejb.getAuthors().add(ishika);
		
		authorRepo.save(ishika);
		bookRepo.save(ejb);
	}

}
