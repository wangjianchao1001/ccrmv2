package com.ccrm.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ccrm.dto.Pager;
import com.ccrm.entity.RegOrganinfo;
import com.ccrm.entity.SysDictionary;
import com.ccrm.entity.TirClass;
import com.ccrm.entity.TirStudent;
import com.ccrm.entity.UmgOperator;
import com.ccrm.service.RegOrganinfoService;
import com.ccrm.service.SysDictionaryService;
import com.ccrm.service.TirClassService;
import com.ccrm.service.TirStudentService;
import com.ccrm.util.DateTimeUtils;
import com.ccrm.util.ImportExcelUtil;
import com.ccrm.util.excelExport.ExcelUtil;

@Controller
@RequestMapping("/tirStudent/*")
public class TirStudentController {
	private static final Logger log = LoggerFactory.getLogger(TirStudentController.class);
	
	@Autowired
	TirStudentService studentService;
	@Autowired
	TirClassService classService;
	@Autowired
	RegOrganinfoService organService;	
	@Autowired
	SysDictionaryService dicService;
	
	/**
	 * 跳转学员页面
	 */
	@RequestMapping("studentList.html")
	public String studentList(TirStudent student, HttpServletRequest req, HttpServletResponse res, ModelMap model,Pager page){
		
		UmgOperator user = (UmgOperator) req.getSession().getAttribute("umgOperator");
		if(student.getStatus() == null){
			student.setStatus(-1l);
			student.setBranchId(user.getBranchid());
		}
		Pager pager = studentService.findPageList(student, page.getPageNumber(), page.getPageSize());
		
		String idxids = "'40','70','71','72','73','74','81'";
		List<SysDictionary> dicList = dicService.getDicListByIdxids(idxids);
		
		RegOrganinfo organInfo = new RegOrganinfo();
		organInfo.setStatus(-1);
		organInfo.setBranchid(user.getBranchid());
		List<RegOrganinfo> organList = organService.findList(organInfo);
		
		TirClass tirClass = new TirClass();
		tirClass.setStatus(-1l);
		List<TirClass> classList = classService.findList(tirClass);
		
		model.put("pager", pager);
		model.put("organList",organList);
		model.put("classList",classList);
		model.put("dicList", dicList);
		model.put("student", student);
		
		return "student/studentList";
	}
	
	/**
	 * 跳转新增页面
	 */
	@RequestMapping("edit.html")
	public String update(String id, HttpServletRequest req, HttpServletResponse res, ModelMap model){
		
		log.info("跳转页面，参数 studentId ："+id);
		
		String idxids = "'40','70','71','72','73','74','81'";
		List<SysDictionary> dicList = dicService.getDicListByIdxids(idxids);
		
		TirClass tirClass = new TirClass();
		tirClass.setStatus(-1l);
		List<TirClass> classList = classService.findList(tirClass);
		
		if(StringUtils.isNotBlank(id)){
			TirStudent student = studentService.getById(Long.valueOf(id));
			model.put("student", student);
		}
		model.put("dicList", dicList);
		model.put("classList", classList);
		
		return "student/studentEdit";
	}
	
	/**
	 * 跳转登记页面
	 */
	@RequestMapping("register.html")
	public String register(String ids, HttpServletRequest req, HttpServletResponse res, ModelMap model){
		
		log.debug("跳转页面，参数 ids ："+ids);
		
		TirClass tirClass = new TirClass();
		tirClass.setStatus(-1l);
		List<TirClass> classList = classService.findList(tirClass);
		
		model.put("classList", classList);
		model.put("ids", ids);
		
		return "student/register";
	}

