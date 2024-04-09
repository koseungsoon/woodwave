package com.woodwave.goods.dao;

import com.woodwave.goods.vo.GoodsVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class GoodsDAOImpl implements GoodsDAO{

    @Autowired
    private SqlSession sqlSession;

    @Override
    public List<GoodsVO>  selectGoodsAll(String goodsStatus) throws Exception {
        List<GoodsVO> goodsList = (ArrayList)sqlSession.selectList("mapper.goods.selectGoodsAll",goodsStatus);
//        goodsList = sqlSession.selectList("mapper.goods.selectGoodsAll");
        return goodsList;
    }

    @Override
    public List<GoodsVO> selectGoodsMenu() throws Exception {
        List<GoodsVO> goodsList = null;
        goodsList = sqlSession.selectList("mapper.goods.selectGoodsMenu");
        return goodsList;
    }
}
