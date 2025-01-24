package com.Hotel.controller.Goods;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

import com.Hotel.service.Goods.IGoods_CartService;
import com.Hotel.service.Goods.Goods_CartServiceImpl;
import com.Hotel.vo.Goods_CartVO;
import com.Hotel.vo.MemberVO;

@WebServlet("/goods_CartList")
public class Goods_CartList extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MemberVO loggedInMember = (MemberVO) request.getSession().getAttribute("loginCode");
        String memId = (loggedInMember != null) ? loggedInMember.getMem_id() : null;

        // 서비스 호출
        IGoods_CartService service = Goods_CartServiceImpl.getInstance();
        List<Goods_CartVO> goods_CartList = service.getAllGoodsCart(memId);
        
        // 세션에 장바구니 목록 저장
        request.getSession().setAttribute("Goods_CartList", goods_CartList);

        // 장바구니 목록 페이지로 포워드
        request.getRequestDispatcher("/Goods_CartList.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}

