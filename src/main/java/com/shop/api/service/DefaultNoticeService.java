package com.shop.api.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shop.api.dao.NoticeDAO;
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
	
	private final NoticeDAO noticeDAO;
	
	@Override
	public Notice saveNotice(NoticeSaveDto noticeSaveDto) {
		Notice notice = noticeSaveDto.toEntity();
		
		noticeDAO.saveNoticE(notice);
		
		NoticeNum noticeNum = new NoticeNum(notice.getNb_num());
				
		return noticeDAO.selectNotice(noticeNum);
	}
	
	@Override
	public Notice selectNotice(NoticeListDto noticeListDto) {
		return noticeDAO.selectNotice(noticeListDto.toEntity());
	}
	
	@Override
	public String deleteNotice(NoticeRemoveDto noticeRemoveDto) {
		int result = noticeDAO.deleteNotice(noticeRemoveDto.toEntity());
		
		if(result > 0) {
			return "삭제 성공";
		} else {
			return "삭제 실패";
		}
	}
}
