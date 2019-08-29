package cn.beida.ssm.dao.service;

import org.apache.ibatis.session.SqlSession;
import cn.beida.ssm.util.CreateSession;
import cn.beida.ssm.dao.MapperDad;

@SuppressWarnings("hiding")
public class Service <MapperDad> {
    //sqlsession 是线程不安全的 ，每个线程有它自己的sqlsession，不应被共享
	protected SqlSession session ;
	protected MapperDad MapperDad ;
	public Service(java.lang.Class<MapperDad> arg0){
		this.session = CreateSession.getSqlSession();
		this.MapperDad = this.session.getMapper(arg0);
	}
	public void  closesSession(SqlSession session) {
	    session.close();
	}
}
