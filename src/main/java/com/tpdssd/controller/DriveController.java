package com.tpdssd.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.social.google.api.Google;
import org.springframework.social.google.api.drive.DriveFile;
import org.springframework.social.google.api.drive.DriveFilesPage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping(value = "/drive", method = GET)
public class DriveController {
	
	private final Google google;
	
	@Autowired
	public DriveController(Google google) {
		this.google = google;
	}
	
	@ResponseBody
	@RequestMapping("/files")
	public DriveFilesPage files() {
		return google.driveOperations().getFiles("root", null);
	}
	
	@ResponseBody
	@RequestMapping("/downloadfile/{id}")
	public Resource downloadfile(@PathVariable String id) {
		return google.driveOperations().downloadFile(id);
	}

	@ResponseBody
	@RequestMapping("/createfile/{id}")
	public String createfile(@PathVariable String id) {

		DriveFile file = DriveFile.builder().setTitle(id).setDescription("Trabajo").build();
		google.driveOperations().createFileMetadata(file);
		return google.driveOperations().getFile(id).getSelfLink();
	}
	
}
