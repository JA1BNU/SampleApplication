import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginServlet3")
public class LoginServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
							throws ServletException, IOException {
		// リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String password = request.getParameter("pass");

		// SevletContextの取得
		ServletContext context = getServletContext();

		// アプリケーションスコープ（ServletContext）から属性の取得
		Integer counter = (Integer)context.getAttribute("counter");
		if (counter == null) {
			counter = 1;
		}else {
			counter++;
		}
		context.setAttribute("counter", counter);

		// HttpSessionの取得
		HttpSession session = request.getSession();
		if (name != null && name.length() > 0
				&& password != null && password.length() > 0) {
			session.setAttribute("username", name);
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
		if (name != null && name.length() > 0
				&& password != null && password.length() > 0) {
			out.println("<h2>Welcome!</h2>");
			out.println("アクセス数：" + counter + "<br>");
			out.println("<h3>" + name + "さん、こんにちは</h3>");
			out.println("<br>");
			out.println("ユーザ名　：" + name + "<br>");
			out.println("パスワード：" + password + "<br>");
			out.println("<hr>");
			out.println("<a href=\"NextServlet2\" >次へ</a>");
		} else {
			out.println("<h2>ログインエラー</h2>");
			out.println("<h3>" + "ユーザ名とパスワードを入力してください。</h3>");
			out.println("<br>");
			out.println("<a href=\"login3.html\">戻る</a>");
		}
		out.println("</body>");
		out.println("</html>");

		// ストリームのclose
		out.close();
	}
}
