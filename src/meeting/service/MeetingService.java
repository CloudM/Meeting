package meeting.service;

import meeting.entity.Meeting;
public interface MeetingService {
	public boolean SAddMeeting(Meeting m);
	public boolean SDeleteMeeting(Meeting m);
	public Meeting SFindMeeting(Meeting m);

}
