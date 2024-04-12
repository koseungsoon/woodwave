package com.woodwave.member.controller;

import com.woodwave.member.service.MemberService;
import com.woodwave.member.vo.MemberVO;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller("memberController")
@Log4j2
@RequestMapping("/member")
public class MemberControllerImpl implements  MemberController{
    @Autowired
    private MemberService memberService;
    @Autowired
    private MemberVO memberVO;


    @Override
    @RequestMapping(value="/login.do" ,method = RequestMethod.POST)
    public ModelAndView login(@RequestParam Map<String, String> loginMap, HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mav = new ModelAndView();
        memberVO = memberService.login(loginMap);
        log.info("로그인한 memberVO: "+memberVO);
        if (memberVO != null && memberVO.getMember_id() != null) {
            HttpSession session = request.getSession();
//            session = request.getSession();
            session.setAttribute("isLogOn", true);
            session.setAttribute("memberInfo", memberVO);

            log.info("로그인한 아이디 memberInfo: " + session.getAttribute("memberInfo"));

            String action = (String) session.getAttribute("action");

            log.info("action: " + action);
            if (action != null && action.equals("/order/orderEachGoods.do")) {
                mav.setViewName("forward:" + action);
            } else {
                mav.setViewName("redirect:/main/main.do");
            }
        } else {
            String message = "아이디나  비밀번호가 틀립니다. 다시 로그인해주세요";
            mav.addObject("message", message);
            mav.setViewName("/member/loginForm");
        }
        return mav;
    }

    @Override
    @RequestMapping(value="/logout.do" ,method = RequestMethod.GET)
    public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
            ModelAndView mav = new ModelAndView();
            HttpSession session=request.getSession();
            session.setAttribute("isLogOn", false);
            session.removeAttribute("memberInfo");
            log.info("로그아웃한 아이디: "+session.getAttribute("memberInfo"));
            mav.setViewName("redirect:/main/main.do");
            return mav;
    }

    @Override
    @RequestMapping(value="/addMember.do" ,method = RequestMethod.POST)
    public ResponseEntity addMember(@ModelAttribute("memberVO") MemberVO _memberVO, HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("utf-8");

        log.info("회원가입하려는아이디: "+_memberVO);

        String message = null;
        ResponseEntity resEntity = null;
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add("Content-Type", "text/html; charset=utf-8");
        try {
            memberService.addMember(_memberVO);
            message  = "<script>";
            message +=" alert('회원 가입을 마쳤습니다.로그인창으로 이동합니다.');";
            message += " location.href='"+request.getContextPath()+"/member/loginForm.do';";
            message += " </script>";

        }catch(Exception e) {
            message  = "<script>";
            message +=" alert('작업 중 오류가 발생했습니다. 다시 시도해 주세요');";
            message += " location.href='"+request.getContextPath()+"/member/memberForm.do';";
            message += " </script>";
            e.printStackTrace();
        }
        resEntity =new ResponseEntity(message, responseHeaders, HttpStatus.OK);
        return resEntity;
    }

    @Override
    @RequestMapping(value="/overlapped.do" ,method = RequestMethod.POST)
    public ResponseEntity overlapped(@RequestParam("member_id") String member_id, HttpServletRequest request, HttpServletResponse response) throws Exception {
        ResponseEntity resEntity = null;
        String result = memberService.overlapped(member_id);
        resEntity =new ResponseEntity(result, HttpStatus.OK);
        return resEntity;
    }

    @Override
    @RequestMapping("/loginForm.do")
    public ModelAndView loginForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/member/loginForm");

        return mav;
    }

    @Override
    @RequestMapping("/memberForm.do")
    public ModelAndView memberForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/member/memberForm");

        return mav;
    }
}
