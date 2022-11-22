package com.example.ProjectTravelMaster.Model.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import com.example.ProjectTravelMaster.Model.Entity.Enterprise;
import com.example.ProjectTravelMaster.Model.Entity.EnterpriseAccount;
import com.example.ProjectTravelMaster.Model.Entity.User;

public interface LoginRegisterService {

	List<EnterpriseAccount> loginEnterprise(String code, String email, String password);
	List<User> loginUser(String email, String password);

}
