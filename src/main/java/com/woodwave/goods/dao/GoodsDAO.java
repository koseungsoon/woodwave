package com.woodwave.goods.dao;

import com.woodwave.goods.vo.GoodsVO;
import com.woodwave.goods.vo.ImageFileVO;
import org.springframework.dao.DataAccessException;

import java.util.List;
import java.util.Map;

public interface GoodsDAO {
    public List<GoodsVO> selectGoodsAll(String goodsStatus) throws Exception;
    public List<GoodsVO> selectGoodsMenu() throws Exception;

    public GoodsVO selectGoodsDetail(String goods_id) throws DataAccessException;

    public List<ImageFileVO> selectGoodsDetailImage(String goods_id) throws DataAccessException;

}
