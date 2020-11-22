package com.ftf.naming.biz.service;

import java.util.Calendar;

import org.springframework.stereotype.Service;

import com.ftf.naming.biz.enums.ZodiacEnum;
import com.ftf.naming.util.DateUtil;

/**
 * 生肖管理
 * @author qumuasa
 *
 */
@Service
public class ZodiacService {
	
	private static final int START = 1900;
	private static final int LENGTH = 12;
	
	/**
     * 通过生日计算属相
     * 
     * @param year
     * @return
     */
    private ZodiacEnum getByYear(int year) {
        if (year < START) {
            return null;
        }
        return ZodiacEnum.getByIndex((year - START) % LENGTH);
    }
    
    public ZodiacEnum getByBirth(String birth) {
		return getByYear(DateUtil.getCalender(birth).get(Calendar.YEAR));
    }
}
