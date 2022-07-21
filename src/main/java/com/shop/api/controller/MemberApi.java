package com.shop.api.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shop.api.controller.dto.MemberDeleteDto.MemberDeleteRequest;
import com.shop.api.controller.dto.MemberEditDto.MemberEditData;
import com.shop.api.controller.dto.MemberEditDto.MemberEditRequest;
import com.shop.api.controller.dto.MemberEditDto.MemberEditResponse;
import com.shop.api.controller.dto.MemberSelectDto.MemberSelectData;
import com.shop.api.controller.dto.MemberSelectDto.MemberSelectRequest;
import com.shop.api.controller.dto.MemberSelectDto.MemberSelectResponse;
import com.shop.api.controller.dto.MemberCreateDto.MemberCreateData;
import com.shop.api.controller.dto.MemberCreateDto.MemberCreateRequest;
import com.shop.api.controller.dto.MemberCreateDto.MemberCreateResponse;
import com.shop.api.dao.dto.Member;
import com.shop.api.service.MemberService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberApi {
	
	private final MemberService memberService;
	
	@PostMapping("/join")
	public MemberCreateResponse joinMember(@RequestBody MemberCreateRequest req) {
		Member member = memberService.joinMember(req.toDto());
		
		return new MemberCreateResponse(MemberCreateData.create(member));
	}
	
	@PutMapping("/modify")
	public MemberEditResponse modifyMember(@RequestBody MemberEditRequest req) {
		Member member = memberService.modifyMember(req.toDto());
		
		return new MemberEditResponse(MemberEditData.create(member));
	}
	
	@DeleteMapping("/delete")
	public String deleteMember(@RequestBody MemberDeleteRequest req) {
		return memberService.withdrawMember(req.toDto());
	}
	
	@GetMapping("/select")
	public MemberSelectResponse selectMember(@RequestBody MemberSelectRequest req) {
		Member member = memberService.selectMember(req.toDto());
		return new MemberSelectResponse(MemberSelectData.create(member));
	}
}
