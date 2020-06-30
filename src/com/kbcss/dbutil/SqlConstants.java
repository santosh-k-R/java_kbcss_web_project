package com.kbcss.dbutil;

public class SqlConstants {

	// QueryDAo

	public static final String _INSERT_QUERY = "insert into query values((select nvl(max(queryid),1000)+1 from query),?,?,?,?,?)";
	public static final String _GET_QUERY = "select queryid,userid,qdescription,qstatus,to_char(qdate,'dd-mm-yy'),SENDTO from query where SENDTO=(select userid from userdetails where loginid=?)";
	public static final String _GET_QUERY_AT = "select queryid,userid,qdescription,qstatus,TO_CHAR(qdate,'dd-mm-yyyy') from query where queryid=?";
	public static final String _GET_SOLUTION = "select q.queryid,q.userid,q.qdescription,TO_CHAR(q.qdate,'DD-MM-YYYY'),TO_CHAR(s.soldate,'DD-MM-YYYY'),s.solution ,u.userid,q.qstatus from query q , FEEDBACKSOLU s ,userdetails u where q.queryid=s.queryid and s.queryid=? and u.loginid=?";

	// solution

	public static final String _INSERT_SOLUTION = "insert into feedbacksolu values(?,?,?)";
	public static final String _GET_QUERY_STATUS = "select  distinct q.queryid,q.userid,q.qdescription,TO_CHAR(q.qdate,'DD-MM-YYYY'),s.soldate,s.solution ,u.userid,q.qstatus from query q ,  FEEDBACKSOLU  s ,userdetails u where q.queryid=s.queryid and u.userid=? and q.userid=?";

	// Material
	public static final String _VIEW_MATERIAL = "select NOTESID,NOTES from NOTES where NOTESID=? ";
	public static final String _INSERT_NEW_MATERIAL = "insert into NOTES values((select nvl(max(NOTESID),111)+1 from NOTES),(select USERID from USERDETAILS where  LOGINID=?),?,(select sysdate from dual),?,?)";
	public static final String _VIEW_ALL_MATERIALNAME = "select  MATERIALNAME, NOTESID from NOTES";

	// public static final String _VIEW=

	// LoginAction

	public static final String _GET_LOGINTYPE = "select logintype from userdetails where loginid=? and password=?";
	public static final String _CHECKAVAILABLE_LOGINNAME = "select userid from userdetails where loginid=?";
	public static final String _CHANGEPASSWORD = "update userdetails set password=? where  loginid=? and password=?";
	public static final String _CHANGEQUESTION = "update userdetails set FORGOTPWQUESTION=?,FORGOTPWANSWER =? where loginid=? and password=? ";

	// Profile

	public static final String _GETPERSONALDETAILS = "select u.USERID,u.LOGINTYPE,u.firstname,u.lastname,u.dob,u.emailid,u.photograph,s.subname,c.cname from userdetails u,college c,subject s where s.subid=u.SUBJECTREFNO and u.COLLEGEREFNO=c.COLLEGEID AND u.LOGINID=?";

	// SUBJECT

	public static final String _VIEWSUBJECT_NAMES = "select SUBID,subname from subject";
	public static final String _ADDNEWSUBJECT = "insert into SUBJECT values((select nvl(max(SUBID),100)+1 from SUBJECT),?)";
	// "insert into SUBJECT values((select nvl(max(SUBID),100)+1 from
	// SUBJECT),?)" ;

	// COLLEGE
	public static final String _VIEWCOLLEGE = "select * from COLLEGE";
	public static final String _INSERTNEW_COLLEGE = "insert into COLLEGE values((select nvl(max(COLLEGEID),100)+1 from COLLEGE),?,?,?,?)";
	public static final String _UPDATECOLLEGE_DETAILS = "Update COLLEGE SET CNAME=?,PLACE=?,DISTRICT=?,REGION=? where COLLEGEID=?";
	public static final String _VIEWCOLLEGE_DETAILS_BYID = "select * from COLLEGE  where COLLEGEID=?";

	// Question

	public static final String _INSERTQUESTION = "insert into QUESTIONS values((select nvl(max(QUESID),111)+1 from QUESTIONS),?,(select USERID from USERDETAILS where LOGINID=?),'new',?,?)";
	public static final String _VIEW_QUESTION_BYCATEGORY = "select QDETAILS,STATUS,QTYPE,TITLE,USERIDREF,QUESID from QUESTIONS where QTYPE=?";
	public static final String _VIEWQUESTION = "select QDETAILS,STATUS,QTYPE,TITLE,USERIDREF,QUESID from QUESTIONS where USERIDREF=(select USERID from USERDETAILS where LOGINID=?) and QUESID=?";

	// Answers

	public static final String _VIEWANSWERS = "select userid,photograph,FIRSTNAME,LASTNAME from userdetails where userid=?";
	public static final String _VIEWSOLUTION = "select sol.SOLID,sol.QUESREF,sol.ANSWERS,sol.SOLVEDBYUSERIDREF,sol.POINTS,ud.PHOTOGRAPH from SOLUTION sol,USERDETAILS ud where sol.QUESREF=? and sol.SOLVEDBYUSERIDREF=ud.USERID";
	public static final String _ALREADY_GIVENMARKSUSERORNOT = "select *  from  FORUMPOINTS where SOLUTIONIDREF=? and MARKSGIVENUSERID=(select userid from userdetails where Loginid=?)";
	public static final String _IF_NOTALREADY_GIVENMARKSUSER = "insert into FORUMPOINTS values(?,(select USERID from USERDETAILS where LOGINID=?),?,(select QTYPE from QUESTIONS where QUESID=?))";
	public static final String _INSERTANSWER = "insert into solution values((select nvl(max(SOLID),100)+1 from solution),?,?,(select userid from userdetails where loginid=?),0)";
	public static final String _VIEWQUESTION_ASKED_BYOWN = "select QDETAILS,STATUS,QTYPE,TITLE,USERIDREF,QUESID from QUESTIONS where USERIDREF=(select USERID from USERDETAILS where LOGINID=?)";

	// Forums
	public static final String _VIEWALLFORUMS = "select f. FORUMID,f.SUBJECTREF,f.TOPICDESCRIPTION,f.FORUMDATE,f.TIME,s.SUBNAME from FORUMS f,SUBJECT s where f.SUBJECTREF=s.SUBID";
	public static final String _INSERT_NEW_FORUM = "insert into FORUMS values((select nvl(max(FORUMID),111)+1 from FORUMS),(select SUBID from SUBJECT where SUBNAME=?),?,?,?)";
	public static final String _VIEW_FORUMDETAILS_BYDATE = "select f. FORUMID,f.SUBJECTREF,f.TOPICDESCRIPTION,f.FORUMDATE,f.TIME,s.SUBNAME from FORUMS f,SUBJECT s where f.SUBJECTREF=s.SUBID and f.FORUMDATE=?";
	public static final String _VIEW_FORUMDETAILS_BYSUBJECT = "select f.FORUMID,f.SUBJECTREF,f.TOPICDESCRIPTION,f.FORUMDATE,f.TIME,s.SUBNAME from FORUMS f,SUBJECT s where f.SUBJECTREF=s.SUBID AND   f.SUBJECTREF=(select SUBID from SUBJECT where SUBNAME=?)";

	// "select materialid,material from material where courseid=?"
}
