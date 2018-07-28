/**   
 * @Description: 
 *     
 * @author wanghao   
 * @version  1.0   
 */
package com.whbs.market.util;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**   
 * @Description: 拦截器
 *     
 * @author wanghao   
 * @version  1.0   
 */
@Configuration
public class MyWebMvcConfigurer extends WebMvcConfigurerAdapter {
	@Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new SessionInterceptor()).addPathPatterns("/**").excludePathPatterns("/show/**");
        super.addInterceptors(registry);
    }
}
