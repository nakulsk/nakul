package com.niit.backend.interfaces;

import com.niit.backend.model.UploadFile;

public interface FileUploadDAO {
	void save(UploadFile uploadFile);

	UploadFile getFile(String username);
}
