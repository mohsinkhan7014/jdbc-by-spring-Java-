package com.springJdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.springJdbc.Dao.StudentDao;
import com.springJdbc.Dao.Entity.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        
        
       //way one by xml file 
        //ApplicationContext context=new ClassPathXmlApplicationContext("com/springJdbc/config.xml");
        
        //way to create context by java file
        ApplicationContext context=new AnnotationConfigApplicationContext(javaconfig.class);
       
        
        
        // JdbcTemplate temp=   (JdbcTemplate) context.getBean("jdbcTemplet");
      
        //insert 
//        String query="insert into student (id,name,city) values(?,?,?)";
//        
//        int result=temp.update(query,141,"Ankit Saini","UP");
//        System.out.println("REsult inserted "+result);
        
        
        //2nd method
         StudentDao studentdao=   (StudentDao) context.getBean("studentdao",StudentDao.class);
       // Student student=new Student();
//        student.setId(44);
//        student.setName("Mohsin");
//        student.setCity("Makrana");
//        int result=studentdao.insert(student);
//        
        
        
//        System.out.println("REsult inserted "+result);
//        student.setId(121);
//        student.setName("RAhim");
//        student.setCity("Makrana");
//        
//        int result=studentdao.change(student);
//        System.out.println(result+"data changed");
      
        //detele by student object
//        student.setId(121);
//        System.out.println("deleted query :"+studentdao.Delete(student));
       
        //direct
        int resulta=studentdao.Delete(141);
        System.out.println(resulta+"deleted");
        
        //select student from table 
        Student s=studentdao.getStudnetData(454);
        System.out.println(s.getName());
        System.out.println(s.getCity());
       
        
        //get all student from database
       List<Student> ss=studentdao.getAllStudent();
        for(Student s1:ss)
        {
        	System.out.println(s1);
        }
         
        
        
        
        
        
        
        
    }
}
