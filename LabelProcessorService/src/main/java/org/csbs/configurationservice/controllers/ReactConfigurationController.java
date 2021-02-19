package org.csbs.configurationservice.controllers;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;


import javax.servlet.http.HttpServletRequest;

import org.csbs.configurationservice.domain.StringConfiguration;
import org.csbs.configurationservice.exception.DocConstants;
import org.csbs.configurationservice.formatters.CSVFormatter;
import org.csbs.configurationservice.formatters.JSONFormatter;
import org.csbs.configurationservice.services.FileStorageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

@RestController
@Validated
@RequestMapping
@Tag(name = "configuration", description = "The configuration API")
@Slf4j
@ApiResponses(value = {
        @ApiResponse(responseCode = "401", description = DocConstants.HTTP_401, content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorResponse.class))
        })
})
public class ReactConfigurationController {

	private static final Logger logger = LoggerFactory.getLogger(ReactConfigurationController.class);

	@Autowired
	FileStorageService fileStorageService;

	/**
	 * Allows the user to upload a configuration spreadsheet. This method will
	 * eventually change to record success or failure, but at the moment, doesn't
	 * store the results in a database, so it returns them to the user in JSON
	 * format.
	 * 
	 * @param file The file to be uploaded
	 * @return A JSON representation of the file that was uploaded
	 */
	@PostMapping("/screenConfig/uploadScreenConfiguration")
	public String uploadFile(@RequestParam("file") MultipartFile file) {

		List<StringConfiguration> configs = new ArrayList<StringConfiguration>();
		try {
			configs.addAll(CSVFormatter.csvToStringConfigurations(file.getInputStream()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BufferedInputStream result = JSONFormatter.stringConfigurationsToJSON(configs);

		try {
			return new String(result.readAllBytes(), StandardCharsets.US_ASCII);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	/**
	 * 
	 * @param displayGroup
	 * @param request
	 * @return
	 */
	@GetMapping("/screenConfig/downloadScreenConfiguration")
	public ResponseEntity<Resource> downloadFile(@PathVariable String displayGroup, HttpServletRequest request) {
		
		// Load file as Resource
		Resource resource = fileStorageService.loadFileAsResource(displayGroup);

		// Try to determine file's content type
		String contentType = null;
		try {
			contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
		} catch (IOException ex) {
			logger.info("Could not determine file type.");
		}

		// Fallback to the default content type if type could not be determined
		if (contentType == null) {
			contentType = "application/octet-stream";
		}

		return ResponseEntity.ok().contentType(MediaType.parseMediaType(contentType))
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
				.body(resource);
	}

	private List<StringConfiguration> getResponseForDisplayGroup(String displayGroup) {
		// TODO Auto-generated method stub
		return null;
	}
}
