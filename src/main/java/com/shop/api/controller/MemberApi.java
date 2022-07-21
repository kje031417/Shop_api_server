package com.shop.api.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shop.api.controller.dto.MemberDeleteDto.MemberDeleteRequest;
import com.shop.api.controller.dto.MemberSelectDto.MemberSelectData;
import com.shop.api.controller.dto.MemberSelectDto.MemberSelectRequest;
import com.shop.api.controller.dto.MemberSelectDto.MemberSelectResponse;
import com.shop.api.controller.dto.MemberAssignDto.MemberAssignData;
import com.shop.api.controller.dto.MemberAssignDto.MemberAssignRequest;
import com.shop.api.controller.dto.MemberAssignDto.MemberAssignResponse;
import com.shop.api.dao.dto.Member;
import com.shop.api.service.MemberService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberApi {
	
	private final MemberService memberService;
	
	@PostMapping("/save")
	public MemberAssignResponse saveMember(@RequestBody MemberAssignRequest req) {
		Member member = memberService.saveMember(req.toDto());
		
		return new MemberAssignResponse(MemberAssignData.create(member));
	}

	@GetMapping("/select")
	public MemberSelectResponse selectMember(@RequestBody MemberSelectRequest req) {
		Member member = memberService.selectMember(req.toDto());
		
		return new MemberSelectResponse(MemberSelectData.create(member));
	}
	
	@DeleteMapping("/delete")
	public String deleteMember(@RequestBody MemberDeleteRequest req) {
		return memberService.withdrawMember(req.toDto());
	}	
}
