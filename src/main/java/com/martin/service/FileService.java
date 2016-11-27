package com.martin.service;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.IOUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class FileService
{
    private static final String STUBS_FOLDER = "stubs";

    public static String getFileContent(String fileName)
    {
        Resource resource = new ClassPathResource(STUBS_FOLDER + File.separator + fileName);

        try
        {
            return IOUtils.toString(resource.getInputStream(), StandardCharsets.UTF_8);
        } catch (IOException e)
        {
            return "No stub available for this scenario.";
        }
    }
}
