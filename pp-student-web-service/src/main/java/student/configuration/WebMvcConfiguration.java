package student.configuration;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@MapperScan({"student.repository"})
public class WebMvcConfiguration extends WebMvcConfigurerAdapter{

	@Autowired
	private DataSource dataSource;

	
	//TODO: to use with @Transaction in spring
	@Bean
	public DataSourceTransactionManager transactionManager() {
		System.out.println("_____TEST______");
		return new DataSourceTransactionManager(dataSource);
	}
 	
	@Bean
	public SqlSessionFactoryBean sqlSessionFactory() throws Exception {
		SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setDataSource(dataSource);
		return sessionFactory;
	}
	
}
