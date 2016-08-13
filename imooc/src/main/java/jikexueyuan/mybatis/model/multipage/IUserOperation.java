package jikexueyuan.mybatis.model.multipage;

import java.util.HashMap;
import java.util.List;

public interface IUserOperation {
	public List<Article> getUserArticles(HashMap<String, Integer> map);
}
