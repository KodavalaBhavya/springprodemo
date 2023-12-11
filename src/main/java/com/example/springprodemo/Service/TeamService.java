package com.example.springprodemo.Service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springprodemo.Dao.TeamDao;

@Service
public class TeamService {
	
	private final TeamDao teamDao;
	
	@Autowired
	public TeamService(TeamDao teamDao) {
		this.teamDao=teamDao;
	}
	public List<Map<String, Object>> getTeammates(){
		return teamDao.getTeammates();
	}
	public Map<String, Object> getById(int id){
		return teamDao.getById(id);
	}
	public String insertTeam(Map<String, Object> team) {
		teamDao.insertTeam(team);
		return "Inserted Successfully";
	}
	public String updateTeam(int id,Map<String, Object> updatedTeam) {
		teamDao.updateTeam(id,updatedTeam);
		return "Updated Successfully";
	}
	public String deleteTeam(int id) {
		teamDao.deleteTeam(id);
		return "Deleted Successfully";
	}
}
