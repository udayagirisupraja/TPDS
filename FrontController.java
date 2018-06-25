package com.bvrit.tpds.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.bvrit.tpds.dao.AdminDAO;
import com.bvrit.tpds.dao.CitizenDAO;
import com.bvrit.tpds.dao.CitizenGoodsDAO;
import com.bvrit.tpds.dao.DealerDAO;
import com.bvrit.tpds.dao.DealerGoodsDAO;
import com.bvrit.tpds.dao.DistrctDAO;
import com.bvrit.tpds.dao.FamilyMembersDAO;
import com.bvrit.tpds.dao.SubsidaryGoodsDAO;
import com.bvrit.tpds.dao.WardDAO;
import com.bvrit.tpds.dbutility.DBConnection;
import com.bvrit.tpds.dto.Admin;
import com.bvrit.tpds.dto.Citizen;
import com.bvrit.tpds.dto.CitizenGoods;
import com.bvrit.tpds.dto.Dealer;
import com.bvrit.tpds.dto.DealerGoods;
import com.bvrit.tpds.dto.District;
import com.bvrit.tpds.dto.FamilyMembers;
import com.bvrit.tpds.dto.SubsidaryGoods;
import com.bvrit.tpds.dto.Ward;

@WebServlet("/FrontController")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, maxFileSize = 1024 * 1024 * 10,maxRequestSize = 1024 * 1024 * 50, 
location = "C:\\javaproject\\TPDS_Final\\TPDS\\WebContent\\images")

