package jikexueyuan.mybatis.model.CRUD;

import java.util.List;

public interface IUserOperation {
	public List<User> selectUsers(String userName);

	public void addUser(User user);

	public void deleteUser(int id);

	public void updateUser(User user);
}
