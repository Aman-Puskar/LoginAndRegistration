package com.spring.controllers;

import java.security.PublicKey;
import java.util.List;
import org.springframework.dao.EmptyResultDataAccessException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.beans.LoginDetails;
import com.spring.beans.UpdateDetails;
import com.spring.beans.User;

@Controller
public class MyController {
	
    @Autowired
    private JdbcTemplate jdbcTemp;
	
	@GetMapping("/registration")
	public String getRegistrationForm() {
		return "registration-form";
	}
	
	@GetMapping("/login")
	public String getLoginForm() {
		return "login-form";
	}
	
	@PostMapping("/registerForm")
	public String getUserData(@ModelAttribute User user) {
		String name = user.getName();
		String email = user.getEmail();
		String city = user.getCity();
		String inser_query = "insert into UserDetails values(?, ?, ?)";
		int status = jdbcTemp.update(inser_query, name, email, city);
		if(status > 0) {
			System.out.println("Success");
		} else {
			System.out.println("Failer");
		}
		
		return "login-form";
	}
	
	@PostMapping("/loginForm")
	public String openProfilePage(@ModelAttribute LoginDetails details, Model model) {
	    String email = details.getEmail();
//	    System.out.println(email);
	  
	    
	    String city = details.getCity();
//	    System.out.println(city);
	    String select_Query = "select * from UserDetails where email=? and city=?";
	    boolean status = false;
	    try {
	        UserDetailMapper udm = jdbcTemp.queryForObject(select_Query, new UserMapper(), email, city);
//	        System.out.println(udm);
	        if (udm != null) {
	        	
	            status = true;
	            model.addAttribute("user",udm);
	        } 
	    } catch (EmptyResultDataAccessException e) {
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    if (status) {
	        return "profile";
	    } else {
	        return "registration-form";
	    }
	}
	
	   //update
    @GetMapping("/update")
    public String openUpdateRegistrationForm() {
    	return "update-form";
    }
    
    @PostMapping("/updateDetails")
    public String updateAndLogin(@ModelAttribute UpdateDetails updtls) {
    	String oldname = updtls.getOldname();
    	String newname = updtls.getNewname();
    	String oldemail = updtls.getOldemail();
    	String newemail = updtls.getNewemail();
    	String oldcity = updtls.getOldcity();
    	String newcity = updtls.getNewcity();
    	String update_query = "update UserDetails set name=?, email=?, city=? where name=? and email=? and city=?";
    	int status = jdbcTemp.update(update_query, newname, newemail, newcity , oldname, oldemail, oldcity);
    	if(status > 0) {
    		System.out.println("success to update!");
    		return "login-form";
    	} else {
    		System.out.println("fail to update!");
    		return "update-form";
    	}
    }
  //delete
	@GetMapping("/delete")
	public String openDeletePage() {
		return "delete-form";
	}
	
	@PostMapping("/deleteuser")
	public String deleteUser(@RequestParam("email") String email, Model model) {
		String delete_query = "delete from UserDetails where email=?";
		int status = jdbcTemp.update(delete_query, email);
		if(status > 0) {
			System.out.println("deletion success");
			model.addAttribute("popup_message", "User deleted!");
			return "delete-form";
		} else {
			System.out.println("deletion failer");
			model.addAttribute("popup_message", "User not registered!");
			return "delete-form";
		}
		
	}
	
	//show list of users
	@GetMapping("/showlist")
	public String openUserListPage(Model model) {
		String select_Query = "select * from UserDetails";
        List<UserDetailMapper> udm = jdbcTemp.query(select_Query, new UserMapper());
        
		model.addAttribute("users", udm);
		return "user-list";
	}

}
