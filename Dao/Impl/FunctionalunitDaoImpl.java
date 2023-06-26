package com.pennant.prodmtr.Dao.Impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;

import com.pennant.prodmtr.Dao.Interface.FunctionalunitDao;
import com.pennant.prodmtr.model.Dto.FunctionalUnitdto;
import com.pennant.prodmtr.model.Entity.FunctionalUnit;

@Component
public class FunctionalunitDaoImpl implements FunctionalunitDao {

	public FunctionalunitDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	@PersistenceContext
	private EntityManager entityManager;

	public List<FunctionalUnitdto> getFunctionalunitByModId(Integer modId) {
		TypedQuery<FunctionalUnit> query = entityManager
				.createQuery("SELECT pt FROM FunctionalUnit pt WHERE pt.id.module.id = :modl_id", FunctionalUnit.class);
		query.setParameter("modl_id", modId);
		List<FunctionalUnit> funit = query.getResultList();
		List<FunctionalUnitdto> funitlist = new ArrayList<>();

		for (FunctionalUnit functionunit : funit) {
			FunctionalUnitdto funitDTO = FunctionalUnitdto.fromEntity(functionunit);
			funitlist.add(funitDTO);
		}

		return funitlist;
	}

	public void save(FunctionalUnit funit) {
		System.out.println(funit);
		entityManager.persist(funit);

	}

}
