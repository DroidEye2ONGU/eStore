import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

import droideye.estore.common.util.SqlSessionFactoryUtil;
import droideye.estore.mapper.CategoryMapper;
import droideye.estore.pojo.Category;

public class CategoryTest {

    @Test
    public void getAllCategoriesTest() {
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSession(true);
        CategoryMapper categoryMapper = sqlSession.getMapper(CategoryMapper.class);

        List<Category> categories = categoryMapper.queryAllCategories();

        for (Category c :
                categories) {
            System.out.println(c);
        }
        sqlSession.close();

    }
}
