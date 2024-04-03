package com.woodwave.goods.service;

import com.woodwave.goods.vo.GoodsVO;

import java.util.List;

public interface GoodsService {

    public List<GoodsVO> listGoods() throws Exception;
    public List<GoodsVO> menuGoods() throws Exception;

}


