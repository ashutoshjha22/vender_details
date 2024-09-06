package com.working.hours.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "working_hours")
@Data
public class WorkingHours {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private int vendor_id;
    
    @Column(nullable = false)
    private String dayOfWeek;
    
    @Column(nullable = false)
    private String openTime;
    
    @Column(nullable = false)
    private String closeTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDayOfWeek() {
		return dayOfWeek;
	}

	public void setDayOfWeek(String dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}

	public String getOpenTime() {
		return openTime;
	}

	public void setOpenTime(String openTime) {
		this.openTime = openTime;
	}

	public String getCloseTime() {
		return closeTime;
	}

	public void setCloseTime(String closeTime) {
		this.closeTime = closeTime;
	}

	
}
