package com.woodwave.member.service;

import com.woodwave.member.dao.MemberDAO;
import com.woodwave.member.vo.MemberVO;
import lombok.extern.log4j.Log4j2;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;
@Log4j2
@Service("memberService")
@Transactional(propagation= Propagation.REQUIRED)

public class MemberServiceImpl implements  MemberService{

    @Autowired
    private MemberDAO memberDAO;

    @Autowired
    private SqlSession sqlSession;

    @Override
    public MemberVO login(Map loginMap) throws Exception {
        return memberDAO.login(loginMap);
    }

    @Override
    public void addMember(MemberVO memberVO) throws Exception {
        memberDAO.insertNewMember(memberVO);
    }

    @Override
    public String overlapped(String id) throws Exception {
        return memberDAO.selectOverlappedID(id);
    }

    @Override
    public int idCheck(String member_id) {

        log.info("Service Impl 아이디중복 들어옴");
        return memberDAO.idCheck(member_id);
    }
}
