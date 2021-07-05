package com.jun.dao;

import com.jun.domain.Goods;

/**
 * @author Wu
 */
public interface GoodsDao {
    /**
     * 更新商品用的
     * @param goods 商品信息
     * @return 更新结果
     */
    int updateGoods(Goods goods);

    /**
     * 查询商品信息
     * @param id 根据商品id查询
     * @return 查询到的商品
     */
    Goods selectGoods(Integer id);
}
