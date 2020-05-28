package pers.yus.javaweb.control;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(urlPatterns = {"/CodeServlet"})
public class CodeServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Cache-Control", "no-cache");
		//在内存中创建图像
		int width = 170, height = 60;
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		
		//获取画笔
		Graphics g = image.getGraphics();
		
		//设置背景色
		g.setColor(Color.white);
		g.fillRect(0, 0, width, height);
		
		//取随机产生的验证码（四位数字）
		Random rnd = new Random();
		int randNum = rnd.nextInt(8999)+1000;
		String randStr = String.valueOf(randNum);
		
		//将验证码存入session
		HttpSession session = request.getSession();
		session.setAttribute("randStr", randStr);
		
		//将验证码显示到图像
		g.setColor(new Color(23,168,26));
		g.setFont(new Font("", Font.PLAIN, 60));
		g.drawString(randStr, 25, 50);//在右下方绘制
		
		//随机产生100个干扰点，使图像中的验证码不易呗其他程序探测到
		for(int i = 0; i< 100; i++) {
			int x = rnd.nextInt(width);
			int y = rnd.nextInt(height);
			g.drawOval(x, y, 1, 1);
		}
		
		g.drawLine(0, 0, 170, 60);
		
		//输出图像到页面
		ImageIO.write(image, "JPEG", response.getOutputStream());
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
