package com.yzb.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yzb.model.User;
import com.yzb.util.pdf.PdfUtil;

@Controller
@RequestMapping("/pdf")
public class PdfController {

	/**
	 * 
	 * @param request
	 * @param response
	 * @throws Exception 
	 */
	@RequestMapping("/download")
	public void agreeDownload(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		response.setCharacterEncoding("UTF-8");
		OutputStream out = response.getOutputStream();
		response.setContentType("application/pdf");
		response.addHeader(
				"Content-Disposition",
				"attachment; filename="
						+ String.format("%s.pdf",
								Long.toString(System.currentTimeMillis())));

		String templateHtml = PdfUtil.generateHtml(request.getSession().getServletContext(), 
				"template.html", getDynamicData());
		PdfUtil.generatePdf(templateHtml, out);

		out.flush();
		out.close();
	}

	private Map<String, Object> getDynamicData() throws IOException {

		// 从数据库中获取数据， 出于演示目的， 这里数据不从数据库获取， 而是直接写死

		Map<String, Object> variables = new HashMap<String, Object>(3);

		List<User> userList = new ArrayList<User>();

		User tom = new User("Tom", 19, 1);
		User amy = new User("Amy", 28, 0);
		User leo = new User("Leo", 23, 1);

		userList.add(tom);
		userList.add(amy);
		userList.add(leo);

		variables.put("title", "用户列表");
		variables.put("userList", userList);

		return variables;
	}
}
