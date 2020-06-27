package org.student.service;

import java.util.HashMap;
import java.util.List;

import org.student.entity.Admin;
import org.student.entity.Assisant;
import org.student.entity.Assistants;

public interface AssisatantService {
	//获取所有
    List<Assistants> listByAll();
    //检查账号密码
    List<Admin> checkUserPwd(Integer username,Integer password);
    //获取管理员姓名
	Admin getByname(Integer id);
	int add(Assistants assistants);
	Assistants getById(int id);
	int edit(Assistants assistants);
	int delete(String id);
	Assistants listBynumber(Integer number);
	List<Assistants> checknumber(String username);

}
