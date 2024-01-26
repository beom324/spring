package com.example.demo.util;

import java.util.List;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.demo.dao.EmpDAO;
import com.example.demo.vo.EmpVO;

import lombok.Setter;

@EnableScheduling
@Component
@Setter
public class SistUtil {

	@Autowired
	private JavaMailSender javaMailSender;
	@Autowired
	private EmpDAO dao;
	
	public SistUtil(JavaMailSender javaMailSender) {
		super();
		this.javaMailSender = javaMailSender;
	}
	
	public SistUtil(EmpDAO dao) {
		super();
		this.dao = dao;
	}
	
	
	
	
	@Scheduled(cron = "01 44 12 25 01 *")
	public void send() {
	
			
			javaMailSender.send(new MimeMessagePreparator() {
				
				@Override
				public void prepare(MimeMessage mimeMessage) throws Exception {
					MimeMessageHelper message=
					new MimeMessageHelper(mimeMessage,"UTF-8");
					
					List<EmpVO> list = dao.findAll();
					try {
					for(EmpVO vo : list	) {
						String text ="<h1>2024년 1월</h1>" ;
						text+="<tr>";
						text+="<table border='1'>";
						text+="<tr>";
						text+="<th>사원번호</th>";
						text+="<th>이름</th>";
						text+="<th>부서번호</th>";
						text+="<th>급여</th>";
						text+="<th>수당</th>";
						text+="<th>실수령액</th>";
						text+="</tr>";
						text+="<tr>";
						text+="<td>"+vo.getEno()+"</td>";
						text+="<td>"+vo.getEname()+"</td>";
						text+="<td>"+vo.getDno()+"</td>";
						text+="<td>"+vo.getSalary()+"</td>";
						text+="<td>"+vo.getComm()+"</td>";
						text+="<td>"+vo.getSalary()+vo.getComm()+"</td>";
						text+="</tr>";
						text+="</table>";
						text+="</tr>";
						message.setTo(vo.getEmail());
						message.setSubject("급여명세서 [담당자 : 김범진]");
						message.setFrom("tjfkqm1@gmail.com");
						message.setText(text,true);
						System.out.println("전송");
					}
					}catch(Exception e) {
						System.out.println(e.getMessage());
					}											
					
				}
			});

		}
	public SistUtil() {
		super();
	}
}
