package com.springapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.io.File;
import java.util.List;

@RestController
@SpringBootApplication
public class StorageBoxApplication {
	@Autowired
	private StorageBoxService service;

	@GetMapping("/listdb")
	public List<StorageBoxes> listDatabase() {
		List<StorageBoxes> allRows;
		allRows=service.findAll();
		//StringBuffer sb=new StringBuffer();
		//sb.append("Returned "+allRows.size()+" rows\n");
		//allRows.forEach(BoxEntry -> sb.append(BoxEntry.toString()+"\n"));
		return allRows;
	}
	@PostMapping("/post")
	public ModelAndView uploadFile(@RequestParam("file") MultipartFile file,
								   @RequestParam("category") String formCategory,
								   @RequestParam("folder") String formFolder,
								   @RequestParam("tags") String formTags,
								   RedirectAttributes redirectAttributes) {
		try {
			//System.out.println("pre-maxid is: "+service.getMaxId()); System.out.flush();

			Integer useMyId;
			useMyId=service.getMaxId()+1;

			//System.out.println("myId is: "+useMyId); System.out.flush();
			//System.out.println("point 1:"+formCategory+":");System.out.flush();

			String offlinePath;
			offlinePath=StorageBoxConstants.offlineStorageDir+"/"+formFolder+useMyId+"_"+formCategory+".jpg";
			file.transferTo(new File(offlinePath));

			//System.out.println("point 2");System.out.flush();

			StorageBoxes be=new StorageBoxes(formCategory,formFolder,formTags,offlinePath,useMyId);

			//System.out.println("point 3");System.out.flush();
			//System.out.println("maxid is: "+service.getMaxId()); System.out.flush();
			//System.out.println("first tag is: "+service.getFirstTag()); System.out.flush();

			service.save(be);
			//System.out.println("point 4");System.out.flush();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("redirect:/listdb");
	}
	public static void main(String[] args) {
		SpringApplication.run(StorageBoxApplication.class, args);
	}
}
