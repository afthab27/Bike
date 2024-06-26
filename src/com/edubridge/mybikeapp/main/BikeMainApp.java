package com.edubridge.mybikeapp.main;

import java.util.List;
import java.util.Scanner;

import com.edubridge.mybike.model.Bike;
import com.edubridge.mybike.service.BikeServiceImpl;






public class BikeMainApp {
	public static void main(String[] args) {
		BikeServiceImpl service=new BikeServiceImpl();
	    Bike b = null;
		Scanner in = new Scanner(System.in);
		int option;
		do {
			System.out.println("welcome to Bike App");
			System.out.println("***********************");
			System.out.println("1. Add Bike");
			System.out.println("2. view Bike");
			System.out.println("3. Search Bike");
			System.out.println("4. Update Bike");
			System.out.println("5. Delete Bike");
			System.out.println("6. DeleteAll Bike");
			System.out.println("0. exit");
			System.out.println("please choose option");
			option = in.nextInt();
			switch(option) {
		case 1:
			System.out.println(" Add NEW BIKE ");
			System.out.println("-----------------");
			System.out.println("please enter id");
			int id=in.nextInt();
			System.out.println("Please enter companyname:");
			String companyname = in.next();
			System.out.println("please enter bodytype:");
			String bodytype = in.next();
			System.out.println("please enter modelname");
			String modelname =in.next();
			System.out.println("please enter price");
			int price=in.nextInt();
			b=new Bike();
			b.setCompanyname(companyname);
			b.setBodytype(bodytype);
			b.setModelname(modelname);
			b.setPrice(price);
			
			int status =service.addBike(b);
			if(status==1) {
				System.out.println("New Bike added!");

			}else {
				System.out.println("something is wrong!");

			}

			break;
		case 2:
			System.out.println("view All bikes");
			List<Bike> bikes=service.findbikes();
			System.out.println("COMPANYNAME\tBODYTYPE\tMOMDELNAME\tPRICE");
			System.out.println("-----------\t---------\t----------\t\t-------");

			for(Bike bike:bikes) {
				System.out.println(bike.getCompanyname()+"\t"+bike.getBodytype()+"\t"+bike.getModelname()+"\t"+bike.getPrice());

			}
			break;
		case 3:
			System.out.println("search bike");
			System.out.println("please enter bike  companyname");
			String searchName=in.next();
			Bike searchBike=service.findBikeByName(searchName);
			if(searchBike !=null) {
				System.out.println("ID: "+searchBike.getId());
				System.out.println("CompanyName: "+searchBike.getCompanyname());
				System.out.println("Bodytype: "+searchBike.getBodytype());
				System.out.println("modelname: "+searchBike.getModelname());
				System.out.println("price: "+searchBike.getPrice());

			}else {
				System.out.println("No contact found!");
			}
			break;
		case 4:
			System.out.println("please enter bike name:");
			searchName=in.next();				
			searchBike=service.findBikeByName(searchName);
			
			if(searchBike !=null) {
				//displaying existing contact details
				System.out.println("ID: "+searchBike.getId());
				System.out.println("CompanyName: "+searchBike.getCompanyname());
				System.out.println("Bodytype: "+searchBike.getBodytype());
				System.out.println("modelname: "+searchBike.getModelname());
				System.out.println("price: "+searchBike.getPrice());
								
				//reading contact update info
				
				System.out.println("please enter update companyname:");
			    companyname=in.next();
				System.out.println("please enter update bodytype:");
				bodytype=in.next();
				System.out.println("please enter update modelname:");
				modelname=in.next();
				System.out.println("please enter update price:");
			    price=in.nextInt();
				
				
				Bike updateBike=new Bike();
				
                updateBike.setCompanyname(companyname);
                updateBike.setBodytype(bodytype);
                updateBike.setModelname(modelname);
                updateBike.setPrice(price);
                updateBike.setId(searchBike.getId());
                
                int updateStatus =service.updateBike(updateBike);
                if(updateStatus ==1) {
                	System.out.println("Bike updated successfully");
                }else {
                	System.out.println("something is wrong !");
                }
				
			}else {
				System.out.println("Bike not found with name");
			}
			break;
		case 5:
			System.out.println("delete bike");
			System.out.println("please enter  companyname:");
			searchName=in.next();
			searchBike =service.findBikeByName(searchName);
			if(searchBike !=null) {
				int deleteStatus=service.deleteBikeByName(searchName);
				if(deleteStatus==1) {
					System.out.println("Bike deleted successfully");
				}else {
					System.out.println("something went wrong");

				}
			}
			break;
		
		case 6:
			System.out.println("Are you sure deleteAll bike?[Y/N]");
			String deleteConfirmStatus=in.next();
			if(deleteConfirmStatus.equalsIgnoreCase("Y")) {
				service.deleteAllBikes();
				System.out.println("All bikes deleted");
			}

			


			
			}
		}while (option != 0);
	}
}




