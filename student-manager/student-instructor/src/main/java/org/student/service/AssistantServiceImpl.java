package org.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.student.dao.AssistantMapper;
import org.student.dao.StudentMapper;
import org.student.entity.Admin;
import org.student.entity.Assisant;
import org.student.entity.Assistants;

@Service
public class AssistantServiceImpl implements AssisatantService {
	
	@Autowired
	private AssistantMapper assistantMapper;

	@Override
	public List<Assistants> listByAll() {
		// TODO Auto-generated method stub
		List<Assistants> as=assistantMapper.listByAll();
		for (Assistants assistants : as) {
			System.out.println(assistants.toString());
		}
		return assistantMapper.listByAll();
	}

	@Override
	public List<Admin> checkUserPwd(Integer username, Integer password) {
		// TODO Auto-generated method stub
		return assistantMapper.checkUserPwd(username,password);
	}

	@Override
	public Admin getByname(Integer id) {
		// TODO Auto-generated method stub
		return assistantMapper.selectNameByPrimaryKey(id);
	}

	@Override
	public int add(Assistants assistants) {
		// TODO Auto-generated method stub
		assistantMapper.insertassisinformation(assistants);
		return assistantMapper.insert(assistants);
	}

	@Override
	public Assistants getById(int id) {
		// TODO Auto-generated method stub
		return assistantMapper.selectByPrimaryKey(id);
	}

	@Override
	public int edit(Assistants assistants) {
		// TODO Auto-generated method stub
		assistantMapper.updateinformationByPrimaryKey(assistants);
		return assistantMapper.updateByPrimaryKey(assistants);
	}

	@Override
	public int delete(String id) {
		// TODO Auto-generated method stub
		assistantMapper.deleteinformationByPrimaryKey(id);
		return assistantMapper.deleteByPrimaryKey(id);
	}

	@Override
	public Assistants listBynumber(Integer number) {
		// TODO Auto-generated method stub
		return assistantMapper.selectByPrimaryKey(number);
	}

	@Override
	public List<Assistants> checknumber(String username) {
		// TODO Auto-generated method stub
		return assistantMapper.SelectByPrimaryKey(username);
	}

}
