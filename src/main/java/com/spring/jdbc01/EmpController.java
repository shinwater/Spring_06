package com.spring.jdbc01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.model.EmpDAO;
import com.spring.model.EmpDTO;

@Controller
public class EmpController {
	
	@Autowired
	private EmpDAO dao;

	@RequestMapping("/emp_list.do")
	public String list(Model model) {
		List<EmpDTO> list = this.dao.getEmpList();
		
		//model 에저장->뷰페이지로 넘겨줌
		
		model.addAttribute("List",list);
		
		return "emp_list";
		}//list() end;
	
		
	@RequestMapping("/emp_cont.do")
	public String cont(@RequestParam("empno") int empno,Model model) {
		EmpDTO dto =this.dao.empCont(empno);
		model.addAttribute("cont",dto);
		
		return "emp_cont";
		
	}//cont() end
	
	@RequestMapping("/emp_insert.do")
	public String insert() {
		
		return "emp_insertForm";
	}//insert() end;
	
	@RequestMapping("/emp_insertOk.do")
	public String insertOk(EmpDTO dto ,HttpServletResponse response) {//매핑이 다르니까 메서드 이름은 같아도됨!
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html charset=UTF-8");// 이게 출력인가봥
		
		int res = this.dao.empInsert(dto);
		
		try {
			PrintWriter out =response.getWriter();
			
			if(res>0) {
				/*
				 * out.println("<script>"); out.println("alert('성공ㅇ ')");
				 * out.println("location.href='emp_list.do'"); out.println("</script>");
				 */
				
				return "redirect:emp_list.do";
			}else {
				return "redirect:emp_insert.do";//★
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}//insertOk();end;
	
	@RequestMapping("/emp_update.do")
	public ModelAndView modify(@RequestParam("empno")  int empno) {
		//상세내역 조회하는 메서드 호출
		EmpDTO dto = this.dao.empCont(empno);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("modify", dto);
		mav.setViewName("emp_updateForm");
		
		return mav;
	}// modify() 메서드 end;
	
	@RequestMapping("/emp_updateOk.do")
	public String modifyOk(EmpDTO dto, HttpServletResponse response) throws IOException {
		
		response.setContentType("text/html charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		int res =this.dao.empUpdate(dto);
		if(res > 0) {
			out.println("<script>");
			out.println("alert('ㅅ엉공')");
			out.println("location.href='emp_cont.do?empno="+dto.getEmpno()+"'");
			out.println("</script>");
			
			//return "redirect:emp_cont.do?empno="+dto.getEmpno();
		}else {
			out.println("<script>");
			out.println("alert('ㅅㅣㄹ패')");
			out.println("location.href='emp_update.do?empno="+dto.getEmpno()+"'");
			out.println("</script>");
		}
		return null;
	}//modifyOk() end;
	
	@RequestMapping("/emp_delete.do")
	public String delete(@RequestParam("empno") int empno) {
		int res=this.dao.empDelete(empno);
		
		if(res == 1) {
			return "redirect:emp_list.do";
		}else {
			return "redirect:emp_cont.do?empno="+empno;
		}
		
	}//delete() end;
}
