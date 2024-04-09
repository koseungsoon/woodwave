package com.woodwave.goods.service;

import com.woodwave.goods.vo.GoodsVO;

import java.util.List;
import java.util.Map;

public interface GoodsService {

    public Map<String,List<GoodsVO>> listGoods() throws Exception;
    public List<GoodsVO> menuGoods() throws Exception;

}


