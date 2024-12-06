package kr.or.ddit.login.dao;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.util.MybatisUtil;
import kr.or.ddit.vo.MemberVO;

public class MemberDaoImple implements IMemberDao {
   private static MemberDaoImple dao;
   
   private MemberDaoImple() { }
   
   public static MemberDaoImple getInstance() {
      if(dao==null) dao = new MemberDaoImple();
      
      return dao;
   }

   @Override
   public MemberVO getLoginMember(MemberVO memVo) {
      MemberVO loginMemVo = null;   // 반환값이 저장될 변수
      SqlSession session = null;
      
      try {
         session = MybatisUtil.getSqlSession();
         
         loginMemVo = session.selectOne("member.getLoginMember",memVo);
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         session.close();
      }
      
      return loginMemVo;
   }

}
