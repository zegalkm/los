package com.ncos.hero.service;

import com.ncos.hero.entity.Hero;

public interface HeroMngService {

	public enum HeroImg{};
	public void saveHero(Hero hero,String rgb);
}
