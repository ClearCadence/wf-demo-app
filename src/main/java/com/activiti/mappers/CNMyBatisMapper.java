/**
 * © Copyright 2012- 2020 ClearCadence, LLC 
 * All Rights Reserved.
 * 
 * Proprietary Materials – Property of ClearCadence, LLC.  These ClearCadence materials may be used, 
 * modified and  redistributed only by written authorization of ClearCadence, LLC and limited to the 
 * organization(s) for  whom permission is granted.  Any derivate works incorporating this code must 
 * also adhere to these terms. All materials must be kept confidential and be marked as such.  
 *
 * Any questions regarding the treatment of these ClearCadence materials may be directed to 
 * info@ClearCadence.com
 *
 * ClearCadence Confidential Information
 *
 */

package com.activiti.mappers;

import java.math.BigInteger;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface CNMyBatisMapper {

	@Select("SELECT ID FROM RELATED_CONTENT WHERE SOURCE_ID = #{rcSourceId} AND PROCESS_ID = #{processInstanceId}")
	BigInteger getRCContentId(@Param(value = "rcSourceId") String rcSourceId,
			@Param(value = "processInstanceId") String processInstanceId);

	@Update("UPDATE RELATED_CONTENT SET SOURCE_ID = #{newSourceId} WHERE ID = #{rcId}")
	Integer updateRCSourceId(@Param(value = "newSourceId") String newSourceId, @Param(value = "rcId") BigInteger rcId);

	@Select("SELECT ID FROM FORM  where Name=#{formName} ORDER BY Created DESC LIMIT 1")
	String getFormKey(@Param(value = "formName") String formName);

}
