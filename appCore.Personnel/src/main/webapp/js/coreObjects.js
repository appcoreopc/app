var User = function () {
    this.Nid;
    this.Username;
    this.Password;
    this.LastLogin;
}

var Experience = function () {
    this.nid;
    this.expertise;
    this.yearOfExpertise;
    this.expertiseDescription;
}

var Skill = function () {
    this.nid;
    this.skill;
    this.skillLevel;
    this.category;
    this.description;
    this.categoryDescription;
}

var Offday = function () {
    this.nid;
    this.patternName;
    this.description;
    this.dayPerCycle;
    this.disabled;
    this.remark;
    this.offDayInfo;
}

var OffdayInfo = function () {
    this.nid;
    this.dayNo;
    this.dayType;
    this.description;
    this.dayTypeDescription;
    this.clashedAction;
    this.nonClashedAction;
    this.refEntity;
}

var HolidayGroup = function () {
    this.nid;
    this.name;
    this.description;
}

var Holiday = function () {
    this.nid;
    this.name;
    this.holidayDate;
    this.description;
    this.type;
    this.recurring;
    this.refEntity;
}

var Company = function () {
    this.nid;
    this.companyCode;
    this.companyName;
    this.address;
    this.address2;
    this.address3;
    this.city;
    this.country;
    this.defaultCurrency;
    this.postcode;
    this.registration;
    this.parentCompany;
    this.tel;
    this.fax;
    this.disabled;
}

var Grade = function () {
    this.nid;
    this.code;
    this.description;
    this.category;
    this.probationMonth;
    this.disabled;
}

var EmploymentType = function () {
    this.nid;
    this.code;
    this.description;
    this.category;
    this.disabled;
}


var Division = function () {
    this.nid;
    this.divisionCode;
    this.divisionName;
    this.description;
    this.companyId;
    this.enabled;
}

var Section = function () {
    this.nid;
    this.sectionCode;
    this.sectionName;
    this.departmentId;
    this.enabled;
    this.remark;
    this.sectionInfo;
};

var Department = function () {
    this.nid;
    this.departmentCode;
    this.departmentName;
    this.divisionId;
    this.detailInfo;
    this.enabled;
    this.remark;
    this.departmentInfo;
};

var Unit = function () {
    this.nid;
    this.unitCode;
    this.unitName;
    this.remark;
    this.enabled;
    this.unitInfo;
    this.sectionId;
};

var Branch = function () {
    this.nid;
    this.branchCode;
    this.branchName;
    this.companyId;
    this.description;
    this.enabled;
    this.lastUpdated;
    this.branchInfo;
};

var DivisionInfo = function () {
    this.type;
    this.value;
    this.category;
    this.description;
};

var UnitInfo = function () {
    this.type;
    this.value;
    this.category;
    this.description;
};

var BranchInfo = function () {
    this.type;
    this.value;
    this.category;
    this.description;
};

var SectionInfo = function () {
    this.typse;
    this.value;
    this.category;
    this.description;
};

var GradeInfo = function () {
    this.typse;
    this.value;
    this.category;
    this.description;
};

var EmploymentTypeInfo = function () {
    this.typse;
    this.value;
    this.category;
    this.description;
};

var DepartmentInfo = function () {
    this.typse;
    this.value;
    this.category;
    this.description;
};

var User = function () {
    this.username;
    this.password;
}

var EmployeeContact = function () {

    this.nid;
    this.level;
    this.email;
    this.mobileNo;
    this.alternateEmail;
    this.extNo;
    this.correspondenceAddress1;
    this.correspondenceAddress2;
    this.correspondenceAddress3;
    this.city;
    this.country;
    this.telNo;
    this.employeeRefId;
}

var EmployeeResidence = function () {

    this.nid;
    this.permanentAddress1;
    this.permanentAddress2;
    this.permanentAddress3;
    this.city;
    this.country;
    this.postcode;
    this.telNo;
    this.emergencyContact1;
    this.emergencyContact2;
    this.contact1;
    this.contact2;
}

var EmployeeFamily = function () {
    this.memberName;
    this.memberType;
    this.birthDate;
    this.age
    this.salutation;
    this.gender
    this.maritalStatus;
    this.identificationNo;
    this.working;
    this.studying;
    this.handicap;
    this.nominatedSpouse;
    this.attachments;
    this.remarks;
    this.employeeRefId;
}

var EmployeeQualification = function () {
    this.level;
    this.employeeRefId;
    this.major;
    this.institution;
    this.localOrOversea;
    this.startDate;
    this.endDate;
    this.resultCGPA;
    this.attachment;
    this.remarks;
    this.fieldOfStudy;
    this.levelDescription;
    this.fieldOfStudyDescription;

}


var EmployeeExpertise = function () {
    this.industry;
    this.specialty;
    this.startDate;
    this.endDate;
    this.period;
    this.remarks;
    this.employeeRefId;

}

var EmployeeMembership = function () {
    this.association;
    this.memberType;
    this.contactDetails;
    this.startDate;
    this.endDate;
    this.membershipPeriod;
    this.enrollmentFees;
    this.membershipFees;
    this.attachments;
    this.remarks;
    this.employeeRefId;

}

var EmployeeEmployment = function () {
    this.employerName;
    this.job;
    this.industry;
    this.startDate;
    this.endDate;
    this.duration;
    this.lastDrawnSalary;
    this.resignationReason;
    this.remarks;
    this.employeeRefId;

}

// doesn't look like the UI interface
var EmployeeExperience = function () {
    this.expertise;
    this.employeeRefId;
    this.yearOfExpertise;
    this.expertiseDescription;
    this.lastUpdate;
}

var EmployeeFamilyRelationType = function () {
    this.employeeRefId;
    this.name;
    this.description;
    this.startEffectiveDate;
    this.endEffectiveDate;
    this.disabled;
}

var Religion = function () {
    this.employeeRefId;
    this.name;
    this.description;
    this.startEffectiveDate;
    this.endEffectiveDate;
    this.disabled;
}


var GenericCodeMaintenance = function () {
    this.employeeRefId;
    this.name;
    this.description;
    this.startEffectiveDate;
    this.endEffectiveDate;
    this.disabled;
}


var Employee = function () {
    this.nid;
    this.code;
    this.companyRef;
    this.description;

    this.name;
    this.firstName;
    this.lastName;
    this.middleName;

    this.gender;
    this.salutation;
    this.birthDate;

    this.age;
    this.maritalStatus;
    this.marriageDate;

    this.race;
    this.religion;
    this.nationality;
    this.countryOrigin;
    this.disabled;

}

var JobType = function () {

    this.nid;
    this.code;
    this.jobTitle;
    this.jobCategory;
    this.description;
}

var JobSetupQualification = function () {
    var self = this;
    self.nid;
    self.jobSetupRef;
    self.level;
    self.levelDescription;
    self.fieldOfStudy;
}

var JobSetupExperience = function () {
    var self = this;
    self.nid;
    self.jobSetupRef;
    self.expertise;
    self.description;
    self.experienceYears;
}

var JobSetupSkill = function () {
    var self = this;
    self.nid;
    self.jobSetupRef;

    self.skill;
    self.level;
    self.category;
    self.categoryDescription;
    self.description;
}
