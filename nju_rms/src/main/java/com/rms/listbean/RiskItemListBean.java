package com.rms.listbean;

import java.util.ArrayList;
import java.util.List;

import com.rms.entity.Riskitem;

public class RiskItemListBean {
	List<Riskitem> riskitemList;
	public RiskItemListBean(){
		riskitemList=new ArrayList<>();
	}
	
	
	public List<Riskitem> getRiskitemList() {
		return riskitemList;
	}
	public void setRiskitemList(List<Riskitem> riskitemList) {
		this.riskitemList = riskitemList;
	}
	
	
}
