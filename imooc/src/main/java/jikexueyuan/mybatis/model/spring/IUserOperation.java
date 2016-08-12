package jikexueyuan.mybatis.model.spring;

import java.util.List;

public interface IUserOperation {
	public User selectUserByID(int id);
	public List<Article> getUserArticles(int id);
}
