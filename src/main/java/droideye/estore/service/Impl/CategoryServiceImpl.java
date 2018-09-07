package droideye.estore.service.Impl;

import org.apache.ibatis.session.SqlSession;

import java.util.List;

import droideye.estore.common.util.SqlSessionFactoryUtil;
import droideye.estore.mapper.CategoryMapper;
import droideye.estore.pojo.Category;
import droideye.estore.service.CategoryService;

public class CategoryServiceImpl implements CategoryService {
    @Override
    public List<Category> getAllCategories() {
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSession(true);
        CategoryMapper categoryMapper = sqlSession.getMapper(CategoryMapper.class);

        List<Category> categories = categoryMapper.queryAllCategories();
        sqlSession.close();

        return categories;
    }

    @Override
    public Category querySingleCategoryById(String id) {
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSession(true);
        CategoryMapper categoryMapper = sqlSession.getMapper(CategoryMapper.class);

        Category category = categoryMapper.querySingleCategoryById(Integer.parseInt(id));
        sqlSession.close();

        return category;
    }
}
