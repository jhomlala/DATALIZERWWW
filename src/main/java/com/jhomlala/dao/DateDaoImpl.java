package com.jhomlala.dao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jhomlala.model.DateWords;
import com.jhomlala.model.Word;

@Repository
public class DateDaoImpl implements DateDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public java.util.Date getLastDate() {
		List <DateWords> dateList = new ArrayList<DateWords>();
		dateList = sessionFactory.getCurrentSession().createCriteria(DateWords.class).list();
		return dateList.get(dateList.size() - 1).getDate();
	}
}
