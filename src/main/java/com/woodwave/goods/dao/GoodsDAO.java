package com.woodwave.goods.dao;

import com.woodwave.goods.vo.GoodsVO;

import java.util.List;
import java.util.Map;

public interface GoodsDAO {
    public List<GoodsVO> selectGoodsAll(String goodsStatus) throws Exception;
    public List<GoodsVO> selectGoodsMenu() throws Exception;
}
