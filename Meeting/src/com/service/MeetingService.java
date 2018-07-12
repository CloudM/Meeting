//Karenzhu
package com.service;

import com.entity.Meeting;
public interface MeetingService {
	public boolean SAddMeeting(Meeting m);
	public boolean SDeleteMeeting(Meeting m);
	public Meeting SFindMeeting(Meeting m);
	public boolean SUpdateMeeting(Meeting m);
	public boolean SReleaseMeeting(Meeting m);

}