public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String action=request.getParameter("action");
		
		System.out.println("\n" + action + "\n");

		
		response.setContentType("text/html");
		out.println("<html>");
		
		if ("AdminLogin".equalsIgnoreCase(action)) {
			String userName = request.getParameter("userName");
			String pwd = request.getParameter("pwd");
			AdminDAO adminDao = new AdminDAO();
		    Admin admin = new Admin();
		    admin = adminDao.getDetails(userName, pwd);
		    
			HttpSession session=request.getSession();
			session.setAttribute("userName", userName);
			
			DistrctDAO districtDao = new DistrctDAO();
			List<District> districtList = new ArrayList<District>();
			districtList = districtDao.getAll();
			request.setAttribute("districts", districtList);	
			
			System.out.println("\n" + districtList + "\n");
			
			if(userName.equalsIgnoreCase(admin.getUserName()) && pwd.equals(admin.getPassword())){
				RequestDispatcher dispatcher=request.getRequestDispatcher("AdminHomePage.jsp");	
				dispatcher.include(request, response);
			} else {
				out.println("<body text=red> Invalid credentials.!</body>");
				RequestDispatcher dispatcher=request.getRequestDispatcher("tpds.html");
				dispatcher.include(request, response);		
			}
			out.println("</html>");
			return;
		} else if ("CitizenLogin".equalsIgnoreCase(action)) {
			String aadharId = request.getParameter("aadharId");
			String pwd = request.getParameter("pwd");
			CitizenDAO citizenDao = new CitizenDAO();
		    Citizen citizen = new Citizen();
		    citizen = citizenDao.getDetails(aadharId);
		    
			HttpSession session=request.getSession();
			session.setAttribute("citizenAaadharId", aadharId);
		    
			if(aadharId.equals(citizen.getAadharId()) && pwd.equals(citizen.getPassword())) {
				RequestDispatcher dispatcher=request.getRequestDispatcher("citizenpage.jsp");	
				dispatcher.include(request, response);
			} else{
				out.println("<body text=red> Invalid credentials.!</body>");
				RequestDispatcher dispatcher=request.getRequestDispatcher("tpds.html");
				dispatcher.include(request, response);		
			}
			out.println("</html>");
			return;
		} else if ("DealerLogin".equalsIgnoreCase(action)) {
			String aadharId = request.getParameter("aadharId");
			String pwd = request.getParameter("pwd");
			DealerDAO dealerDao = new DealerDAO();
		    Dealer dealer = new Dealer();
		    dealer = dealerDao.isExists(aadharId,pwd);
			HttpSession session=request.getSession();
			session.setAttribute("dealerAaadharId", aadharId);
		    
			if(aadharId.equals(dealer.getAadharId())&& pwd.equals(dealer.getPassword())) {
				RequestDispatcher dispatcher=request.getRequestDispatcher("dealerpage.jsp");	
				dispatcher.include(request, response);
			} else{
				out.println("<body text=red> Invalid credentials.!</body>");
				RequestDispatcher dispatcher=request.getRequestDispatcher("tpds.html");
				dispatcher.include(request, response);		
			}
			out.println("</html>");
			return;
		} else if ("AdminRegister".equalsIgnoreCase(action)) {
			String userName = request.getParameter("userName");
			String pwd = request.getParameter("pwd");
			AdminDAO adminDao = new AdminDAO();
		    Admin admin = new Admin(userName,pwd);
		    adminDao.add(admin);
		    RequestDispatcher dispatcher=request.getRequestDispatcher("tpds.html");
		   	dispatcher.forward(request, response);		
			return;
		} else if ("DealerRegister".equalsIgnoreCase(action)) {			
			String aadharId = request.getParameter("aadharId");
			String fname = request.getParameter("fname");
			String lname = request.getParameter("lname");
			String dob = request.getParameter("dob");		
			int age = Integer.parseInt(request.getParameter("age"));
			String gender = request.getParameter("gender");
			String phoneNo = request.getParameter("phoneNo");
			String email = request.getParameter("email");
			String wardId = request.getParameter("wardid");
			Part part = request.getPart("picture");
			String fileName = DBConnection.getFileName(part);
			String status = "status";
			part.write(fileName);	
			String pwd = request.getParameter("pwd");
			DealerDAO dealerDao = new DealerDAO();
			WardDAO wardDao = new WardDAO();
			Ward ward = new Ward();
			ward = wardDao.getDetails(wardId);
			//System.out.println("\n\n inside dealer register" + ward);
		    Dealer dealer= new Dealer(aadharId,fname,lname,phoneNo,email,gender,DBConnection.getUtilDate(dob),age,ward,fileName,pwd,status);  		    
		    dealerDao.add(dealer);    
		    RequestDispatcher dispatcher=request.getRequestDispatcher("tpds.html");
		   	dispatcher.forward(request, response);	
			return;
		} else if ("CitizenRegister".equalsIgnoreCase(action)) {
			String aadharId = request.getParameter("aadhar");
			String fname = request.getParameter("fname");
			String lname = request.getParameter("lname");
			String dob = request.getParameter("dob");
			int age = Integer.parseInt(request.getParameter("age"));
			String gender = request.getParameter("gender");
			String phoneNo = request.getParameter("phoneNo");
			String email = request.getParameter("email");
			String occupation = request.getParameter("oname");
			double income = Double.parseDouble(request.getParameter("income"));
			int noOfmem= Integer.parseInt(request.getParameter("nname"));
			String status = "status";
			Part part = request.getPart("myfile");
			String fileName = DBConnection.getFileName(part);
			part.write(fileName);
			String pwd = request.getParameter("pwd");
			String wardId = request.getParameter("wardId");

			CitizenDAO citizenDao = new CitizenDAO();
			Citizen citizen = new Citizen(aadharId,fname,lname,income,phoneNo,email,DBConnection.getUtilDate(dob),age,gender,noOfmem,occupation,fileName,pwd,status,wardId);
			citizenDao.add(citizen);
		    RequestDispatcher dispatcher=request.getRequestDispatcher("tpds.html");
		   	dispatcher.forward(request, response);		
			return;
		} else if ("DealerProfileEdit".equalsIgnoreCase(action)) {
			String aadharId = request.getParameter("aadharId");
			String fname = request.getParameter("fname");
			String lname = request.getParameter("lname");
			String dob = request.getParameter("dob");		
			int age = Integer.parseInt(request.getParameter("age"));
			String gender = request.getParameter("gender");
			String phoneNo = request.getParameter("phoneNo");
			String email = request.getParameter("email");
			String wardId = request.getParameter("wardid");
			Part part = request.getPart("picture");
			String fileName = DBConnection.getFileName(part);
			String status = "status";
			part.write(fileName);	
			String pwd = request.getParameter("pwd");
			DealerDAO dealerDao = new DealerDAO();
			WardDAO wardDao = new WardDAO();
			Ward ward = new Ward();
			ward = wardDao.getDetails(wardId);
		    Dealer dealer= new Dealer(aadharId,fname,lname,phoneNo,email,gender,DBConnection.getUtilDate(dob),age,ward,fileName,pwd,status);  		    
		    dealerDao.update(dealer);    
		    RequestDispatcher dispatcher=request.getRequestDispatcher("dealeredit.jsp");
		   	dispatcher.include(request, response);	
			return;			
		} else if ("AddFamilyMembers".equalsIgnoreCase(action)) {
			String memAadharId = request.getParameter("aadhar");
			String fname = request.getParameter("fname");
			String lname = request.getParameter("lname");
			String dob = request.getParameter("dob");
			int age = Integer.parseInt(request.getParameter("age"));
			String gender = request.getParameter("gender");
			String occupation = request.getParameter("oname");
			String aadharId;
			HttpSession session=request.getSession();
			aadharId = (String) session.getAttribute("citizenAaadharId");			
			CitizenDAO citizenDao = new CitizenDAO();
			Citizen citizen = new Citizen();
			citizen = citizenDao.getDetails(aadharId);
			FamilyMembersDAO  fmDao = new FamilyMembersDAO();
			FamilyMembers fm = new FamilyMembers(memAadharId,fname,lname,age,DBConnection.getUtilDate(dob),gender,occupation,citizen);
			fmDao.add(fm);			
		    RequestDispatcher dispatcher=request.getRequestDispatcher("citizenpage.jsp");
		   	dispatcher.forward(request, response);		
			return;
		}  else if("GotoCitizenHomePage".equalsIgnoreCase(action)) {
		    RequestDispatcher dispatcher=request.getRequestDispatcher("citizenpage.jsp");
		   	dispatcher.forward(request, response);		
			return;
		} else if ("CitizenEdit".equalsIgnoreCase(action)) {
			HttpSession session=request.getSession();
			String citizenAadharId = (String) session.getAttribute("citizenAaadharId");			
			Citizen citizen = new CitizenDAO().getDetails(citizenAadharId);
			request.setAttribute("CitizenData", citizen);			
		    RequestDispatcher dispatcher=request.getRequestDispatcher("CitizenProfileEdit.jsp");
		   	dispatcher.include(request, response);		
			return;
		} else if ("CitizenProfileEdit".equalsIgnoreCase(action)) {	
			String aadharId = request.getParameter("aadhar");
			String fname = request.getParameter("fname");
			String lname = request.getParameter("lname");
			String dob = request.getParameter("dob");
			int age = Integer.parseInt(request.getParameter("age"));
			String gender = request.getParameter("gender");
			String phoneNo = request.getParameter("phoneNo");
			String occupation = request.getParameter("oname");
	        String email = request.getParameter("email");
	        Double income = Double.parseDouble(request.getParameter("income"));
	        int noOfMem = Integer.parseInt(request.getParameter("nname"));
	        String pwd = request.getParameter("pwd");
	        String wardId = request.getParameter("wardId");
			Part part = request.getPart("pname");
			String status = "status";
			String photo = DBConnection.getFileName(part);
			part.write(photo);
			CitizenDAO citizenDao = new CitizenDAO();
			Citizen citizen = new Citizen(aadharId,fname,lname,income,phoneNo,email,DBConnection.getUtilDate(dob),age,gender,noOfMem,occupation,photo,pwd,status,wardId);

			citizenDao.update(citizen);
		    RequestDispatcher dispatcher=request.getRequestDispatcher("citizenpage.jsp");
		   	dispatcher.include(request, response);		
			return;
		} else if ("DealerEdit".equalsIgnoreCase(action)) {
			HttpSession session=request.getSession();
			String dealerAadharId = (String) session.getAttribute("dealerAaadharId");			
			Dealer dealer = new DealerDAO().getDealer(dealerAadharId);
			request.setAttribute("DealerData", dealer);			
		    RequestDispatcher dispatcher=request.getRequestDispatcher("dealeredit.jsp");
		   	dispatcher.include(request, response);			
		   	return;
		} else if("GotoDealerPage".equalsIgnoreCase(action)) {
		    RequestDispatcher dispatcher=request.getRequestDispatcher("dealerpage.jsp");
		   	dispatcher.forward(request, response);				
			return;
		} else if("FamilyMemberEdit".equalsIgnoreCase(action)) {
			String memAadharId = request.getParameter("aadhar");
			String fname = request.getParameter("fname");
			String lname = request.getParameter("lname");
			String dob = request.getParameter("dob");
			int age = Integer.parseInt(request.getParameter("age"));
			String gender = request.getParameter("gender");
			String occupation = request.getParameter("oname");
			String aadharId;
			HttpSession session=request.getSession();
			aadharId = (String) session.getAttribute("citizenAaadharId");			
			CitizenDAO citizenDao = new CitizenDAO();
			Citizen citizen = new Citizen();
			citizen = citizenDao.getDetails(aadharId);
			FamilyMembersDAO  fmDao = new FamilyMembersDAO();
			FamilyMembers fm = new FamilyMembers(memAadharId,fname,lname,age,DBConnection.getUtilDate(dob),gender,occupation,citizen);
			fmDao.update(fm);			
		    RequestDispatcher dispatcher=request.getRequestDispatcher("FamilyMemberEdit.jsp");
		   	dispatcher.include(request, response);			
		   	return;
		}else if("FamilyMemberDelete".equalsIgnoreCase(action)) {
			String memAadharId = request.getParameter("aadhar");			
			FamilyMembersDAO familyMembersDao = new FamilyMembersDAO();
			familyMembersDao.delete(memAadharId);
		    RequestDispatcher dispatcher=request.getRequestDispatcher("FamilyMemberEdit.jsp");
		   	dispatcher.include(request, response);	
			return;
		} else if("DisplayWards".equalsIgnoreCase(action)) {
			String dstId = request.getParameter("districtId");
			List<Ward> wardList = new ArrayList<Ward>();
			WardDAO wardDao = new WardDAO();
	        wardList = wardDao.getAll(dstId);
			request.setAttribute("wards", wardList);	
			DistrctDAO districtDao = new DistrctDAO();
			List<District> districtList = new ArrayList<District>();
			districtList = districtDao.getAll();
			request.setAttribute("districts", districtList);
			RequestDispatcher dispatcher=request.getRequestDispatcher("AdminHomePage.jsp");	
			dispatcher.include(request, response);
			return;
		} else if("LogOut".equalsIgnoreCase(action)) {
		    response.sendRedirect("tpds.html"); 
		} else if ("AddWardGoods".equalsIgnoreCase(action)) {
			String name = request.getParameter("pname");
			String qty = request.getParameter("qty");
			Double price = Double.parseDouble(request.getParameter("price"));
			Double priceFor = Double.parseDouble(request.getParameter("priceFor"));
		   HttpSession session=request.getSession();
		   String wardId = (String) session.getAttribute("wardId");
			//String wardId = request.getParameter("wardId");
			

			String pId = request.getParameter("pId");
			Dealer dealer = new Dealer();
			DealerDAO dDao = new DealerDAO();
			dealer = dDao.getDetails(wardId);			
			DealerGoods dGoods = new DealerGoods(name,pId,qty,price,dealer,priceFor);
			DealerGoodsDAO dealerGoodsDao = new DealerGoodsDAO();
			dealerGoodsDao.add(dGoods);
			String aadharId = dealer.getAadharId();
			List<DealerGoods> dgoods = new ArrayList<DealerGoods>();
			dgoods = dealerGoodsDao.getAll(aadharId);
			request.setAttribute("dealerGoods", dgoods);
		    RequestDispatcher dispatcher=request.getRequestDispatcher("Wardgoods.jsp");
		   	dispatcher.forward(request, response);
		} else if ("AddAdminGoods".equalsIgnoreCase(action)) {
			SubsidaryGoodsDAO  sbDao = new SubsidaryGoodsDAO();			
			String name = request.getParameter("pname");
			String qty = request.getParameter("qty");
			HttpSession session=request.getSession();
			String uname = (String) session.getAttribute("userName");
			Admin admin = new Admin();
			admin.setUserName(uname);
			Double price = Double.parseDouble(request.getParameter("price"));
			Double priceFor = Double.parseDouble(request.getParameter("priceFor"));
			SubsidaryGoods sbGoods = new SubsidaryGoods(name,qty,admin,price,priceFor);	
			sbDao.add(sbGoods);		
			
			List<SubsidaryGoods> adgoods = new ArrayList<SubsidaryGoods>();
			adgoods = sbDao.getAll();
			request.setAttribute("adminGoods",adgoods);
		    RequestDispatcher dispatcher=request.getRequestDispatcher("Admingoods.jsp");
		   	dispatcher.forward(request, response);	
		   	return;
		} else if("addDistricts".equalsIgnoreCase(action)) {
			DistrctDAO districtDAO = new DistrctDAO();
			String name = request.getParameter("dname");
			String id = request.getParameter("did");
			District district = new District();
			HttpSession session=request.getSession();
			String uname = (String) session.getAttribute("userName");
			AdminDAO adminDao = new AdminDAO();
			Admin admin = new Admin();
			admin = adminDao.getDetails(uname);
			district.setDistrictId(id);
			district.setName(name);
			district.setUserName(admin);
			districtDAO.add(district);
		    RequestDispatcher dispatcher=request.getRequestDispatcher("AdminHomePage.jsp");
		   	dispatcher.include(request, response);			
		} else if("addWards".equalsIgnoreCase(action)) {
			WardDAO wardDAO = new WardDAO();
			String name = request.getParameter("wname");
			String id = request.getParameter("wid");
			String dstid = request.getParameter("dstid");
			DistrctDAO districtDAO = new DistrctDAO();
			District district = new District();
			district = districtDAO.getDetails(dstid);
			Ward ward = new Ward();
			ward.setwardId(id);
			ward.setDistrictId(district);
			ward.setname(name);
			wardDAO.add(ward);
		    RequestDispatcher dispatcher=request.getRequestDispatcher("AdminHomePage.jsp");
		   	dispatcher.include(request, response);	
		   	return;
		} else if ("AddCitizenGoods".equalsIgnoreCase(action)) {
			String name = request.getParameter("pname");
			String qty = request.getParameter("qty");
			Double priceFor = Double.parseDouble(request.getParameter("priceFor"));
			String pId = request.getParameter("pId");
			 HttpSession session=request.getSession();
			String citizenAadharId = (String) session.getAttribute("citAadhar");

			Citizen citizen = new CitizenDAO().getDetails(citizenAadharId);
			CitizenGoods cGoods = new CitizenGoods();
			Dealer dealer = new Dealer();
			DealerDAO dealerDAO = new DealerDAO();
			dealer = dealerDAO.getDetails(citizen.getWardId());
			cGoods.setProductName(name);
			cGoods.setQty(qty);
			cGoods.setPrice(priceFor);
			cGoods.setProductId(pId);
			cGoods.setAadharId(citizen);
			DealerGoodsDAO dGoodsDao = new DealerGoodsDAO();
			DealerGoods dGoods = new DealerGoods();
			dGoods = dGoodsDao.getDetails(dealer.getAadharId());
			cGoods.setSerialNo(dGoods);
			CitizenGoodsDAO cDao = new CitizenGoodsDAO();
			cDao.add(cGoods);
			
			List<CitizenGoods> cgoods = new ArrayList<CitizenGoods>();
			CitizenGoodsDAO citizenGoodsDao = new CitizenGoodsDAO();
			cgoods = citizenGoodsDao.getAll(citizenAadharId);
			request.setAttribute("citizenGoods", cgoods);
			
		    RequestDispatcher dispatcher=request.getRequestDispatcher("distribute.jsp");
		   	dispatcher.forward(request, response);
		} else {
			out.println("<body text=red> Invalid credentials.!</body>");
			RequestDispatcher dispatcher=request.getRequestDispatcher("tpds.html");
			dispatcher.include(request, response);		
			out.println("</html>");
			return;
		}
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		System.out.println("\n" + action + "\n");

		if("AdminRegister".equalsIgnoreCase(action)) {
			RequestDispatcher dispatcher=request.getRequestDispatcher("adminRegister.jsp");	
			dispatcher.forward(request, response);		
			return;
		} else if("DealerRegister".equalsIgnoreCase(action)) {
			RequestDispatcher dispatcher=request.getRequestDispatcher("dealerRegister.jsp");	
			dispatcher.forward(request, response);
			return;
		} else if("CitizenRegister".equalsIgnoreCase(action)) {
			RequestDispatcher dispatcher=request.getRequestDispatcher("citizenRegister.jsp");	
			dispatcher.forward(request, response);
			return;
		} else if ("FamilyMembersDisplay".equalsIgnoreCase(action)) {
			HttpSession session=request.getSession();
			String citizenAadharId = (String) session.getAttribute("citizenAaadharId");	
			List<FamilyMembers> fm = new ArrayList<FamilyMembers>();
			fm = new FamilyMembersDAO().getAll(citizenAadharId);
			request.setAttribute("FamilyMembers", fm);					
			RequestDispatcher rd = request.getRequestDispatcher("NOOfMembers.jsp");
			rd.include(request, response);
			return;
		} else if ("DisplayFamilyMember".equalsIgnoreCase(action)){
			HttpSession session=request.getSession();
			String citizenAadharId = (String) session.getAttribute("citizenAaadharId");	
			Citizen dealer = new CitizenDAO().getDetails(citizenAadharId);
			request.setAttribute("FamilyMembersData", dealer);			
			RequestDispatcher rd = request.getRequestDispatcher("FamilyMemberDisplay.jsp");
			rd.include(request, response);
			return;
		}  else if ("AddFamilyMember".equalsIgnoreCase(action)) {
			HttpSession session=request.getSession();
			String citizenAadharId = (String) session.getAttribute("citizenAaadharId");	
			Citizen dealer = new CitizenDAO().getDetails(citizenAadharId);
			request.setAttribute("FamilyMembersData", dealer);			
			RequestDispatcher rd = request.getRequestDispatcher("AddFamilyMembers.jsp");
			rd.include(request, response);		
			return;
		} else if ("CitizenProfileDisplay".equalsIgnoreCase(action)) {
			HttpSession session=request.getSession();
			String citizenAadharId = (String) session.getAttribute("citizenAaadharId");			
			Citizen citizen = new CitizenDAO().getDetails(citizenAadharId);
			request.setAttribute("CitizenData", citizen);			
			RequestDispatcher rd = request.getRequestDispatcher("CitizenProfileDisplay.jsp");
			rd.include(request, response);
			return;
		} else if ("CitizenEdit".equalsIgnoreCase(action)) {
			HttpSession session=request.getSession();
			String citizenAadharId = (String) session.getAttribute("citizenAaadharId");			
			Citizen citizen = new CitizenDAO().getDetails(citizenAadharId);
			request.setAttribute("CitizenData", citizen);			
		    RequestDispatcher dispatcher=request.getRequestDispatcher("CitizenProfileEdit.jsp");
		   	dispatcher.include(request, response);		
			return;
		} else if ("AddFamilyMembers".equalsIgnoreCase(action)) {
			String memAadharId = request.getParameter("aadhar");
			String fname = request.getParameter("fname");
			String lname = request.getParameter("lname");
			String dob = request.getParameter("dob");
			int age = Integer.parseInt(request.getParameter("age"));
			String gender = request.getParameter("gender");
			String occupation = request.getParameter("oname");
			String aadharId;
			HttpSession session=request.getSession();
			aadharId = (String) session.getAttribute("citizenAaadharId");			
			CitizenDAO citizenDao = new CitizenDAO();
			Citizen citizen = new Citizen();
			citizen = citizenDao.getDetails(aadharId);
			FamilyMembersDAO  fmDao = new FamilyMembersDAO();
			FamilyMembers fm = new FamilyMembers(memAadharId,fname,lname,age,DBConnection.getUtilDate(dob),gender,occupation,citizen);
			fmDao.add(fm);			
		    RequestDispatcher dispatcher=request.getRequestDispatcher("citizenpage.jsp");
		   	dispatcher.include(request, response);		
			return;
		} else if ("DealerProfileDisplay".equalsIgnoreCase(action)) {
			HttpSession session=request.getSession();
			String dealerAadharId = (String) session.getAttribute("dealerAaadharId");		
			Dealer dealer = new DealerDAO().getDealer(dealerAadharId);
			request.setAttribute("DealerData", dealer);			
			RequestDispatcher rd = request.getRequestDispatcher("dealerDisplay.jsp");
			rd.include(request, response);
			return;
		} else if ("DealerEdit".equalsIgnoreCase(action)) {
			HttpSession session=request.getSession();
			String dealerAadharId = (String) session.getAttribute("dealerAaadharId");			
			Dealer dealer = new DealerDAO().getDealer(dealerAadharId);
			request.setAttribute("DealerData", dealer);			
		    RequestDispatcher dispatcher=request.getRequestDispatcher("dealeredit.jsp");
		   	dispatcher.include(request, response);		
			return;
		} else if("addDistricts".equalsIgnoreCase(action)) {
			DistrctDAO districtDAO = new DistrctDAO();
			String name = request.getParameter("dname");
			String id = request.getParameter("did");
			District district = new District();
			HttpSession session=request.getSession();
			String uname = (String) session.getAttribute("userName");
			AdminDAO adminDao = new AdminDAO();
			Admin admin = new Admin();
			admin = adminDao.getDetails(uname);
			district.setDistrictId(id);
			district.setName(name);
			district.setUserName(admin);
			districtDAO.add(district);
		    RequestDispatcher dispatcher=request.getRequestDispatcher("AdminHomePage.jsp");
		   	dispatcher.include(request, response);			
		} else if("addWards".equalsIgnoreCase(action)) {
			WardDAO wardDAO = new WardDAO();
			String name = request.getParameter("wname");
			String id = request.getParameter("wid");
			String dstid = request.getParameter("dstid");
			DistrctDAO districtDAO = new DistrctDAO();
			District district = new District();
			district = districtDAO.getDetails(dstid);
			Ward ward = new Ward();
			ward.setwardId(id);
			ward.setDistrictId(district);
			ward.setname(name);
			wardDAO.add(ward);
		    RequestDispatcher dispatcher=request.getRequestDispatcher("AdminHomePage.jsp");
		   	dispatcher.include(request, response);	
		   	return;
		} else if("viewDistricts".equalsIgnoreCase(action)) {
			DistrctDAO districtDAO = new DistrctDAO();
			List<District> dstList = new ArrayList<District>();
			dstList = districtDAO.getAll();
			request.setAttribute("dstList", dstList);
		    RequestDispatcher dispatcher=request.getRequestDispatcher("viewDistricts.jsp");
		   	dispatcher.forward(request, response);	
		   	return;
		} else if ("viewWards".equalsIgnoreCase(action)) {
			WardDAO wardDAO = new WardDAO();
			List<Ward> wdList = new ArrayList<Ward>();
			wdList = wardDAO.getAll();
			request.setAttribute("wdList", wdList);
			

		    RequestDispatcher dispatcher=request.getRequestDispatcher("viewWards.jsp");
		   	dispatcher.forward(request, response);	
		   	return;
		} else if("LogOut".equalsIgnoreCase(action)) {
		    response.sendRedirect("tpds.html"); 
		} else if ("AdminGoodsDisplay".equalsIgnoreCase(action)) {
			List<SubsidaryGoods> adgoods = new ArrayList<SubsidaryGoods>();
			SubsidaryGoodsDAO subsidaryGoodsDao = new SubsidaryGoodsDAO();
			adgoods = subsidaryGoodsDao.getAll();
			request.setAttribute("adminGoods", adgoods);
		    RequestDispatcher dispatcher=request.getRequestDispatcher("Admingoods.jsp");
		   	dispatcher.forward(request, response);
		}  else if ("AddDealerGoods".equalsIgnoreCase(action)) {
			String name = request.getParameter("pname");
			String qty = request.getParameter("qty");
			Double price = Double.parseDouble(request.getParameter("price"));
			Double priceFor = Double.parseDouble(request.getParameter("priceFor"));
			String wardId = request.getParameter("wId");
			String pId = request.getParameter("pId");
			Dealer dealer = new Dealer();
			DealerDAO dDao = new DealerDAO();
			dealer = dDao.getDealer(wardId);
			DealerGoods dGoods = new DealerGoods(name,pId,qty,price,dealer,priceFor);
			DealerGoodsDAO dealerGoodsDao = new DealerGoodsDAO();
			dealerGoodsDao.add(dGoods);
			List<DealerGoods> dgoods = new ArrayList<DealerGoods>();
			request.setAttribute("dealerGoods", dgoods);
		    RequestDispatcher dispatcher=request.getRequestDispatcher("Wardgoods.jsp");
		   	dispatcher.forward(request, response);
		} else if ("DealerGoodsDisplay".equalsIgnoreCase(action)) {
			HttpSession session=request.getSession();
			String dealerAadharId = (String) session.getAttribute("dealerAaadharId");			
			List<DealerGoods> dgoods = new ArrayList<DealerGoods>();
			DealerGoodsDAO dealerGoodsDao = new DealerGoodsDAO();
			dgoods = dealerGoodsDao.getAll(dealerAadharId);
			request.setAttribute("dealerGoods", dgoods);
		    RequestDispatcher dispatcher=request.getRequestDispatcher("dealergoods.jsp");
		   	dispatcher.forward(request, response);
		} else if ("WardGoodsDisplay".equalsIgnoreCase(action)) {
			String wardId = request.getParameter("wardId");
			
			HttpSession session=request.getSession();
			session.setAttribute("wardId", wardId);
			DealerDAO  dealerDao = new DealerDAO();
			Dealer dealer = new Dealer();
			dealer = dealerDao.getDetails(wardId);
			String aadharId = dealer.getAadharId();
			
			List<DealerGoods> dgoods = new ArrayList<DealerGoods>();
			DealerGoodsDAO dealerGoodsDao = new DealerGoodsDAO();
			dgoods = dealerGoodsDao.getAll(aadharId);
			request.setAttribute("dealerGoods", dgoods);
		    RequestDispatcher dispatcher=request.getRequestDispatcher("Wardgoods.jsp");
		   	dispatcher.forward(request, response);
		}  else if ("CitizensDisplay".equalsIgnoreCase(action)) {
			HttpSession session=request.getSession();
			String dealerAadharId = (String) session.getAttribute("dealerAaadharId");	
			
			System.out.println("\n\n inside citizen display d adhar" + dealerAadharId  + "\n" );
			String citizenAadharId = request.getParameter("aadharId");
			session.setAttribute("citAadhar", citizenAadharId);
			DealerDAO  dealerDao = new DealerDAO();
			Dealer dealer = new Dealer();
			dealer = dealerDao.getDealer(dealerAadharId);

			List<Citizen> citizens = new ArrayList<Citizen>();
			CitizenDAO citizenDao = new CitizenDAO();
			citizens = citizenDao.getAll(dealer.getWardId().getwardId());
			request.setAttribute("citizens", citizens);
		    RequestDispatcher dispatcher=request.getRequestDispatcher("viewCitizens.jsp");
		   	dispatcher.forward(request, response);
		} else if ("DealerGoods".equalsIgnoreCase(action)) {
			String name = request.getParameter("pname");
			String qty = request.getParameter("qty");
			Double price = Double.parseDouble(request.getParameter("price"));
			Double priceFor = Double.parseDouble(request.getParameter("priceFor"));
			String wardId = request.getParameter("wdId");
			String pId = request.getParameter("pId");
			Dealer dealer = new Dealer();
			DealerDAO dDao = new DealerDAO();
			dealer = dDao.getDealer(wardId);
			DealerGoods dGoods = new DealerGoods(name,pId,qty,price,dealer,priceFor);
			DealerGoodsDAO dealerGoodsDao = new DealerGoodsDAO();
			dealerGoodsDao.add(dGoods);
		    RequestDispatcher dispatcher=request.getRequestDispatcher("viewDistricts.jsp");
		   	dispatcher.forward(request, response);
		}  else if ("CitizenGoodsDisplay".equalsIgnoreCase(action)) {
			String aadharId = request.getParameter("aadharId");
			List<CitizenGoods> cgoods = new ArrayList<CitizenGoods>();
			CitizenGoodsDAO citizenGoodsDao = new CitizenGoodsDAO();
			HttpSession session=request.getSession();
			session.setAttribute("citAadhar", aadharId);
			cgoods = citizenGoodsDao.getAll(aadharId);
			request.setAttribute("citizenGoods", cgoods);
		    RequestDispatcher dispatcher=request.getRequestDispatcher("distribute.jsp");
		   	dispatcher.forward(request, response);
		} 
	}

}
