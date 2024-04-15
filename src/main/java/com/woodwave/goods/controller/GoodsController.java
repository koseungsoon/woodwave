package com.woodwave.goods.controller;


import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface GoodsController {

	public ModelAndView listGoods(HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView menuGoods(@RequestParam("goods_sort") String goods_id,HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView goodsDetail(@RequestParam("goods_id") String goods_id,HttpServletRequest request, HttpServletResponse response) throws Exception;

//	public ModelAndView searchGoods(@RequestParam("searchWord") String searchWord,HttpServletRequest request, HttpServletResponse response) throws Exception;
}
