package com.segurosguadalupe.service.remote;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.segurosguadalupe.api.SegurosController;
import com.segurosguadalupe.modelo.SegurosDto;
import com.segurosguadalupe.modelo.remote.AutorizacionesResumenDto;

@Component
public class AutorizacionesServiceClientFallback implements AdministracionSegurosServiceRemote {

	private static final Logger log = Logger.getLogger(SegurosController.class);

	@Override
	public AutorizacionesResumenDto solicitaAutorizacion(SegurosDto datosSeguro) {
		log.info("Error controlado, servicio de autorizaciones no disponible, evitando TIMEOUT");
		return new AutorizacionesResumenDto();
	}

}