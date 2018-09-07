package droideye.estore.mapper;

import java.util.List;

import droideye.estore.pojo.Category;

public interface CategoryMapper {

    /*
     * 查找所有的类别
     * */
    List<Category> queryAllCategories();

    public Category querySingleCategoryById(Integer id);


}
