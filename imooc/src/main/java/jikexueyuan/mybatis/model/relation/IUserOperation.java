package jikexueyuan.mybatis.model.relation;

import java.util.List;

public interface IUserOperation {
	public List<Article> getUserArticles(int id);
}
