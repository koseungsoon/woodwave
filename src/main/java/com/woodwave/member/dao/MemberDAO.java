package com.woodwave.member.dao;

import com.woodwave.member.vo.MemberVO;
import org.springframework.dao.DataAccessException;

import java.util.Map;

public interface MemberDAO {

    public MemberVO login(Map loginMap) throws DataAccessException;
    public void insertNewMember(MemberVO memberVO) throws DataAccessException;
    public String selectOverlappedID(String member_id) throws DataAccessException;

    public int idCheck(String member_id) throws DataAccessException;


}
