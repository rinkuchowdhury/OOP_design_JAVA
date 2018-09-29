package sourceCode_config_class;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import sourceCode_config_int.Coach;
import sourceCode_config_int.FortuneService;

@Configuration
//@ComponentScan("sourceCode_config_class")
@PropertySource("classpath:sport.properties")
public class SportConfig {
	
	//define bean for our sad fortune service :bean id == method name
	@Bean
	public FortuneService randomFortuneService() {
		return new RandomFortuneService();
	}
	
	//define bean for our swim coach AND inject dependency
	@Bean
	public Coach tennisCoach() {
		return new TennisCoach(randomFortuneService());
	}
	
}
