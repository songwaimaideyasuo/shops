package com.w.mapper;



import com.w.pojo.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ProductMapper {

    //根据商品分类进行查询
    @Select("select * from shops.product where cate_id = #{cate_id}")
    public List<Product> findByCateId(Integer cate_id);

    //查询当前分类商品的总记录数
    @Select("select count(*) from shops.product where cate_id = #{cate_id}")
    public long findTotalCount(Integer cate_id);

    //查询当前页的集合信息
    @Select("select * from shops.product where cate_id = #{cate_id} limit #{start}, #{pageSize}")
    public List<Product> findByPage(Integer cate_id,int start,int pageSize);
//
//    //根据id查询
//    public Product findById(int id);

}
