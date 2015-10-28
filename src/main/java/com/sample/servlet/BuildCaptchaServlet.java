package com.sample.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.ImageIcon;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.servlet.http.*;

import java.io.*;

import com.sample.util.CaptchaUtil;

public class BuildCaptchaServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final String FILE_TYPE = "jpeg";
	
	private static final Logger LOGGER = LoggerFactory.getLogger(BuildCaptchaServlet.class);

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		response.setHeader("Pragma", "no-cache");
		response.setDateHeader("Max-Age", 0);
		response.setContentType("image/jpeg");

		String captchaStr = "";

		LOGGER.info("Generating captua...");

		captchaStr = CaptchaUtil.generateCaptchaText(6);

		try {

			int width = 135;
			int height = 40;

			Color fg = new Color(225, 0, 225);

			Font font = new Font("Eras Bold ITC", Font.BOLD + Font.ITALIC, 20);
			
			Image  img = new ImageIcon(getServletContext().getRealPath("/resources/images/noisy_bg_img_2.jpg")).getImage();

			BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
			
			Graphics graphics = bufferedImage.createGraphics();

			graphics.setFont(font);
			//graphics.setColor(bg);
			graphics.fillRect(0, 0, width, height);
			graphics.setColor(fg);
			graphics.drawImage(img, 0, 0, null);
			graphics.drawString(captchaStr, 15, 30);

			HttpSession session = request.getSession(true);
			session.setAttribute("CAPTCHA", captchaStr);

			OutputStream outputStream = response.getOutputStream();

			ImageIO.write(bufferedImage, FILE_TYPE, outputStream);
			outputStream.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

}
