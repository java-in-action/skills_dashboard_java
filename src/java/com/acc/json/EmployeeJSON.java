package com.acc.json;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class EmployeeJSON {
	 @XmlElement public int sysId;
	 @XmlElement public String eId;
	 @XmlElement public String name;
	 @XmlElement public int level;
	 @XmlElement public String location;
	 @XmlElement public String birthday;
}
