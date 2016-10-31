package net.topic.services;

import net.topic.entities.Author;
import net.topic.services.exceptions.AuthorServiceException;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

/**
 * @author Vlad Lukjanenko.
 */
public class AuthorServiceTest extends BasicTestConfig {

    @Autowired
    private AuthorService authorService;


    @Test
    public void testCreateAuthor() {

        Author author = getAuthor();
        Author created = null;

        try {
            created = authorService.create(author);
        } catch (AuthorServiceException e) {
            fail();
        }

        assertThat(created.getAuthorId(), is(not(0L)));
        assertThat(created.getAuthorName(), is("Author"));
        assertThat(created.getBooks().size(), is(0));
    }

    @Test
    public void testUpdateAuthor() {

        Author author = getAuthor();
        Author created = null;
        Author updated = null;

        try {
            created = authorService.create(author);
        } catch (AuthorServiceException e) {
            fail();
        }

        created.setAuthorName("NewAuthor");

        try {
            updated = authorService.update(created);
        } catch (AuthorServiceException e) {
            fail();
        }

        assertThat(updated.getAuthorId(), is(created.getAuthorId()));
        assertThat(updated.getAuthorName(), is("NewAuthor"));
        assertThat(updated.getBooks().size(), is(0));
    }

    @Test
    public void testDeleteAuthor() {

        Author author = getAuthor();
        Author created = null;
        boolean deleted = false;

        try {
            created = authorService.create(author);
        } catch (AuthorServiceException e) {
            fail();
        }

        deleted = authorService.delete(created);

        assertThat(deleted, is(true));
    }

    @Test
    public void testDeleteAuthorById() {

        Author author = getAuthor();
        Author created = null;
        boolean deleted = false;

        try {
            created = authorService.create(author);
            deleted = authorService.deleteById(created.getAuthorId());
        } catch (AuthorServiceException e) {
            fail();
        }

        assertThat(deleted, is(true));
    }

    @Test
    public void testFindAuthorById() {

        Author author = getAuthor();
        Author created = null;
        Author found = null;

        try {
            created = authorService.create(author);
            found = authorService.find(created.getAuthorId());
        } catch (AuthorServiceException e) {
            fail();
        }

        assertThat(found.getAuthorId(), is(created.getAuthorId()));
        assertThat(found.getAuthorName(), is(created.getAuthorName()));
    }

    @Test
    public void testFindAllAuthors() {

        Author author1 = getAuthor();
        Author author2 = getAuthor();
        Author createdAuthor1 = null;
        Author createdAuthor2 = null;

        author1.setAuthorName("Test1");
        author2.setAuthorName("Test2");

        try {
            createdAuthor1 = authorService.create(author1);
            createdAuthor2 = authorService.create(author2);
        } catch (AuthorServiceException e) {
            fail();
        }

        List<Author> authors = authorService.findAll();

        assertThat(authors.size(), is(not(0)));
        assertThat(authors, hasItem(createdAuthor1));
        assertThat(authors, hasItem(createdAuthor2));
    }

    @Test
    public void testDeleteAllAuthors() {

        Author author1 = getAuthor();
        Author author2 = getAuthor();

        author1.setAuthorName("Test1");
        author2.setAuthorName("Test2");

        try {
            authorService.create(author1);
            authorService.create(author2);
        } catch (AuthorServiceException e) {
            fail();
        }

        authorService.deleteAll();

        int size = authorService.findAll().size();

        assertThat(size, is(0));
    }


    private Author getAuthor() {

        Author author = new Author();

        author.setAuthorName("Author");
        author.setBooks(new ArrayList<>());

        return author;
    }
}
