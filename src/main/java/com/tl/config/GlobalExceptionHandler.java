package com.tl.config;

import com.tl.utils.ResultUtil;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.ConstraintViolationException;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: tl
 * @description:
 * @author:
 * @create: 2018-10-31 10:00
 **/
@ControllerAdvice
public class GlobalExceptionHandler {
/*
    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public Map<String, Object> exceptionHandle(Exception e, Model model) {
        Map<String,Object> result = new HashMap<String, Object>();
        if(e instanceof UnauthorizedException){
            model.addAttribute("error","权限不够");
            return ResultUtil.resultMap("message","权限不够");
        }
        if(e instanceof ConstraintViolationException){
            return ResultUtil.resultMap("message",e.getLocalizedMessage());
        }
        return result;
    }*/
}
