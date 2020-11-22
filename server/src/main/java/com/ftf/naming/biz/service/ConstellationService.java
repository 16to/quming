package com.ftf.naming.biz.service;

import java.util.Calendar;

import org.springframework.stereotype.Service;

import com.ftf.naming.biz.enums.ConstellationEnum;
import com.ftf.naming.util.DateUtil;


/**
 * 星座管理
 * @author qumuasa
 *
 */
@Service
public class ConstellationService {

	private final static int MAX_INDEX = 11;
	
    private final static int[] dayArr = new int[] { 20, 19, 21, 20, 21, 22, 23,23, 23, 24, 23, 22 };
    
    /**
     * 通过生日计算星座
     * 
     * @param month
     * @param day
     * @return
     */
    private ConstellationEnum getConstellation(int month, int day) {
    	int index = -1;
    	if(day < dayArr[month - 1]) {
    		index = month - 1;
    	}
    	else {
    		index = month;
    	}
    	if(index > MAX_INDEX) {
    		index--;
    	}
        return  ConstellationEnum.getByIndex(index);
    }
    
    public ConstellationEnum getByBirth(String birth) {
    	Calendar cal = DateUtil.getCalender(birth);
		return getConstellation(cal.get(Calendar.MONTH) + 1, cal.get(Calendar.DAY_OF_MONTH));
    }
}
