package com.woodwave.goods.controller;

import com.woodwave.common.base.BaseController;
import com.woodwave.goods.service.GoodsService;
import com.woodwave.goods.vo.GoodsVO;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller("goodsController")
@RequestMapping(value="/goods")
@Log4j2
public class GoodsControllerImpl extends BaseController implements GoodsController {
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private GoodsVO goodsVO;

    @Override
    @RequestMapping(value="/listGoods.do")
    public ModelAndView listGoods(HttpServletRequest request, HttpServletResponse response) throws Exception {
        log.info("listGoods 들어옴");
        ModelAndView mav=new ModelAndView();
        mav.setViewName("goodsList");
        return mav;
    }

    @Override
    public ModelAndView menuGoods(String goods_id, HttpServletRequest request, HttpServletResponse response) throws Exception {
        return null;
    }

//    @Override
//    public ModelAndView goodsDetail(String goods_id, HttpServletRequest request, HttpServletResponse response) throws Exception {
//        return null;
//    }
//
//    @Override
//    public ModelAndView searchGoods(String searchWord, HttpServletRequest request, HttpServletResponse response) throws Exception {
//        return null;
//    }
}
