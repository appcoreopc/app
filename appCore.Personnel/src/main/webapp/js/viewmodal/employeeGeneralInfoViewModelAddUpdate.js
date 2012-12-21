var EmployeeGeneralInfoViewModelAddUpdate = function (mode) {

    var self = this;

    self.countryList = ko.observableArray();
    self.salutationList = ko.observableArray();
    self.genderList = ko.observableArray();
    self.maritalStatusList = ko.observableArray();
    self.raceList = ko.observableArray();

    self.religionList = ko.observableArray();
    self.nationalityList = ko.observableArray();




    self.mode = ko.observable(0);

    if (mode != 0) {
        self.mode = ko.observable(mode);
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


    var helper = new EmployeeHelper();
    helper.getCountryCode(self.countryList);
    helper.getSalutationCode(self.salutationList);
    helper.getGenderCode(self.genderList);
    helper.getMaritalStatusCode(self.maritalStatusList);
    helper.getRaceCode(self.raceList);
    helper.getReligionCode(self.religionList);
    helper.getNationalityCode(self.nationalityList);

    self.getCountryCode = function (code) {
        return helper.findCodeInList(code, self.countryList());
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

    self.getRaceCode = function (code) {
        return helper.findCodeInList(code, self.raceList());
    }

    self.getReligionCode = function (code) {
        return helper.findCodeInList(code, self.religionList());
    }

    self.getNationalityCode = function (code) {
        return helper.findCodeInList(code, self.nationalityList());
    }

    self.remove = function (element) {
        self.initData.remove(element);
    }

}