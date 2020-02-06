/***
 * CopyRight(C), 2018-2020
 * FileName:   MyRequestMappingHandlerMapping
 * Author:     
 * Date:       2020/2/6 13:19
 * Description:   
 *  <author>       <time>           <version>
 *  作者名字       修改时间          版本
 */
package com.hl.Filter;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

//由于改类注入不进去直接，所以将其继承，然后再将其注入。该类的作用为拦截spring容器中所有的方法。
@Component
public class MyRequestMappingHandlerMapping extends RequestMappingHandlerMapping {

}
