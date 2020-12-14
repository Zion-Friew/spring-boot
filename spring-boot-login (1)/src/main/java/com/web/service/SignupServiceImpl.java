package com.web.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.web.controller.vo.Signup;
import com.web.dao.SignupDaoRepository;
import com.web.dao.entity.SignupEntity;

@Service
@Transactional
public class SignupServiceImpl implements SignupService {

	//private SignupDao signupDao;
	@Autowired
	private SignupDaoRepository signupDaoRepository;

	@Override
	public void update(Signup signup) {
		SignupEntity entity=new SignupEntity();
		BeanUtils.copyProperties(signup, entity);
		signupDaoRepository.save(entity);
	}

	@Override
	public void save(Signup signup) {
		SignupEntity entity=new SignupEntity();
		BeanUtils.copyProperties(signup, entity);
		signupDaoRepository.save(entity);
		
	}

	@Override
	public void delete(String username) {
		signupDaoRepository.deleteByUsername(username);
		
	}

	@Override
	public Signup findByUsername(String username) {
		SignupEntity entity=signupDaoRepository.findByUsername(username).get();
		Signup signup=new Signup();
		BeanUtils.copyProperties(entity, signup);
		return signup;
	}

	@Override
	public List<Signup> findAll() {
		List<SignupEntity> signups=signupDaoRepository.findAll();
		List<Signup> signups2=new ArrayList<Signup>();
		//Converting List<SignupEntity> into List<Signup>
		for(SignupEntity entity :signups){
			Signup signup=new Signup();
			BeanUtils.copyProperties(entity, signup);
			signups2.add(signup);
		}
		return signups2;
	}

	@Override
	public Map<String, Object> authUser(String username, String password) {
		Optional<SignupEntity> optional=signupDaoRepository.findByUsernameAndPassword(username, password);
		 Map<String, Object>  maps=new HashMap<>();
		 if(optional.isPresent()){
			 SignupEntity signupEntity=optional.get();
			 maps.put("username", signupEntity.getUsername());
			 maps.put("email", signupEntity.getEmail());
			 maps.put("password", signupEntity.getPassword());
			 maps.put("gender", signupEntity.getGender());
			 maps.put("name", signupEntity.getName());
			 maps.put("role", signupEntity.getRole());
			 maps.put("photo", signupEntity.getPhoto());
		 }

		return maps;
	}
	
}
