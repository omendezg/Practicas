package com.microservicios.monitoreo.creditos.config;

import org.apache.log4j.Logger;
import org.influxdb.InfluxDB;
import org.influxdb.InfluxDBFactory;
import org.influxdb.dto.Point;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.autoconfigure.ExportMetricWriter;
import org.springframework.boot.actuate.endpoint.MetricsEndpoint;
import org.springframework.boot.actuate.endpoint.MetricsEndpointMetricReader;
import org.springframework.boot.actuate.metrics.writer.GaugeWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

/*
 * Retention policy management

The following sections cover how to create, alter, and delete retention policies. 
Note that when you create a database, InfluxDB automatically creates a retention 
policy named autogen which has infinite retention. 
You may disable its auto-creation in the configuration file.
 */
@Configuration
public class InfluxDBConfig {

	private static final Logger log = Logger.getLogger(InfluxDBConfig.class);
	@Value("${influx.host}")
	String host;
	@Value("${influx.port}")
	Integer port;
	@Value("${influx.user}")
	String user;
	@Value("${influx.password}")
	String password;
	@Value("${influx.database}")
	String dbName;

	@Bean
	@ExportMetricWriter
	GaugeWriter influxMetricsWriter() {
		String connection = String.format("http://%s:%d", host, port);

		InfluxDB influxDB = InfluxDBFactory.connect(connection, user, password);

		try {
			if (!influxDB.databaseExists(dbName)) {
				influxDB.createDatabase(dbName);
			}
		} catch (Throwable t) {
			log.info(t.getMessage(), t);
		}

		influxDB.setDatabase(dbName);
		/*
		 * https://docs.influxdata.com/influxdb/v1.7/query_language/database_management/
		 */
		influxDB.setRetentionPolicy("autogen");
		
		/*
		 * // Enable batch writes to get better performance.
		 */
		influxDB.enableBatch(100, 30000, MILLISECONDS);
		
		/*
		 * Write points to InfluxDB.
		 */
		return value -> {
			Point point = Point.measurement(value.getName()).time(value.getTimestamp().getTime(), MILLISECONDS)
					.addField("value", value.getValue()).build();
			
			influxDB.write(point);
			log.info("Escribiendo informacion de los microservicios creditos(" + value.getName() + "): " + value.getValue());
		};
	}

	@Bean
	public MetricsEndpointMetricReader metricsEndpointMetricReader(final MetricsEndpoint metricsEndpoint) {
		return new MetricsEndpointMetricReader(metricsEndpoint);
	}
}
