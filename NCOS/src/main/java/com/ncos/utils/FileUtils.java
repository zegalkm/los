package com.ncos.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public class FileUtils {
	MultipartHttpServletRequest multiRequest = null;
	
	public MultipartHttpServletRequest getMultiRequest() {
		return this.multiRequest;
	}
	public List<Map<String, String>> upload(HttpServletRequest request, String uploadPath) {
		this.multiRequest = (MultipartHttpServletRequest)request;
    	Map<String, MultipartFile> files = this.multiRequest.getFileMap();

    	File saveFolder = new File(uploadPath);

    	if(!saveFolder.exists() || saveFolder.isFile()) {
    		saveFolder.mkdirs();
    	}

    	Iterator<Entry<String, MultipartFile>> itr = files.entrySet().iterator();
    	MultipartFile file;
    	List<Map<String, String>> fileInfoList = new ArrayList<Map<String, String>>();
    	String filePath = "";
    	String newFileName = "";

    	while(itr.hasNext()) {
    		Entry<String, MultipartFile> entry = itr.next();
    		file = entry.getValue();
    		if (!"".equals(file.getOriginalFilename())) {
    			try {
    				newFileName = getNewFileName(file.getOriginalFilename());
    				
        			filePath = uploadPath + "/" + newFileName;
        			file.transferTo(new File(filePath));

        			Map<String, String> fileInfo = new HashMap<String, String>();
        			fileInfo.put("key", entry.getKey());
        			fileInfo.put("filePath", filePath);
        			fileInfo.put("newFileName", newFileName);
        			fileInfo.put("originalFilename", file.getOriginalFilename());
        			fileInfo.put("fileSize", String.valueOf(file.getSize()));
        			fileInfoList.add(fileInfo);
    			}catch(Exception e) {
    				e.printStackTrace();
    			}
    		}
    	}
    	return fileInfoList;
	}

	
	/**
	 * hero upload
	 */
	public List<Map<String, String>> uploadHero(HttpServletRequest request, String uploadPath) {
		this.multiRequest = (MultipartHttpServletRequest)request;
		Map<String, MultipartFile> files = this.multiRequest.getFileMap();
		
		File saveFolder = new File(uploadPath);
		
		if(!saveFolder.exists() || saveFolder.isFile()) {
			saveFolder.mkdirs();
		}
		
		Iterator<Entry<String, MultipartFile>> itr = files.entrySet().iterator();
		MultipartFile file;
		List<Map<String, String>> fileInfoList = new ArrayList<Map<String, String>>();
		String filePath = "";
		String newFileName = "";
		newFileName = getNewFileName2();
		while(itr.hasNext()) {
			Entry<String, MultipartFile> entry = itr.next();
			file = entry.getValue();
			if (!"".equals(file.getOriginalFilename())) {
				try {
					
					filePath = uploadPath + "/" + newFileName + "_" + file.getOriginalFilename();
					file.transferTo(new File(filePath));
					
					Map<String, String> fileInfo = new HashMap<String, String>();
					fileInfo.put("key", entry.getKey());
					fileInfo.put("filePath", filePath);
					fileInfo.put("newFileName", newFileName);
					fileInfo.put("originalFilename", file.getOriginalFilename());
					fileInfo.put("fileSize", String.valueOf(file.getSize()));
					fileInfoList.add(fileInfo);
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
		return fileInfoList;
	}
	
	public String getNewFileName(String fileName) {
		final long systemTime = System.currentTimeMillis();
		String newFileName = String.valueOf(systemTime);

		//String fileExt = FilenameUtils.getExtension(fileName);
		int index = fileName.lastIndexOf(".");
		String fileExt = fileName.substring(index + 1);

		return newFileName + "." + fileExt;
	}
	public String getNewFileName2() {
		final long systemTime = System.currentTimeMillis();
		String newFileName = String.valueOf(systemTime);
		return newFileName;
	}
}
