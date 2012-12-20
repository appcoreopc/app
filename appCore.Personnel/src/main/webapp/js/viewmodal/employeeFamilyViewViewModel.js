var EmployeeFamilyViewInfo = function(source)
{

    var self = this;
    var helper = new EmployeeHelper();

    self.nid = ko.observable(source.nid);
    self.memberName = ko.observable(source.memberName);
    self.memberType = ko.observable(source.memberType);

    self.birthDate = ko.observable(helper.getDateOnly(new Date(source.birthDate)));

    self.age = ko.observable(source.age);
    self.salutation = ko.observable(source.salutation);
    self.gender = ko.observable(source.gender);

    self.maritalStatus = ko.observable(source.maritalStatus);
    self.identificationNo = ko.observable(source.identificationNo);

    self.working = ko.observable(source.working);

    self.studying = ko.observable(source.studying);
    self.handicap = ko.observable(source.handicap);
    self.nominatedSpouse = ko.observable(source.nominatedSpouse);

    self.attachments = ko.observable(source.attachments);
    self.remarks = ko.observable(source.remarks);
    self.employeeRefId = ko.observable(source.employeeRefId);
}

/*
var EmployeeViewInfo = function(source)
{

    var self = this;
    var helper = new EmployeeHelper();

    self.nid = source.nid;
    self.memberName = source.memberName;
    self.memberType = source.memberType;

    self.birthDate = helper.getDateOnly(new Date(source.birthDate));

    self.age = source.age;
    self.salutation = source.salutation;
    self.gender = source.gender;

    self.maritalStatus = source.maritalStatus;
    self.identificationNo = source.identificationNo;

    self.working = source.working;

    self.studying = source.studying;
    self.handicap = source.handicap;
    self.nominatedSpouse = source.nominatedSpouse;

    self.attachments = source.attachments;
    self.remarks = source.remarks;
    self.employeeRefId = source.employeeRefId;

}
*/


var EmployeeFamilyViewViewModel = function (dataSource, mode, audMode, employeeId) {

    var self = this;

    self.bindingSource = ko.observableArray();
    self.familyMemberTypeList = ko.observableArray();
    self.salutationList = ko.observableArray();
    self.genderList = ko.observableArray();
    self.maritalStatusList = ko.observableArray();
    self.countryList = ko.observableArray();

    var helper = new EmployeeHelper();

    self.mode = ko.observable(0);
    self.enableAdd = ko.observable(false);
    self.enableUpdate = ko.observable(false);
    self.enableDelete = ko.observable(false);

    self.selectedItem = ko.observable();
    self.formPermission = ko.observable();

    if (audMode != undefined)
    {
        self.enableAdd = ko.observable(helper.getEnableAdd(audMode));
        self.enableUpdate = ko.observable(helper.getEnableUpdate(audMode));
        self.enableDelete = ko.observable(helper.getEnableDelete(audMode));
    }

    self.getPermission = function () {
        return self.enableAdd() || self.enableDelete() || self.enableUpdate();
    }

    if (mode == 0 && dataSource != null)
    {
        for (var i=0; i < dataSource.length; i++)
        {
            self.bindingSource.push(new EmployeeFamilyViewInfo(dataSource[i]));
        }
    }

    self.editData = function (item) {
        self.selectedItem(item);
        self.mode(0);
    }

    self.templateToUse = function (item) {

        if (item === self.selectedItem()) {
            return "employeeFamilyAddTemplate";
        }

        switch (self.mode()) {
            case 0:
                return "employeeFamilyTemplate";
            case 1:
            case 2:
                return "employeeFamilyAddTemplate";
            default:
                return "employeeFamilyTemplate";
        }
        return "employeeFamilyTemplate";

    }.bind(this);

    self.cancelEdit = function () {
        //self.editData();
        self.mode(0);
    }

    self.saveDataForm = function (data) {

        var source = data;

        var employeeFamily = new EmployeeFamily();

        employeeFamily.nid = source.nid();
        employeeFamily.memberName = source.memberName();
        employeeFamily.memberType = source.memberType();

        employeeFamily.birthDate = helper.getDate(source.birthDate().toString());

        employeeFamily.age = source.age();
        employeeFamily.salutation = source.salutation();
        employeeFamily.gender = source.gender();

        employeeFamily.maritalStatus = source.maritalStatus();
        employeeFamily.identificationNo = source.identificationNo();

        employeeFamily.working = source.working();

        employeeFamily.studying = source.studying();
        employeeFamily.handicap = source.handicap();
        employeeFamily.nominatedSpouse = source.nominatedSpouse();

        employeeFamily.attachments = source.attachments();
        employeeFamily.remarks = source.remarks();

        employeeFamily.employeeRefId = globalCurrentEmployee;

        var ajaxCore = new AjaxCore();
        var request = ajaxCore.sendRequestType(globalEmployeeFamilySaveOrUpdateUrl, employeeFamily, "post");

        request.success(function (data, status, xhrObj) {
            self.editData();
        });

    }

    helper.getFamilyMemberCode(self.familyMemberTypeList);
    helper.getSalutationCode(self.salutationList);
    helper.getGenderCode(self.genderList);
    helper.getMaritalStatusCode(self.maritalStatusList);
    helper.getCountryCode(self.countryList);

    self.remove = function (element) {
        self.initData.remove(element);
    }

    self.getMemberTypeCode = function (code) {
        return helper.findCodeInList(code, self.familyMemberTypeList());
    }

    self.getSalutationCode = function (code) {
        return helper.findCodeInList(code, self.salutationList());
    }

    self.getGenderCode = function (code) {
        return helper.findCodeInList(code, self.genderList());
    }

    self.getMaritalStatusCode = function (code) {
        return helper.findCodeInList(code, self.maritalStatusList());
    }

    self.getCountryCode = function (code) {
        return helper.findCodeInList(code, self.countryList());
    }

}   