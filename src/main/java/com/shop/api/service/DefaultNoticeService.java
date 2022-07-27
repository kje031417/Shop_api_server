package com.shop.api.service;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.shop.api.controller.dto.NoticeAssignDto.NoticeAssignData;
import com.shop.api.dao.FileDAO;
import com.shop.api.dao.NoticeDAO;
import com.shop.api.dao.dto.Attach;
import com.shop.api.dao.dto.Notice;
import com.shop.api.dao.dto.NoticeNum;
import com.shop.api.service.dto.NoticeListDto;
import com.shop.api.service.dto.NoticeRemoveDto;
import com.shop.api.service.dto.NoticeSaveDto;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class DefaultNoticeService implements NoticeService {
	
	private final FileService fileService;
	
	private final NoticeDAO noticeDAO;
	
	private final FileDAO fileDAO;
	
	@Override
	public NoticeAssignData saveNotice(NoticeSaveDto noticeSaveDto, MultipartHttpServletRequest mr) {

		String path = mr.getSession().getServletContext().getRealPath("/resources/file");	// 절대 경로 설정?
		System.out.println(path);
		String board_type = "NOTICE";
		String saved_file_name = null;
		NoticeNum noticeNum = null;
		
		try {
			Notice notice = noticeSaveDto.toEntity();	
			
			noticeDAO.saveNotice(notice);
			
			noticeNum = new NoticeNum(notice.getNb_num());
			
			if(!mr.getFile("file").isEmpty()) {
				Attach attach = null;
				
				if(fileDAO.selectFile(noticeNum) != null) {
					attach = fileDAO.selectFile(noticeNum);
					saved_file_name = attach.getSaved_file_name();

					File deleteFile = new File(path + "/" + saved_file_name);
					
					deleteFile.delete();
					
					attach = fileService.singleUpload(mr, path, board_type, notice.getNb_num());
					
					fileDAO.editFile(attach);
				} else {
					attach = fileService.singleUpload(mr, path, board_type, notice.getNb_num());
					
					fileDAO.insertFile(attach);
				}
			}
		} catch (Exception e) {			
			File deleteFile = new File(path + "/" + saved_file_name);
			
			deleteFile.delete();
		}		
		Notice notice = noticeDAO.selectNotice(noticeNum);
		Attach attach = fileDAO.selectFile(noticeNum);

		return NoticeAssignData.create(notice, attach);
	}
	
	@Override
	public Notice selectNotice(NoticeListDto noticeListDto) {
		return noticeDAO.selectNotice(noticeListDto.toEntity());
	}
	
	@Override
	public String deleteNotice(NoticeRemoveDto noticeRemoveDto, HttpServletRequest httpServletRequest) {
		int result = noticeDAO.deleteNotice(noticeRemoveDto.toEntity());
		
		String path = httpServletRequest.getSession().getServletContext().getRealPath("/resources/file");
		System.out.println(path);
		NoticeNum noticeNum = new NoticeNum(noticeRemoveDto.getNb_num());
		
		if(fileDAO.selectFile(noticeNum) != null) {
			Attach attach = fileDAO.selectFile(noticeNum);
			
			File deleteFile = new File(path + "/" + attach.getSaved_file_name());
			
			deleteFile.delete();
			
			fileDAO.deleteFile(noticeNum); 	
		} 
		
		if(result > 0) {
			return "삭제 성공";
		} else {
			return "삭제 실패";
		}
	}
}
