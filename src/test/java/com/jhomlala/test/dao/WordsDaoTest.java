package com.jhomlala.test.dao;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.jhomlala.config.AppConfig;
import com.jhomlala.config.ResourcesConfig;
import com.jhomlala.config.SecurityConfig;
import com.jhomlala.config.core.SpringMvcInitializer;
import com.jhomlala.dao.WordsDao;
import com.jhomlala.model.Word;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class,SecurityConfig.class,ResourcesConfig.class, SpringMvcInitializer.class })
@WebAppConfiguration
@Transactional
public class WordsDaoTest {

	@Autowired
	WordsDao wordsDao;
	
	@Test
	public void getAllTest()
	{
		//check if return object is not null
		assertNotNull(wordsDao.getAll());
		
		//check if return object is istance of list
		assertEquals(wordsDao.getAll().getClass(),ArrayList.class);
		
		//check values
		List<Word> wordList = wordsDao.getAll();
		Word word = wordList.get(0);
		
		assertEquals(word.getId(),1);
		assertEquals(word.getWord(),"ala");
		assertEquals(word.getAmount(),45);
		
		
	}
}
