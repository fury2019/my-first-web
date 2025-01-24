package com.Hotel.controller.member;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

import com.Hotel.service.member.JoinLoginServiceImpl;
import com.Hotel.vo.MemberVO;


@WebServlet("/Join")
public class Join extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public Join() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 회원가입 페이지를 메인페이지에 끼워넣을 조건 키를 하나 생성
		request.setAttribute("joinCode", "join");
		
		//요청객체에 담긴 속성을 원하는 위치로 전달 >> requestDispatcher객체
		RequestDispatcher disp = request.getRequestDispatcher("index.jsp");
		disp.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		MemberVO memVO = new MemberVO();
		try {
			BeanUtils.populate(memVO, request.getParameterMap());
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(memVO);
		
		//controller에서 vo에 담은 정보를 service <> dao <> DB인서트 
		JoinLoginServiceImpl service = JoinLoginServiceImpl.getInstance();
		int count = service.joinMember(memVO);
		
		System.out.println("인서트 결과 >> " + count);
		response.getWriter().print(count);
		
	}
}
