package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.TreeMap;

import model.Skill;
import utility.ConnectionManager;

public class SkillDAO{
		
		 public TreeMap<Integer, Skill> skillCount() throws Exception {
			 TreeMap<Integer,Skill>map = new TreeMap<Integer,Skill>();
			 
		 Connection con =ConnectionManager.getConnection();
		 Statement st=con.createStatement();
		 String sql="select * from player";
		 
		 ResultSet rs=st.executeQuery(sql);
		 
		 int coding=0;
		 int CN=0;
		 int Physics=0;
		 while(rs.next())
		 {
			 if(rs.getLong(4)==1) {
				 System.out.println("test1"+ rs.getLong(4));
				 coding++;
			 }
			 else if(rs.getLong(4)==2) {
				 CN++;
				 System.out.println("test2"+ rs.getLong(4));
			 }
			 else if(rs.getLong(4)==3) {
				 Physics++;
				 System.out.println("test3"+ rs.getLong(4));
			 }
		 }
				 Skill s1=new Skill(1,"coding");
				 Skill s2=new Skill(2,"CN");
				 Skill s3=new Skill(3,"Physics");
				 
				 map.put(coding,s1);
				 map.put(CN,s2);
				 map.put(Physics,s3);
		return map;

		 
}
}