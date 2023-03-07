package com.kobb.model;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionManager;

public class UserDAO {
		private SqlSessionFactory sqlSessionFactory = com.db.SqlSessionManager.getSqlSession();
		
		public int join(UserDTO dto) {
			
			int row = 0;
			SqlSession session = sqlSessionFactory.openSession(true);
			try {
				row = session.insert("com.kobb.model.UserDAO.join", dto);
				
			}catch (Exception e) {
				e.printStackTrace();
			} finally {
				session.close();
			}
			return row;
			
			
		}


	

}
