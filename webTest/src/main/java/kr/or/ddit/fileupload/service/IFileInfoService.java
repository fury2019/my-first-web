package kr.or.ddit.fileupload.service;

import java.util.List;

import kr.or.ddit.vo.FileInfoVO;

public interface IFileInfoService {
	/**
	 * 업로드한 파일 정보가 저장된 FileInfoVO객체를 매개변수로 받아서
	 * DB에 insert하는 메서드
	 * 
	 * @param fileVo 업로드한 파일 정보가 저장된 FileInfoVO객체
	 * @return 작업성공 : 1, 작업실패 : 0
	 */
	public int insertFileinfo(FileInfoVO fileVo);
	
	/**
	 * DB에 저장된 전체 파일 목록을 가져와 List에 담아서 반환하는 메서드
	 * 
	 * @return 파일 목록이 저장된 List객체
	 */
	public List<FileInfoVO> getAllFileinfo();
	
	/**
	 * 파일 번호를 매개변수로 받아서 해당 파일 정보를 검색하여 반환하는 메서드
	 * 
	 * @param fileNo 검색할 file 번호
	 * @return 검색된 파일 정보
	 */
	public FileInfoVO getFileInfo(int fileNo);

}
