package com.woodwave.goods.dao;

import com.woodwave.goods.vo.GoodsVO;

import java.util.List;

public interface GoodsDAO {
    public List<GoodsVO> selectGoodsAll() throws Exception;
    public List<GoodsVO> selectGoodsMenu() throws Exception;
}
