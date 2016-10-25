package main.java.walsh.springwebapps.config;

import java.util.regex.Pattern;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.core.type.filter.RegexPatternTypeFilter;

import main.java.walsh.springwebapps.config.RootConfig.WebPackage;

/**
 * This class the root configuration details
 * @author John
 *
 */
@Configuration
@Import(DatabaseConfig.class)
@ComponentScan(basePackages={"main.java.walsh.springwebapps"}, 
excludeFilters={
    @Filter(type=FilterType.CUSTOM, value=WebPackage.class)
})
public class RootConfig {
	public static class WebPackage extends RegexPatternTypeFilter {
		public WebPackage() {
			super(Pattern.compile("main.java.walsh.springwebapps\\.web"));
		}    
	}
}
