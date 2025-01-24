package kr.or.ddit.member.dao;


import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.util.MybatisUtil;
import kr.or.ddit.vo.MemberVO;



public class MemberDao implements IMemberDao {
   private static MemberDao dao;

   private MemberDao() {

   }

   public static MemberDao getInstance() {
      if (dao == null)
         dao = new MemberDao();
      return dao;
   }

   @Override
   public int insertMember(MemberVO memVo) {
      int cnt = 0;
      
      SqlSession session = null;
      try {
         session = MybatisUtil.getSqlSession();
         
         cnt = session.insert("member.insertMember", memVo);
         
         if(cnt > 0) session.commit();
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         session.close();
      }
      return cnt;
   }

   @Override
   public int deleteMember(String memId) {
      int cnt = 0;
      SqlSession session = null;
      try {
         session = MybatisUtil.getSqlSession();
         cnt = session.delete("member.deleteMember", memId);
         
         if(cnt>0) session.commit();
         
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         session.close();
      }

      return cnt;
   }

   @Override
   public int updateMember(MemberVO memVo) {
      int cnt = 0;
      
      SqlSession session = null;
      
      try {
         session = MybatisUtil.getSqlSession();
         
         cnt = session.update("member.updateMember", memVo);
         
         if(cnt>0) session.commit();
      
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         session.close();
      }
      return cnt;
   }

   @Override
   public List<MemberVO> getAllMember() {
      List<MemberVO> memlist = null;
      SqlSession session = null;
      try {
         
         session = MybatisUtil.getSqlSession();
         
         memlist = session.selectList("member.getAllMember");      
   
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         session.close();
      }
      
      return memlist;
   }

   @Override
   public int getMemberCount(String memId) {
      int count = 0;
      
      SqlSession session = null;
      
      try {
         session = MybatisUtil.getSqlSession();
         
         count = session.selectOne("member.getMemberCount", memId);
         
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         session.close();
      }
      
      return count;
   }

   
   
   @Override
   public int updateMember2(Map<String, String> paramMap) {
      int cnt = 0;
      
      SqlSession session = null;
      
      try {
         session = MybatisUtil.getSqlSession();
         
         cnt = session.update("member.updateMember2", paramMap);
         
         if(cnt>0) session.commit();
         
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         session.close();
      }
      return cnt;
   }



}
