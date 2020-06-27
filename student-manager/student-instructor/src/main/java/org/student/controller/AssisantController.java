package org.student.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.WebUtils;
import org.student.entity.Admin;
import org.student.entity.Assisant;
import org.student.entity.Assistants;
import org.student.entity.Student;
import org.student.service.AssisatantService;
import org.student.service.StudentService;

@Controller
@RequestMapping("/admin")
public class AssisantController {
	
	@Autowired private AssisatantService assistantService;

	 @ResponseBody
	 @RequestMapping(value = "/loginPage", method = {RequestMethod.POST, RequestMethod.GET})
	    public String login(HttpServletRequest request, HttpSession session) {
	        String tno = request.getParameter("tno");
	        String password1 = request.getParameter("password");
	        Integer username=Integer.parseInt(tno);
	        Integer password=Integer.parseInt(password1);
	        System.out.println("你输入的用户名为：" + tno);
	        System.out.println("你输入的密码为：" + password);
	                   
	        if (assistantService.checkUserPwd(username, password).size()<=0){

	            return "<script language=\"javascript\">alert(\"用户名和密码不正确!\");window.location.href=\"/admin/login\"</script>";
	        }
	        else {
		 System.out.println("sfsdfds");
	        	session.setAttribute("tname", tno);
	        	return "<script language=\"javascript\">window.location.href=\"/admin/index\"</script>";
	        }
	       
	    }
	 
	 @RequestMapping(value = "/login", method = {RequestMethod.POST, RequestMethod.GET})
	    public String login() {
	        return "student/login";
	    }
	 
	 @RequestMapping("/index")
		public String index(ModelMap map ,HttpServletRequest request){
			Object obj =WebUtils.getSessionAttribute(request, "tname");
	    	if(obj!=null){
	    		Integer id=Integer.parseInt((String) obj);
				Admin admin=assistantService.getByname(id);
	    		map.addAttribute("Assistants",assistantService.listByAll());
	    		map.addAttribute("admin",admin);
	    		return "student/adminindex";
	    	}
	    	else{
	    		return "student/login";
	    	}
			
		}
	 
	  @RequestMapping("/logout")
	    public String logout(HttpServletRequest request, HttpSession session){
			Object obj =WebUtils.getSessionAttribute(request, "tname"); 
	    	if(obj!=null){
	    		session.removeAttribute("tname");
	    		return "student/login";
	    	}
	    	else{
	    		return "student/login";
	    	}
	         
	    }
	  
	  @RequestMapping("/add")
		public String add(ModelMap map){
			map.addAttribute("Assistants",new Assistants());
			return "student/addAdmin";
		}
	  
	//添加辅导员
	    @ResponseBody
	    @RequestMapping("/addsave")
	    public String addsave(@ModelAttribute Assistants assistants){
	        if(assistants == null){
	            return "fail";
	        }
	        System.out.println(assistants.toString());
	        if(assistantService.checknumber(assistants.getUsername()).isEmpty())
	        if(assistantService.add(assistants)>0){
	        	return "<script language=\"javascript\">alert(\"添加成功!\");window.location.href=\"/admin/index\"</script>";
	        }
	        else{
	        	return "<script language=\"javascript\">alert(\"添加失败!\");window.location.href=\"/admin/index\"</script>";
	        }else
	        	return "<script language=\"javascript\">alert(\"添加失败,已存在账号相同的辅导员!\");window.location.href=\"/admin/index\"</script>";      
	    }
	    
	    @RequestMapping("/edit")
	    public String edit(ModelMap map ,@RequestParam(defaultValue = "0") int id){
	    	map.addAttribute("Assistants",assistantService.getById(id));
	        return "student/adminedit";
	    }
	    
	    //编辑
	    @ResponseBody
	    @RequestMapping("/editsave")
	    public String editsave(@ModelAttribute Assistants assistants){
	        if(assistants == null){
	            return "fail";
	        }
	        	if(assistantService.edit(assistants)>0)        
	        		return "<script language=\"javascript\">alert(\"编辑成功!\");window.location.href=\"/admin/index\"</script>";
	        	else return "<script language=\"javascript\">alert(\"编辑错误!\");window.location.href=\"/admin/index\"</script>";      
	    }
	    
	    //删除
	    @ResponseBody
	    @RequestMapping("/del/{id}")
	    public String del(@PathVariable String id){
	    	if(this.assistantService.delete(id)>0){
	    		return "<script language=\"javascript\">alert(\"删除成功!\");window.location.href=\"/admin/index\"</script>";
	    	}
	    	else{
	    		return "Del false!";
	    	}
	    }
	    
	    @RequestMapping(value = "/search", method = {RequestMethod.POST, RequestMethod.GET})
	    public String search(ModelMap map ,HttpServletRequest request, HttpSession session) {
	        String tno = request.getParameter("number");
	        Object obj =WebUtils.getSessionAttribute(request, "tname");
	        Integer id=Integer.parseInt((String) obj);
	        Admin admin=assistantService.getByname(id); 
	        Integer number=Integer.parseInt(tno);
	        System.out.println("你输入的用户名为：" + tno);
	        map.addAttribute("Assistants",assistantService.listBynumber(number));
    		map.addAttribute("admin",admin);
	        return "student/adminindex";       
	    }

}
