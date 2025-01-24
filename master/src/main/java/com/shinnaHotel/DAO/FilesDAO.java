package com.shinnaHotel.DAO;

import java.util.Enumeration;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.oreilly.servlet.MultipartRequest;
import com.shinnaHotel.DTO.FilesDTO;
import com.shinnaHotel.mybatis.SqlMapConfig;

public class FilesDAO {

	SqlSessionFactory factory = SqlMapConfig.getFactory();
	SqlSession sqlSession;

	public FilesDAO() {
		sqlSession = factory.openSession(true);
	}
	
	// 게시글의 첨부파일 추가
	public void insertFile(MultipartRequest multi, int r_id) {
		Enumeration<String> files =  multi.getFileNames();
		FilesDTO fdto = new FilesDTO();
		
		while(files.hasMoreElements()) {
			// 사용자가 업로드한 파일 태그의 name
			String name = files.nextElement();
			// 사용자가 업로드한 원본 파일 이름
			String original = multi.getOriginalFileName(name);
			// 파일이름 중복 시 변경된 이름
			String systemName = multi.getFilesystemName(name);
			// 파일이 첨부되지 않으면 null이므로, DTO에 담기지 않도록 continue
			if(systemName == null) {continue;}
			
			fdto.setFileName(systemName);
			fdto.setR_id(r_id);
			fdto.setFileNameOriginal(original);
			
			// 파일의 개수만큼 while문으로 insert됨
			sqlSession.insert("Files.insertFile", fdto );
		}
	}
}
