package com.concatel.restful.service;

import java.util.List;

import com.concatel.restful.exceptions.InvalidRebelException;
import com.concatel.restful.models.Rebel;


public interface RebelService {
		
		public List<Rebel> getAllRebel();
		
		
		public Rebel getRebelById(int id) throws InvalidRebelException;
		
		
		public Rebel addRebel(Rebel rebel);
		 
}
