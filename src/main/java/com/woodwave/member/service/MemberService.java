package com.woodwave.member.service;

import com.woodwave.member.vo.MemberVO;

import java.util.Map;

public interface MemberService {
    public MemberVO login(Map loginMap) throws Exception;
    public void addMember(MemberVO memberVO) throws Exception;
    public String overlapped(String id) throws Exception;

    public int idCheck(String member_id);
}
