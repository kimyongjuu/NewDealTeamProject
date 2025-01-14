package com.studycafe.utils.file.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public interface S3FileService {
	
	String saveFile(MultipartFile file, String filePath);
	
	byte[] downloadFile(String filename);
	
	String deleteFile(String filename);
	
	List<String> listAllFiles();
}
