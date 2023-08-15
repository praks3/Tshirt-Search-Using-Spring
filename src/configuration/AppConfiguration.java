package configuration;

import org.springframework.context.annotation.Bean;

import dao.*;
import daoImplementation.*;
import service.ReadFilesService;
import serviceImplementation.*;
public class AppConfiguration {

	@Bean
	public UserDao getUserDao() {
		return new UserDaoImp();
	}

	@Bean
	public UserServiceImpl getUserService() {
		return new UserServiceImpl();
	}

	@Bean
	public TshirtDao getTshirtDao() {
		return new TshirtDaoImp();
	}

	@Bean
	public TshirtSearchServiceImpl getTshirtSearchService() {
		return new TshirtSearchServiceImpl();
	}

	@Bean
	public ReadFilesService readDirectory() {
		return new ReadFilesServiceImpl();
	}
}