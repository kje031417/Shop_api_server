package com.shop.api.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.shop.api.dao.dto.Attach;

public interface FileService {
	Attach singleUpload(MultipartHttpServletRequest req, String path, String board_type, int board_id) throws IOException;	
	
}
