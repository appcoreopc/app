var EmployeeGeneralInfo = function () {

    var self = this;
    self.nid = ko.observable();
    self.name = ko.observable();
    self.code = ko.observable();
    self.salutation = ko.observable();
    self.firstName = ko.observable();
    self.middleName = ko.observable();
    self.lastName = ko.observable();

    self.gender = ko.observable();
    self.birthDate = ko.observable();
    //self.age = ko.observable();

    self.age = ko.computed(function()
    {
        var helper = new EmployeeHelper();
        return helper.getDateDiffYear(self.birthDate());
    });

    self.maritalStatus = ko.observable();
    self.marriageDate = ko.observable();
    self.race = ko.observable();

    self.religion = ko.observable();
    self.nationality = ko.observable();

    self.countryOrigin = ko.observable();
    self.disabled = ko.observable();

}


var EmployeeGeneralInfoViewModel = function (mode, audMode, employeeId) {

    var self = this;
    var helper = new EmployeeHelper();

    self.bindingSource = ko.observableArray();

    self.countryList = ko.observableArray();
    self.salutationList = ko.observableArray();
    self.genderList = ko.observableArray();
    self.maritalStatusList = ko.observableArray();
    self.raceList = ko.observableArray();

    self.religionList = ko.observableArray();
    self.nationalityList = ko.observableArray();

    self.mode = ko.observable(0);

    self.enableAdd = ko.observable(false);
    self.enableUpdate = ko.observable(false);
    self.enableDelete = ko.observable(false);

    if (audMode != undefined) {
        self.enableAdd = ko.observable(helper.getEnableAdd(audMode));
        self.enableUpdate = ko.observable(helper.getEnableUpdate(audMode));
        self.enableDelete = ko.observable(helper.getEnableDelete(audMode));
    }


    self.editForm = function () {
        self.mode(2);
    }

    self.cancelEdit = function () {
        if (self.mode() == 1) {
            self.cancelForm();
        }
        else {
            self.mode(0);
        }
    }

    self.templateToUse = function (item) {

        switch (self.mode()) {
            case 0:
                return "employeeGeneralInfoTemplate";
            case 1:
            case 2:
                return "employeeGeneralInfoAddTemplate";
            default:
                return "employeeGeneralInfoTemplate";
        }
        return "employeeGeneralInfoTemplate";

    }.bind(this);


    self.cancelForm = function () {
        preparePageForLoading("employeeList.jsp");
    }

    self.saveDataForm = function (data) {

        var employeeGeneralInfo = self.bindingSource()[0];
        var employee = new Employee();
        employee.nid = employeeId;

        if (self.mode() == 1) {
            console.log("insert new employee");
            employee.nid = null;
        }
        employee.code = employeeGeneralInfo.code();
        employee.companyRef = globalCurrentCompanyId;

        employee.name = employeeGeneralInfo.name();
        employee.firstName = employeeGeneralInfo.firstName();
        employee.lastName = employeeGeneralInfo.lastName();
        employee.middleName = employeeGeneralInfo.middleName();

        employee.gender = employeeGeneralInfo.gender();
        employee.salutation = employeeGeneralInfo.salutation();

        employee.birthDate = helper.getDate(employeeGeneralInfo.birthDate().toString());

        employee.age = employeeGeneralInfo.age();
        employee.maritalStatus = employeeGeneralInfo.maritalStatus();
        employee.marriageDate = helper.getDate(employeeGeneralInfo.marriageDate().toString());

        employee.race = employeeGeneralInfo.race();
        employee.religion = employeeGeneralInfo.religion();

        employee.nationality = employeeGeneralInfo.nationality();
        employee.countryOrigin = employeeGeneralInfo.countryOrigin();
        employee.disabled = employeeGeneralInfo.disabled();

        var request = ajaxCore.sendRequestType(globalEmployeeSaveOrUpdateUrl, employee, "post");

        request.success(function (data, status, xhrObj) {
            globalCurrentId = null;
            preparePageForLoading("employeeList.jsp");
        });
    }

    helper.getCountryCode(self.countryList);
    helper.getSalutationCode(self.salutationList);
    helper.getGenderCode(self.genderList);
    helper.getMaritalStatusCode(self.maritalStatusList);
    helper.getRaceCode(self.raceList);
    helper.getReligionCode(self.religionList);
    helper.getNationalityCode(self.nationalityList);


    self.initCountryCode = function () {
        helper.getCountryCode(self.countryList);
    }

    self.initSalutationCode = function () {
        helper.getSalutationCode(self.salutationList);
    }

    self.initGenderCode = function () {
        helper.getGenderCode(self.genderList);
    }

    self.initMaritalStatusCode = function () {
        helper.getMaritalStatusCode(self.maritalStatusList);
    }

    self.initRaceCode = function () {
        helper.getRaceCode(self.raceList);
    }

    self.initReligionCode = function () {
        helper.getReligionCode(self.religionList);
    }

    self.initNationalityCode = function () {
        helper.getNationalityCode(self.nationalityList);
    }

    self.getCountryCode = function (code) {
        return helper.findCodeInList(code(), self.countryList());
    }

    self.getSalutationCode = function (code) {
        return helper.findCodeInList(code(), self.salutationList());
    }

    self.getGenderCode = function (code) {
        return helper.findCodeInList(code(), self.genderList());
    }

    self.getMaritalStatusCode = function (code) {
        return helper.findCodeInList(code(), self.maritalStatusList());
    }

    self.getRaceCode = function (code) {
        return helper.findCodeInList(code(), self.raceList());
    }

    self.getReligionCode = function (code) {
        return helper.findCodeInList(code(), self.religionList());
    }

    self.getNationalityCode = function (code) {
        return helper.findCodeInList(code(), self.nationalityList());
    }

    self.remove = function (element) {
        self.initData.remove(element);
    }

    self.applyBinding = function () {
        self.mode(2);
    }

    self.getGeneralInfo = function (code) {

        var employeeCode = { id:code };
        var request = ajaxCore.sendRequestSequential(globalEmployeeGetUrl, employeeCode, "get");

        request.success(function (data, status, xhrObj) {

            var employeeGeneralInfo = new EmployeeGeneralInfo();
            employeeGeneralInfo.nid(data.nid);
            employeeGeneralInfo.name(data.name);
            employeeGeneralInfo.code(data.code);
            employeeGeneralInfo.salutation(data.salutation);
            employeeGeneralInfo.firstName(data.firstName);
            employeeGeneralInfo.middleName(data.middleName);
            employeeGeneralInfo.lastName(data.lastName);

            employeeGeneralInfo.gender(data.gender);
            employeeGeneralInfo.birthDate(helper.getDateOnly(new Date(data.birthDate)));

            employeeGeneralInfo.maritalStatus(data.maritalStatus);
            employeeGeneralInfo.marriageDate(helper.getDateOnly(new Date(data.marriageDate)));
            employeeGeneralInfo.race(data.race);

            employeeGeneralInfo.religion(data.religion);
            employeeGeneralInfo.nationality(data.nationality);

            employeeGeneralInfo.countryOrigin(data.countryOrigin);
            employeeGeneralInfo.disabled(data.disabled);

            self.bindingSource = ko.observableArray([employeeGeneralInfo]);

        });
    }

    if (mode != 0)
        self.mode = ko.observable(mode);

    if (mode == coreModeInsert) {

        var employeeGeneralInfo = new EmployeeGeneralInfo();
        var todayDate = new Date();
        var currentDateValue = helper.getDateFormatDDMMYYYY(todayDate);
        employeeGeneralInfo.birthDate(currentDateValue);

        employeeGeneralInfo.marriageDate(currentDateValue);
        self.mode = ko.observable(mode);
        self.bindingSource = ko.observableArray([employeeGeneralInfo]);
    }

    if (mode == coreModeEdit) {
        self.getGeneralInfo(employeeId);
    }

}