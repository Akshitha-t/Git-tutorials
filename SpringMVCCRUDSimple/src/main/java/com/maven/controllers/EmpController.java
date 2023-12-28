package com.maven.controllers;   
import java.util.List;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;  
import org.springframework.web.bind.annotation.PathVariable;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;   
import com.maven.beans.Emp;  
import com.maven.dao.EmpDao;  
@Controller  
public class EmpController {  
	private static final Logger logger = LogManager.getLogger(EmpController.class);  

    @Autowired  
    EmpDao dao;//will inject dao from xml file  
      
    /*It displays a form to input data, here "command" is a reserved request attribute 
     *which is used to display object data into form 
     */  
    @RequestMapping("/empform")  
    public String showform(Model m){  
    	m.addAttribute("command", new Emp());
    	logger.info("this is empform url");
    	return "empform"; 
    }  
    /*It saves object into database. The @ModelAttribute puts request data 
     *  into model object. You need to mention RequestMethod.POST method  
     *  because default request is GET*/  
    @RequestMapping(value="/save",method = RequestMethod.POST)  
    public String save(@ModelAttribute("emp") Emp emp){  
        dao.save(emp);  
    	logger.info("this is save url");

        return "redirect:/viewemp";//will redirect to viewemp request mapping  
    }  
    /* It provides list of employees in model object */  
    @RequestMapping("/viewemp")  
    public String viewemp(Model m){  
        List<Emp> list=dao.getEmployees();  
        m.addAttribute("list",list);
    	logger.info("this is viewemp url");

        return "viewemp";  
    }  
    /* It displays object data into form for the given id.  
     * The @PathVariable puts URL data into variable.*/  
    @RequestMapping(value="/editemp/{id}")  
    public String edit(@PathVariable int id, Model m){  
        Emp emp=dao.getEmpById(id);  
        m.addAttribute("command",emp);
    	logger.info("this is editemp url");

        return "empeditform";  
    }  
    /* It updates model object. */  
    @RequestMapping(value="/editsave",method = RequestMethod.POST)  
    public String editsave(@ModelAttribute("emp") Emp emp){  
        dao.update(emp);  
    	logger.info("this is editsave url");

        return "redirect:/viewemp";  
    }  
    /* It deletes record for the given id in URL and redirects to /viewemp */  
    @RequestMapping(value="/deleteemp/{id}",method = RequestMethod.GET)  
    public String delete(@PathVariable int id){  
        dao.delete(id);  
    	logger.info("this is deleteemp url");

        return "redirect:/viewemp";  
    }   
}  