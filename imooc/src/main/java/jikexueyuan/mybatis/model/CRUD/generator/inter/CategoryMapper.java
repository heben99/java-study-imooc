package jikexueyuan.mybatis.model.CRUD.generator.inter;

import java.util.List;
import jikexueyuan.mybatis.model.CRUD.generator.model.Category;
import jikexueyuan.mybatis.model.CRUD.generator.model.CategoryExample;
import org.apache.ibatis.annotations.Param;

public interface CategoryMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table category
	 * @mbggenerated  Sat Aug 13 13:48:42 CST 2016
	 */
	int countByExample(CategoryExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table category
	 * @mbggenerated  Sat Aug 13 13:48:42 CST 2016
	 */
	int deleteByExample(CategoryExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table category
	 * @mbggenerated  Sat Aug 13 13:48:42 CST 2016
	 */
	int deleteByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table category
	 * @mbggenerated  Sat Aug 13 13:48:42 CST 2016
	 */
	int insert(Category record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table category
	 * @mbggenerated  Sat Aug 13 13:48:42 CST 2016
	 */
	int insertSelective(Category record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table category
	 * @mbggenerated  Sat Aug 13 13:48:42 CST 2016
	 */
	List<Category> selectByExample(CategoryExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table category
	 * @mbggenerated  Sat Aug 13 13:48:42 CST 2016
	 */
	Category selectByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table category
	 * @mbggenerated  Sat Aug 13 13:48:42 CST 2016
	 */
	int updateByExampleSelective(@Param("record") Category record, @Param("example") CategoryExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table category
	 * @mbggenerated  Sat Aug 13 13:48:42 CST 2016
	 */
	int updateByExample(@Param("record") Category record, @Param("example") CategoryExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table category
	 * @mbggenerated  Sat Aug 13 13:48:42 CST 2016
	 */
	int updateByPrimaryKeySelective(Category record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table category
	 * @mbggenerated  Sat Aug 13 13:48:42 CST 2016
	 */
	int updateByPrimaryKey(Category record);
}