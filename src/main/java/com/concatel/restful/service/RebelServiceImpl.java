package com.concatel.restful.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Component;

import com.concatel.restful.models.Rebel;

@Component
public class RebelServiceImpl implements RebelService{
	private static List<Rebel> rebels = new ArrayList<>();
	
	@Override
	public List<Rebel> getAllRebel() {
		return rebels;
	}
	
	@Override
	public Rebel getRebelById(int id) {
		for(Rebel rebel : rebels) {
			if(rebel.getId() == id) {
				return rebel;
			}
		}
		return null;
	}
	
	@Override
	public Rebel addRebel(Rebel rebel) {
		Random random = new Random();
		int nextId = random.nextInt(1000) + 10;
        
		rebel.setId(nextId);
		rebel.setDatetime(LocalDate.now());
		
		rebels.add(rebel);
		
		return rebel;
	}
	
}
