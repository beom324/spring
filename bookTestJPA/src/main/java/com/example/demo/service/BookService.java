
package com.example.demo.service;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.BookDAO;
import com.example.demo.vo.BookVO;

import jakarta.persistence.criteria.CriteriaBuilder.In;
import lombok.Setter;

@Service
@Setter
public class BookService {
	@Autowired
	private BookDAO dao;
	
	public BookVO findById(int bookid) {
		BookVO b = null;
		//jpa의 findById는 VO를 반환하지 않고 
		//VO을 Optional로 포장해서 반환합니다.
		Optional<BookVO> o = dao.findById(bookid);
		if(o.isPresent()) {
			b = o.get();
		}
		return b;
	}
	
	
	public List<BookVO> findAll(HashMap<String, String> map){
		String cname = map.get("cname");
		String keyword = map.get("keyword");
		String sname = map.get("sname");
		System.out.println("서비스에서 sname:"+sname);
		List<BookVO> list = null;
		
		
		
		if(keyword != null && !keyword.equals("")) {
			String methodName = "findBy"+cname;
			if(sname != null) {
				methodName += "OrderBy"+sname;
			}
			
			try {
				Class<?> cls = 
					Class.forName(dao.getClass().getName());
				if(cname.equals("Bookname") || cname.equals("Publisher")) {
					StringBuffer sb = new StringBuffer(methodName);
					int i = sb.length();
					if(sb.indexOf("OrderBy") != -1) {
						i = sb.indexOf("OrderBy");
					}
					methodName = sb.insert(i, "Containing").toString();					
					Method method = 
							cls.getDeclaredMethod(methodName, String.class);			
							list = (List<BookVO>)method.invoke(dao, keyword);
				}else {
					Method method = 
							cls.getDeclaredMethod(methodName, Integer.class);							
							list = (List<BookVO>)method.invoke(dao, new Integer(keyword) );
				}						
			}catch (Exception e) {
				System.out.println("예외발생:"+e.getMessage());
			}
			System.out.println("keyword:"+keyword);
			System.out.println("methodName:"+methodName);
		}
		
		
		
		else {
			String methodName = "findAllByOrderBy";
			if(sname != null) {
				methodName += sname;
			}else {
				methodName += "Bookname";
			}
			try {
				Class<?> cls = 
					Class.forName(dao.getClass().getName());
					Method method = 
							cls.getDeclaredMethod(methodName);			
							list = (List<BookVO>)method.invoke(dao);										
			}catch (Exception e) {
				System.out.println("예외발생:"+e.getMessage());
			}
		}
		return list;
	}
	
	//pk에 해당하는 레코드가 이미있으면 update를 수행하고 
	//그렇지 않으면 insert를 수행합니다.
	public void save(BookVO b) {
		dao.save(b);
	}
	
	public void delete(int bookid) {
		dao.deleteById(bookid);
	}
}
