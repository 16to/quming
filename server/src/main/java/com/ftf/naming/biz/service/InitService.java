package com.ftf.naming.biz.service;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.ftf.naming.biz.domain.dao.LunyuDAO;
import com.ftf.naming.biz.domain.dao.ShijingDAO;
import com.ftf.naming.biz.domain.dao.SongciDAO;
import com.ftf.naming.biz.domain.dao.TangshiDAO;
import com.ftf.naming.biz.domain.dao.XHWordDAO;
import com.ftf.naming.biz.domain.mapper.LunyuMapper;
import com.ftf.naming.biz.domain.mapper.ShijingMapper;
import com.ftf.naming.biz.domain.mapper.SongciMapper;
import com.ftf.naming.biz.domain.mapper.TangshiMapper;
import com.ftf.naming.biz.domain.mapper.XHWordMapper;
import com.ftf.naming.biz.dto.LunyuDTO;
import com.ftf.naming.biz.dto.ShijingDTO;
import com.ftf.naming.biz.dto.SongciDTO;
import com.ftf.naming.biz.dto.TangshiDTO;
import com.ftf.naming.util.JsonUtil;
import com.ftf.naming.util.RuleUtil;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class InitService {

	@Autowired
	private XHWordMapper xhwordMapper;
	
	@Autowired
	private ShijingMapper shijingMapper;
	
	@Autowired
	private LunyuMapper lunyuMapper;
	
	@Autowired
	private TangshiMapper tangshiMapper;
	
	@Autowired
	private SongciMapper songciMapper;
	
	@PostConstruct
	public void initRule() {
		InputStreamReader is = null;
		try{
			is = new InputStreamReader(this.getClass().getResourceAsStream("/rule.properties"),"utf-8");
			StringBuffer sb = new StringBuffer();
			int ch = 0;
            while ((ch = is.read()) != -1) {
                sb.append((char) ch);
            }
            RuleUtil.init(sb.toString());
        }
		catch(Exception e) {
			log.error("rule init error",e);
		}
		finally {
			if(is != null) {
				try {
					is.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				is = null;
			}
		}
	}
	
	public void initXHWord() {
		InputStreamReader is = null;
		try{
			is = new InputStreamReader(this.getClass().getResourceAsStream("/word.json"),"utf-8");
			StringBuffer sb = new StringBuffer();
			int ch = 0;
            while ((ch = is.read()) != -1) {
                sb.append((char) ch);
            }
            TypeReference<List<XHWordDAO>> t = new TypeReference<List<XHWordDAO>>() {};
            List<XHWordDAO> wordList = JsonUtil.string2Obj(sb.toString(), t);
            
            xhwordMapper.batchInsert(wordList);
        }
		catch(Exception e) {
			log.error("xhword init error",e);
		}
		finally {
			if(is != null) {
				try {
					is.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				is = null;
			}
		}
	}
	
	public void initShijing() {
		InputStreamReader is = null;
		try{
			is = new InputStreamReader(this.getClass().getResourceAsStream("/shijing.json"),"utf-8");
			StringBuffer sb = new StringBuffer();
			int ch = 0;
            while ((ch = is.read()) != -1) {
                sb.append((char) ch);
            }
            TypeReference<List<ShijingDTO>> t = new TypeReference<List<ShijingDTO>>() {};
            List<ShijingDTO> shijingList = JsonUtil.string2Obj(sb.toString(), t);
            
            shijingMapper.batchInsert(toShijingDAOs(shijingList));
        }
		catch(Exception e) {
			log.error("shijing init error",e);
		}
		finally {
			if(is != null) {
				try {
					is.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				is = null;
			}
		}
	}
	
	public void initLunyu() {
		InputStreamReader is = null;
		try{
			is = new InputStreamReader(this.getClass().getResourceAsStream("/lunyu.json"),"utf-8");
			StringBuffer sb = new StringBuffer();
			int ch = 0;
            while ((ch = is.read()) != -1) {
                sb.append((char) ch);
            }
            TypeReference<List<LunyuDTO>> t = new TypeReference<List<LunyuDTO>>() {};
            List<LunyuDTO> lunyuList = JsonUtil.string2Obj(sb.toString(), t);
            
            lunyuMapper.batchInsert(toLunyuDAOs(lunyuList));
        }
		catch(Exception e) {
			log.error("lunyu init error",e);
		}
		finally {
			if(is != null) {
				try {
					is.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				is = null;
			}
		}
	}
	
	public void initTangshi() {
		for(int i=0;i<=57;i++) {
			InputStreamReader is = null;
			try{
				String fileName = "/tang/poet.tang." + i*1000 + ".json";
				is = new InputStreamReader(this.getClass().getResourceAsStream(fileName),"utf-8");
				StringBuffer sb = new StringBuffer();
				int ch = 0;
	            while ((ch = is.read()) != -1) {
	                sb.append((char) ch);
	            }
	            TypeReference<List<TangshiDTO>> t = new TypeReference<List<TangshiDTO>>() {};
	            List<TangshiDTO> tangshiList = JsonUtil.string2Obj(sb.toString(), t);
	            
	            tangshiMapper.batchInsert(toTangshiDAOs(tangshiList));
	        }
			catch(Exception e) {
				log.error("tangshi init error",e);
			}
			finally {
				if(is != null) {
					try {
						is.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					is = null;
				}
			}
		}
	}
	
	public void initSongci() {
		for(int i=0;i<=21;i++) {
			InputStreamReader is = null;
			try{
				String fileName = "/song/ci.song." + i*1000 + ".json";
				is = new InputStreamReader(this.getClass().getResourceAsStream(fileName),"utf-8");
				StringBuffer sb = new StringBuffer();
				int ch = 0;
	            while ((ch = is.read()) != -1) {
	                sb.append((char) ch);
	            }
	            TypeReference<List<SongciDTO>> t = new TypeReference<List<SongciDTO>>() {};
	            List<SongciDTO> songciList = JsonUtil.string2Obj(sb.toString(), t);
	            
	            songciMapper.batchInsert(toSongciDAOs(songciList));
	        }
			catch(Exception e) {
				log.error("tangshi init error",e);
			}
			finally {
				if(is != null) {
					try {
						is.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					is = null;
				}
			}
		}
	}
	
	private List<ShijingDAO> toShijingDAOs(List<ShijingDTO> shijingList){
		List<ShijingDAO> daoList = new  ArrayList<ShijingDAO>();
		shijingList.forEach(s->daoList.add(new ShijingDAO(s)));
		return daoList;
	}
	
	private List<LunyuDAO> toLunyuDAOs(List<LunyuDTO> lunyuList){
		List<LunyuDAO> daoList = new  ArrayList<LunyuDAO>();
		lunyuList.forEach(s->daoList.add(new LunyuDAO(s)));
		return daoList;
	}
	
	private List<TangshiDAO> toTangshiDAOs(List<TangshiDTO> tangshiList){
		List<TangshiDAO> daoList = new  ArrayList<TangshiDAO>();
		tangshiList.forEach(s->daoList.add(new TangshiDAO(s)));
		return daoList;
	}
	
	private List<SongciDAO> toSongciDAOs(List<SongciDTO> songciList){
		List<SongciDAO> daoList = new  ArrayList<SongciDAO>();
		songciList.forEach(s->daoList.add(new SongciDAO(s)));
		return daoList;
	}
}
