package kr.or.ddit.basic;

import java.io.Reader;
import java.util.Scanner;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.or.ddit.vo.LprodVO;

public class JdbcToMybatisTest {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Reader rd = null;
        SqlSessionFactory factory = null;

        try {
            // MyBatis 환경 설정 읽기
            rd = Resources.getResourceAsReader("kr/or/ddit/mybatis/config/mybatis-config.xml");
            factory = new SqlSessionFactoryBuilder().build(rd);
        } catch (Exception e) {
            System.out.println("MyBatis 초기화 실패");
            e.printStackTrace();
            return;
        } finally {
            if (rd != null) try { rd.close(); } catch (Exception e) { }
        }

        // MyBatis SQL 처리 시작
        try (SqlSession session = factory.openSession(true)) {
            String lprodGu;
            while (true) {
                System.out.print("Lprod_GU 입력 >> ");
                lprodGu = scan.next();

                // 중복 체크
                int count = session.selectOne("Lprod.checkLprodGu", lprodGu);
                if (count == 0) {
                    break; // 중복되지 않으면 반복문 종료
                } else {
                    System.out.println("이미 존재하는 Lprod_GU입니다. 다시 입력해주세요.");
                }
            }

            System.out.print("Lprod_NM 입력 >> ");
            String lprodNm = scan.next();

            // lprod_id 계산
            int lprodId = session.selectOne("Lprod.getNextLprodId");

            // VO 객체에 데이터 저장
            LprodVO lvo = new LprodVO();
            lvo.setLprod_id(lprodId);
            lvo.setLprod_gu(lprodGu);
            lvo.setLprod_nm(lprodNm);

            // 데이터 삽입
            int result = session.insert("Lprod.insertLprod", lvo);
            if (result > 0) {
                System.out.println("Lprod 데이터 추가 성공!");
            } else {
                System.out.println("Lprod 데이터 추가 실패!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
