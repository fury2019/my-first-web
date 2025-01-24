package kr.or.ddit.basic;

import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.util.MybatisUtil;
import kr.or.ddit.vo.LprodVO;

// MyBatis를 이용하여 DB 자료를 처리하는 순서및 방법
public class LprodMybatisTest {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
/*
		// MyBatis의 환경 설정 파일(mybatis-config.xml)을 읽어와서
		// 그 내용을 처리한 후 SqlSessionFactory객체를 생성한다.
		// InputStream in = null;
		Reader rd = null;
		SqlSessionFactory factory = null;

		try {
			// 1-1. 환경설정 파일을 읽어올 스트림 객체를 생성한다.
			// in =
			// Resources.getResourceAsStream("kr/or/ddit/mybatis/config/mybatis-config.xml");
//			rd = Resources.getResourceAsReader("mybatis-config.xml");
			rd = Resources.getResourceAsReader("kr/or/ddit/mybatis/config/mybatis-config.xml");

			// 1-2. 환경설정 파일을 읽어와 환경 설정을 진행하고 환경 설정이 완료되면
			// SqlSessionFactory객체가 생성된다.
			// factory = new SqlSessionFactoryBuilder().build(in);
			factory = new SqlSessionFactoryBuilder().build(rd);

		} catch (Exception e) {
			System.out.println("MyBatis 초기화 실패");
			e.printStackTrace();
		} finally {
			// 스트림 닫기
			// if(in!=null) try {in.close();} catch(IOException e) {}
			if (rd != null)
				try {
					rd.close();
				} catch (IOException e) {
				}
		}
*/
		// ------------------------------------------------------------
		// 2. mapper에 등록된 SQL문 중에서 실행할 SQL문을 호출해서 원하는 작업을 수행한다.
/*
		// 2-1. insert 연습
		System.out.println("insert 작업 시작");

		System.out.println("Lprod_ID 입력 >> ");
		int lprodId = scan.nextInt();

		System.out.println("Lprod_GU 입력 >> ");
		String lprodGu = scan.next();

		System.out.println("Lprod_NM 입력 >> ");
		String lprodNm = scan.next();

		// 입력한 데이터를 VO객체에 저장한다.
		LprodVO lvo = new LprodVO();
		lvo.setLprod_id(lprodId);
		lvo.setLprod_gu(lprodGu);
		lvo.setLprod_nm(lprodNm);

		/*
		 * SqlSession session = null; try { // SqlSessionFactory객체의 openSession()메서드를
		 * 이용하여 // SqlSession객체를 생성한다. // 이 SqlSession객체를 이용하여 SQL문을 호출해서 실행할 수 있다.
		 * 
		 * // 형식) SqlSessionFactory객체.openSession(논리값) // '논리값'이 true이면 AutoCommit이 활성화된
		 * 상태이고 // '논리값'이 생략되거나 false이면 AutoCommit이 비활성화 된 상태이다. session =
		 * factory.openSession();
		 * 
		 * // SqlSession 객체를 이용하여 처리할 SQL문을 호출하여 실행한다. // 형식)
		 * SqlSession객체.insert("namespace속성값.id속성값",파라미터클래스); // 반환값 : 작업에 성공한 레코드 수 int
		 * insertCnt = session.insert("lprod.insertLprod", lvo);
		 * 
		 * if(insertCnt>0) { // 작업에 성공하고 AutoCommit이 비활성화 된 상태일 때는 // commit을 직접 실행해 주어야
		 * 한다. session.commit(); System.out.println("insert 작업 성공"); } else {
		 * System.out.println("insert 작업 실패"); }
		 * 
		 * } catch (Exception e) { e.printStackTrace(); } finally { // 작업이 모두 끝나면
		 * SqlSession객체를 닫아준다. session.close(); }
		 */
//----------------------------------------------------------------------------
		/*
		// 2-2. update 연습
		System.out.println("update 작업 시작");

		System.out.println("수정할 Lprod_GU 입력 >> ");
		String lprodGu2 = scan.next();

		System.out.println("새로운 Lprod_ID 입력 >>");
		int newlprodId = scan.nextInt();

		System.out.println("새로운 Lprod_NM 입력 >>");
		String newlprodNm = scan.next();

		// 입력한 데이터를 VO에 저장
		LprodVO lvo2 = new LprodVO();
		lvo2.setLprod_id(newlprodId);
		lvo2.setLprod_gu(lprodGu2);
		lvo2.setLprod_nm(newlprodNm);

		SqlSession session = null;
		try {
			session = factory.openSession();
			
			// SqlSession 객체를 이용하여 처리할 SQL문을 호출하여 실행한다.
			// 형식) SqlSession객체.insert("namespace속성값.id속성값",파라미터클래스);
			// 반환값 : 작업에 성공한 레코드 수
			int updateCnt = session.update("lprod.updateLprod", lvo2);
			
			if(updateCnt>0) {
				session.commit();
				System.out.println("update 작업 성공 ");
			}else {
				System.out.println("update 작업 실패 ");
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			session.close();
		}*/
//--------------------------------------------------------------------------------
		// 2-3. delete 작업
		/*
		System.out.println("delete 작업 시작");
		
		System.out.println("삭제할 Lprod_gu 입력 >>");
		String lprodGu3 = scan.next();
		
		SqlSession session = null;
		
		try {
			session = factory.openSession();
			
			// SqlSession 객체를 이용하여 처리할 SQL문을 호출하여 실행한다.
			// 형식) SqlSession객체.insert("namespace속성값.id속성값",파라미터클래스);
			// 반환값 : 작업에 성공한 레코드 수
			int deleteCnt = session.delete("lprod.deleteLprod", lprodGu3);
			
			if(deleteCnt>0) {
				session.commit();
				System.out.println("삭제 작업 성공");
			}else {
				System.out.println("삭제 작업 실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		*/
//--------------------------------------------------------------------------
		// 2-4. select 연습
		/*
		// 1) 응답 결과가 여러개의 레코드인 경우
		System.out.println("select 작업 시작 - 결과가 여러개의 레코드일 경우...");
		
		SqlSession session = null;
		try {
			session = factory.openSession();
			
			// SqlSession객체를 이용하여 처리할 SQL문을 호출하여 실행한다.
			// 처리 결과가 여러개의 레코드일 경우에는 selectList()메서드를 사용하는데
			// 이 메서드는 검색된 레코드 각각을 'resultType속성'에 지정한 곳에 
			// 저장한 후 이 자료를 List에 추가해 주는 작업을 자동으로 수행한다.
			
			// 형식) SqlSession객체.selectList("namespace속성값.id속성값", 파라미터클래스);
			List<LprodVO> lprodList = session.selectList("lprod.getAllLprod");
			
			for(LprodVO lvo3 : lprodList ) {
				System.out.println("ID : " + lvo3.getLprod_id());
				System.out.println("ID : " + lvo3.getLprod_gu());
				System.out.println("ID : " + lvo3.getLprod_nm());
				System.out.println("-------------------------------");
			}
			System.out.println();
			System.out.println("출력 끝");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		*/
//--------------------------------------------------------------------------
		
