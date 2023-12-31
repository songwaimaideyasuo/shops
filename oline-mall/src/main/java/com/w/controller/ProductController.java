package com.w.controller;


import com.w.pojo.PageBean;
import com.w.pojo.Product;
import com.w.pojo.Result;
import com.w.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;


@Slf4j
@RequestMapping("/product")
@RestController //自动将方法的返回值转为json响应回去
public class ProductController extends BaseServlet {

    @Autowired
    private ProductService productService;

    @GetMapping("/findByCate")
    public Result findByCateId(@RequestParam Integer cate_id) {
        log.info("根据cate_id查询商品");
        List<Product> product = productService.findByCateId(cate_id);
        return Result.success("查询成功", product);
    }

    @GetMapping("/findPage")
    public Result findPage(@RequestParam Integer cate_id,
                           @RequestParam(defaultValue = "1") Integer currentPage,
                           @RequestParam(defaultValue = "10") Integer pageSize) {
        log.info("分页查询");
        PageBean<Product> pageBean = productService.findPage(cate_id, currentPage, pageSize);
        return Result.success("查询成功", pageBean);
    }

    @GetMapping("/findById")
    public Result findById(@RequestParam Integer productId){
        log.info("查看{}详情",productId);

        //调用业层查询商品详情
        Product product = productService.findById(productId);

        System.out.println("---------------------------------------");
        System.out.println(product);

        return Result.success("查询成功",product);

    }


//    public void findPage(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException{
//        //获取到前台传过来的分类编号
//        String categoryId = request.getParameter("categoryId");
//        //获取前台传过来的当前页
//        String page = request.getParameter("currentPage");
//        //获取每页显示的记录数
//        String size = request.getParameter("pageSize");
//
//        int cateId=0;
//        if(categoryId!=null){
//            cateId=Integer.parseInt(categoryId);
//        }
//
//        int currenPage=1;  //如果前台没有传递当前页，则默认值为1
//        if(page!=null){
//            currenPage=Integer.parseInt(page);
//        }
//
//        int pageSize=10;//如果前台没有传递每页条数，则默认值为10
//        if(size!=null){
//            pageSize= Integer.parseInt(size);
//        }
//
//        PageBean<Product> pageBean = productService.findPage(cateId, currenPage, pageSize);
//
//        writeJson(response,pageBean);
//    }


//    public void findById(HttpServletRequest request,HttpServletResponse response)throws IOException, ServletException{
//
//        //接收前台传过来的商品编号
//        String sid = request.getParameter("productId");
//        int productId = Integer.parseInt(sid);
//
//        //调用业层查询商品详情
//        Product product = productService.findById(productId);
//
//        //封装result对象进行返回
//        Result result = new Result(true,product,"查询成功");
//
//        //将result转换成json响应到前台
//        writeJson(response,result);
//
//    }


/*    public void findByCate(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        //获取到前台传过来的分类编号
        String cate_id = request.getParameter("cate_id");
        int cateid = 0;//如果用户没有传分类id，则默认为0
        if (cate_id!=null){
            cateid = Integer.parseInt(cate_id);
        }

        //调用业务层根据分类来进行商品的查询
        List<Product> productList = productService.findByCateId(cateid);

        //构建一个结果对象
        Result result = new Result(true,productList,"查询成功");

        writeJson(response, result);


    }*/
}
