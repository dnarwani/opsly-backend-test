package com.opsly.assignment.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class InfoResponse {
	private String twitter;
	private String facebook;
	private String instagram;
}
