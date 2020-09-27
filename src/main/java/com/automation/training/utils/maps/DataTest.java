package com.automation.training.utils.maps;

import java.io.IOException;

import org.json.simple.parser.ParseException;

import com.automation.training.utils.PropertiesJson;
import com.automation.training.utils.modals.DateModal;
import com.automation.training.utils.text.TextDate;
import com.automation.training.utils.text.Urls;

public class DataTest {
	PropertiesJson json = new PropertiesJson();
	DateModal date = new DateModal();

	public DateModal init()  {

		try {
			date.setNewName(json.getJson(TextDate.NEW_NAME, Urls.FILE_JSON));
			date.setNewLasName(json.getJson(TextDate.NEW_LAST_NAME, Urls.FILE_JSON));
			date.setNewEmail(json.getJson(TextDate.NEW_EMAIL, Urls.FILE_JSON));
			date.setNewPassword(json.getJson(TextDate.NEW_PASSWORD, Urls.FILE_JSON));
			date.setOldName(json.getJson(TextDate.OLD_NAME, Urls.FILE_JSON));
			date.setOldEmail(json.getJson(TextDate.OLD_EMAIL, Urls.FILE_JSON));
			date.setOldPassword(json.getJson(TextDate.OLD_PASSWORD, Urls.FILE_JSON));
			date.setDeleteEmailOld(json.getJson(TextDate.DELETE_EMAIL_OLD, Urls.FILE_JSON));
			date.setDeletePasswordOld(json.getJson(TextDate.DELETED_PASSWORD_OLD, Urls.FILE_JSON));
			date.setDeleteEmail(json.getJson(TextDate.DELETE_EMAIL, Urls.FILE_JSON));
			date.setDeletePassword(json.getJson(TextDate.DELETED_PASSWORD, Urls.FILE_JSON));
			date.setCloseEmail(json.getJson(TextDate.CLOSE_EMAIL, Urls.FILE_JSON));
			date.setClosePassword(json.getJson(TextDate.CLOSE_PASSWORD, Urls.FILE_JSON));
		} catch (IOException | ParseException e) {

			e.printStackTrace();
		}
	
		return date;

	}
}
