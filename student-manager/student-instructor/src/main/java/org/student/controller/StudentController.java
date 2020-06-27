package org.student.controller;

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
import org.student.entity.Assisant;
import org.student.entity.Student;
import org.student.service.StudentService;

@Controller
@RequestMapping("/students")
public class StudentController {

    @Autowired private StudentService studentService;

    @RequestMapping("/edit")
    public String edit(ModelMap map ,@RequestParam(defaultValue = "0") int id){
    	map.addAttribute("student",studentService.getById(id));
        return "student/edit";
    }

    //删除
    @ResponseBody
    @RequestMapping("/del/{id}")
    public String del(@PathVariable Integer id){
    	if(this.studentService.delete(id)>0){
    		return "<script language=\"javascript\">alert(\"删除成功!\");window.location.href=\"/students/index\"</script>";
    	}
    	else{
    		return "Del false!";
    	}
    }
    //编辑
    @ResponseBody
    @RequestMapping("/editsave")
    public String editsave(@ModelAttribute Student student){
        if(student == null){
            return "fail";
        }
        	if(studentService.edit(student)>0)        
        		return "<script language=\"javascript\">alert(\"编辑成功!\");window.location.href=\"/students/index\"</script>";
        	else return "<script language=\"javascript\">alert(\"编辑错误!\");window.location.href=\"/students/index\"</script>";      
    }
    
    //添加学生
    @ResponseBody
    @RequestMapping("/addsave")
    public String addsave(@ModelAttribute Student student){
        if(student == null){
            return "fail";
        }
        System.out.println(student.toString());
        if(studentService.checknumber(student.getNumber()).isEmpty())
        if(studentService.add(student)>0){
        	return "<script language=\"javascript\">alert(\"添加成功!\");window.location.href=\"/students/index\"</script>";
        }
        else{
        	return "<script language=\"javascript\">alert(\"添加失败!\");window.location.href=\"/students/index\"</script>";
        }else
        	return "<script language=\"javascript\">alert(\"添加失败,已存在学号相同的学生!\");window.location.href=\"/students/index\"</script>";
    }
    
    
    @RequestMapping(value = "/login", method = {RequestMethod.POST, RequestMethod.GET})
    public String login() {System.out.println("123");
        return "student/login";

    }
    
    @RequestMapping("/logout")
    public String logout(HttpServletRequest request, HttpSession session){
		Object obj =WebUtils.getSessionAttribute(request, "tname"); 
    	if(obj!=null){
    		session.removeAttribute("tname");;
    		return "student/login";
    	}
    	else{
    		return "student/login";
    	}
         
    }
    
    @ResponseBody
    @RequestMapping(value = "/loginPage", method = {RequestMethod.POST, RequestMethod.GET})
    public String login(HttpServletRequest request, HttpSession session) {
        String tno = request.getParameter("tno");
        String password = request.getParameter("password");
        System.out.println("你输入的用户名为：" + tno);
        System.out.println("你输入的密码为：" + password);
                   
        if (studentService.checkUserPwd(tno, password).isEmpty()){
        	
            return "<script language=\"javascript\">alert(\"用户名和密码不正确!\");window.location.href=\"/students/login\"</script>";
        } 
        else {
        	session.setAttribute("tname", tno);
        	return "<script language=\"javascript\">window.location.href=\"/students/index\"</script>";
        }
       
    }

	
	@RequestMapping("/index")
	public String index(ModelMap map ,HttpServletRequest request){
		Object obj =WebUtils.getSessionAttribute(request, "tname");
    	if(obj!=null){
    		Integer id=Integer.parseInt((String) obj);
    		Assisant assisant=studentService.getByname(id); 
    		String sclass=studentService.getsclass(id);
            System.out.println(studentService.listBysclass(sclass));
    		map.addAttribute("students",studentService.listBysclass(sclass));
    		map.addAttribute("assistant",assisant);
    		return "student/index";
    	}
    	else{
    		return "student/login";
    	}
		
	}
	
    @RequestMapping(value = "/search", method = {RequestMethod.POST, RequestMethod.GET})
    public String search(ModelMap map ,HttpServletRequest request, HttpSession session) {
        String tno = request.getParameter("number");
        Object obj =WebUtils.getSessionAttribute(request, "tname");
        Integer id=Integer.parseInt((String) obj);
		Assisant assisant=studentService.getByname(id); 
        Integer number=Integer.parseInt(tno);
        System.out.println("你输入的用户名为：" + tno);
        map.addAttribute("students",studentService.listBynumber(number));

        map.addAttribute("assistant",assisant);
        return "student/index";       
    }
	

	@RequestMapping("/add")
	public String add(ModelMap map){
		map.addAttribute("student",new Student());
		return "student/add";
	}

		
}
