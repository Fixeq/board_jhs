package com.hyunseok.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.hyunseok.service.BoardService;
import com.hyunseok.vo.BoardVO;
import com.hyunseok.vo.PageInfo;
import com.hyunseok.vo.PageMaker;

@RequestMapping("/board")
@Controller
public class BoardController {

	@Autowired
	public BoardService service;
	
	@RequestMapping(value="/list")
	public ModelAndView selectBoardListPaging(BoardVO dto) {

		// 검색 목록 셋팅
		PageInfo search = new PageInfo();
		search.setSearchOption(dto.getSearchOption());
		search.setKeyword(dto.getKeyword());
		System.out.println("search : " + search);
		
		// 페이징 준비
		int totalCount = service.selectBoardTotalCount(dto);
		System.out.println("total cnt : " + totalCount);
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setPageInfo(dto);
		pageMaker.setTotalCount(totalCount);
		System.out.println("PageMaker : " + pageMaker);

		ModelAndView mav = new ModelAndView();
		List<BoardVO> list = service.selectListBoard(dto);
		
		for(BoardVO board : list) {
			System.out.println("list board : " + board);
		}
		
		mav.addObject("list", list);
		mav.addObject("search",search);
		mav.addObject("pageMaker", pageMaker);
		mav.setViewName("/board/listView");
		return mav;
	}
	
	@RequestMapping(value="/insertView")
	public ModelAndView insertView(HttpServletRequest req) {
		HttpSession session = req.getSession();
		//세션 생성 후 로그인 시 생성되는 세션 받아오기
		//BoardVO loginSession = (BoardVO)session.getAttribute("loginInfo");
		ModelAndView mav = new ModelAndView();
		//mav.addObject("session"	, loginSession);
		return mav;
	}
	
	@ResponseBody
	@RequestMapping(value="/insertProc",method=RequestMethod.POST )
	public int inserProc(BoardVO dto) throws IOException{
		
		System.out.println("insert dto : " + dto);
		int result = 0;
		
		// 파일 업로드 처리
		MultipartFile uploadFile = dto.getUploadFile();
		String fileName = "";
		try {
			if(!uploadFile.isEmpty()) {
				fileName = uploadFile.getOriginalFilename();
				uploadFile.transferTo(new File("C:\\zzz\\upload\\" + fileName));
				System.out.println("업로드 성공!");
			}
		}catch (Exception e) {
			// result = -1 : 파일 업로드 중 장애발생
			result = -2;
			e.printStackTrace();
		}
		
		try {
			// result = 1 : 등록 성공, 0 : 등록 실패
			result = service.insertBoard(dto);
		}catch (Exception e) {
			// result = -1 : 등록 중 장애발생
			result = -1;
			e.printStackTrace();
		}
		return result;
	}
	
	@RequestMapping(value="/detail")
	public ModelAndView detailView(BoardVO dto) {
		System.out.println("detail dto : " + dto);
		
		BoardVO board = service.selectBoardDetail(dto);
		
		System.out.println("detail board : " + board);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("board", board);
		mav.setViewName("/board/detailView");
		return mav;
	}
	
	@ResponseBody
	@RequestMapping(value="/updateProc", method=RequestMethod.POST)
	public int updateProc(BoardVO dto) {
		
		System.out.println("update dto : " + dto);
		
		int result = 0;
		dto.setBoardUpdateId(dto.getBoardWriter());
		
		try {
			// 수정 성공 : 1, 수정 실패 : 0
			result = service.updateBoard(dto);
		}catch (Exception e) {
			// 장애 발생 : -1
			result = -1;
			e.printStackTrace();
		}
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value="/deleteProc", method=RequestMethod.POST)
	public int deleteProc(BoardVO dto) {
		
		System.out.println("delete dto : " + dto);
		
		int result = 0;
		dto.setBoardUpdateId(dto.getBoardWriter());
		
		try {
			// 수정 성공 : 1, 수정 실패 : 0
			result = service.deleteBoardSeq(dto);
		}catch (Exception e) {
			// 장애 발생 : -1
			result = -1;
			e.printStackTrace();
		}
		return result;
	}
}
