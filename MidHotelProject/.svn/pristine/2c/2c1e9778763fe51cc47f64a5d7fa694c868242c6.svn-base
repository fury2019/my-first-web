package com.Hotel.dao.HotelNearbySpots;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.Hotel.common.util.MybatisUtil;
import com.Hotel.vo.HotelVO;
import com.Hotel.vo.Hotel_PlaceVO;
import com.Hotel.vo.Place_LikeVO;

import jakarta.websocket.Session;

public class HotelNearbySpotsDAO implements IHotelNearbySpotsDAO {

	private static HotelNearbySpotsDAO dao;

	// 싱글턴 패턴을 위한 생성자
	private HotelNearbySpotsDAO() {

	}

	// 싱글턴 인스턴스 반환
	public static HotelNearbySpotsDAO getInstance() {
		if (dao == null) {
			dao = new HotelNearbySpotsDAO();
		}
		return dao;
	}

	// 주변 장소 가져오기
	@Override
	public List<Hotel_PlaceVO> HotelPlaceDisplayAll() {
		List<Hotel_PlaceVO> spots = null;
		SqlSession session = null; // SqlSession 선언

		try {
			session = MybatisUtil.getSqlSession(); // SqlSession 생성
			spots = session.selectList("place.HotelPlaceDisplayAll");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close(); // SqlSession 닫기
			}
		}
		return spots;
	}

	@Override
	public List<Hotel_PlaceVO> getPlacesByHotelId(String hotelId) {
		List<Hotel_PlaceVO> place = null;
		SqlSession session = null;

		try {
			session = MybatisUtil.getSqlSession();
			place = session.selectList("place.getPlacesByHotelId", hotelId);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close(); // SqlSession 닫기
			}
		}

		return place;

	}

	public List<HotelVO> getAllHotels() {
		List<HotelVO> place = null;
		SqlSession session = null;

		try {
			session = MybatisUtil.getSqlSession();
			place = session.selectList("hotel.getAllHotels");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close(); // SqlSession 닫기
			}
		}

		return place;

	}

	// 기존에 LIKE_COUNT를 증가시키는 메서드
	public boolean updateLikeCount(String placeId, String memId) {
		SqlSession session = null;

		try {
			// placeId와 memId를 map으로 묶어 MyBatis 매퍼 호출
			Map<String, String> paramMap = new HashMap<>();
			paramMap.put("placeId", placeId);
			paramMap.put("memId", memId);

			session = MybatisUtil.getSqlSession();
			// 먼저 좋아요 수를 증가시키는 쿼리 실행
			int updatedRows = session.update("place.updateLikeCount", paramMap);

			if (updatedRows == 0) {
				// 좋아요 레코드가 없다면 새로 추가
				int insertRows = session.insert("place.insertLike", paramMap);
				if (insertRows > 0) {
					session.commit();
					return true;
				}
			} else {
				// 성공적으로 처리되었으므로 true 반환
				session.commit();
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		// 실패한 경우 false 반환
		return false;

	}

	// 새로운 레코드를 삽입하는 작업을 합니다.
	public boolean insertLike(String placeId, String memId) {
		SqlSession session = null;

		try {
			// placeId와 memId를 map으로 묶어 Mybatis 매퍼 호출
			Map<String, String> paramMap = new HashMap<>();
			paramMap.put(placeId, placeId);
			paramMap.put(memId, memId);

			// MyBatis 세션을 얻어오기
			session = MybatisUtil.getSqlSession();

			// 새 좋아요 레코드를 추가
			int insertedRows = session.insert("place.insertLike");

			// 삽입된 행 수가 1이면 성공적으로 추가된 것
			if (insertedRows == 1) {
				session.commit();
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return false;
	}

	// 이 메소드는 특정 장소에 대한 좋아요 수를 조회하는 작업을 합니다.
	public int selectLikeCount(String placeId) {
		SqlSession session = null;
		try {
			// placeId를 map으로 묶어 MyBatis 매퍼 호출
			Map<String, String> paramMap = new HashMap<>();
			paramMap.put("placeId", placeId);

			// MyBatis 세션을 얻어오기
			session = MybatisUtil.getSqlSession();

			// 좋아요 수 조회
			Integer likeCount = session.selectOne("place.selectLikeCount", paramMap);

			// 조회된 결과가 null인 경우 0을 반환 (좋아요가 없다면 0)
			return likeCount != null ? likeCount : 0;
		} catch (Exception e) {
			// 예외 처리
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		// 예외 발생 시 기본적으로 0 반환
		return 0;
	}
	
	public List<Hotel_PlaceVO> updatePlacesLikeCount(String hotelId) {
        SqlSession session = null;
        List<Hotel_PlaceVO> result = null;
        
        try {
            session = MybatisUtil.getSqlSession();
            result = session.selectList("place.updatePlacesLikeCount", hotelId); // 마이바티스 쿼리 호출
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        
        return result;
    }

	@Override
	public List<Place_LikeVO> selectPlacesLikeList(String placeId) {
		SqlSession session = null;
		List<Place_LikeVO> result = null;
		
		try {
            session = MybatisUtil.getSqlSession();
            result = session.selectList("place.selectPlacesLikeList", placeId); // 마이바티스 쿼리 호출
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
		
		return result;
	}
	
    @Override
    public int deleteLike(Place_LikeVO vo) {
    	SqlSession session = null;
    	int result = 0;
    	
        try {
        	session = MybatisUtil.getSqlSession();
			result = session.delete("place.deleteLike", vo);
			if (result > 0) {
                session.commit();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
			if (session != null) {
				session.close();
			}
		}
        return result;
    }
}
