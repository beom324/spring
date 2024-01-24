//package com.example.demo.util;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.mail.MailSender;
//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.scheduling.annotation.EnableScheduling;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//
//import com.example.demo.dao.EmpDAO;
//import com.example.demo.vo.EmpVO;
//
//import lombok.Setter;
//
//@Setter
//@Component//자동으로 객체생성
//@EnableScheduling //어노테이션으로 스케줄링을 설정할거야
//public class SistUtil {
//
//	@Autowired
//	private MailSender mailSender;
//	@Autowired
//	private EmpDAO dao;	
//	
//	
//	@Scheduled(cron = "00 43 16 24 01 *")
//	public void pro() {
//		List<EmpVO> list = dao.findAll(); 
//		SimpleMailMessage mailMessage = new SimpleMailMessage();
//
//		for(EmpVO vo : list) {
//			
//			int total = vo.getSalary() + vo.getComm();
//			mailMessage.setFrom("tjfkqm1@gmail.com");
//			mailMessage.setSubject("급여명세서[담당자 : 김범진]");
//			mailMessage.setTo(vo.getEmail());
//			mailMessage.setText(vo.getEname()+"님 2024년 1월 급여는"+total +"입니다");
//			
//			
//			mailSender.send(mailMessage);
//		}
//
//	}
//}
