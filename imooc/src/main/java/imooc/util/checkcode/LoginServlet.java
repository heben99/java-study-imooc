package imooc.util.checkcode;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(req.getRequestURI() + ": begin doGet()");

		resp.setContentType("text/html;charset=gbk");
		// ��session�л���û����һ�λ�ȡ����֤��
		String piccode = (String) req.getSession().getAttribute("piccode");

		// �û������ֶ��������֤��
		String submitCheckcode = req.getParameter("checkcode");

		PrintWriter out = resp.getWriter();

		if (0 == submitCheckcode.compareToIgnoreCase(piccode)) {
			out.write("��֤��������ȷ");
		} else {
			out.write("��֤���������");
		}
		out.flush();
		out.close();

		System.out.println(req.getRequestURI() + ": end doGet()");
	}
}
