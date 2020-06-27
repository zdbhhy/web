package org.student.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.student.entity.Student;

import org.student.entity.Assisant;

@Service
public interface StudentMapper {
    int deleteByPrimaryKey(Integer number);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Integer number);
    
    List<Student> SelectByPrimaryKey(Integer number);
    
    Assisant selectNameByPrimaryKey(Integer username);
    
    String selectClassByPrimaryKey(Integer assname);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);
    
    //@Select("select * from customers")
    List<Student> listByAll();
    
    //@Select("select count(*) from tb_admin where user=#{user} and password=#{pwd}")
    List<Assisant> checkUserPwd(@Param("username")String user,@Param("password")String pwd);
    
    List<Student> listByUsername(@Param("user")String user);

	List<Student> listBysclass(@Param("sclass")String sclass);

}