package com.example.ProjectTravelMaster.Model.Repository;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.example.ProjectTravelMaster.Model.Entity.User;
import com.example.ProjectTravelMaster.Model.Entity.UserPost;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserPostRepository extends JpaRepository<UserPost, Integer>{	 
	//	@Query("SELECT DISTINCT e FROM user_post e INNER JOIN e.user WHERE e.user.userId = :userId ORDER BY e.upId")
	//	List<UserPost> getPost(@Param("userId") Integer userId);

	 List<UserPost> findByUpId(int up_id);
	
	 List<UserPost> findByUpName(String up_name);
	 
	 @Query(value = "SELECT * FROM user_post up INNER JOIN user u ON up.user_id = u.user_id",nativeQuery = true)
	 List<UserPost> findAllPost();
	 

}