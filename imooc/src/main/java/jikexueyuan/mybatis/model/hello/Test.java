package jikexueyuan.mybatis.model.hello;

import java.io.Reader;

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

	public static void main(String[] args) {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			User user = (User) session.selectOne("jikexueyuan.mybatis.model.UserMapper.selectUserByID", 1);
			System.out.println(user.getUserName());
			System.out.println(user.getUserAddress());
		} finally {
			session.close();
		}

	}
}
