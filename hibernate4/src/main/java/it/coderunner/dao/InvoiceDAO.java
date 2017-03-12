package it.coderunner.dao;

import java.util.List;

import it.coderunner.model.Invoice;


public interface InvoiceDAO {

	public void save(Invoice i);
	
	List<Invoice> list();
}
