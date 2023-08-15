package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import model.Tshirt;
import service.ReadFilesService;
import serviceImplementation.TshirtSearchServiceImpl;


@Controller
public class SearchController {

	@Autowired
	private TshirtSearchServiceImpl tshirtSearch;


	@RequestMapping("/search")
	public ModelAndView searchTshirt(@RequestParam("color") String color, @RequestParam("size") String size,@RequestParam("gender") String gender, @RequestParam("outputPref") String outputPreference,HttpServletRequest request, HttpServletResponse response) throws IOException {

		ModelAndView mv = new ModelAndView();
		PrintWriter out = response.getWriter();
		
		List<Tshirt> searchResult = tshirtSearch.getSearchResult(color, size, gender, outputPreference);
		if (searchResult.isEmpty()) {
			mv.addObject("searchResult", searchResult);
//			mv.setViewName("tshirtUnavailable.jsp");
			out.println("<script type=\"text/javascript\">");
			out.println("alert('T-shirt is Unavailable!');");
			out.println("window.location = \"/TshirtSearch/SearchPage.jsp\";");
			out.println("</script>");
		}
		else {
			mv.addObject("searchResult", searchResult);
			mv.setViewName("display.jsp");
		}
		return mv;

	}

}