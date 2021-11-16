package com.atmira.nasa.service;

import java.util.List;

import com.atmira.nasa.model.Asteroids;
import com.atmira.nasa.model.neo.NearEarthObj;
import com.atmira.nasa.model.neo.ObjAsteroids;

public interface INasaAppService {
	
	/**
	 * Devolver listado de Asteroides
	 * 
	 * @param String planet
	 */
	public List<Asteroids> getAsteroids(String planet);
	
	/**
	 * Llamar a la API de la NASA y recoger los datos
	 * 
	 */
	public ObjAsteroids getObjFromJsonNasa();
	
	/**
	 * Filtar por los campos
	 * 
	 * @param String planet
	 * 
	 */
	public List<NearEarthObj> getNeo(String planet);
	
	/**
	 * Encargado de crear la lista de Asteroides.
	 * 
	 * @param List<NearEarthObj> neos
	 * @param String planet
	 */
	public List<Asteroids> getListAsteroids(List<NearEarthObj> neos, String planet);
	
	/**
	 * Dar de alta los datos de un usuario y su facturación
	 * 
	 * @param id usuario
	 * @param userData datos de usuario
	 */
	public Asteroids createAsteroids(NearEarthObj neo, String planet);
	
	}
