package org.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.student.dao.StudentMapper;
import org.student.entity.Assisant;
import org.student.entity.Student;

@Service
public class StudenntServiceImpl implements StudentService {

    @Autowired private StudentMapper studentMapper;

    @Override
    public List<Student> listByUsername(String user){
    	return studentMapper.listByUsername(user);
    }
    @Override
    public List<Assisant> checkUserPwd(String username,String password){
    	return studentMapper.checkUserPwd(username,password);
    }
    
    @Override
    public int add(Student student) {
        return studentMapper.insert(student);
    }

    @Override
    public int edit(Student student) {
        return studentMapper.updateByPrimaryKey(student);
    }

    @Override
    public int delete(int id) {
        return studentMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Student getById(int id) {
        return studentMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Student> listByAll() {
        return studentMapper.listByAll();
    }
	@Override
	public Assisant getByname(int id) {
		// TODO Auto-generated method stub
		return studentMapper.selectNameByPrimaryKey(id);
	}
	@Override
	public String getsclass(int id) {
		// TODO Auto-generated method stub
		return studentMapper.selectClassByPrimaryKey(id);
	}
	@Override
	public List<Student> listBysclass(String sclass) {
		// TODO Auto-generated method stub
		return studentMapper.listBysclass(sclass);
	}
	@Override
	public Student listBynumber(Integer number) {
		// TODO Auto-generated method stub
		return studentMapper.selectByPrimaryKey(number);
	}
	@Override
	public List<Student> checknumber(Integer number) {
		// TODO Auto-generated method stub
		return studentMapper.SelectByPrimaryKey(number);
	}
}
