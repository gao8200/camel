package com.practice.pojo;

import org.springframework.stereotype.Component;

/*

{ 
  "employeeName":"Oscar perocho",
  "employeeId":"102019"
}

 */
@Component
public class Employee {

	private String employeeName;
	private String employeeId;
	private String shift;

	private String aRouteMessage;
	private String bRouteMessage;
	private String cRouteMessage;

	public String getaRouteMessage() {
		return aRouteMessage;
	}

	public void setaRouteMessage(String aRouteMessage) {
		if (this.aRouteMessage == null && aRouteMessage !=null)
		  this.aRouteMessage = aRouteMessage;
	}

	public String getbRouteMessage() {
		return bRouteMessage;
	}

	public void setbRouteMessage(String bRouteMessage) {
		if (this.bRouteMessage == null && bRouteMessage != null)
		  this.bRouteMessage = bRouteMessage;
	}

	public String getcRouteMessage() {
		return cRouteMessage;
	}

	public void setcRouteMessage(String cRouteMessage) {
		if (this.cRouteMessage == null && cRouteMessage !=null)
		  this.cRouteMessage = cRouteMessage;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
		// System.out.println(toString());
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId + "PH1 ";
		// System.out.println(toString());
	}

	public String getShift() {
		return shift;
	}

	public void setShift(String shift) {
		this.shift = shift;
	}

	@Override
	public String toString() {
		return "Employee [employeeName=" + employeeName + ", employeeId=" + employeeId + ", shift=" + shift
				+ ", aRouteMessage=" + aRouteMessage + ", bRouteMessage=" + bRouteMessage + ", cRouteMessage="
				+ cRouteMessage + "]";
	}

}
