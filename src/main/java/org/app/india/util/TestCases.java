package org.app.india.util;

import org.app.india.dao.LaptopDao;
import org.app.india.dto.LaptopDto;

public class TestCases {
		public static void main(String[] args) {
			//++++++++++++++[Session Tests]++++++++++++++++
//			LaptopDto dto= new LaptopDto();
//			saveBySession(dto); 				//C
//			getBySession(1l);					//R
//			updateBySession(1l, "VivoBook 14"); //U
//			deleteBySession(2l);				//D
			
			//-----------------------------------
			
			//++++++++++++++++[HQL Tests]+++++++++++++++
//			LaptopDao dao=LaptopDao.getInstance();
			//Retrive
//			System.out.println("Retriving Data...");
//			System.out.println(dao.getDetailsById(1l));			
//			System.out.println("Cache Working Here");
//			System.out.println("---------------------------");
//			System.out.println("Retriving Data...");
//			System.out.println(dao.getDetailsById(1l));			//R
//			//Update
//			System.out.println("Updating.....");
//			dao.updateLaptopYearById(1l, 2019);					//U
			//Delete
//			System.out.println("Deleting...");
//			dao.deleteDataLaptopById(1l);						//D
		}
		public static void saveBySession(LaptopDto dto) {
			dto.setLaptopName("VivoBook 10");
			dto.setBrandName("ASUS");
			dto.setReleaseYear(2020);
			dto.setSpecification("SSD:250GB, RAM:4GB, Grpahics:Intel HD, Procceser:Intel Core i3 7th Gen");
			LaptopDao dao=LaptopDao.getInstance();
			dao.saveLaptopDetails(dto);
			System.out.println("Data Saved..");
		}
		public static void getBySession(Long id) {
			LaptopDao dao=LaptopDao.getInstance();
			System.out.println("Retriving Data...");
			System.out.println(dao.getLaptopDetailsById(id));
			System.out.println("Cache Working Here");
			System.out.println("---------------------------");
			System.out.println("Retriving Data...");
			System.out.println(dao.getLaptopDetailsById(id));
			System.out.println("Got your all data...");
		}
		public static void updateBySession(Long id,String newName) {
			LaptopDao dao=LaptopDao.getInstance();
			System.out.println("Updating Data...");
			System.out.println("-----------------------------");
			dao.updateLaptopName(id, newName);
			System.out.println("Updated");
		}
		public static void deleteBySession(Long id) {
			LaptopDao dao=LaptopDao.getInstance();
			dao.deleteLaptopById(id);
			System.out.println("************************");
			System.out.println("Data Deleted");
		}
}

