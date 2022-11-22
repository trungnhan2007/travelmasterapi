package com.example.ProjectTravelMaster.Model.Repository;

import java.util.Collection;
import java.util.List;

import com.example.ProjectTravelMaster.Model.Entity.Enterprise;
import com.example.ProjectTravelMaster.Model.Entity.EnterpriseAccount;
import com.example.ProjectTravelMaster.Model.Entity.EnterprisePost;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EnterpriseRepository extends JpaRepository<Enterprise, Integer>{
	Enterprise findByEnId(int en_id);
	List<Enterprise> findByEnNamecompany(String en_namecompany);
	
	//login find account
	@Query("SELECT en FROM Enterprise en WHERE en.enCode = ?1")
	Enterprise findEnterpriseByCode(String en_code);
}
