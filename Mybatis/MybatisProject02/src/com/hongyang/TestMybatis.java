package com.hongyang;
 
import java.io.IOException;


import java.io.InputStream;
import java.util.List;
 
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import com.hongyang.Category;
 


public class TestMybatis {
 
    public static void main(String[] args) throws IOException {
    	String resource = "mybatis-config.xml";
    	InputStream inputStream = Resources.getResourceAsStream(resource);
    	SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    	SqlSession session = sqlSessionFactory.openSession();
    	
    	//getCategory(session);
    	//addCategory(session);
    	listAll(session);
    	//updateCategory(session);
        //delete(session);
 


        session.commit();//提交
        session.close();
 
    }
    
    // select
    private static void getCategory(SqlSession session)
    {
    	String statement = "getCategory";
    	Category c = session.selectOne(statement,1);
    	System.out.println(c.getName());
    }
    
    //listAll
	private static void listAll(SqlSession session) {
	
	 
	  
      List<Category> cs = session.selectList("listCategory");
      for (Category c : cs) {
          System.out.println(c.getName());
      }
   }
	
	//add
	private static void addCategory(SqlSession session) {
	
		Category c = new Category();
		
		//c.setId(3);
	    c.setName("category");
	    
	    session.insert("addCategory",c);
	     
	    listAll(session);
	}
    
	//update
	private static void updateCategory(SqlSession session)
	{
		Category c = new Category();
		
		c.setId(2);
		c.setName("categoryrenew");
		session.update("updateCategory",c);
		
		listAll(session);		
	}
	
	
	//delete
	private static void delete(SqlSession session) {
		
		Category c = new Category();
		c.setId(2);
        session.delete("deleteCategory",c);
        listAll(session);
	}






}