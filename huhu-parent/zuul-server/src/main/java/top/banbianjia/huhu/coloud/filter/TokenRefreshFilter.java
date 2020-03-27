package top.banbianjia.huhu.coloud.filter;


import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by admin
 */
/*
@Component
public class TokenRefreshFilter extends ZuulFilter {
    @Autowired
    private TokenFeignApi tokenFeignApi;

    public String filterType() {
        return FilterConstants.POST_TYPE;
    }

    public int filterOrder() {
        return 0;
    }

    public boolean shouldFilter() {
        //请求中携带了token才需要进行刷新
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        String token = CookieUtil.getCookie(request, CookieUtil.TOKEN_NAME);
        if (StringUtils.isEmpty(token)) {
            return false;
        }
        return true;
    }

    public Object run() throws ZuulException {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        String token = CookieUtil.getCookie(request, CookieUtil.TOKEN_NAME);
        //刷新redis中对应的token的有效时间
        Result<Boolean> result = tokenFeignApi.refreshToken(token);
        if (result != null && !result.hasError() && result.getData()) {
            //刷新cookie中的token的有效时间
            CookieUtil.addCookie(context.getResponse(), CookieUtil.TOKEN_NAME, token, CookieUtil.TOKEN_SECONDS);
        }
        return null;
    }
}
*/
