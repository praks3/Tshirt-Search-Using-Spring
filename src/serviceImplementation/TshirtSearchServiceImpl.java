package serviceImplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.TshirtDao;
import model.Tshirt;
import service.TshirtSearchService;

@Service
public class TshirtSearchServiceImpl implements TshirtSearchService {

	@Autowired
	private TshirtDao tshirtDao;

	public List<Tshirt> getSearchResult(String color, String size, String gender, String outputPreference) {

		List<Tshirt> tshirtSearchResult;

		tshirtSearchResult = tshirtDao.getData(color, size, gender, outputPreference);

		return tshirtSearchResult;

	}

}