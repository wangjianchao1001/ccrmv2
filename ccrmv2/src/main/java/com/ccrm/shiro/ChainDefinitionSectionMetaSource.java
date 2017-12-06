package com.ccrm.shiro;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.config.Ini;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;

import com.ccrm.entity.SysDictionary;
import com.ccrm.service.SysDictionaryService;

/**
 * 产生责任链，确定每个url的访问权限
 *
 * Created by Jeremie on 2014/10/1.
 */
public class ChainDefinitionSectionMetaSource implements FactoryBean<Ini.Section> {
	@Autowired
	private SysDictionaryService authService;

	// 静态资源访问权限
	private String filterChainDefinitions;

	public String getFilterChainDefinitions() {
		return filterChainDefinitions;
	}

	public void setFilterChainDefinitions(String filterChainDefinitions) {
		this.filterChainDefinitions = filterChainDefinitions;
	}

	@Override
	public Ini.Section getObject() throws Exception {//TODO
		SysDictionary authority = new SysDictionary();
		authority.setIdxid(Long.valueOf(10));
		List<SysDictionary> list = authService.findList(authority);
		Ini ini = new Ini();
		// 加载默认的url
		ini.load(filterChainDefinitions);
		Ini.Section section = ini.getSection(Ini.DEFAULT_SECTION_NAME);
		// 循环Resource的url,逐个添加到section中。section就是filterChainDefinitionMap,
		// 里面的键就是链接URL,值就是存在什么条件才能访问该链接
		
		for (SysDictionary p : list) {
			// 构成permission字符串
			String permission = "";
			if (StringUtils.isNotEmpty(p.getCodeid())
					&& StringUtils.isNotEmpty(p.getMemo())) {
				permission = "perms[" + p.getCodeid() + "]";
			} else if(p.getMemo().equals("#")){
				continue;
			}else{
				permission = "anon";
			}
			section.put(p.getMemo(), permission);
		}
		// 所有资源的访问权限，必须放在最后
		section.put("/**", "authc");
		return section;
	}

	@Override
	public Class<?> getObjectType() {
		return this.getClass();
	}

	@Override
	public boolean isSingleton() {
		return false;
	}
}
