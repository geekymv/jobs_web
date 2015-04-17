package com.heike.util;

import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.VerticalAlignment;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import com.heike.domain.dto.SalaryDto;

public class ExcelUtil {

	public static void createExcel(List<SalaryDto> list, String[] title,  String fileName, HttpServletResponse response) {
		WritableWorkbook book = null;
		try {
			OutputStream os = response.getOutputStream();
			response.setHeader("Content-disposition", 
					"attachment; filename=" + new String(fileName.getBytes("GB2312"),"8859_1") + ".xls");// 设定输出文件头
	        response.setContentType("application/msexcel");
	        // 创建一个工作薄，就是整个Excel文档
	        book = Workbook.createWorkbook(os);
	        // 创建工作表
	        WritableSheet sheet = book.createSheet("第一页", 0);
	        
	        // 设定列宽
	        sheet.setColumnView(3, 15);
	        sheet.setColumnView(4, 15); // 设定第5列的宽度15
	        sheet.setColumnView(5, 20);
	        
	        WritableCellFormat format = new WritableCellFormat();
	        
	     // 指定字体、字号和粗细
	        WritableFont font = new WritableFont(WritableFont.TIMES, 12,
	     					WritableFont.BOLD);
			format = new WritableCellFormat(font);
        	format.setAlignment(Alignment.CENTRE); // 水平居中
	        format.setVerticalAlignment(VerticalAlignment.CENTRE); // 垂直居中
        	
	        // 创建标签（单元格）
	        Label label = new Label(0, 0, "标题", format);
	        // 将单元格加入工作表中
	        sheet.addCell(label);
	        // 合并第1行第1列-第1行第12列
	        sheet.mergeCells(0, 0, 11, 0);
	      
	        label = new Label(0, 1, "单位盖章处", format);
	        sheet.addCell(label);
	        // 合并第2行第1列-第3行第3列
	        sheet.mergeCells(0, 1, 2, 2);
	        
	        if(list == null || list.size() == 0) {
	        	// 暂无
	        	label = new Label(0, 3, "暂无工资", format);
	        	sheet.addCell(label);
	        }else {
	        	// 设置标题样式
	        	font = new WritableFont(WritableFont.TIMES, 10,
     					WritableFont.BOLD);
	        	format = new WritableCellFormat(font);
	        	format.setAlignment(Alignment.CENTRE);
	        	format.setVerticalAlignment(VerticalAlignment.CENTRE);
	        	
	        	 // 标题
		        for (int i = 0; i < title.length; i++) {
					// 第4行，第(i+1)列添加标题
					label = new Label(i, 3, title[i], format);
					sheet.addCell(label);
				}
		        
	        	format = new WritableCellFormat();
	        	format.setAlignment(Alignment.CENTRE);
	        	format.setVerticalAlignment(VerticalAlignment.CENTRE);
	        	
		        // 内容
		        for(int i = 0; i < list.size(); i++) {
		        	SalaryDto s = list.get(i);
		        	
		        	String salary = s.getSalary();
		        	String toolFee = s.getToolFee();
		        	String bonus = s.getBonus();
		        	float total = Float.valueOf(salary) + Float.valueOf(toolFee) + Float.valueOf(bonus);
 		        	
		        	String[] values = {String.valueOf(i+1), s.getName(), s.getNum(), s.getProfession(), s.getPostName(),
		        			s.getEmpName(), s.getWorktime(), s.getSalary(), s.getToolFee(), s.getBonus(),  
		        			String.valueOf(total), s.getRemarks()};
		        
		        	for(int k = 0; k < values.length; k++) {
		        		label = new Label(k, 4+i, values[k], format);
			        	sheet.addCell(label);	
		        	}
		        }
	        }
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				book.write();
				book.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
