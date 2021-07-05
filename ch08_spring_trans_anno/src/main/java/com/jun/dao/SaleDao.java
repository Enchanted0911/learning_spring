package com.jun.dao;

import com.jun.domain.Sale;

/**
 * @author Wu
 */
public interface SaleDao {
    /**
     * 添加一条销售记录
     * @param sale 这东西有什么用
     * @return 应该是结果
     */
    int insertSale(Sale sale);
}
