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

import com.woodwave.common.interceptor.ViewNameInterceptor;

import java.util.List;
import java.util.Map;

@Controller("goodsController")
@RequestMapping(value="/goods")
@Log4j2
public class GoodsControllerImpl extends BaseController implements GoodsController {
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private GoodsVO goodsVO;

    private ViewNameInterceptor viewNameInterceptor;
    @Override
    @RequestMapping(value="/listGoods.do")
    public ModelAndView listGoods(HttpServletRequest request, HttpServletResponse response) throws Exception {
        log.info("listGoods 들어옴");
        ModelAndView mav=new ModelAndView();
        String viewName = getViewName(request);
        log.info("viewName: "+ viewName);



        mav.setViewName(viewName);
//        List goodsList = goodsService.listGoods();
        Map<String,List<GoodsVO>> goodsMap = (Map<String, List<GoodsVO>>) goodsService.listGoods();
//        mav.addObject("goodsList",goodsList);
        mav.addObject("goodsMap",goodsMap);
        log.info(mav);
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



    private String getViewName(HttpServletRequest request) throws Exception {
        String contextPath = request.getContextPath();
        String uri = (String) request.getAttribute("javax.servlet.include.request_uri");
        if (uri == null || uri.trim().equals("")) {
            uri = request.getRequestURI();
        }

        int begin = 0;
        if (!((contextPath == null) || ("".equals(contextPath)))) {
            begin = contextPath.length();
        }

        int end;
        if (uri.indexOf(";") != -1) {
            end = uri.indexOf(";");
        } else if (uri.indexOf("?") != -1) {
            end = uri.indexOf("?");
        } else {
            end = uri.length();
        }

        String viewName = uri.substring(begin, end);
        if (viewName.indexOf(".") != -1) {
            viewName = viewName.substring(0, viewName.lastIndexOf("."));
        }
        if (viewName.lastIndexOf("/") != -1) {
            viewName = viewName.substring(viewName.lastIndexOf("/", 1), viewName.length());
        }
        return viewName;
    }

}
