package com.example.base;

import javax.persistence.Transient;

public class BaseModel {

	@Transient
	private int index = 1;

	@Transient
	private int row = 10;

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}
}
