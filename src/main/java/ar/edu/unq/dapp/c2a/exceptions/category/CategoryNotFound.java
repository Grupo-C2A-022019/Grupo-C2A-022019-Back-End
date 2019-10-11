package ar.edu.unq.dapp.c2a.exceptions.category;

public class CategoryNotFound extends RuntimeException {
    public CategoryNotFound(Long categoryId) {
        super("Invalid category Id: " + categoryId);
    }
}
