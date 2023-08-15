package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import serviceImplementation.UserServiceImpl;

@Controller
public class RegisterController {

	@Autowired
	private UserServiceImpl userService;

	@RequestMapping("/register")
	public ModelAndView register(@RequestParam("fullName") String fullname, @RequestParam("username") String username,
			@RequestParam("email") String email, @RequestParam("password") String password, HttpServletRequest request,
			HttpServletResponse response) throws IOException {

		ModelAndView mv = new ModelAndView();		
		PrintWriter out = response.getWriter();
		boolean isNotRegisteredUser = userService.isRegisteredUser(username);

		if (isNotRegisteredUser) {
			userService.saveUser(username, fullname, password, email);
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			mv.setViewName("Login.jsp");
		} else {
			out.println("<script type=\"text/javascript\">");
			out.println("alert('The user is already registered.');");
			out.println("window.location = \"/TshirtSearch/Login.jsp\";");
			out.println("</script>");
		}
		return mv;
	}
}