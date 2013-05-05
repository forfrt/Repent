package servlet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

public class IdentityServlet extends HttpServlet {
	//����ַ��ֵ�
	public static final char[] CHARS = {'2','3','4','5','6','7','8','9','A',
		'B','C','D','E','F','G','H','J','K','L','M','N','P','Q','R','S','T',
		'U','V','W','X','Y','Z'};//������0��0��1��I�ȵ��ѱ��ϵ��ַ�
	public static Random random = new Random();//�����
	
	public static String getRandomString(){//��ȡ6λ�����
		StringBuffer buffer = new StringBuffer();//�ַ���
		for(int i = 0; i < 6; i++){//ѭ��6��
			buffer.append(CHARS[random.nextInt(CHARS.length)]);
											//ÿ��ȡһ������ַ�
		}
		return buffer.toString();
	}
	
	public static Color getRandomColor(){//��ȡ������ɫ
		return new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255));
	}
	public static Color getReverseColor(Color c){//����ĳ��ɫ�ķ�ɫ
		return new Color(255-c.getRed(),255-c.getGreen(),255-c.getBlue());
	}
	
	public void doGet(HttpServletRequest request,HttpServletResponse response)
	throws ServletException,IOException{
		//GET����
		response.setContentType("image/jpeg");//����������ͣ������
		String randomString = getRandomString();//����ַ�
		request.getSession(true).setAttribute("randomString", randomString);//�ŵ�session��
		
		int width = 100;//ͼƬ���
		int height = 30;//ͼƬ�߶�
		
		Color color = getRandomColor();//�����ɫ�����ڱ���ɫ
		Color reverse = getReverseColor(color);//��ɫ������ǰ����
		
		BufferedImage bi = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
					//����һ����ɫͼƬ
		Graphics2D g = bi.createGraphics();//��ȡ��ͼ����
		g.setFont(new Font(Font.SANS_SERIF,Font.BOLD,16));//��������
		g.setColor(color);//������ɫ
		g.fillRect(0, 0, width, height);//���Ʊ���
		g.setColor(reverse);//������ɫ
		g.drawString(randomString, 18, 20);//��������ַ�
		for(int i = 0, n = random.nextInt(100); i < n; i++)
		{
			//�����100��������
			g.drawRect(random.nextInt(width),random.nextInt(height),1,1);
			//���������
		}
		ServletOutputStream out = response.getOutputStream();
															//ת��JPEG��ʽ
		JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);//������
		
		encoder.encode(bi);//��ͼƬ���б���
		out.flush();//������ͻ���
	}
}
