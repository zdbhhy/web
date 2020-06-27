package org.student.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.student.entity.Admin;
import org.student.entity.Assisant;
import org.student.entity.Assistants;
import org.student.entity.Student;
@Service
public interface AssistantMapper {

	List<Assistants> listByAll();

	List<Admin> checkUserPwd(Integer username,Integer password);

	Admin selectNameByPrimaryKey(Integer username);
	
	Assistants selectByPrimaryKey(Integer username);
	List<Assistants> SelectByPrimaryKey(String username);
	
	int updateByPrimaryKey(Assistants assistants);
	void updateinformationByPrimaryKey(Assistants assistants);
	
	int deleteByPrimaryKey(String username);
	void deleteinformationByPrimaryKey(String username);

	int insert(Assistants assistants);

	void insertassisinformation(Assistants assistants);


}
