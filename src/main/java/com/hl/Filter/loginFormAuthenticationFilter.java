/***
 * CopyRight(C), 2018-2020
 * FileName:   loginFormAuthenticationFilter
 * Author:     
 * Date:       2020/2/5 21:36
 * Description:   
 *  <author>       <time>           <version>
 *  作者名字       修改时间          版本
 */
package com.hl.Filter;
import com.hl.entity.user;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.stereotype.Repository;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

//解决直接访问登陆页面，验证成功之后无法进入主页面的问题，
//第二个方法解决等用户非正常注销页面时，无法再次登陆主页面
@Repository
public class loginFormAuthenticationFilter extends FormAuthenticationFilter {
    private final String successUrl = "/main";
    //解决直接访问登陆页面，验证成功之后无法进入主页面的问题，
    @Override
    protected void issueSuccessRedirect(ServletRequest request, ServletResponse response) throws Exception {
        WebUtils.issueRedirect(request, response, successUrl, null, true); }

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue)
    {
        if (isLoginRequest(request, response))
        {
            if (isLoginSubmission(request, response))
            {
                //本次用户登陆账号
                String account = this.getUsername(request);

                Subject subject = this.getSubject(request, response);
                //之前登陆的用户
                user user = (user) subject.getPrincipal();
                //如果两次登陆的用户不一样，则先退出之前登陆的用户
                if (account != null && user != null && !account.equals(user.getUsername()))
                {
                    subject.logout();
                }
            }
        }
        return super.isAccessAllowed(request, response, mappedValue);
    }
}
