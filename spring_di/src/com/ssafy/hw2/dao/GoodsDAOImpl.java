package com.ssafy.hw2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import com.ssafy.hw2.model.CateVO;
import com.ssafy.hw2.model.ItemVO;
import com.ssafy.util.DBUtil;

public class GoodsDAOImpl implements GoodsDAO{
	DataSource dataSource;
	private GoodsDAOImpl(DataSource datasource) {
		this.dataSource = datasource;
	}	

	@Override
	public List<ItemVO> list() throws Exception {
		List<ItemVO> list = new ArrayList<ItemVO>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = dataSource.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select seq, item_code, item_name, item_price, item_corp, item_stat, dt_reg, cate_seq \n");
			sql.append("from hw2_goods_info \n");
			
			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ItemVO item = new ItemVO();
				item.setSeq(rs.getInt("seq"));
				item.setItem_code(rs.getString("item_code"));
				item.setItem_name(rs.getString("item_name"));
				item.setItem_price(rs.getInt("item_price"));
				item.setItem_corp(rs.getString("item_corp"));
				item.setItem_stat(rs.getString("item_stat").charAt(0));
				item.setDate(rs.getString("dt_reg"));
				item.setItem_corp(rs.getString("cate_seq"));
				list.add(item);
			}
		} finally {
			DBUtil.close(rs, pstmt, conn);
		}
		
		return list;
	}

	@Override
	public List<CateVO> listCate(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int modify(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
