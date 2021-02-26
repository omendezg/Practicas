package com.segurosguadalupe.administracion.service.remote;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.segurosguadalupe.administracion.modelo.ConfirmacionDto;
import com.segurosguadalupe.administracion.modelo.ConfirmacionResumenDto;
@Component
public class SegurosServiceClientFallback implements SegurosServiceRemote {

	private Logger log = Logger.getLogger(SegurosServiceClientFallback.class);
	@Override
	public ConfirmacionResumenDto confirmacionesPoliza(ConfirmacionDto confirmaciones) {
		log.info("Error controlado, servicio de seguros no disponible, evitando TIMEOUT");
		return new ConfirmacionResumenDto();
	}
}