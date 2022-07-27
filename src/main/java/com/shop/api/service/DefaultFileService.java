package com.shop.api.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.shop.api.dao.dto.Attach;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class DefaultFileService implements FileService {
	
	@Override
	public Attach singleUpload(MultipartHttpServletRequest mr, String path, String board_type, int board_id) throws IOException {
		
		File saveDir = new File(path);
		
		if(!saveDir.exists()) {
			saveDir.mkdirs();
		}
		
		MultipartFile file = mr.getFile("file");
		
		String boardType = board_type;
		String name = file.getOriginalFilename();
		Long size = file.getSize();
		
		File destination = File.createTempFile("F_" + System.currentTimeMillis(), name.substring(name.lastIndexOf(".")), saveDir);
		
		String saved_file_name = destination.getName();
		
		FileCopyUtils.copy(file.getInputStream(), new FileOutputStream(destination));
		
		Attach attach = Attach.create(boardType, board_id, name, saved_file_name, size);
		
		return attach;
	}
}
