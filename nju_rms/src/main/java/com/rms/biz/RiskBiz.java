package com.rms.biz;

import java.util.List;

import com.rms.entity.Risk;
import com.rms.entity.Riskitem;

public interface RiskBiz {
	
	public List<Risk> getRisk(String projectId);
	public List<Riskitem> getRiskItem(String projectId);

}
