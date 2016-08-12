package jikexueyuan.mybatis.model.spring;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import util.PathManager;

public class Test {

	private static ApplicationContext ctx;  

    static 
    {  
        ctx = new ClassPathXmlApplicationContext(PathManager.getDirClasspath(Test.class)  + "/applicationContext.xml");  
    }        

    public static void main(String[] args)  
    {  
        IUserOperation mapper = (IUserOperation)ctx.getBean("userMapper"); 
        //����id=1���û���ѯ���������ݿ��е���������Ըĳ����Լ���.
        System.out.println("�õ��û�id=1���û���Ϣ");
        User user = mapper.selectUserByID(1);
        System.out.println(user.getUserAddress()); 

        //�õ������б����
        System.out.println("�õ��û�idΪ1�����������б�");
        List<Article> articles = mapper.getUserArticles(1);

        for(Article article:articles){
            System.out.println(article.getContent()+"--"+article.getTitle());
        }

    }  
}
