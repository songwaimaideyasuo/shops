package com.w.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.w.mapper.MemberMapper;
import com.w.pojo.Member;
import com.w.pojo.Result;
import com.w.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.Map;


@Slf4j
//@RequestMapping(value = "/member/login",produces ="application/json; charset=utf-8")
@RequestMapping("/member")
@RestController //自动将方法的返回值转为json响应回去
public class MemberController {

    @Autowired
    private MemberService memberService;

    @Autowired
    private MemberMapper memberMapper;

    @PostMapping("/login")
    public Result login(Member member) {
        log.info("用户登录：{}", member.getMobile());
        Member e = memberService.login(member);
        //创建一个结果对象
        //Result result = new Result();
        if (e != null) {
            return Result.success(member);
            //result.setMsg("登录成功");
        }
        return Result.error("用户名或密码错误");
    }


    @GetMapping("/logout")
    public void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //销毁session
        HttpSession session = request.getSession();

        session.invalidate();

        Result result = new Result();
        result.setFlag(true);

        //转换成json
        writeJson(response, result);
    }

    private void writeJson(HttpServletResponse response, Object object) {
        response.setContentType("application/json");
        ObjectMapper mapper = new ObjectMapper();
        try {
            String json = mapper.writeValueAsString(object);
            response.getWriter().print(json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @PostMapping("/register")
    public Result register(Member member) {
        log.info("新增会员{}", member.getMobile());
        memberService.add(member);

        return Result.success("注册成功");

//        //根据注册的结果返回对应的消息
//        if ((memberMapper.add(member)) == 1) {
//            //说明注册成功
//            return Result.success("注册成功");
//        } else {
//            return Result.error("注册失败");
//        }

    }

    @GetMapping("/findNickName")
    public Result findNickName(Member member) {

        //返回的结果对象
//        Result result = new Result();
//        result.setFlag(true);
//        result.setMsg("");
//        result.setData(member);

        return Result.success(member);

    }

}

//    public void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
//        response.setCharacterEncoding("UTF-8");
//        PrintWriter out = response.getWriter();
//
///*       如果当前台数据很多时，可以使用BeanUtils.Populdate()方法快速的将表单中的数据封装到实体对象中。
//        前提要保存表单数据的名字要和实体对象的属性名一致*/
//        Map<String, String[]> parameterMap = request.getParameterMap();
//        Member member = new Member();
//
//        try {
//            BeanUtils.populate(member, parameterMap);
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        }
//        //设置用户注册时间
//        member.setRegister_time(new Date());
//        //调用业务层完成添加的任务
//        boolean result = memberService.regist(member);
//        //根据注册的结果返回对应的消息
//        Result result1 = new Result();
//        if (result==true){
//            //说明注册成功
//            result1.setFlag(true);
//            result1.setMsg("注册成功");
//        }else {
//            result1.setFlag(false);
//            result1.setMsg("注册失败");
//        }
//        ObjectMapper mapper = new ObjectMapper();
//        String s = mapper.writeValueAsString(result1);
//        response.getWriter().print(s);
//    }



//    @PostMapping
//    @ResponseBody
//    public String getCode(HttpServletRequest request){
//        String id = request.getParameter("id");
//        System.out.println("AJAX传递的参数：" + id);
//        //获取5位验证码
//        return randomCodes();
//    }


//        //登录成功，生成令牌，下发令牌
//        if (e != null){
//            Map<String, Object> claims = new HashMap<>();
//            claims.put("id", e.getId());
//            claims.put("name", e.getName());
//            claims.put("username", e.getUsername());
//            String jwt = JwtUtils.generateJwt(claims); //jwt包含了当前登录的员工信息
//            return Result.success(jwt);
//        }
//        //return e != null?Result.success():Result.error("用户名或密码错误");
//        return Result.error("用户名或密码错误");



