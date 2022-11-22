package com.example.ProjectTravelMaster.Model.Service.Impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.ProjectTravelMaster.Model.Entity.EnterprisePost;
import com.example.ProjectTravelMaster.Model.Entity.User;
import com.example.ProjectTravelMaster.Model.Repository.EnterprisePostRepository;
import com.example.ProjectTravelMaster.Model.Service.EnterprisePostService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class EnterprisePostServiceImpl implements EnterprisePostService{
	
	// get enterprise post
	
	@Autowired
	EnterprisePostRepository rep;
	
	@Override
	public List<EnterprisePost> getAllEnterprisePost() throws IOException{
		try {
			return rep.findAll();
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}


	@Override
	public List<EnterprisePost> getEnterprisePostby(String ep_name,String en_id) throws IOException{
		try {
			List<EnterprisePost> enterprisePosts = new ArrayList<EnterprisePost>();
			if (ep_name != null && en_id == null) {
				enterprisePosts = rep.findByEpName(ep_name);
			}if(ep_name == null && en_id != null)  {
				int id = Integer.valueOf(en_id);
				enterprisePosts = rep.findByEnId(id);
			}
			if(ep_name == null && en_id == null) {
				enterprisePosts = rep.findAll();
			}if (enterprisePosts.isEmpty()) {
				return null;
			}
			return enterprisePosts;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
	
	//add enterprise post	
	@Override
	public EnterprisePost createEnterprisePost(EnterprisePost enterprisePost)throws IOException {
		try {
			if (enterprisePost != null) {
				return rep.save(enterprisePost);
			} else {
				return null;
			}
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
	
	// update enterprise post
	@Override
	public EnterprisePost updateEnterprisePost(int id,EnterprisePost enterprisePost) throws IOException{
		try {
			if (id != 0 && enterprisePost != null) {
				Optional<EnterprisePost> data = rep.findById(id);
				EnterprisePost _enterprisePost = data.get();			 
				_enterprisePost.setEpName(enterprisePost.getEpName());
				_enterprisePost.setEpDetail(enterprisePost.getEpDetail());
				_enterprisePost.setEpDescription(enterprisePost.getEpDescription());
				_enterprisePost.setEnId(enterprisePost.getEnId());			
				return rep.save(_enterprisePost);
			}else {
				return null;
			}		
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
	
	@Override
	public String deleteEnterprisePost(int id) throws IOException{
		try {
			if (id != 0) {
				rep.deleteById(id);
				return "OK";
			} else {
				return "Failed";
			}
		} catch (Exception e) {
			// TODO: handle exception
			return "Failed";
		}
	}
	
	
	
	
	
}
