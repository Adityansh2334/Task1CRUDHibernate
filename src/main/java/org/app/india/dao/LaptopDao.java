package org.app.india.dao;

import org.app.india.dto.LaptopDto;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class LaptopDao {
		private static LaptopDao dao=null;
		private Configuration configuration=null;
		private SessionFactory factory=null;
		
		private LaptopDao() {
			configuration=new Configuration();
			configuration.configure();
			factory=configuration.buildSessionFactory();
		}
		public static LaptopDao getInstance() {
			if(dao==null) {
				dao=new LaptopDao();
				return dao;
			}
			return dao;
		}
		//SESSION METHODS--- CRUD OPERATIONS
		public void saveLaptopDetails(LaptopDto dto) {
			Session openSession = factory.openSession();
			Transaction beginTransaction = openSession.beginTransaction();
			openSession.save(dto);
			beginTransaction.commit();
			openSession.close();
		}
		public LaptopDto getLaptopDetailsById(Long id) {
			Session openSession = factory.openSession();
			LaptopDto laptopDto = openSession.get(LaptopDto.class, id);
			openSession.close();
			return laptopDto;
		}
		public void updateLaptopName(Long id,String newLaptopName) {
			LaptopDto dto = getLaptopDetailsById(id);
			if(dto!=null) {
			Session openSession = factory.openSession();
			Transaction beginTransaction = openSession.beginTransaction();
			dto.setLaptopName(newLaptopName);
			openSession.update(dto);
			beginTransaction.commit();
			openSession.close();
			}
			else System.out.println("Invalid");
		}
		public void deleteLaptopById(Long id) {
			LaptopDto lp = getLaptopDetailsById(id);
			if(lp!=null) {
			Session openSession = factory.openSession();
			Transaction beginTransaction = openSession.beginTransaction();
			openSession.delete(lp);
			beginTransaction.commit();
			openSession.close();
			}
			else System.out.println("Invalid");
		}
		
		//HQL METHODS--- RUD OPERATIONS
		@SuppressWarnings("unchecked")
		public void updateLaptopYearById(Long id,Integer year) {
			Session openSession = factory.openSession();
			Transaction beginTransaction = openSession.beginTransaction();
			String hql="update "+LaptopDto.class.getName()+" set releaseYear=:yr where id=:id";
			Query<LaptopDto> createQuery = openSession.createQuery(hql);
			createQuery.setParameter("yr", year).setParameter("id", id);
			int executeUpdate = createQuery.executeUpdate();
			if(executeUpdate>0) {
				System.out.println("Updated");
			}
			else System.out.println("Can't Update...");
			beginTransaction.commit();
			openSession.close();
		}
		@SuppressWarnings("unchecked")
		public LaptopDto getDetailsById(Long id) {
			String hql="from "+LaptopDto.class.getName()+" where id=:id";
			Query<LaptopDto> createQuery = factory.openSession().createQuery(hql);
			createQuery.setParameter("id", id).setCacheable(true);
			return createQuery.uniqueResult();
		}
		@SuppressWarnings("unchecked")
		public void deleteDataLaptopById(Long id) {
			Session openSession = factory.openSession();
			Transaction beginTransaction = openSession.beginTransaction();
			String hql="delete "+LaptopDto.class.getName()+" where id=:id";
			Query<LaptopDto> createQuery = openSession.createQuery(hql);
			createQuery.setParameter("id", id);
			int executeUpdate = createQuery.executeUpdate();
			if(executeUpdate>0) {
				System.out.println("Deleted");
			}
			else System.out.println("Can't Delete..");
			beginTransaction.commit();
			openSession.close();
		
		}
}
