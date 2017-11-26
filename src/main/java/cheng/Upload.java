package cheng;

import java.io.File;
import java.util.Arrays;

import com.opensymphony.xwork2.ActionSupport;

/**
 * <code>Allows upload a file</code>
 */
public class Upload extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private File[] upload;
	private String[] uploadFileName;
	private String[] uploadContentType;

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return INPUT;
	}

	public File[] getUpload() {
		return upload;
	}

	public void setUpload(File[] upload) {
		this.upload = upload;
	}

	public String[] getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String[] uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public String[] getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(String[] uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	@Override
	public String toString() {
		return "Upload [upload=" + Arrays.toString(upload) + ", uploadFileName=" + Arrays.toString(uploadFileName)
				+ ", uploadContentType=" + Arrays.toString(uploadContentType) + "]";
	}

}
