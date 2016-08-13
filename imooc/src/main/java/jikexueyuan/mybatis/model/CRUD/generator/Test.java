package jikexueyuan.mybatis.model.CRUD.generator;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import jikexueyuan.mybatis.model.CRUD.generator.inter.CategoryMapper;
import jikexueyuan.mybatis.model.CRUD.generator.model.Category;
import jikexueyuan.mybatis.model.CRUD.generator.model.CategoryExample;
import util.PathManager;

public class Test {

	private static SqlSessionFactory sqlSessionFactory;
	private static Reader reader;

	static {
		try {
			reader = Resources.getResourceAsReader(PathManager.getDirClasspath(Test.class) + "/Configuration.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	

	public void process() {
		Category category = new Category();
		category.setCatname("math");
		category.setCatdescription("interesting");

		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			CategoryMapper mapper = sqlSession.getMapper(CategoryMapper.class);
			mapper.insertSelective(category);
			Category ret = mapper.selectByPrimaryKey(1);
			System.out.println(
					ret.getId() + ", "
					+ ret.getCatname() + ", "
					+ ret.getCatdescription());
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}

	
	public static void main(String[] args) {
		Test test = new Test();
		test.process();
	}
}
