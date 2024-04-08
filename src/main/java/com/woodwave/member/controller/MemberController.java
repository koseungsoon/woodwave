package com.woodwave.member.controller;

import com.woodwave.member.vo.MemberVO;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;


public interface MemberController {

    public ModelAndView login(@RequestParam Map<String, String> loginMap, HttpServletRequest request, HttpServletResponse response) throws Exception;
    public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) throws Exception;
    public ResponseEntity addMember(@ModelAttribute("member") MemberVO member,
                                    HttpServletRequest request, HttpServletResponse response) throws Exception;
    public ResponseEntity   overlapped(@RequestParam("id") String id,HttpServletRequest request, HttpServletResponse response) throws Exception;

    public ModelAndView loginForm(HttpServletRequest request, HttpServletResponse response) throws Exception;
    public ModelAndView memberForm(HttpServletRequest request, HttpServletResponse response) throws Exception;

}
