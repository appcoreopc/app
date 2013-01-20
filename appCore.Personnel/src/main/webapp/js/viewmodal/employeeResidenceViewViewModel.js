var EmployeeResidenceViewViewModel = function (dataSource, mode, audMode, employeeId)
{
    var self = this;

    self.totalRecordCount = ko.observable(dataSource.length-1);
    self.bindingSource = ko.observableArray(dataSource);
    self.countryList = ko.observableArray();

    self.mode = ko.observable(0);
    self.enableAdd = ko.observable(false);
    self.enableUpdate = ko.observable(false);
    self.enableDelete = ko.observable(false);

    self.selectedItem = ko.observable();
    self.formPermission = ko.observable();

    var helper = new EmployeeHelper();

    self.getPermission = function ()
    {
        return self.enableAdd() || self.enableDelete() || self.enableUpdate();
    }

    self.editData = function (item)
    {
        self.selectedItem(item);
        self.mode(0);
    }

    self.templateToUse = function (item) {

        if (item === self.selectedItem())
        {
            return "employeeResidenceAddTemplate";
        }

        switch (self.mode()) {
            case 0:
                return "employeeResidenceTemplate";
            case 1:
            case 2:
                return "employeeResidenceAddTemplate";
            default:
                return "employeeResidenceTemplate";
        }
        return "employeeResidenceTemplate";

    }.bind(this);

    self.cancelEdit = function ()
    {
        self.editData();
        self.mode(0);
    }

    self.saveDataForm = function (data)
    {
        var source = data;

        var residence = new EmployeeResidence();

        if (source.nid != null || source.nid != undefined)
            residence.nid = source.nid;

        residence.employeeRefId = globalCurrentEmployee;
        residence.permanentAddress1 = source.permanentAddress1;
        residence.permanentAddress2 = source.permanentAddress2;
        residence.permanentAddress3 = source.permanentAddress3;
        residence.city = source.city;
        residence.country = source.country;
        residence.postCode = source.postcode;
        residence.telNo = source.telNo;
        residence.emergencyContact1 = source.emergencyContact1;
        residence.emergencyContact2 = source.emergencyContact2;
        residence.contact1 = source.contact1;
        residence.contact2 = source.contact2;

        var request = ajaxCore.sendRequestType(globalEmployeeResidencSaveUpdateUrl, residence, "post");
        request.success(function (data, status, xhrObj) {
                self.editData();
        });
    }


    helper.getCountryCode(self.countryList);

    if (audMode != undefined)
    {
        self.enableAdd = ko.observable(helper.getEnableAdd(audMode));
        self.enableUpdate = ko.observable(helper.getEnableUpdate(audMode));
        self.enableDelete = ko.observable(helper.getEnableDelete(audMode));
    }


    self.getCountryCode = function (code) {
        return helper.findCodeInList(code, self.countryList());
    }

    self.remove = function (element) {
        self.initData.remove(element);
    }

}