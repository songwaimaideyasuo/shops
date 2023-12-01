package com.w.mapper;



import com.w.pojo.Category;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CategoryDao {

    public List<Category> findAll();
}
