package com.woodwave.goods.service;

import com.woodwave.goods.dao.GoodsDAO;
import com.woodwave.goods.vo.GoodsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class GoodsServiceImpl implements GoodsService{
    @Autowired
    private GoodsDAO goodsDAO;
    @Override
    public List<GoodsVO> listGoods() throws Exception {
        List<GoodsVO> goodsList = null;
        goodsList=goodsDAO.selectGoodsAll();

        return goodsList;
    }

    @Override
    public List<GoodsVO> menuGoods() throws Exception {
        List<GoodsVO> goodsList = null;
        goodsList=goodsDAO.selectGoodsMenu();

        return goodsList;
    }
}
