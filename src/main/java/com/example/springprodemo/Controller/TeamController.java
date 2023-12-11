package com.example.springprodemo.Controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springprodemo.Service.TeamService;

@RestController
@RequestMapping("/team")
public class TeamController {
	
	private final TeamService teamService;
	
	@Autowired
	public TeamController(TeamService teamService) {
		this.teamService=teamService;
	}
	@GetMapping
	public List<Map<String, Object>> getTeammates(){
		return teamService.getTeammates();
	}
	@GetMapping("/{id}")
	public Map<String, Object> getById(@PathVariable("id") int id){
		return teamService.getById(id);
	}
	@PostMapping("/insert")
	public String insertTeam(@RequestBody Map<String, Object> team){
		return teamService.insertTeam(team);
	}
	@PutMapping("/update/{id}")
	public String updateTeam(@PathVariable("id") int id,@RequestBody Map<String, Object> updatedTeam) {
		return teamService.updateTeam(id,updatedTeam);
	}
	@DeleteMapping("/delete/{id}")
	public String deleteTeam(@PathVariable("id") int id) {
		return teamService.deleteTeam(id);
	}
	
	

}
