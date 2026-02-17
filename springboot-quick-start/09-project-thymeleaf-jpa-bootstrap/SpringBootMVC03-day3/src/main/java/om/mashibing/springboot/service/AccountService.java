package om.mashibing.springboot.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import om.mashibing.springboot.RespStat;
import om.mashibing.springboot.entity.Account;
import om.mashibing.springboot.repository.AccountRepository;


@Service
public class AccountService {

	
	@Autowired
	AccountRepository accRep;
	
	public RespStat save(Account account) {
		// TODO Auto-generated method stub
		
		/**
		 * translatedText，idtranslatedText。
		 */
		
		try {
			Account entity = accRep.save(account);
		} catch (Exception e) {
			return new RespStat(500, "translatedText", e.getMessage());
		}
		return RespStat.build(200);
	}

	public List<Account> findAll() {
		// TODO Auto-generated method stub
		
		// translatedText

		// translatedText
		return accRep.findByIdBetween(1,6);
	//	return accRep.findAll();
		
		
	}

	public Optional<Account> findById(int id) {
		// translatedText
		return accRep.findById(id);
		
	}

	public Object findxxx() {

	//	Account account = accRep.findByLoginNameAndPassword("yimingge", "123");
		List<Account> findbyxx = accRep.findbyxx2(2);
		return findbyxx;
	}

}
