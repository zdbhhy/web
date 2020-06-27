package org.student.service;

import java.util.HashMap;
import java.util.List;

import org.student.entity.Assisant;
import org.student.entity.Student;

public interface StudentService {
    //新增
    int add(Student student);
    //编辑
    int edit(Student student);
    //删除
    int delete(int id);
    //获取辅导员所管理的班级
    String getsclass(int id);
    //获取单个
    Student getById(int id);
    //获取辅导员姓名
    Assisant getByname(int id);
    //获取所有
    List<Student> listByAll();
    List<Student> listByUsername(String user);
    List<Student> listBysclass(String sclass);
    Student listBynumber(Integer number);
    
    List<Assisant> checkUserPwd(String username,String password);
	List<Student> checknumber(Integer number);
    
}
