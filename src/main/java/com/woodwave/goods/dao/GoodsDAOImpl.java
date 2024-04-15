package com.woodwave.goods.dao;

import com.woodwave.goods.vo.GoodsVO;
import com.woodwave.goods.vo.ImageFileVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
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

    @Override
    public GoodsVO selectGoodsDetail(String goods_id) throws DataAccessException {
        GoodsVO goodsVO=(GoodsVO)sqlSession.selectOne("mapper.goods.selectGoodsDetail",goods_id);
        return goodsVO;
    }

    @Override
    public List<ImageFileVO> selectGoodsDetailImage(String goods_id) throws DataAccessException {
        List<ImageFileVO> imageList=(ArrayList)sqlSession.selectList("mapper.goods.selectGoodsDetailImage",goods_id);
        return imageList;
    }
}
