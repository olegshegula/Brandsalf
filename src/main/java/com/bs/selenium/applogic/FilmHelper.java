package com.bs.selenium.applogic;

import java.util.List;

import com.bs.selenium.model.Film;

public interface FilmHelper {

	void create(Film film);
	void delete(Film film);
	List<Film> search(String title);

}