	/**
	 * 登记
	 */
	@RequestMapping("register")
	public @ResponseBody String register(String classIdList, String studentIdList, HttpServletRequest req, HttpServletResponse res, ModelMap model){
		String msg = "操作成功";
		if(StringUtils.isNotBlank(classIdList) && StringUtils.isNotBlank(studentIdList)){
			String[] classIdsArray = classIdList.split(",");
			String[] studentIdsArray = studentIdList.split(",");
			for(int i=0; i<classIdsArray.length; i++){
				for(int j = 0; j < studentIdsArray.length; j++){
					TirStudent student = studentService.getById(Long.valueOf(studentIdsArray[j]));

					TirStudent tirStudent = new TirStudent();
					
					tirStudent.setIdxid(classIdsArray[i]);
					tirStudent.setName(student.getName());
					tirStudent.setIdno(student.getIdno());
					tirStudent.setNationid(student.getNationid());
					tirStudent.setHouseholdid(student.getHouseholdid());
					
					tirStudent.setCultureid(student.getCultureid());
					tirStudent.setAdress(student.getAdress());
					tirStudent.setPhoneno(student.getPhoneno());
					tirStudent.setStructid(student.getStructid());
					tirStudent.setIdentid(student.getIdentid());
					
					tirStudent.setIdentno(student.getIdentno());
					tirStudent.setDateunemployed(student.getDateunemployed());
					tirStudent.setTrainaprid(student.getTrainaprid());
					tirStudent.setCompleteaprid(student.getCompleteaprid());
					tirStudent.setScoretheory(student.getScoretheory());
					
					tirStudent.setScoreskill(student.getScoreskill());
					tirStudent.setIspasser(student.getIspasser());
					tirStudent.setCertifyno(student.getCertifyno());
					tirStudent.setCertifydate(student.getCertifydate());
					tirStudent.setIsemploy(student.getIsemploy());
					
					tirStudent.setEmployunit(student.getEmployunit());
					tirStudent.setEmploydate(student.getEmploydate());
					tirStudent.setProjectname(student.getProjectname());
					tirStudent.setLicenseno(student.getLicenseno());
					tirStudent.setEmployformaid(student.getEmployformaid());
					
					tirStudent.setUnitlinkman(student.getUnitlinkman());
					tirStudent.setUnitphoneno(student.getUnitphoneno());
					tirStudent.setLaborcontract(student.getLaborcontract());
					tirStudent.setIsdifficulty(student.getIsdifficulty());
					tirStudent.setIshandicapped(student.getIshandicapped());
					
					tirStudent.setEmployfigure(student.getEmployfigure());
					tirStudent.setIsapprase(student.getIsapprase());
					tirStudent.setIssubsidy(student.getIssubsidy());
					tirStudent.setImage(student.getImage());
					tirStudent.setStatus(student.getStatus());
					
					tirStudent.setCertificatetype(student.getCertificatetype());
					tirStudent.setMemo(student.getMemo());
					tirStudent.setDatenew(new Date());
					
					studentService.save(student);
				}
			}
		}
		return msg;
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("save")
	public String save(TirStudent student, HttpServletRequest req, HttpServletResponse res, ModelMap model, final RedirectAttributes redirectAttributes){
		String msg = "操作成功";
		log.info(student.toString());
		if(student.getPkid() == null ){
			studentService.save(student);
			student.setDatenew(new Date());
		}else{
			student.setDateedit(new Date());
			studentService.update(student);
		}
		
		redirectAttributes.addFlashAttribute("message", msg);
		return "redirect:/tirStudent/studentList.html";
	}
	
	
	/**
	 * 删除
	 */
	@RequestMapping("delete")
	public @ResponseBody String delete(String ids, HttpServletRequest req, HttpServletResponse res, ModelMap model){
		int msg = 0;
		if(StringUtils.isNotBlank(ids)){
			String[] idsArray = ids.split(",");
			for(int i=0; i<idsArray.length; i++){
				TirStudent student = studentService.getById(Long.valueOf(idsArray[i]));
				student.setStatus(-1l);
				msg = studentService.update(student);
			}
		}
		return msg+"";
	}
	
	/**
	 * 导出excel
	 */
	@RequestMapping("exportExcel")
	public @ResponseBody String exportExcel(String className, TirStudent student, HttpServletRequest req, HttpServletResponse res, ModelMap model, final RedirectAttributes redirectAttributes){
		String msg = "操作成功";
		
		if(student.getStatus() == null ){
			student.setStatus(-1l);
		}
		List<TirStudent> list = studentService.findListForExport(student);
		String title = "培训学员管理("+className+")";
		Map<String, String> map = new HashMap<String, String>(); 
		map.put("title",title);
		
		res.setContentType("application/vnd.ms-excel");
		String name = "培训学员";
		
		try {
			res.setHeader("Content-Disposition","attachment;filename = "+new String(name.getBytes("GBK"),"ISO8859-1")+"_"+new String(className.getBytes("GBK"),"ISO8859-1")+".xlsx");
			ExcelUtil.getInstance().exportObj2ExcelByTemplate(map, "/template/培训学员管理导出模版.xlsx", res.getOutputStream(), list, TirStudent.class, true);
			return null;
		} catch (IOException e) {
			msg = "导出培训学员失败";
			e.printStackTrace();
		}
		
		redirectAttributes.addFlashAttribute("message", msg);
		return "redirect:/class/classList.html";
	}	
	
	/**
	 * 下载模版
	 * @param req
	 * @param res
	 * @param model
	 */
	@RequestMapping(value="downloadTemplate")
	public void downloadTemplate(HttpServletRequest req, HttpServletResponse res, ModelMap model){
		res.setContentType("application/vnd.ms-excel");
		String name = "培训学员导入模版";
		
		try {
			res.setHeader("Content-Disposition","attachment;filename = "+new String(name.getBytes("GBK"),"ISO8859-1")+".xlsx");
			ExcelUtil.getInstance().exportObj2ExcelByTemplate(new HashMap<String, String>(), "/template/培训学员导入模版.xls", res.getOutputStream(), new ArrayList<TirStudent>(), TirStudent.class, true);
		} catch (IOException e) {
			log.error("下载培训学员导入模版错误");
			e.printStackTrace();
		}
	}
	
	/**  
     * 描述：通过传统方式form表单提交方式导入excel文件  
     * @param request  
     * @throws Exception  
     */  
    @RequestMapping(value="importExcel")  
    public @ResponseBody String  importExcel(String idxId, HttpServletRequest req, HttpServletResponse res, ModelMap model, final RedirectAttributes redirectAttributes) {  
    	log.info("importExcel start IdId："+ idxId);
    	String message = "导入成功";
		try {
			MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) req;
			InputStream in = null;
			List<List<Object>> listob = null;
			MultipartFile file = multipartRequest.getFile("upfile");
			if (file.isEmpty()) {
				throw new Exception("文件不存在！");
			}
			in = file.getInputStream();
			listob = new ImportExcelUtil().getBankListByExcel(in,
					file.getOriginalFilename());
			in.close();

			// 该处可调用service相应方法进行数据保存到数据库中，现只对数据输出
			for (int i = 0; i < listob.size(); i++) {
				List<Object> lo = listob.get(i);
				TirStudent student = new TirStudent();
				student.setName(lo.get(0).toString());
				student.setIdno(lo.get(1).toString());
				// 民族
				if (lo.get(2) != null && lo.get(2).toString().indexOf("汉") != -1) {
					student.setNationid(7001L);
				} else if (lo.get(2) != null && lo.get(2).toString().indexOf("蒙") != -1) {
					student.setNationid(7002L);
				} else if (lo.get(2) != null && lo.get(2).toString().indexOf("回") != -1) {
					student.setNationid(7003L);
				} else if (lo.get(2) != null && lo.get(2).toString().indexOf("满") != -1) {
					student.setNationid(7011L);
				} else if (lo.get(2) != null && lo.get(2).toString().indexOf("朝") != -1) {
					student.setNationid(7010L);
				} else {
					student.setNationid(7004L);
				}
				// 户口
				if (lo.get(3) != null && lo.get(3).toString().equals("非农业户口")) {
					student.setHouseholdid(7101L);
				} else if (lo.get(3) != null && lo.get(3).toString().equals("农业户口")) {
					student.setHouseholdid(7104L);
				} else if (lo.get(3) != null && lo.get(3).toString().equals("本市城镇")) {
					student.setHouseholdid(7102L);
				} else if (lo.get(3) != null && lo.get(3).toString().equals("外省城镇")) {
					student.setHouseholdid(7103L);
				} else if (lo.get(3) != null && lo.get(3).toString().equals("本市农村")) {
					student.setHouseholdid(7105L);
				} else if (lo.get(3) != null && lo.get(3).toString().equals("外省农村")) {
					student.setHouseholdid(7106L);
				} else if (lo.get(3) != null && lo.get(3).toString().equals("港澳台人员")) {
					student.setHouseholdid(7107L);
				} else {
					student.setHouseholdid(7101L);
				}
				// 文化程度
				if (lo.get(4) != null && lo.get(4).toString().equals("初中")) {
					student.setCultureid(7209L);
				} else if (lo.get(4) != null && lo.get(4).toString().equals("高中")) {
					student.setCultureid(7207L);
				} else if (lo.get(4) != null && lo.get(4).toString().equals("职高")) {
					student.setCultureid(7208L);
				} else if (lo.get(4) != null && lo.get(4).toString().equals("技校")) {
					student.setCultureid(7206L);
				} else if (lo.get(4) != null && lo.get(4).toString().equals("中专中技")) {
					student.setCultureid(7205L);
				} else if (lo.get(4) != null && lo.get(4).toString().equals("大专")) {
					student.setCultureid(7204L);
				} else if (lo.get(4) != null && lo.get(4).toString().equals("大学")) {
					student.setCultureid(7203L);
				} else {
					student.setCultureid(7210L);
				}
				// 证书类型
				student.setCertificatetype(4001L);
				// 人员类别
				student.setStructid(7307L);
				student.setMemo("系统导入");
				student.setIdxid(idxId);
				student.setDatenew(new Date());
				if (lo.get(5) != null && lo.get(5).toString().indexOf(".") != -1) {
					student.setPhoneno(lo.get(5).toString());
				} else if (lo.get(5) != null) {
					student.setPhoneno(lo.get(5).toString());
				}
				if (lo.get(6) != null) {
					student.setAdress(lo.get(6).toString());
				}
				if (lo.get(7) != null && lo.get(7).equals("是")) {
					student.setIspasser(7600L);
				} else {
					student.setIspasser(7601L);
				}
				if (lo.get(8) != null && lo.get(8).equals("是")) {
					student.setIsemploy(7700L);
				} else {
					student.setIspasser(7701L);
				}
				if (lo.get(9) != null && lo.get(9).toString().equals("中级职业资格")) {
					student.setIdentlevel(8102L);
				} else if (lo.get(9) != null && lo.get(9).toString().equals("高级职业资格")) {
					student.setIdentlevel(8103L);
				} else if (lo.get(9) != null && lo.get(9).toString().equals("技师职业资格")) {
					student.setIdentlevel(8104L);
				} else if (lo.get(9) != null && lo.get(9).toString().equals("高级技师资格")) {
					student.setIdentlevel(8105L);
				} else {
					student.setIdentlevel(8101L);
				}
				studentService.save(student);
			}
		} catch (Exception e) {
			message = "导入失败";
			log.error("importExcel error "+ e.toString());
		}
		log.info("importExcel end");
        return message;  
    }  
	
}
