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
import com.ccrm.entity.HsrTrinsStudent;
import com.ccrm.entity.TirStudent;
import com.ccrm.entity.UmgBranch;
import com.ccrm.entity.UmgOperator;
import com.ccrm.service.HsrTrinsStudentService;
import com.ccrm.service.RegOrganinfoService;
import com.ccrm.service.UmgBranchService;
import com.ccrm.util.DateTimeUtils;
import com.ccrm.util.ImportExcelUtil;
import com.ccrm.util.excelExport.ExcelUtil;

@Controller
@RequestMapping("/hktirStudent/*")
public class HKTirStudentController {
	private static final Logger log = LoggerFactory.getLogger(HKTirStudentController.class);
	
	@Autowired
	RegOrganinfoService regOrgService;
	@Autowired
	UmgBranchService umgBranchService;
	@Autowired
	HsrTrinsStudentService studentSevice;
	
	@RequestMapping("hkStudentList.html")
	public String famCopList(HsrTrinsStudent student, HttpServletRequest req, HttpServletResponse res, ModelMap model,Pager page){
		
		//从session 取用户
		UmgOperator user = (UmgOperator) req.getSession().getAttribute("umgOperator");
		if(user != null){
			student.setBranchid(user.getBranchid()+"");
		}
		
		Pager pager = studentSevice.findPageList(student, page.getPageNumber(), page.getPageSize());
		
		List<UmgBranch> branchList = umgBranchService.getBranchTree("2200",String.valueOf(user.getBranchid()+"")); 
		String branchTree = umgBranchService.umgBranchTree(branchList); 
		
		model.put("pager", pager);
		model.put("branchTree", branchTree);
		model.put("student",student);
		
		return "hkStudent/hkStudentList";
	}
	
	
	/**
	 * 跳转新增页面
	 */
	@RequestMapping("edit.html")
	public String update(String id, HttpServletRequest req, HttpServletResponse res, ModelMap model){
		log.info("跳转页面，参数 studentId ："+id);
		
		UmgOperator user = (UmgOperator) req.getSession().getAttribute("umgOperator");
		List<UmgBranch> branchList = umgBranchService.getBranchTree("1200",String.valueOf(user.getBranchid())); 
		String branchTree = umgBranchService.umgBranchTree(branchList); 
		
		if(StringUtils.isNotBlank(id)){
			HsrTrinsStudent student = studentSevice.getById(Long.valueOf(id));
			model.put("student", student);
		}
		
		model.put("branchList", branchList);
		model.put("branchTree", branchTree);
		
		return "hkStudent/hkStudentEdit";
	}
	
	
	/**
	 * 保存
	 */
	@RequestMapping("save")
	public String save(HsrTrinsStudent student, HttpServletRequest req, HttpServletResponse res, ModelMap model, final RedirectAttributes redirectAttributes){
		String msg = "操作成功";
		if(student.getPkid() == null ){
			studentSevice.save(student);
		}else{
			studentSevice.update(student);
		}
		
		redirectAttributes.addFlashAttribute("message", msg);
		return "redirect:/hkStudent/hkStudentList.html";
	}
	
	
	/**
	 * 删除
	 */
	@RequestMapping("delete")
	public @ResponseBody String delete(String id, HttpServletRequest req, HttpServletResponse res, ModelMap model){
		int msg = 0;
		if(StringUtils.isNotBlank(id)){
			msg = studentSevice.delete(Long.valueOf(id));
		}
		return msg+"";
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
		String name = "学员花名册导入模版";
		try {
			res.setHeader("Content-Disposition","attachment;filename = "+new String(name.getBytes("GBK"),"ISO8859-1")+".xls");
			ExcelUtil.getInstance().exportObj2ExcelByTemplate(new HashMap<String, String>(), "/template/学员花名册导入模版.xls", res.getOutputStream(), new ArrayList<HsrTrinsStudent>(), HsrTrinsStudent.class, true);
		} catch (IOException e) {
			log.error("下载学员花名册导入模版错误");
			e.printStackTrace();
		}
	}
	
	
	@RequestMapping("import")
	public @ResponseBody String importStudent(String idxId, HttpServletRequest req, HttpServletResponse res, ModelMap model, final RedirectAttributes redirectAttributes) {  
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
			listob = new ImportExcelUtil().getBankListByExcel(in, file.getOriginalFilename());
			in.close();

			// 该处可调用service相应方法进行数据保存到数据库中，现只对数据输出
			for (int i = 0; i < listob.size(); i++) {
				List<Object> lo = listob.get(i);
				HsrTrinsStudent student = new HsrTrinsStudent();
				student.setPkid(Long.valueOf(DateTimeUtils.getDateTimeStr(new Date(), "yyyyMMddHHmmssms")));
				student.setName(lo.get(1).toString());
				if("男".equals(lo.get(2).toString())){
					student.setSexual("2");
				}else{
					student.setSexual("1");
				}
				student.setAge(lo.get(3) == null ? null : (Integer)lo.get(3));
				student.setIdnumber(lo.get(4).toString());
				student.setTriainyear(lo.get(5).toString());
				student.setTraintime(DateTimeUtils.convertDate(lo.get(6).toString()));
				if("家政服务".equals(lo.get(7).toString())){
					student.setTrainprof("1");
				}else if("养老护理".equals(lo.get(7).toString())){
					student.setTrainprof("2");
				}else if("病患陪护".equals(lo.get(7).toString())){
					student.setTrainprof("3");
				}else if("社区照料".equals(lo.get(7).toString())){
					student.setTrainprof("4");
				}else{
					student.setTrainprof("5");
				}
				student.setTrainperiod(lo.get(8).toString());
				student.setProflevel(lo.get(9).toString());
				student.setFamaddress(lo.get(10).toString());
				student.setPhone(lo.get(11).toString());
				if("否".equals(lo.get(12).toString())){
					student.setIspassidentify(0);
				}else{
					student.setIspassidentify(1);
				}
				if("否".equals(lo.get(13).toString())){
					student.setIstrainqualify(0);
				}else{
					student.setIstrainqualify(1);
				}
				student.setMemo("系统导入");
				
				studentSevice.save(student);
			}
		} catch (Exception e) {
			message = "导入失败";
			log.error("importExcel error "+ e.toString());
		}
		log.info("importExcel end");
        return message;  
	}
	
	/**
	 * 导出excel
	 */
	@RequestMapping("exportExcel")
	public @ResponseBody String exportExcel(String orgName, HsrTrinsStudent student, HttpServletRequest req, HttpServletResponse res, ModelMap model, final RedirectAttributes redirectAttributes){
		String msg = "操作成功";
		
		List<TirStudent> list = new ArrayList<TirStudent>();
		String title = "培训学员管理("+orgName+")";
		Map<String, String> map = new HashMap<String, String>(); 
		map.put("title",title);
		
		res.setContentType("application/vnd.ms-excel");
		String name = "培训学员";
		
		try {
			res.setHeader("Content-Disposition","attachment;filename = "+new String(name.getBytes("GBK"),"ISO8859-1")+"_"+new String(orgName.getBytes("GBK"),"ISO8859-1")+".xlsx");
			ExcelUtil.getInstance().exportObj2ExcelByTemplate(map, "/template/培训学员管理导出模版.xlsx", res.getOutputStream(), list, TirStudent.class, true);
			return null;
		} catch (IOException e) {
			msg = "导出培训学员失败";
			e.printStackTrace();
		}
		
		redirectAttributes.addFlashAttribute("message", msg);
		return "redirect:/class/classList.html";
	}	
	
}
