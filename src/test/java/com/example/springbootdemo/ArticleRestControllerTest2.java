package com.example.springbootdemo;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.annotation.Resource;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@Slf4j

@RunWith(SpringRunner.class)
//类似：mockMvc = MockMvcBuilders.standaloneSetup(new ArticleRestController()).build();
@AutoConfigureMockMvc
@SpringBootTest
public class ArticleRestControllerTest2 {

    @Resource
    private MockMvc mockMvc;

//
//    @Before
//    public void setUp(){mockMvc = MockMvcBuilders.standaloneSetup(new ArticleRestController()).build();}
//
    @Test
    public void saveArticle() throws Exception{
    String article =
        "{\n"
            + "   \"id\": 1,\n"
            + "   \"author\": \"dejing\",\n"
            + "   \"title\": \"程配套文档\",\n"
            + "   \"content\": \"Spring boot Start Learn.\",\n"
            + "   \"createTime\": \"2019-08-19 13:38:46\",\n"
            + "   \"reader\":[{\"name\":\"name1\",\"age\":18},{\"name\":\"name2\",\"age\":35}]\n"
            + "}";
    MvcResult result =
        mockMvc
            .perform(
                MockMvcRequestBuilders.request(HttpMethod.POST, "/rest/article")
                    .contentType("application/json")
                    .content(article))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.data.author").value("dejing"))
            .andExpect(MockMvcResultMatchers.jsonPath("$.data.id").value(1))
            .andExpect(MockMvcResultMatchers.jsonPath("$.data.reader[1].age").value(35))
            .andDo(print())
            .andReturn();
    log.info(result.getResponse().getContentAsString());
    }
}