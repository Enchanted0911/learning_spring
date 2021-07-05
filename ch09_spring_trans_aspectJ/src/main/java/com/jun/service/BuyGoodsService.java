package com.jun.service;

/**
 * @author Wu
 */
public interface BuyGoodsService {
    /**
     * 购买商品的方法
     * @param goodsId 商品编号
     * @param nums 商品数量
     */
    void buy(Integer goodsId, Integer nums);
}
