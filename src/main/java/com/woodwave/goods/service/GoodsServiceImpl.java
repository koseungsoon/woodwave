package com.woodwave.goods.service;

import com.woodwave.goods.dao.GoodsDAO;
import com.woodwave.goods.vo.GoodsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GoodsServiceImpl implements GoodsService{
    @Autowired
    private GoodsDAO goodsDAO;
    @Override
    public Map<String,List<GoodsVO>> listGoods() throws Exception {
        Map<String,List<GoodsVO>> goodsMap=new HashMap<String,List<GoodsVO>>();
        List<GoodsVO> goodsList=goodsDAO.selectGoodsAll("bestItem");
        goodsMap.put("bestItem",goodsList);
        return goodsMap;

       /* List<GoodsVO> goodsList = null;
        goodsList=goodsDAO.selectGoodsAll();

        return goodsList;*/
    }

    @Override
    public List<GoodsVO> menuGoods() throws Exception {
        List<GoodsVO> goodsList = null;
        goodsList=goodsDAO.selectGoodsMenu();

        return goodsList;
    }
}
