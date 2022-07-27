package com.shop.api.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.shop.api.controller.dto.NoticeDeleteDto.NoticeDeleteRequest;
import com.shop.api.controller.dto.NoticeAssignDto.NoticeAssignData;
import com.shop.api.controller.dto.NoticeAssignDto.NoticeAssignRequest;
import com.shop.api.controller.dto.NoticeAssignDto.NoticeAssignResponse;
import com.shop.api.controller.dto.NoticeSelectDto.NoticeSelectData;
import com.shop.api.controller.dto.NoticeSelectDto.NoticeSelectRequest;
import com.shop.api.controller.dto.NoticeSelectDto.NoticeSelectResponse;
import com.shop.api.dao.dto.Notice;
import com.shop.api.service.NoticeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/notice")
@RequiredArgsConstructor
public class NoticeApi {
	
	private final NoticeService noticeService;
	
	@PostMapping("/save")
	public NoticeAssignResponse saveNotice(@RequestPart NoticeAssignRequest req, MultipartHttpServletRequest mr) {
		NoticeAssignData data = noticeService.saveNotice(req.toDto(), mr);
		
		return new NoticeAssignResponse(data);
	}

	@GetMapping("/select")
	public NoticeSelectResponse selectNotice(@RequestBody NoticeSelectRequest req) {		
		Notice notice = noticeService.selectNotice(req.toDto());
		
		return new NoticeSelectResponse(NoticeSelectData.create(notice));
	}
	
	@DeleteMapping("/delete")
	public String deleteNotice(@RequestBody NoticeDeleteRequest req, HttpServletRequest httpServletRequest) {
		return noticeService.deleteNotice(req.toDto(), httpServletRequest);
	}
}
