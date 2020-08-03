package com.panda.mybatis.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

@Slf4j
@Component
public class DruidSessionFactory {

	@Autowired(required = false)
	@Qualifier("druidSqlSessionFactory")
	@Lazy
	private SqlSessionFactory druidSqlSessionFactory;

	public SqlSession getSession() {
		SqlSession sqlSession = druidSqlSessionFactory.openSession(true);
		try {
			sqlSession.getConnection().setAutoCommit(true);
		} catch (SQLException e) {
			log.error(e.getMessage(), e);
		}
		log.info("SqlSession Create AutoCommit=[TRUE]===>{}||{}", sqlSession, sqlSession.getConnection());

		return sqlSession;
	}

	/**
	 * 手动事务 write session
	 */
	public SqlSession getManualSession() {
		SqlSession sqlSession = druidSqlSessionFactory.openSession(false);
		try {
			sqlSession.getConnection().setAutoCommit(false);
		} catch (SQLException e) {
			log.error(e.getMessage(), e);
		}
		log.info("SqlSession Create AutoCommit=[FALSE] [Write]===>{}||{}", sqlSession, sqlSession.getConnection());
		return sqlSession;
	}

	/**
	 * 失败回滚事务
	 * 
	 * @return
	 * @throws Exception
	 */
	public void rollbackTransaction(SqlSession sqlSession) {
		try {
			log.info("SqlSession rollback===>{}||{}", sqlSession, sqlSession.getConnection());
			sqlSession.getConnection().rollback();
			sqlSession.rollback();
		} catch (SQLException e) {
			log.error(e.getMessage(), e);
			log.info("SqlSession rollback exception===>{}||{}", sqlSession, sqlSession.getConnection());
		}
	}

	public void commit(SqlSession sqlSession) {
		if (sqlSession != null) {
			try {
				sqlSession.getConnection().commit();
				sqlSession.commit();
				log.info("SqlSession commited===>{}||{}", sqlSession, sqlSession.getConnection());
			} catch (SQLException e) {
				log.error(e.getMessage(), e);
				log.info("SqlSession commited exception-->{}||{}", sqlSession, sqlSession.getConnection());
			}
		}
	}

	public void releaseConnection(SqlSession sqlSession) {
		if (sqlSession != null) {
			log.info("SqlSession close ===>{}||{}", sqlSession, sqlSession.getConnection());
			sqlSession.close();
		}
	}

}
