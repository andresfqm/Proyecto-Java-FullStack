package com.quintana.service;

import java.util.List;

// Creamos una interfaz que contiene objetos genericos para reducir codigo
public interface ICRUD <T, V>{
	
	// T --> Objeto Generico
	// V --> Hace referencia al Id de ese objeto Generico
	T registrar(T obj);
	T modificar(T obj);
	List<T> listar();
	T listarPorId(V id);
	boolean eliminar(V id);

}
