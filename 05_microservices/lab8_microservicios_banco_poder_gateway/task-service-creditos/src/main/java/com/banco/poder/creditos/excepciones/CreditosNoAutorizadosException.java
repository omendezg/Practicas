package com.banco.poder.creditos.excepciones;

public class CreditosNoAutorizadosException extends RuntimeException {
	  private final String id;

	  public CreditosNoAutorizadosException(String message, String id) {
	    super(message);
	    this.id = id;
	  }

	  public static CreditosNoAutorizadosException from(String message, String id) {
	    return new CreditosNoAutorizadosException(message, id);
	  }

	  public String getId() {
	    return id;
	  }
}
