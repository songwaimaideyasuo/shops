package com.w.service;



import com.w.pojo.PageBean;
import com.w.pojo.Product;

import java.util.List;

public interface ProductService {

    //根据商品分类进行查询
    public List<Product> findByCateId(Integer cate_id);

    //根据商品分类进行分页查询
    public PageBean<Product> findPage(Integer cate_id, Integer currentPage, Integer pageSize);

    //根据id查询
    public Product findById(Integer id);
}
