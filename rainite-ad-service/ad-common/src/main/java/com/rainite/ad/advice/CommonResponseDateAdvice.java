package com.rainite.ad.advice;

import com.rainite.ad.annotation.IgnoreResponseAdvice;
import com.rainite.ad.vo.CommonResponse;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@RestControllerAdvice
public class CommonResponseDateAdvice implements ResponseBodyAdvice<Object> {

    // 判断响应是否去拦截
    @Override
    public boolean supports(MethodParameter methodParameter,
                            Class<? extends HttpMessageConverter<?>> aClass) {
        // 如果类上进行了注解，就不拦截
        if (methodParameter.getDeclaringClass().isAnnotationPresent(
                IgnoreResponseAdvice.class))
            return false;
        // 如果方法上进行了注解，就不拦截
        if (methodParameter.getMethod().isAnnotationPresent(
                IgnoreResponseAdvice.class
        ))
            return false;
        return true;
    }

    @Nullable
    @Override
    @SuppressWarnings("all")
    public Object beforeBodyWrite(@Nullable Object o,
                                  MethodParameter methodParameter,
                                  MediaType mediaType,
                                  Class<? extends HttpMessageConverter<?>> aClass,
                                  ServerHttpRequest serverHttpRequest,
                                  ServerHttpResponse serverHttpResponse) {

        CommonResponse<Object> response = new CommonResponse<>(0,"");

        //如果返回对象o 是空，那么直接返回这个response
        if (null == o){
            return response;
            // 如果o本来就是个CommonResponse，那直接返回
        } else if ( o instanceof CommonResponse){
            response = (CommonResponse<Object>) o;
            //否则就把o的数据写进这个response
        } else {
            response.setData(o);
        }

        return response;
    }
}
