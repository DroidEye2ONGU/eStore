package droideye.estore.service;

import java.util.List;

import droideye.estore.pojo.Category;

public interface CategoryService {

    public List<Category> getAllCategories();

    public Category querySingleCategoryById(String id);

}
