package com.example.springprodemo.Dao;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TeamDao {
	
	private final JdbcTemplate jdbcTemplate;
	
	@Autowired
	public TeamDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate=jdbcTemplate;
	}
	public List<Map<String, Object>> getTeammates(){
		return jdbcTemplate.queryForList("SELECT * FROM Colleagues");
	}
	public Map<String, Object> getById(int id){
		return jdbcTemplate.queryForMap("SELECT * FROM Colleagues WHERE id=?",id);
	}
	public void insertTeam(Map<String, Object> team) {
		jdbcTemplate.update("INSERT INTO Colleagues(id,emp_name,mail,loc) VALUES (?,?,?,?)",team.get("id"),team.get("emp_name"),team.get("mail"),team.get("loc"));
	}
	public void updateTeam(int id,Map<String, Object> updatedTeam) {
		jdbcTemplate.update("UPDATE Colleagues SET emp_name=?,mail=?,loc=? WHERE id=?",updatedTeam.get("emp_name"),updatedTeam.get("mail"),updatedTeam.get("loc"),id);
	}
	public void deleteTeam(int id) {
		jdbcTemplate.update("DELETE FROM Colleagues WHERE id=?",id);
	}

}
