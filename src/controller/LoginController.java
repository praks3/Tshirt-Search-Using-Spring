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

import service.ReadFilesService;
import serviceImplementation.UserServiceImpl;

@Controller
public class LoginController {

	@Autowired
	private UserServiceImpl userService;
	@Autowired
	private ReadFilesService readFilesDirectory;
	
	@RequestMapping("login")
	public ModelAndView login(@RequestParam("username") String username, @RequestParam("password") String password,
			HttpServletRequest request, HttpServletResponse response) throws IOException {

		ModelAndView mv = new ModelAndView();
		/*readFilesDirectory.readDirectory();
*/
		PrintWriter out = response.getWriter();

		if (!userService.validateUser(username, password)) {
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Either User is not registered or password is wrong!');");
			out.println("window.location = \"/TshirtSearch/Login.jsp\";");
			out.println("</script>");
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			mv.setViewName("SearchPage.jsp");
		}
		return mv;

	}

}