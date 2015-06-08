package com.jhomlala.test.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.mvc.annotation.AnnotationMethodHandlerAdapter;

import com.jhomlala.config.AppConfig;
import com.jhomlala.config.ResourcesConfig;
import com.jhomlala.config.SecurityConfig;
import com.jhomlala.config.core.SpringMvcInitializer;
import com.jhomlala.dao.DateDao;
import com.jhomlala.dao.WordsDao;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfig.class, SecurityConfig.class,
		ResourcesConfig.class, SpringMvcInitializer.class })
// @ContextConfiguration(locations = {"classpath:testContext.xml",
// "classpath:exampleApplicationContext-web.xml"})
@WebAppConfiguration
@Transactional
public class DashboardControllerTest {

	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext webApplicationContext;

	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
				.build();
	}

	@Autowired
	WordsDao wordDao;

	@Autowired
	DateDao dateDao;
	
	@Test
	public void testPages200Status() throws Exception {
		mockMvc.perform(get("/dashboard")).andExpect(status().isOk());
		mockMvc.perform(get("/dashboard/authors")).andExpect(status().isOk());
		mockMvc.perform(get("/dashboard/stats/")).andExpect(status().isOk());
		mockMvc.perform(get("/login")).andExpect(status().isOk());

	}

	@Test
	public void testMainPage() throws Exception {
		mockMvc.perform(get("/")).andExpect(status().is(302)) // 302 -> moved
																// (redirect)
				.andExpect(view().name("redirect:/dashboard"));

		mockMvc.perform(get("/dashboard")).andExpect(status().isOk())
				.andExpect(view().name("dashboard"))
				.andExpect(forwardedUrl("/WEB-INF/pages/dashboard.jsp"));
	}

	@Test
	public void testAuthorsPage() throws Exception {
		mockMvc.perform(get("/dashboard/authors")).andExpect(status().isOk())
				.andExpect(view().name("dashboardauthors"))
				.andExpect(forwardedUrl("/WEB-INF/pages/dashboardauthors.jsp"));
	}

	@Test
	public void testStatsPage() throws Exception {

		mockMvc.perform(get("/dashboard/stats")).andExpect(status().isOk())
				.andExpect(view().name("dashboardstats"))
				.andExpect(forwardedUrl("/WEB-INF/pages/dashboardstats.jsp"))
				.andExpect(model().attribute("wordList",wordDao.getAll()))
				.andExpect(model().attribute("lastDate",dateDao.getLastDate()));

	}

	@Test
	public void testLoginPage() throws Exception
	{
		mockMvc.perform(get("/login")).andExpect(status().isOk())
		.andExpect(view().name("dashboardlogin"))
		.andExpect(forwardedUrl("/WEB-INF/pages/dashboardlogin.jsp"));
		

	}

}
