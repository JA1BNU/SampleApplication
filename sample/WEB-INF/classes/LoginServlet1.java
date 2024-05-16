import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet1")
public class LoginServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
							throws ServletException, IOException {
		// リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String password = request.getParameter("pass");

		// Cookieの登録
		Cookie newCookie = null;
		if (name != null && name.length() > 0
				&& password != null && password.length() > 0) {
			newCookie = new Cookie("username", name);
			response.addCookie(newCookie);
		}

		// Content-Typeの指定
		response.setContentType("text/html; charset=UTF-8");

		// HTMLデータの出力ストリームを取得
		PrintWriter out = response.getWriter();

		// レスポンスデータ作成
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Welcome</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h2>Welcome!</h2>");
		out.println("<h3>" + name + "さん、こんにちは</h3>");
		out.println("<br>");
		out.println("ユーザ名　：" + name +"<br>");
		out.println("パスワード：" + password +"<br>");
		out.println("<hr>");
		out.println("<a href=\"NextServlet1\" >次へ</a>");
		out.println("</body>");
		out.println("</html>");

		// ストリームのclose
		out.close();

		// オプションを実装した場合
//		out.println("<html>");
//		if (name != null && name.length() > 0
//				&& password != null && password.length() > 0) {
//			out.println("<head>");
//			out.println("<title>Welcome</title>");
//			out.println("</head>");
//			out.println("<body>");
//			out.println("<h2>Welcome!</h2>");
//			out.println("<h3>" + name + "さん、こんにちは</h3>");
//			out.println("<br>");
//			out.println("ユーザ名　：" + name + "<br>");
//			out.println("パスワード：" + password + "<br>");
//			out.println("<hr>");
//			out.println("<a href=\"NextServlet1\" >次へ</a>");
//		} else {
//			out.println("<head>");
//			out.println("<title>LoginError</title>");
//			out.println("</head>");
//			out.println("<body>");
//			out.println("<h2>ログインエラー</h2>");
//			out.println("<h3>" + "ユーザ名とパスワードを入力してください。</h3>");
//			out.println("<br>");
//			out.println("<a href=\"login1.html\">戻る</a>");
//		}
//		out.println("</body>");
//		out.println("</html>");
//
//		// ストリームのclose
//		out.close();
	}
}
