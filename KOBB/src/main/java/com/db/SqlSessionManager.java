package com.db;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionManager {

	// SqlSessionFactory 필드로 올림 (전역변수)
		public static SqlSessionFactory sqlSessionFactory;

		static {
			// 1. 읽을 설정 파일에 대한 경로 문자열로 지정
			String resource = "com/smhrd/db/mybatis-config.xml";
			// 2. 설정파일을 읽어 데이터베이스 연결
			InputStream inputStream;
			try {
				inputStream = Resources.getResourceAsStream(resource);
				sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		// SqlSessionFactory를 사용하여 DB연결, 실행, 종료 관리하는 sqlsession 생성
		public static SqlSessionFactory getSqlSession() {
			return sqlSessionFactory;
		}
		
		
		
}
