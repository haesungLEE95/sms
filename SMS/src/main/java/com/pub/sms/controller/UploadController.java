package com.pub.sms.controller;
 
import java.io.File;
import java.util.Iterator;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.pub.sms.model.SmsMem;
import com.pub.sms.service.SmsMemService;
 
@Controller
public class UploadController {
	
	@Autowired
	private SmsMemService sms;
	
    @RequestMapping(value = "/profile")
    public String ajaxUpload() {
        return "mem/profile";
    }
     
    @RequestMapping("profFileUpload")
    public String profFileUp(MultipartHttpServletRequest multi, String mem_id) {
         
        // 저장 경로 설정
    	String root = multi.getSession().getServletContext().getRealPath("/");
        String path = root+	"upload"+File.separator;
        System.out.println("path: "+path); 
        String newFileName = ""; // 업로드 되는 파일명
         
        File dir = new File(path);
        if(!dir.isDirectory()){
            dir.mkdirs();
        }
         
        Iterator<String> files = multi.getFileNames();
        while(files.hasNext()){
            String uploadFile = files.next();
                         
            MultipartFile mFile = multi.getFile(uploadFile);
            String fileName = mFile.getOriginalFilename();
            System.out.println("실제 파일 이름 : " +fileName);
            newFileName = System.currentTimeMillis()+"."
                    +fileName.substring(fileName.lastIndexOf(".")+1);
            System.out.println("업로드된 파일 이름 : " +newFileName);             
            try {
                mFile.transferTo(new File(path+newFileName));
            } catch (Exception e) {
                e.printStackTrace();
            }
            String id = mem_id;
            
            System.out.println("id : "+id);
            System.out.println("mem_id 투스트링 "+mem_id.toString());
            System.out.println("셀렉트 "+sms.select(id.toString()));
            System.out.println("셀렉트 테스트 "+sms.select("a1"));
            System.out.println("dd");
            SmsMem mem = sms.select(mem_id);
            mem.setMem_img(newFileName);
            int result = sms.updateImg(mem);
            System.out.println("result : "+result);   
        }
  
        return "mem/profile";
    }
}
