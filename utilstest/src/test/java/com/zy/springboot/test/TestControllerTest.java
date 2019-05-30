package com.zy.springboot.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.Resource;


@RunWith(SpringRunner.class)
@SpringBootTest
public class TestControllerTest {

    //注入spring容器
    @Resource
    private WebApplicationContext context;

    private MockMvc mvc;

    @Before
    public void setUp() throws Exception {
        //初始化 MockMvc 对象
        mvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getAllEmps() throws Exception {

        //构建请求对象
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/getAllEmps");
        builder.accept(MediaType.APPLICATION_JSON_UTF8);

        //构建结果匹配器
        ResultMatcher resultMatcher = MockMvcResultMatchers.status().isOk();

        ResultActions resultActions = mvc.perform(builder);
        resultActions.andExpect(resultMatcher);

        //打印结果
        resultActions.andDo(MockMvcResultHandlers.print());

    }

    @Test
    public void test1() throws Exception {

        //请求构建对象
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post("/test1");
        builder.param("name","zy");
        builder.contentType(MediaType.TEXT_PLAIN);

        ResultActions resultActions = mvc.perform(builder);

        //构建结果匹配器
        ResultMatcher resultMatcher = MockMvcResultMatchers.status().isOk();
        resultActions.andExpect(resultMatcher);

        //打印结果
        resultActions.andDo(MockMvcResultHandlers.print());

        MvcResult mvcResult = resultActions.andReturn();
        String contentAsString = mvcResult.getResponse().getContentAsString();

        Assert.assertEquals("zy",contentAsString);

    }
}