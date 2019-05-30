package com.zy.springboot.conf;

import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


@Configuration
public class WebConf extends WebMvcConfigurationSupport {


    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {

        List<MediaType> supportMediaTypes = new ArrayList<>();
        supportMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
        supportMediaTypes.add(MediaType.TEXT_HTML);

        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
        FastJsonConfig fastJsonConfig = new FastJsonConfig();

        //fastJsonConfig.setSerializeFilters(fastJsonValueFilter);
        fastConverter.setFastJsonConfig(fastJsonConfig);
        fastConverter.setSupportedMediaTypes(supportMediaTypes);

        //去除返回json时的双引号
        StringHttpMessageConverter stringHttpMessageConverter = new StringHttpMessageConverter();

        converters.add(stringHttpMessageConverter);
        converters.add(fastConverter);
    }
}
