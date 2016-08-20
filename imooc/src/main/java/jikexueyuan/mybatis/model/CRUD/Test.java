package jikexueyuan.mybatis.model.CRUD;

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

	public void getUserList(String userName) {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			IUserOperation userOperation = session.getMapper(IUserOperation.class);
			List<User> users = userOperation.selectUsers(userName);
			session.commit();
			for (User u : users) {
				System.out.println(
						u.getId() + ", " + u.getUserName() + ", " + u.getUserAddress() + ", " + u.getUserAge());
			}
			System.out.println();
		} finally {
			session.close();
		}
	}

	public void addUser() {
		User user = new User();
		user.setUserName("陆小凤");
		user.setUserAddress("紫禁之巅");
		user.setUserAge(30);

		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			IUserOperation userOperation = sqlSession.getMapper(IUserOperation.class);
			userOperation.addUser(user);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}

	public void deleteUser(int id) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			IUserOperation userOperation = sqlSession.getMapper(IUserOperation.class);
			userOperation.deleteUser(id);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}

	public void updateUser(int id) {
		User user = new User();
		user.setId(id);
		user.setUserAddress("呼和浩特-已更新");
		user.setUserAge(18);
		user.setUserName("尼奥-已更新");

		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			IUserOperation userOperation = sqlSession.getMapper(IUserOperation.class);
			userOperation.updateUser(user);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}

	public static void main(String[] args) {
		Test test = new Test();
		test.getUserList("%");

		test.addUser();

		test.getUserList("%");

		test.updateUser(2);

		test.getUserList("%");

		test.deleteUser(2);

		test.getUserList("%");
	}
}
