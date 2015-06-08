package com.jhomlala.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jhomlala.dao.DateDaoImpl;
import com.jhomlala.dao.WordsDaoImpl;
import com.jhomlala.model.Word;

@Service("dateService")
public class DateService {

	 @Autowired
	 DateDaoImpl dateDao;
	    
		@Transactional(readOnly=true)	
	    public java.util.Date getLastDate()
	    {
	    	return dateDao.getLastDate();
	    }
}
