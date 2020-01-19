package com.kitri.board.controller;

import java.io.*;
import java.text.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import com.kitri.board.model.*;
import com.kitri.board.model.service.*;
import com.kitri.member.model.*;
import com.kitri.util.*;
import com.oreilly.servlet.*;
import com.oreilly.servlet.multipart.*;

@WebServlet("/pictureupload")
public class PictureUploadController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	private String serverDirectory;
	private int maxPostSize;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		serverDirectory = config.getServletContext().getRealPath("/upload"); //upload의 실제경로를 얻어내고 싶다.
//		System.out.println(saveDirectory);
		maxPostSize = 5 * 1024 * 1024; //5메가 로 제한
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//오늘 날짜를 얻어와라
		DateFormat df = new SimpleDateFormat("yyMMdd");
		String saveFolder = df.format(new Date());
		String saveDirectory = serverDirectory + File.separator + saveFolder;
		//파일 만들기
		File dir = new File(saveDirectory);
		//폴더 만들기
		if(!dir.exists()) {
			dir.mkdirs();
		}
		
		MultipartRequest multi = new MultipartRequest(request, saveDirectory, maxPostSize, BoardConstance.ENCODING, new DefaultFileRenamePolicy());
		String path = "/index.jsp";
		
		HttpSession session = request.getSession();
		MemberDto memberDto = (MemberDto) session.getAttribute("userInfo");
		if(memberDto != null) { //로그인을 했다면?
			
			//작성된 것을 불러와 게시판에 insert
			AlbumDto albumDto = new AlbumDto();
			
			albumDto.setId(memberDto.getId());
			albumDto.setName(memberDto.getName());
			albumDto.setEmail(memberDto.getEmailid() + "@" + memberDto.getEmaildomain());
			albumDto.setSubject(multi.getParameter("subject"));
			albumDto.setContent(multi.getParameter("content"));
			albumDto.setBcode(Integer.parseInt(multi.getParameter("bcode")));
			albumDto.setSaveFolder(saveFolder); //매일 폴더를 만들어서 저장하는 것이 좋다.
			albumDto.setOrignPicture(multi.getOriginalFileName("picture"));//원본사진의 이름
			albumDto.setSavePicture(multi.getFilesystemName("path")); //실제로 저장된 파일의 이름
			
			int seq = AlbumServiceImpl.getAlbumService().writeArticle(albumDto);
			if(seq != 0) { //성공 했을 때
				path = "/album/writeok.jsp";
				request.setAttribute("seq", seq);
			} else { //실패 했을 때
				path = "/index.jsp";
			}
		} else { //로그인 안했을 때
			path = "/member/login.jsp";
		}
		MovePage.forward(request, response, path);
	}

}
