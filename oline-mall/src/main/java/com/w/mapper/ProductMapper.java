package com.w.mapper;



import com.w.pojo.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ProductMapper {

    //根据商品分类进行查询
    @Select("select * from shops.product where cate_id = #{cate_id}")
    List<Product> findByCateId(Integer cate_id);

    //查询当前分类商品的总记录数
    @Select("select count(*) from shops.product where cate_id = #{cate_id}")
    long findTotalCount(Integer cate_id);

    //查询当前页的集合信息
    @Select("select * from shops.product where cate_id = #{cate_id} limit #{start}, #{pageSize}")
    List<Product> findByPage(Integer cate_id,int start,int pageSize);

    @Select("select * from shops.product where id = #{productId}")
    Product findById(Integer productId);

}
