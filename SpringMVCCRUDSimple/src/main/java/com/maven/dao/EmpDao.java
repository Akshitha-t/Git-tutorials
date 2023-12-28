package com.maven.dao;  
import java.sql.ResultSet;  


import java.sql.SQLException;  
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.BeanPropertyRowMapper;  
import org.springframework.jdbc.core.JdbcTemplate;  
import org.springframework.jdbc.core.RowMapper;  
import com.maven.beans.Emp;  
  
public class EmpDao {  
	private static final Logger logger = LogManager.getLogger(EmpDao.class);  

JdbcTemplate template;  
  
public void setTemplate(JdbcTemplate template) {  
    this.template = template;  
}  
public int save(Emp p){  
    String sql="insert into Emp99(name,salary,designation) values('"+p.getName()+"',"+p.getSalary()+",'"+p.getDesignation()+"')";  
    logger.info("this is insert query");
    return template.update(sql);  
}  
public int update(Emp p){  
    String sql="update Emp99 set name='"+p.getName()+"', salary="+p.getSalary()+",designation='"+p.getDesignation()+"' where id="+p.getId()+"";  
    logger.info("this is update query");
 return template.update(sql);  
}  
public int delete(int id){  
    String sql="delete from Emp99 where id="+id+"";  
    logger.info("this is delete query");

    return template.update(sql);  
}  
public Emp getEmpById(int id){  
    String sql="select * from Emp99 where id=?";  
    logger.info("this is getEmpbyid query");

    return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<Emp>(Emp.class));  
}  
public List<Emp> getEmployees(){  
    return template.query("select * from Emp99",new RowMapper<Emp>(){  
        public Emp mapRow(ResultSet rs, int row) throws SQLException {  
            Emp e=new Emp();  
            e.setId(rs.getInt(1));  
            e.setName(rs.getString(2));  
            e.setSalary(rs.getFloat(3));  
            e.setDesignation(rs.getString(4));  
            logger.info("this is list query");

            return e;  
        }  
    });  
}  
}  