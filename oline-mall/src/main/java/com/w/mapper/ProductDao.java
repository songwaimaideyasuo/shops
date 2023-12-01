package com.w.mapper;



import com.w.pojo.Product;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductDao {

    //根据商品分类进行查询
    public List<Product> findByCateId(int cateid);

    //查询当前分类商品的总记录数
    public long findTotalCount(int cateid);

    //查询当前页的集合信息
    public List<Product> findByPage(int cateid,int start,int pageSize);

    //根据id查询
    public Product findById(int id);

}
