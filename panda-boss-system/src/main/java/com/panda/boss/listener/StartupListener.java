package com.panda.boss.listener;

import com.panda.boss.service.cache.CacheService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;

/**
 * 应用启动完毕后执行此方法,预加载数据在次处理 不然会出现依赖问题
 * @author wujianhui
 */
@Service
@Slf4j
public class StartupListener implements ApplicationListener<ContextRefreshedEvent> {

	@Value("${reload.redis:false}")
	private boolean reloadRedis;

	@Autowired
	private CacheService cacheService;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		log.debug("---------------------------- ApplicationListener onApplicationEvent ");
		log.debug("是否更新缓存资源:{}",reloadRedis);

		if(reloadRedis){
			// 缓存系统参数
			cacheService.setSystemParameter();

			// 缓存系统菜单资源
			cacheService.setSystemResource();
		}
	}
}
