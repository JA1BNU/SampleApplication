import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LogoutServlet1")
public class LogoutServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    											throws ServletException, IOException {
		// Cookieの取得
		Cookie[] cookies = request.getCookies();

		// Cookieの削除
		if (cookies != null) {
			for (Cookie c : cookies) {
				c.setMaxAge(0);
				response.addCookie(c);
			}
		}

		// Content-Typeの指定
		response.setContentType("text/html; charset=UTF-8");

		// HTMLデータの出力ストリームを取得
		PrintWriter out = response.getWriter();

		// レスポンスデータ作成
		out.println("<html>");
		out.println("<head>");
		out.println("<title>ログアウト</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h2>ログアウト</h2>");
		out.println("ログアウトしました。<br>");
		out.println("</body>");
		out.println("</html>");

		// ストリームのclose
		out.close();
	}
}
