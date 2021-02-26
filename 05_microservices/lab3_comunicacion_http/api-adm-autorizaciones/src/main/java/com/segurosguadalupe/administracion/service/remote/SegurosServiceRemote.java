package com.segurosguadalupe.administracion.service.remote;



import static org.springframework.web.bind.annotation.RequestMethod.PUT;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.segurosguadalupe.administracion.modelo.ConfirmacionDto;
import com.segurosguadalupe.administracion.modelo.ConfirmacionResumenDto;

@FeignClient(name = "api-seguros-guadalupe", url = "api-seguros-guadalupe:8081",fallback=SegurosServiceClientFallback.class)
public interface SegurosServiceRemote {
	
	@RequestMapping(method = PUT, value = "seguros/v1/confirmaciones", produces = "application/json")
	ConfirmacionResumenDto confirmacionesPoliza(@RequestBody ConfirmacionDto confirmaciones);

}
