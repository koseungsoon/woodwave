package com.woodwave.member.dao;

import com.woodwave.member.vo.MemberVO;
import lombok.extern.log4j.Log4j2;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import java.util.Map;
@Log4j2
@Repository("memberDAO")
public class MemberDAOImpl implements MemberDAO{

    @Autowired
    private SqlSession sqlSession;


    @Override
    public MemberVO login(Map loginMap) throws DataAccessException {
        MemberVO memberVO=sqlSession.selectOne("mapper.member.login",loginMap);
        return memberVO;
    }

    @Override
    public void insertNewMember(MemberVO memberVO) throws DataAccessException {
        sqlSession.insert("mapper.member.insertNewMember",memberVO);
    }

    @Override
    public String selectOverlappedID(String member_id) throws DataAccessException {
        String result =  sqlSession.selectOne("mapper.member.selectOverlappedID",member_id);
        return result;

    }

    @Override
    public int idCheck(String member_id) throws DataAccessException {
        log.info("DAOImpl 아이디중복들어옴");
        int result = sqlSession.selectOne("mapper.member.idCheck",member_id);

                return result;
    }


}
