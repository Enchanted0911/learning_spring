package com.jun.service.impl;

import com.jun.dao.GoodsDao;
import com.jun.dao.SaleDao;
import com.jun.domain.Goods;
import com.jun.domain.Sale;
import com.jun.exception.NotEnoughException;
import com.jun.service.BuyGoodsService;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional(
            // 这些都是默认值， 默认抛出运行时异常回滚事务，如果rollbackFor 指定了异常 不论是受检异常还是运行异常都会回滚,
            // 如果没有指定的异常，spring自动判断是否运行时异常，如果是则回滚
            // 可以只写@Transactional也能达到同样的效果
            propagation = Propagation.REQUIRED,
            isolation = Isolation.DEFAULT,
            readOnly = false,
            rollbackFor = {
                    NullPointerException.class,
                    NotEnoughException.class
            }
    )
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
