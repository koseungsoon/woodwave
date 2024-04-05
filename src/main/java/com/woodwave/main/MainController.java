package com.woodwave.main;

import com.woodwave.common.base.BaseController;
import com.woodwave.goods.service.GoodsService;
import com.woodwave.goods.vo.GoodsVO;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

import com.woodwave.common.base.BaseController;
import com.woodwave.goods.service.GoodsService;
import com.woodwave.goods.vo.GoodsVO;

@Controller("mainController")
@Log4j2
@EnableAspectJAutoProxy
public class MainController extends BaseController {

    @Autowired
    private GoodsService goodsService;

    @RequestMapping(value= "/main/main.do" ,method={RequestMethod.POST,RequestMethod.GET})
    public ModelAndView main(HttpServletRequest request, HttpServletResponse response) throws Exception{
        log.info("main 들어옴");
        ModelAndView mav=new ModelAndView();
        String viewName = getViewName(request);
        log.info("viewName: "+ viewName);



        mav.setViewName(viewName);
        List goodsList = goodsService.listGoods();
        mav.addObject("goodsList",goodsList);
        log.info(mav);
        return mav;


    }
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
