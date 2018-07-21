package cn.itcast.shop.evaluate.service;

import org.springframework.transaction.annotation.Transactional;

import cn.itcast.shop.evaluate.dao.EvaluateDao;
import cn.itcast.shop.evaluate.vo.Evaluate;
@Transactional
public class EvaluateService {
	private EvaluateDao evaluateDao;

	public void setEvaluateDao(EvaluateDao evaluateDao) {
		this.evaluateDao = evaluateDao;
	}

	public void save(Evaluate evaluate) {
		// TODO Auto-generated method stub
		evaluateDao.save(evaluate);
	}
	
}