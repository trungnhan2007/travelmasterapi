package com.example.ProjectTravelMaster.Model.Service;

import java.io.IOException;
import java.util.List;

import com.example.ProjectTravelMaster.Model.Entity.EnterprisePost;

public interface EnterprisePostService{

	List<EnterprisePost> getAllEnterprisePost()throws IOException;

	List<EnterprisePost> getEnterprisePostby(String ep_name, String en_id) throws IOException;

	EnterprisePost createEnterprisePost(EnterprisePost enterprisePost)throws IOException;

	EnterprisePost updateEnterprisePost(int id, EnterprisePost enterprisePost) throws IOException;

	String deleteEnterprisePost(int id) throws IOException;

}
