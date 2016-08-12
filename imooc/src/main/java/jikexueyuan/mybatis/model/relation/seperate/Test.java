package jikexueyuan.mybatis.model.relation.seperate;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

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

	public void getArticleList(int id) {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			IUserOperation userOperation = session.getMapper(IUserOperation.class);
			List<Article> articles = userOperation.getUserArticles(id);
			session.commit();
			for (Article i : articles) {
				User u = i.getUser();
				System.out.println(
						i.getId() + ", " + i.getTitle() + ", " + i.getContent() + ", " +
						u.getUserName() + ", " + u.getUserAge() + ", " + u.getUserAddress()
				);
			}
			System.out.println();
		} finally {
			session.close();
		}
	}

	

	public static void main(String[] args) {
		Test test = new Test();
		test.getArticleList(1);
	}
}
