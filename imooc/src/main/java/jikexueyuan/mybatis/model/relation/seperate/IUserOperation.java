package jikexueyuan.mybatis.model.relation.seperate;

import java.util.List;

public interface IUserOperation {
	public List<Article> getUserArticles(int id);
}
