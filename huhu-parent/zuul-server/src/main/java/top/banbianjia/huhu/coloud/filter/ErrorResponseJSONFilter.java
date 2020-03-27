package top.banbianjia.huhu.coloud.filter;

import com.alibaba.fastjson.JSON;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.ERROR_TYPE;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.SEND_ERROR_FILTER_ORDER;

/**
 * Created by admin
 */
@Component
public class ErrorResponseJSONFilter extends ZuulFilter {
    protected static final String SEND_ERROR_FILTER_RAN = "sendErrorFilter.ran";
    @Override
    public String filterType() {
        return ERROR_TYPE;
    }

    @Override
    public int filterOrder() {
        return SEND_ERROR_FILTER_ORDER;
    }

    @Override
    public boolean shouldFilter() {
        RequestContext ctx = RequestContext.getCurrentContext();
        // 这里只有返回true才会成功2
        return ctx.getThrowable() != null
                && !ctx.getBoolean(SEND_ERROR_FILTER_RAN, false);
    }

    @Override
    public Object run() {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletResponse response = context.getResponse();
        Map<String,Object> map = new HashMap<>();
        if("true".equals(context.get("rateLimitExceeded"))){
            //限流异常
            map.put("code",429);
            map.put("msg","请求频率太快,稍后再试");
        }else{
            //其他的异常
            map.put("code",500);
            map.put("msg","系统繁忙,稍后再试");
        }
        try {
            response.setContentType("text/json;charset=utf-8");
            response.getWriter().write(JSON.toJSONString(map));
        } catch (IOException e) {
            e.printStackTrace();
        }
        context.setSendZuulResponse(false);
        return null;
    }
}