		// 2) 응답 결과가 한 개의 레코드인 경우
		System.out.println("select 작업 시작 - 결과가 한 개일 경우");
		
		System.out.println("검색할 Lprod_gu 입력 >> ");
		String lprodGu4 = scan.next();
		
		SqlSession session = null;
		
		try {
//			session = factory.openSession();
			session = MybatisUtil.getSqlSession();
			
			// SqlSession 객체를 이용하여 처리할 SQL문을 호출하여 실행한다.
			// 처리결과가 한 개의 레코드일 경우에는 'selectOne()'메서드를 사용한다.
			// 'selectOne()' 메서드는 검색된 결과가 없으면 null을 반환한다.
			
			// 형식) Sqlsession객체.selectOne("namespace속성값.id속성값", 파라미터클래스);
			LprodVO lvo4 = session.selectOne("lprod.getLprod",lprodGu4);
			
			if(lvo4==null) {
				System.out.println("검색된 데이터가 하나도 없습니다.");
				return;
			}
			System.out.println("ID : " + lvo4.getLprod_id());
			System.out.println("GU : " + lvo4.getLprod_gu());
			System.out.println("NM : " + lvo4.getLprod_nm());
			System.out.println("-------------------------------");
			
			System.out.println();
			System.out.println("출력 끝");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		

	}
	

}
