package com.w.service.impl;



import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.w.mapper.ProductMapper;
import com.w.pojo.PageBean;
import com.w.pojo.Product;
import com.w.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<Product> findByCateId(Integer cate_id) {
        return productMapper.findByCateId(cate_id);
    }

    @Override
    public PageBean<Product> findPage(Integer cate_id, Integer currentPage, Integer pageSize) {
//        //1.设置分页参数
//        PageHelper.startPage(currentPage,pageSize);
//
//        //2.执行查询
//        List<Product> productList = productMapper.list(categoryId, gender, begin, end);
//        Page<Product> p = (Page<Product>) productList;
//
//        //3.封装PageBean对象
//        PageBean pageBean = new PageBean(p.getTotal(), p.getResult());
//
//        return pageBean;

//        //1.获取总记录数
//        Long count = productMapper.count();
//
//        //2.获取总记录数
//        Integer start = (currentPage - 1) * pageSize;
//        List<Product> empList = productMapper.page(start, pageSize);
//
//        //3.封装PageBean对象
//        PageBean pageBean = new PageBean(count, empList);
//        return pageBean;


        //获取当前分类的总记录数
        long totalCount = productMapper.findTotalCount(cate_id);

        //获取总页数
        long totalPage = totalCount%pageSize==0?totalCount/pageSize:totalCount/pageSize+1;

        //获取一个存有分页商品的集合
        //将当前页转换成一个起始位置
        int start = (currentPage-1)*pageSize;
        List<Product> productList = productMapper.findByPage(cate_id, start, pageSize);

        //构建一个PageBean对象
        PageBean<Product> pageBean =new PageBean<>();
        pageBean.setList(productList);
        pageBean.setCurrentPage(currentPage);
        pageBean.setPageSize(pageSize);
        pageBean.setTotalCount(totalCount);
        pageBean.setTotalPage(totalPage);

        return pageBean;

    }

    @Override
    public Product findById(Integer productId) {
        return productMapper.findById(productId);
    }

}
