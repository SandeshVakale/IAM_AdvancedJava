package fr.epita.sandesh.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import fr.epita.sandesh.model.Etudiant;
import fr.epita.sandesh.services.EtudiantServices;

/**
 * this is Controller class
 * @author Sandesh VAKALE
 *
 */

@Controller
public class EtudiantController {
	
	@Autowired
	EtudiantServices sv;
	
	/**
	 * 
	 * @param username
	 * @param password
	 * @return UserTable view if Username and Password is Correct otherwise Return into Welcome view
	 */
	@RequestMapping(value="/etudiant",method=RequestMethod.POST)
	public String Login(@RequestParam("Username")String username,@RequestParam("Password")String password){
		
		
		
		String user=username;
		String pass=password;
		
		if(user.equals("root")&& pass.equals("admin")){
			return "UserTable";
		}
		else{
			
			return "index";
		}
	}
	
	


	
		
	
     
	/**
	 * Delete given etudiant
	 * @param Etudiant
	 */
	 @RequestMapping(value = "/Delete", method = RequestMethod.POST)	
	 public  @ResponseBody void Delete( @RequestBody Etudiant Etudiant )   {		
            
		 sv.delete(etudiant);
	 	
	 }
	 
	
	 
	 
  /**
   * Delete Save Or Update Etudiant
   * @param Etudiant
   */
	 @RequestMapping(value = "/save", method = RequestMethod.POST)	
	 public  @ResponseBody void saveCompany_JSON( @RequestBody Etudiant etudiant )   {		
            	 
		 sv.saveOrUpdate(etudiant);
		 System.out.println(etudiant.getFullname()+etudiant.getEmail()+etudiant.getUsername());
	 	
	 }
	 
	 
	/**
	 * 
	 * @param etudiant
	 * @return all  etudiant
	*/
	@RequestMapping(value="/list",method=RequestMethod.POST)
	public @ResponseBody Map<String,Object>getAll(Etudiant etudiant){
		Map<String,Object>map=new HashMap<String,Object>();
		List<Etudiant>list=sv.list();
		if(list!=null){
			map.put("status", "200");
			map.put("message", "Data found");
			map.put("data", list);
			
		}
		else{
			map.put("status", "404");
			map.put("message", "data not found");
		}
		return map;
	}
	 
	
	
	
	
}
