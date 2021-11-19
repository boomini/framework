package com.ssafy.hw2.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.hw2.dao.GoodsDAO;
import com.ssafy.hw2.model.CateVO;
import com.ssafy.hw2.model.FileInfo;
import com.ssafy.hw2.model.ItemVO;

@Service
public class GoodsServiceImpl implements GoodsService{
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<ItemVO> list() throws Exception {
		return sqlSession.getMapper(GoodsDAO.class).list();
	}

	@Override
	public List<CateVO> listCate(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.getMapper(GoodsDAO.class).listCate(map);
	}

	@Override
	@Transactional
	public void insert(ItemVO item) throws Exception {
		GoodsDAO goodsDao = sqlSession.getMapper(GoodsDAO.class);
		goodsDao.insert(item);
		List<FileInfo> fileInfos = item.getFileInfos();
		if(fileInfos!=null && !fileInfos.isEmpty()) {
			goodsDao.insertFile(item);
		}
	}

	@Override
	public boolean modify(Map<String, Object> map) throws Exception {
		int status = sqlSession.getMapper(GoodsDAO.class).modify(map);	
		return true;
	}


	@Override
	public ItemVO getItem(int seq) throws Exception {
		return sqlSession.getMapper(GoodsDAO.class).getItem(seq);
	}


	@Override
	public int login(Map<String, String> map) throws Exception {
		return sqlSession.getMapper(GoodsDAO.class).login(map);
	}

	@Override
	public void delete(List<String> del) throws Exception {
		sqlSession.getMapper(GoodsDAO.class).delete(del);
		
	}

	@Override
	public void modify(ItemVO item) throws Exception {
		sqlSession.getMapper(GoodsDAO.class).modify(item);
		
	}

}
