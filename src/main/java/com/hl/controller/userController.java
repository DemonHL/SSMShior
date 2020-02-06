/***
 * CopyRight(C), 2018-2020
 * FileName:   userController
 * Author:     
 * Date:       2020/2/4 16:41
 * Description:   
 *  <author>       <time>           <version>
 *  作者名字       修改时间          版本
 */
package com.hl.controller;
import com.hl.entity.person;
import com.hl.mapper.Impl.personMapperImpl;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/userController")
public class userController {

    @Autowired
    personMapperImpl pm;





    @RequestMapping("toShowUser")
    public String toShowUser(Model model){
        person p = pm.selectByPrimaryKey(1);
        model.addAttribute("user",p.toString());
        return "showUser";
    }
}
