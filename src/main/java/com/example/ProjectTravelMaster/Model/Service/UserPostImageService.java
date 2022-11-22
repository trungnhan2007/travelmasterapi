package com.example.ProjectTravelMaster.Model.Service;

import java.io.IOException;
import java.util.stream.Stream;

import javax.servlet.http.HttpSession;

import com.example.ProjectTravelMaster.Model.Entity.UserPostImage;

import org.springframework.web.multipart.MultipartFile;

public interface UserPostImageService {
    UserPostImage uploadImage(MultipartFile file, int up_id,HttpSession session) throws IOException;
        
}