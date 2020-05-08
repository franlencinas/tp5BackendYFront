package com.utn.main.servicios;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.utn.main.DTOS.InstrumentosDTO;
import com.utn.main.entidades.Instrumentos;
import com.utn.main.repositorio.InstrumentoRepository;

@Service
public class InstrumentosServicios {

	private InstrumentoRepository repository;
	
	public InstrumentosServicios (InstrumentoRepository repository) {
		this.repository = repository;
	}
	
	@Transactional
	public List<InstrumentosDTO> findAll() throws Exception {
		List<Instrumentos> entidades = repository.findAll();
		List<InstrumentosDTO> dtos = new ArrayList();
		
		try {
			for (Instrumentos i : entidades) {
				InstrumentosDTO unDto = new InstrumentosDTO();
				unDto.setId(i.getId());
				unDto.setInstrumento(i.getInstrumento());
				unDto.setMarca(i.getMarca());
				unDto.setModelo(i.getModelo());
				unDto.setImagen(i.getImagen());
				unDto.setPrecio(i.getPrecio());
				unDto.setCostoEnvio(i.getCostoEnvio());
				unDto.setCantidadVendida(i.getCantidadVendida());
				unDto.setDescripcion(i.getDescripcion());
				dtos.add(unDto);
			}
			
			return dtos;
			
		} catch (Exception e) {
			throw new Exception();
		}
	}
	
	@Transactional
	public InstrumentosDTO findById (int id) throws Exception {
		Optional<Instrumentos> entidadOpcional = repository.findById(id);
		InstrumentosDTO unDto = new InstrumentosDTO();
		
		try {
			Instrumentos entidad = entidadOpcional.get();
			unDto.setId(entidad.getId());
			unDto.setInstrumento(entidad.getInstrumento());
			unDto.setMarca(entidad.getMarca());
			unDto.setModelo(entidad.getModelo());
			unDto.setImagen(entidad.getImagen());
			unDto.setCostoEnvio(entidad.getCostoEnvio());
			unDto.setCantidadVendida(entidad.getCantidadVendida());
			unDto.setDescripcion(entidad.getDescripcion());
			
			return unDto;
		} catch (Exception e) {
			throw new Exception();
		}
	}
	
	@Transactional
	public InstrumentosDTO save (InstrumentosDTO unDto) throws Exception {
		Instrumentos entidad = new Instrumentos();
		
		entidad.setInstrumento(unDto.getInstrumento());
		entidad.setMarca(unDto.getMarca());
		entidad.setModelo(unDto.getModelo());
		entidad.setImagen(unDto.getImagen());
		entidad.setCostoEnvio(unDto.getCostoEnvio());
		entidad.setCantidadVendida(unDto.getCantidadVendida());
	    entidad.setDescripcion(unDto.getDescripcion());
	    
	    try {
	    	entidad = repository.save(entidad);
	    	unDto.setId(entidad.getId());
	    	return unDto;
	    } catch (Exception e) {
	    	throw new Exception();
	    }
	}
	
	@Transactional
	public InstrumentosDTO update (int id, InstrumentosDTO unDto) throws Exception {
		Optional<Instrumentos> entidadOpcional = repository.findById(id);
		
		try {
			Instrumentos entidad = entidadOpcional.get();
			
			entidad.setId(id);
			entidad.setInstrumento(unDto.getInstrumento());
			entidad.setMarca(unDto.getMarca());
			entidad.setModelo(unDto.getModelo());
			entidad.setImagen(unDto.getImagen());
			entidad.setCostoEnvio(unDto.getCostoEnvio());
			entidad.setCantidadVendida(unDto.getCantidadVendida());
		    entidad.setDescripcion(unDto.getDescripcion());
		    repository.save(entidad);
		    
			return unDto;
		} catch (Exception e) {
			throw new Exception();
		}
		
	}
	
	@Transactional
	public boolean delete (int id) throws Exception {
		try {
			repository.deleteById(id);
			return true;
		} catch (Exception e) {
			throw new Exception();
		}
	}
	
	public void guardarImagen (MultipartFile img) throws Exception {
		String carpeta = "/imagenes/";
		try {
			byte[] bytes = img.getBytes();
			Path url = Paths.get(carpeta + img.getOriginalFilename());
			Files.write(url, bytes);
		} catch (Exception e) {
			throw new Exception();
		}
	}
	
	public void eliminarImagen (String url) throws Exception {
		try {
			Files.deleteIfExists(Paths.get(url));
		} catch (Exception e) {
			throw new Exception();
		}
	}
}
