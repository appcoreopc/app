var EmployeeResidentialViewModel = function (initView, value, data) {

    this.viewType = initView;

    var self = this;

    self.permanentAddress1 = ko.observable();
    self.permanentAddress2 = ko.observable();
    self.permanentAddress3 = ko.observable();

    self.city = ko.observable();
    self.country = ko.observable();
    self.postcode = ko.observable();
    self.telNo = ko.observable();

    self.emergencyContact1 = ko.observable();
    self.emergencyContact2 = ko.observable();

    self.contactNo = ko.observable();
    self.contactNo2 = ko.observable();

    var helper = new EmployeeHelper();

    this.getRole = function () {
        var input = { "id":globalEmployeeModule, "roleId":1 };
        return input;
    }

    this.getView = function () {
        var gridDataObject = { };
        switch (this.viewType) {
            case 0:
                var helper = new EmployeeHelper();
                var addLinkInfo =
                {
                    "text":"Add Residential Info",
                    // "icon":"icon-plus",
                    "commandId":'ResidentialAdd',
                    "link":this.addPage,
                    "targetControlId":"#userCommand",
                    "ctrlId":"ResidentialAddId",
                    "knockoutAttribute":"click: saveResidentialForm"
                    //"callback":function () {
                    //    var vm = new EmployeeResidentialViewModel();
                    //    vm.saveExpertiseForm();
                    //}
                }

                var cancelLinkInfo = helper.getCancelInfo();

                var updateLinkInfo = {
                    "text":"Update",
                    "link":this.editPage
                };

                gridDataObject.editorMode = "Insert";
                gridDataObject.addLinkInfo = addLinkInfo;
                gridDataObject.cancelLinkInfo = cancelLinkInfo;
                return gridDataObject;
            default:
                break;
        }
    }

    this.saveResidentialForm = function () {

        var isValid = $("#" + "employeeResidenceForm").validationEngine('validate');

        if (!isValid)
            return;

        var employeeResidence = new EmployeeResidence();

        employeeResidence.permanentAddress1 = self.permanentAddress1();
        employeeResidence.permanentAddress2 = self.permanentAddress2();
        employeeResidence.permanentAddress3 = self.permanentAddress3();

        employeeResidence.city = self.city();
        employeeResidence.country = 1;
        //employeeResidence.country = self.country();
        employeeResidence.level = 1;
        employeeResidence.postCode = self.postcode();
        employeeResidence.telNo = self.telNo();
        employeeResidence.emergencyContact1 = self.emergencyContact1();
        employeeResidence.emergencyContact2 = self.emergencyContact2();

        employeeResidence.contact1 = self.contactNo();
        employeeResidence.contact2 = self.contactNo2();

        employeeResidence.employeeRefId = globalCurrentEmployee;

        var ajaxCore = new AjaxCore();

        var request = ajaxCore.sendRequestType(globalEmployeeResidenceUrl, employeeResidence, "post");

        request.success(function (data, status, xhrObj) {
            helper.closeDialog();
        });
    }
}