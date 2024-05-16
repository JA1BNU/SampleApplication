import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/NextServlet1")
public class NextServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
										throws ServletException, IOException {
		// Cookieの取得
		Cookie[] cookies = request.getCookies();

		String name = null;
		if (cookies != null) {
			for(Cookie c : cookies) {
				if (c.getName().equals("username")) {
					name = c.getValue();
				}
			}
		}

		// Content-Typeの指定
		response.setContentType("text/html; charset=UTF-8");

		// HTMLデータの出力ストリームを取得
		PrintWriter out = response.getWriter();

		// レスポンスデータ作成
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Next</title>");
		out.println("</head>");
		out.println("<body>");

		if (name != null) {
			out.println("<h2>User's Page</h2>");
			out.println("<h3>" + name + "さんのページ</h3>");
			out.println("<br>");
			out.println("<form action=\"LogoutServlet1\" method=\"post\">");
			out.println("<input type=\"submit\" value=\"ログアウト\"/><br>");
			out.println("</form>");
		}else {
			out.println("<h2>ログインエラー</h2>");
			out.println("<h3>" + "ログインしてください。</h3>");
			out.println("<br>");
			out.println("<a href=\"login1.html\">戻る</a>");
		}
		out.println("</body>");
		out.println("</html>");

		// ストリームのclose
		out.close();
	}
}
