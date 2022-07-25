package com.shop.api.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	public NoticeAssignResponse saveNotice(@RequestBody NoticeAssignRequest req) {
		Notice notice = noticeService.saveNotice(req.toDto());
		
		return new NoticeAssignResponse(NoticeAssignData.create(notice));
	}

	@GetMapping("/select")
	public NoticeSelectResponse selectNotice(@RequestBody NoticeSelectRequest req) {		
		Notice notice = noticeService.selectNotice(req.toDto());
		
		return new NoticeSelectResponse(NoticeSelectData.create(notice));
	}
	
	@DeleteMapping("/delete")
	public String deleteNotice(@RequestBody NoticeDeleteRequest req) {
		return noticeService.deleteNotice(req.toDto());
	}
}
