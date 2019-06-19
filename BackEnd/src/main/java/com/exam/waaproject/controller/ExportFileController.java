package com.exam.waaproject.controller;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.exam.waaproject.domain.Student;
import com.exam.waaproject.domain.TmChecking;
import com.exam.waaproject.domain.TmRetreat;
import com.exam.waaproject.repository.TmCheckingRepository;
import com.exam.waaproject.services.StudentServiceImpl;
import com.exam.waaproject.services.TmRetreatServiceImpl;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.List;

@RestController
public class ExportFileController {
    @Autowired
    private TmRetreatServiceImpl tmRetreatService;
    @Autowired
    private TmCheckingRepository tmCheckingRepository;
    @Autowired
    private StudentServiceImpl studentService;

    @RequestMapping("/api/export/retreat")
    public String retreatExport(@RequestParam Long stu_id, HttpServletResponse response) throws Exception {
        if (stu_id == null) return "Student ID can't be empey!";
        Student student = studentService.findById(stu_id);
        if (student == null) return "Can't find Student BY ID";
        List<TmRetreat> list = tmRetreatService.findByStudent(student);
        ExportParams exportParams = new ExportParams("TmRetreat", "sheet1");
        //export
        Workbook workbook = ExcelExportUtil.exportExcel(exportParams, TmRetreat.class, list);
        String fileName = "retreat_excel.xls";
        buildExcelFile(fileName, workbook);
        buildExcelDocument(fileName,workbook,response);
        return "download excel";
    }

    @RequestMapping("/api/export/checking")
    public String checkingExport(@RequestParam Long stu_id, HttpServletResponse response) throws Exception {
        if (stu_id == null) return "Student ID can't be empey!";
        Student student = studentService.findById(stu_id);
        if (student == null) return "Can't find Student BY ID";
        List<TmChecking> list = tmCheckingRepository.findAllByStudent(student);
        System.out.println(list.size());
        ExportParams exportParams = new ExportParams("TmChecking", "sheet1");
        //export
        Workbook workbook = ExcelExportUtil.exportExcel(exportParams, TmChecking.class, list);
        String fileName = "checking_excel.xls";
        buildExcelFile(fileName, workbook);
        buildExcelDocument(fileName,workbook,response);
        return "download excel";
    }

    //creat excel file
    protected void buildExcelFile(String filename,Workbook workbook) throws Exception{
        FileOutputStream fos = new FileOutputStream(filename);
        workbook.write(fos);
        fos.flush();
        fos.close();
    }
    //download excel
    protected void buildExcelDocument(String filename,Workbook workbook,HttpServletResponse response) throws Exception{
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment;filename="+ URLEncoder.encode(filename, "utf-8"));
        OutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        outputStream.flush();
        outputStream.close();
    }
}
