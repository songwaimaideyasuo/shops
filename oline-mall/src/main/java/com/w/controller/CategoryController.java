package com.w.controller;



import com.w.pojo.Category;
import com.w.pojo.Result;
import com.w.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@Slf4j
@RequestMapping("/category")
@RestController //自动将方法的返回值转为json响应回去
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/findAll")
    public Result findAll() {
        log.info("查询全部");
        List<Category> categoryList = categoryService.findAll();
        return Result.success("查询成功",categoryList);

    }

}
