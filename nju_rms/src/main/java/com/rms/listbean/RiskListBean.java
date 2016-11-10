package com.rms.listbean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.rms.entity.Risk;

public class RiskListBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	List<Risk> riskList;
	
	public RiskListBean(){
		riskList=new ArrayList<>();
	}
	
	public List<Risk> getRiskList() {
		return riskList;
	}

	public void setRiskList(List<Risk> riskList) {
		this.riskList = riskList;
	}

}
