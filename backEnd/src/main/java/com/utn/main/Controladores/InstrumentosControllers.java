package com.utn.main.Controladores;

import javax.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.utn.main.DTOS.InstrumentosDTO;
import com.utn.main.servicios.InstrumentosServicios;

@RestController
@CrossOrigin (origins = "http://localhost:8080")
@RequestMapping (path ="/api")
public class InstrumentosControllers {
	
	private InstrumentosServicios service;
	
	public InstrumentosControllers (InstrumentosServicios service) {
		this.service = service;
	}
	
	@GetMapping("/")
	@Transactional
	public ResponseEntity getAll() {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Mensaje\": \"Error al traer todos los datos.\"}");
		}
	}

	@GetMapping("/{id}")
	@Transactional
	public ResponseEntity getOne(@PathVariable int id) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"Mensaje\": \"Error al cargar el id = "+id+".\"}");
		}
	}

	@PostMapping("/")
	@Transactional
	public ResponseEntity post(@RequestBody InstrumentosDTO DTO) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(service.save(DTO));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"Mensaje\": \"Error al dar de alta este registro.\"}");
		}
	}

	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity put(@PathVariable int id, @RequestBody InstrumentosDTO DTO) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(service.update(id, DTO));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"Mensaje\": \"Error al modificar este registro.\"}");
		}
	}

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity delete(@PathVariable int id) {
		try {
			service.eliminarImagen(service.findById(id).getImagen());
			service.delete(id);
			return ResponseEntity.status(HttpStatus.OK).body("{\"Mensaje\": \"Registro borrado\"}");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"Mensaje\": \"Error al borrar este registro.\"}");
		}
	}

	
	@PostMapping("/cargarImg")
	public String cargarImg(@RequestParam("img") MultipartFile img) throws Exception {
		String valor = "";
		try {
			service.guardarImagen(img);
			valor = "..\\..\\..\\imagenes\\" + img.getOriginalFilename();
			return valor;
		} catch (Exception e) {
			throw new Exception();
		}
	}
	@DeleteMapping("/deleteImg")
	public ResponseEntity deleteImg(@PathVariable String path) {
		try {
			service.eliminarImagen(path);
			return ResponseEntity.status(HttpStatus.OK).body("{\"Mensaje\": \"Imagen borrada\"}");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"Mensaje\": \"Error al borrar esta imagen.\"}");
		}
	}
}


