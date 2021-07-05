package com.jun.service.impl;

import com.jun.dao.GoodsDao;
import com.jun.dao.SaleDao;
import com.jun.domain.Goods;
import com.jun.domain.Sale;
import com.jun.exception.NotEnoughException;
import com.jun.service.BuyGoodsService;

/**
 * @author Wu
 */
public class BuyGoodsServiceImpl implements BuyGoodsService {
    private SaleDao saleDao;
    private GoodsDao goodsDao;

    public void setSaleDao(SaleDao saleDao) {
        this.saleDao = saleDao;
    }

    public void setGoodsDao(GoodsDao goodsDao) {
        this.goodsDao = goodsDao;
    }

    @Override
    public void buy(Integer goodsId, Integer nums) {
        System.out.println("------开始买东西------");
        Sale sale = new Sale();
        sale.setGid(goodsId);
        sale.setNums(nums);
        saleDao.insertSale(sale);

        Goods goods = goodsDao.selectGoods(goodsId);
        if (goods == null) {
            throw new NullPointerException("编号是 ： " + goodsId + ", 商品不存在");
        } else if (goods.getAmount() < nums) {
            throw new NotEnoughException("编号是 ： " + goodsId + ", 商品库存不足");
        }

        Goods buyGoods = new Goods();
        buyGoods.setId(goodsId);
        buyGoods.setAmount(nums);
        goodsDao.updateGoods(buyGoods);
        System.out.println("------买完东西了-------");
    }
}
