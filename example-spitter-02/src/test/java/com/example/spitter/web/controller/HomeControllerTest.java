package com.example.spitter.web.controller;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 * Created by Richard on 2017/3/20.
 */
public class HomeControllerTest {

    @Test
    public void testHomePageWithMockMvc() throws Exception {
        HomeController controller = new HomeController();
        //构建MockMvc
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
        //执行GET请求, 并预期得到home视图
        mockMvc.perform(MockMvcRequestBuilders.get("/")).andExpect(MockMvcResultMatchers.view().name("home"));
    }

}
