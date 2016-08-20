package imooc.util.checkcode;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ImageServlet extends HttpServlet {

	private int width = 68;
	private int height = 22;
	private int charCount = 4;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(req.getRequestURI() + ": begin doGet()");
		
		BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics g = bi.getGraphics();
		Color c =  Color.WHITE;
		g.setColor(c);
		g.fillRect(0, 0, width, height);
		
		final String s = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		Random r = new Random();
		int index;
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < charCount; ++i) {
			index = r.nextInt(s.length());
			g.setColor(new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
			g.drawString(s.charAt(index)+"", i*(width/charCount), height);
			sb.append(s.charAt(index));
		}
		req.getSession().setAttribute("piccode", sb.toString()); //每次访问验证码servlet时，更新验证码字符串到session中
		System.out.println(req.getRequestURI() + ": before ImageIO.write()");
		ImageIO.write(bi, "JPG", resp.getOutputStream());
		resp.getOutputStream().close();
		System.out.println(req.getRequestURI() + ": end doGet()");
	}
}
