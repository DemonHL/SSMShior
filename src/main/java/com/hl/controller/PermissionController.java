package com.hl.controller;

import com.hl.Filter.MyRequestMappingHandlerMapping;
import com.hl.entity.permission;
import com.hl.mapper.Impl.permissionMapperImpl;
import com.hl.realm.PermissionName;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;


import java.util.Collection;
import java.util.List;
import java.util.Map;

@Controller
public class PermissionController {


    //拦截spring容器中所有的方法类
    @Autowired
    MyRequestMappingHandlerMapping mapping;
    @Autowired
    permissionMapperImpl pmi;
   @RequestMapping("/reload")
    public String reload() throws  Exception{
        List<String> resourceList = pmi.selectAllResource();
        //获取所有的方法
        Map<RequestMappingInfo, HandlerMethod> handlerMethods = mapping.getHandlerMethods();
        Collection<HandlerMethod> methods = handlerMethods.values();
        for(HandlerMethod method:methods){
            //获取含有@RequiresPermissions注解
            RequiresPermissions anno = method.getMethodAnnotation(RequiresPermissions.class);
            if(anno!=null){
               String resource=anno.value()[0];
                if(resourceList.contains(resource)){
                    continue;
                }else{
                    permission p=new permission();
                    //获取@PermissionName的值
                    String annoInfo = method.getMethodAnnotation(PermissionName.class).value();
                    p.setName(annoInfo);
                    p.setResource(resource);
                    pmi.insertSelective(p);
                }
            }
        }
        return "main";
    }

}
