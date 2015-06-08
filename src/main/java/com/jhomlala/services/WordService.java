package com.jhomlala.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jhomlala.dao.WordsDaoImpl;
import com.jhomlala.model.*;
@Service("wordService")
public class WordService {

	
    @Autowired
    WordsDaoImpl wordsDao;
    
	@Transactional(readOnly=true)	
    public List<Word> getAll()
    {
    	return wordsDao.getAll();
    }
}
